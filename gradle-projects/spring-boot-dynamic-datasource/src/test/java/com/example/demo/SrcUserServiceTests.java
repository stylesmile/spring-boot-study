package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SrcUserServiceTests {

    @Resource
    SrcUserService srcUserService;

    @Test
    public void test() {
        List<User> userList = srcUserService.getUsers();
        System.out.println(userList);
    }
}
