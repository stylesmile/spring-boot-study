package com.example.service;

import com.example.dao.UserMapper;
import com.example.entity.User;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
@Service("sysUserService")
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

}
