package com.example.chenye.dao;

import com.example.chenye.entity.SysUser;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;


@SqlResource("sys.sysUser")
public interface SysUserDao extends BaseMapper<SysUser> {

    List<SysUser> getList();
}
