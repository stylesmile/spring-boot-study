package com.Stylesmile.system.service;

import com.Stylesmile.common.PageQuery;
import com.Stylesmile.system.entity.SysUser;
import com.Stylesmile.system.query.SysUserQuery;
import com.Stylesmile.util.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface SysUserService extends BaseService<SysUser> {

    Result<String> getSysUserByNameAndPassword(String loginName, String password);

    Page<SysUser> getUserList(SysUserQuery sysUserQuery);

    Boolean updateUser(SysUser user);

    Boolean deleteUser(String id);
}
