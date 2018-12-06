package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.userGroup.SysRole;
import com.example.userGroup.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/04
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
    List<SysUser> getUserList();
    IPage<SysUser> selectPageVo(Page page, @Param("state") Integer state);

    List<SysRole> getUserRoles(Long userId);
}
