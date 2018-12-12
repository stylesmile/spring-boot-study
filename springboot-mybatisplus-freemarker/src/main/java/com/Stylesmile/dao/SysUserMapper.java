package com.Stylesmile.dao;

import com.Stylesmile.entity.SysUser;
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
    IPage<SysUser> selectPageVo(Page page, @Param("state") Integer state);
    SysUser getSysUserByNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);

    IPage<SysUser> getUserList2(Page<SysUser> page, Integer state);
}
