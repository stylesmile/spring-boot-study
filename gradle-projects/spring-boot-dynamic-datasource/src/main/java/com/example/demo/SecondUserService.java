package com.example.demo;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.demo.mapper.SecondUserMapper;
import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author jason.tang
 * @create 2019-02-13 14:08
 * @description
 */

@Service
@DS("second")
public class SecondUserService {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    SecondUserMapper secondUserMapper;

    public List<User> getUsers() {
        return secondUserMapper.query();
    }
    @DS("second")

    public List selectByCondition2() {
        List list = jdbcTemplate.queryForList("select * from second_user");
        return list;
    }
}