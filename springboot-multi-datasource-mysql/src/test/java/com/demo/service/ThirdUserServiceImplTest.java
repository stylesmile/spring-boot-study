package com.demo.service;

import com.demo.dao.third.ThirdUserDao;
import com.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThirdUserServiceImplTest {

    @Autowired
    private ThirdUserDao thirdUserDao;

    @Test
    public void query() {
        List<User> userList = thirdUserDao.query();
        System.out.println(userList);
    }

}