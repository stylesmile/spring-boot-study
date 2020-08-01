package com.example;

import com.example.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTests {

    @Resource
    RedisUtil redisUtil;

    @Test
    public void set(){
        redisUtil.set("test","test--111");
    }

    @Test
    public void get(){
        System.out.println(redisUtil.get("test"));
    }
}
