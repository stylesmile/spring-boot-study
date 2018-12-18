package com.Stylesmile.service;

import com.Stylesmile.entity.SysUser;
import com.Stylesmile.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface SysUserService extends BaseService<SysUser> {

    Result<String> getSysUserByNameAndPassword(String loginName, String password);

    List<SysUser> geList();

    IPage<SysUser> getUserList(Page<SysUser> page, Integer state);
}
