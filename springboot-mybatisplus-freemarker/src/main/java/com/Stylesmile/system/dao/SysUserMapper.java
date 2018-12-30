package com.Stylesmile.system.dao;

import com.Stylesmile.common.PageQuery;
import com.Stylesmile.system.entity.SysUser;
import com.Stylesmile.system.query.SysUserQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<SysUser> getUserList();

    SysUser getSysUserByNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);

    Boolean updateUser(SysUser user);

    Boolean deleteUser(String id);

    IPage<SysUser> getUserListPage(Page<SysUser> page, QueryWrapper<SysUser> sysUserQueryWrapperw);

    Page<SysUser> getUserList(SysUserQuery sysUserQuery);

    Page<SysUser> getUserList(Page<SysUser> page, @Param("username")String username);
}
