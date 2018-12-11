package com.Stylesmile.service;

import com.Stylesmile.entity.SysUser;
import com.Stylesmile.util.Result;

import java.util.List;

public interface SysUserService extends BaseService<SysUser>{

    public Result<String> getSysUserByNameAndPassword(String loginName, String password);
    public List<SysUser> geList();

}
