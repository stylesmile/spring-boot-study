package com.Stylesmile.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.*;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlHelper;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class  BaseService<M extends BaseMapper<T>, T> {
    @Resource
    protected M baseMapper;


    protected boolean retBool(Integer result) {
        return SqlHelper.retBool(result);
    }

    protected Class<T> currentModelClass() {
        return ReflectionKit.getSuperClassGenericType(this.getClass(), 1);
    }

    protected SqlSession sqlSessionBatch() {
        return SqlHelper.sqlSessionBatch(this.currentModelClass());
    }

    protected void closeSqlSession(SqlSession sqlSession) {
        SqlSessionUtils.closeSqlSession(sqlSession, GlobalConfigUtils.currentSessionFactory(this.currentModelClass()));
    }

    protected String sqlStatement(SqlMethod sqlMethod) {
        return SqlHelper.table(this.currentModelClass()).getSqlStatement(sqlMethod.getMethod());
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean save(T entity) {
        return this.retBool(this.baseMapper.insert(entity));
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        int i = 0;
        String sqlStatement = this.sqlStatement(SqlMethod.INSERT_ONE);
        SqlSession batchSqlSession = this.sqlSessionBatch();
        Throwable var6 = null;

        try {
            for(Iterator var7 = entityList.iterator(); var7.hasNext(); ++i) {
                T anEntityList = (T) var7.next();
                batchSqlSession.insert(sqlStatement, anEntityList);
                if (i >= 1 && i % batchSize == 0) {
                    batchSqlSession.flushStatements();
                }
            }

            batchSqlSession.flushStatements();
            return true;
        } catch (Throwable var16) {
            var6 = var16;
            throw var16;
        } finally {
            if (batchSqlSession != null) {
                if (var6 != null) {
                    try {
                        batchSqlSession.close();
                    } catch (Throwable var15) {
                        var6.addSuppressed(var15);
                    }
                } else {
                    batchSqlSession.close();
                }
            }

        }
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(T entity) {
        if (null == entity) {
            return false;
        } else {
            Class<?> cls = entity.getClass();
            TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
            if (null != tableInfo && StringUtils.isNotEmpty(tableInfo.getKeyProperty())) {
                Object idVal = ReflectionKit.getMethodValue(cls, entity, tableInfo.getKeyProperty());
                if (StringUtils.checkValNull(idVal)) {
                    return this.save(entity);
                } else {
                    return this.updateById(entity) || this.save(entity);
                }
            } else {
                throw ExceptionUtils.mpe("Error:  Can not execute. Could not find @TableId.");
            }
        }
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdateBatch(Collection<T> entityList) {
        return this.saveOrUpdateBatch(entityList, 30);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        if (CollectionUtils.isEmpty(entityList)) {
            throw new IllegalArgumentException("Error: entityList must not be empty");
        } else {
            Class<?> cls = null;
            TableInfo tableInfo = null;
            int i = 0;
            SqlSession batchSqlSession = this.sqlSessionBatch();
            Throwable var7 = null;

            try {
                Iterator var8 = entityList.iterator();

                while(var8.hasNext()) {
                    T anEntityList = (T) var8.next();
                    if (i == 0) {
                        cls = anEntityList.getClass();
                        tableInfo = TableInfoHelper.getTableInfo(cls);
                    }

                    if (null == tableInfo || !StringUtils.isNotEmpty(tableInfo.getKeyProperty())) {
                        throw ExceptionUtils.mpe("Error:  Can not execute. Could not find @TableId.");
                    }

                    Object idVal = ReflectionKit.getMethodValue(cls, anEntityList, tableInfo.getKeyProperty());
                    String sqlStatement;
                    if (StringUtils.checkValNull(idVal)) {
                        sqlStatement = this.sqlStatement(SqlMethod.INSERT_ONE);
                        batchSqlSession.insert(sqlStatement, anEntityList);
                    } else {
                        sqlStatement = this.sqlStatement(SqlMethod.UPDATE_BY_ID);
                        MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap();
                        param.put("et", anEntityList);
                        batchSqlSession.update(sqlStatement, param);
                    }

                    if (i >= 1 && i % batchSize == 0) {
                        batchSqlSession.flushStatements();
                    }

                    ++i;
                    batchSqlSession.flushStatements();
                }
            } catch (Throwable var20) {
                var7 = var20;
                throw var20;
            } finally {
                if (batchSqlSession != null) {
                    if (var7 != null) {
                        try {
                            batchSqlSession.close();
                        } catch (Throwable var19) {
                            var7.addSuppressed(var19);
                        }
                    } else {
                        batchSqlSession.close();
                    }
                }

            }

            return true;
        }
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean removeById(Serializable id) {
        return SqlHelper.delBool(this.baseMapper.deleteById(id));
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean removeByMap(Map<String, Object> columnMap) {
        if (ObjectUtils.isEmpty(columnMap)) {
            throw ExceptionUtils.mpe("removeByMap columnMap is empty.");
        } else {
            return SqlHelper.delBool(this.baseMapper.deleteByMap(columnMap));
        }
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean remove(Wrapper<T> wrapper) {
        return SqlHelper.delBool(this.baseMapper.delete(wrapper));
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return SqlHelper.delBool(this.baseMapper.deleteBatchIds(idList));
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean updateById(T entity) {
        return this.retBool(this.baseMapper.updateById(entity));
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean update(T entity, Wrapper<T> updateWrapper) {
        return this.retBool(this.baseMapper.update(entity, updateWrapper));
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        if (CollectionUtils.isEmpty(entityList)) {
            throw new IllegalArgumentException("Error: entityList must not be empty");
        } else {
            int i = 0;
            String sqlStatement = this.sqlStatement(SqlMethod.UPDATE_BY_ID);
            SqlSession batchSqlSession = this.sqlSessionBatch();
            Throwable var6 = null;

            try {
                for(Iterator var7 = entityList.iterator(); var7.hasNext(); ++i) {
                    T anEntityList = (T) var7.next();
                    MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap();
                    param.put("et", anEntityList);
                    batchSqlSession.update(sqlStatement, param);
                    if (i >= 1 && i % batchSize == 0) {
                        batchSqlSession.flushStatements();
                    }
                }

                batchSqlSession.flushStatements();
                return true;
            } catch (Throwable var17) {
                var6 = var17;
                throw var17;
            } finally {
                if (batchSqlSession != null) {
                    if (var6 != null) {
                        try {
                            batchSqlSession.close();
                        } catch (Throwable var16) {
                            var6.addSuppressed(var16);
                        }
                    } else {
                        batchSqlSession.close();
                    }
                }

            }
        }
    }

    public T getById(Serializable id) {
        return this.baseMapper.selectById(id);
    }

    public Collection<T> listByIds(Collection<? extends Serializable> idList) {
        return this.baseMapper.selectBatchIds(idList);
    }

    public Collection<T> listByMap(Map<String, Object> columnMap) {
        return this.baseMapper.selectByMap(columnMap);
    }

    public T getOne(Wrapper<T> queryWrapper, boolean throwEx) {
        return throwEx ? this.baseMapper.selectOne(queryWrapper) : SqlHelper.getObject(this.baseMapper.selectList(queryWrapper));
    }

    public Map<String, Object> getMap(Wrapper<T> queryWrapper) {
        return (Map)SqlHelper.getObject(this.baseMapper.selectMaps(queryWrapper));
    }

    public Object getObj(Wrapper<T> queryWrapper) {
        return SqlHelper.getObject(this.baseMapper.selectObjs(queryWrapper));
    }

    public int count(Wrapper<T> queryWrapper) {
        return SqlHelper.retCount(this.baseMapper.selectCount(queryWrapper));
    }

    public List<T> list(Wrapper<T> queryWrapper) {
        return this.baseMapper.selectList(queryWrapper);
    }

    public IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper) {
        return this.baseMapper.selectPage(page, queryWrapper);
    }

    public List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper) {
        return this.baseMapper.selectMaps(queryWrapper);
    }

    public List<Object> listObjs(Wrapper<T> queryWrapper) {
        return (List)this.baseMapper.selectObjs(queryWrapper).stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public IPage<Map<String, Object>> pageMaps(IPage<T> page, Wrapper<T> queryWrapper) {
        return this.baseMapper.selectMapsPage(page, queryWrapper);
    }
}
