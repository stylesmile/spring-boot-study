package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SecondUserServiceTests {

    @Resource
    SecondUserService secondUserService;

    @Test
    public void test() {
        List<User> userList = secondUserService.getUsers();
        System.out.println(userList);
    }
    @Test
    public void test2() {
        List<User> userList = secondUserService.selectByCondition2();
        System.out.println(userList);
    }
}
