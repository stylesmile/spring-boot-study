package com.example.demo;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.demo.mapper.ThirdUserMapper;
import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@DS("third")
public class ThirdUserService {

    @Resource
    ThirdUserMapper thirdUserMapper;
    @Resource
    private JdbcTemplate jdbcTemplate;


    public List<User> getUsers() {
        return thirdUserMapper.query();
    }

    public List selectByCondition2() {
        List list = jdbcTemplate.queryForList("select * from third_user");
        return list;
    }
}