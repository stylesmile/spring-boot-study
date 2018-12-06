package com.example.chenye.service;

import com.example.chenye.dao.SysUserDao;
import com.example.chenye.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    SysUserDao sysUserDao;

    public List<SysUser> getList() {
        return sysUserDao.getList();
    }
}
