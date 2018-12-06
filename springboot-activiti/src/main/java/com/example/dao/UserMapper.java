package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Role;
import com.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/04
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> getUserList();
    IPage<User> selectPageVo(Page page, @Param("state") Integer state);

    List<Role> getRoles(String userId);
}
