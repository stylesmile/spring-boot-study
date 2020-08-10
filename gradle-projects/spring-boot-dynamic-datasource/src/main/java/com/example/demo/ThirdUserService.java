package com.example.demo;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.demo.mapper.SrcUserMapper;
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
@DS("third")
public class ThirdUserService {

    @Resource
    SrcUserMapper srcUserMapper;

    public List<User> getUsers() {
        return srcUserMapper.query();
    }
}