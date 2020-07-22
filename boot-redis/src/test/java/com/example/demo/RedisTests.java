package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTests {

    @Resource
    RedisUtil redisUtil;

    @Test
    public void incr() {
        Long value = 1L;
        redisUtil.set("test_incr", value);
        System.out.println(redisUtil.get("test_incr"));

        redisUtil.incr("test_incr", 1);
        redisUtil.incr("test_incr", 1);
        redisUtil.incr("test_incr", 1);
        System.out.println(redisUtil.get("test_incr"));
    }
}
