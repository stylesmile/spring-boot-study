package com.example.springbootjpa.service;


import com.example.springbootjpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Resource
    UserService userService;

    @Test
    public void getUserListtest() {
        List<User> userList = userService.getUserList();
        System.out.println(userList);
    }

    @Test
    public void saveTest() {
        User user = User.builder()
                .name("zhagnsan")
                .build();
        userService.save(user);
        System.out.println(user);
    }

}
