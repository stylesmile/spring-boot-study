package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ThirdUserServiceTests {

    @Resource
    ThirdUserService thirdUserService;

    @Test
    public void test() {
        List<User> userList = thirdUserService.getUsers();
        System.out.println(userList);
    }
}
