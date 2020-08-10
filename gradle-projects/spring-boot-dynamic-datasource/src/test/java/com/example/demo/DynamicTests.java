package com.example.demo;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@DS("slave_1")
public class DynamicTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @DS("master")
    @Test
    public void selectByCondition() {
        List list = jdbcTemplate.queryForList("select * from user limit 10");
        System.out.println(list);
    }


    @Test
    @DS("slave_1")
    public void selectByCondition2() {
        List list = jdbcTemplate.queryForList("select * from src_user");
        System.out.println(list);
    }
}
