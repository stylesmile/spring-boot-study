package com.example.service;

import com.example.entity.SysUser;
import com.example.util.Result;

import java.util.List;

public interface SysUserService extends BaseService<SysUser>{

    public Result<String> getSysUserByNameAndPassword(String loginName, String password);
    public List<SysUser> geList();

}
