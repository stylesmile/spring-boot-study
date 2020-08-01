package com.futve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.futve.entity.RegistryUser;
import com.futve.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (RegistryUser)表数据库访问层
 *
 * @author chenye
 * @since 2020-07-31 16:01:07
 */
@Mapper
public interface RegistryUserMapper extends BaseMapper {
//public interface RegistryUserMapper {

    //    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    RegistryUser queryById(Integer id);
//
//    /**
//     * 查询指定行数据
//     *
//     * @param offset 查询起始位置
//     * @param limit  查询条数
//     * @return 对象列表
//     */
//    List<RegistryUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
//
//
//    /**
//     * 通过实体作为筛选条件查询
//     *
//     * @param RegistryUser 实例对象
//     * @return 对象列表
//     */
//    List<RegistryUser> queryAll(RegistryUser RegistryUser);
//
//    /**
//     * 新增数据
//     *
//     * @param RegistryUser 实例对象
//     * @return 影响行数
//     */
//    int insert(RegistryUser RegistryUser);
//
//    /**
//     * 修改数据
//     *
//     * @param RegistryUser 实例对象
//     * @return 影响行数
//     */
//    int update(RegistryUser RegistryUser);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 影响行数
//     */
//    int deleteById(Integer id);

    /**
     * 通过电话查询用户
     *
     * @param phone 电话
     * @return 实例对象
     */
    @Select("select id, name from user where phone = #{phone} limit 1")
    RegistryUser getUserByPhone(String phone);

    @Select("select * from user where 1=1 limit 10 ")
    List<User> getUserList();
}