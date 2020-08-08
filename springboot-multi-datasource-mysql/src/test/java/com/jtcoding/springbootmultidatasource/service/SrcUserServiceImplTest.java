package com.jtcoding.springbootmultidatasource.service;

import com.jtcoding.springbootmultidatasource.dao.first.UserDao;
import com.jtcoding.springbootmultidatasource.dao.second.SrcUserDao;
import com.jtcoding.springbootmultidatasource.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SrcUserServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    private SrcUserDao srcUserDao;
    @Test
    public void deleteUser() {
        int i = userService.deleteUser(2);
        System.out.println(i);
    }

    @Test
    public void query() {
        List<User> userList = srcUserDao.query();
        System.out.println(userList);
    }
}