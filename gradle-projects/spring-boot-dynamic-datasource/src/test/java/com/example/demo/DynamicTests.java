package com.example.demo;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@DS("master")
public class DynamicTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    SecondUserService secondUserService;

    /**
     * 失败测试
     */
    @DS("master")
    @Test
    public void selectByCondition() {
        List list = jdbcTemplate.queryForList("select * from user limit 10");
        System.out.println(list);
    }

    /**
     * 失败测试
     */
    @DS("second")
    @Test
    public void selectByCondition2() {
        List list = jdbcTemplate.queryForList("select * from second_user");
        System.out.println(list);
    }

    /**
     * 正确
     */
    @Test
    public void selectByCondition22() {
        List list = secondUserService.selectByCondition2();
        System.out.println(list);
    }

    /**
     * 失败测试
     */
    @Test
    @DS("third")
    public void selectByCondition3() {
        List list = jdbcTemplate.queryForList("select * from third_user");
        System.out.println(list);
    }
}
