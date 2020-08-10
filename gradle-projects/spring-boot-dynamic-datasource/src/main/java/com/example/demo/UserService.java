package com.example.demo;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author jason.tang
 * @create 2019-02-13 14:08
 * @description
 */

@Service
@DS("master")
public class UserService {

    @Resource
    UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.query();
    }
}