package com.example;

import com.example.dao.first.UserDao;
import com.example.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class UserServiceImplTest {
    @Resource
    private UserDao userDao;

    @Test
    public void query() {
        List<User> userList = userDao.query();
        System.out.println(userList);
    }

}