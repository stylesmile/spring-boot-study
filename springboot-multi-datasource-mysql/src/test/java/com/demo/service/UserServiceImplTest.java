package com.demo.service;

import com.demo.dao.first.UserDao;
import com.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @Test
    public void deleteUser() {
        int i = userService.deleteUser(2);
        System.out.println(i);
    }
    @Test
    public void query() {
        List<User> userList = userDao.query();
        System.out.println(userList);
    }

}