package com.Stylesmile.system.dao;

import com.Stylesmile.system.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/18
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> getRoleList();
    IPage<SysRole> selectPageVo(Page page, @Param("state") Integer state);
    SysRole getSysRoleByNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);
}
