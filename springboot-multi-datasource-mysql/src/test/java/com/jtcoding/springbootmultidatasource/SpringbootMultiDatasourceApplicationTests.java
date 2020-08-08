package com.jtcoding.springbootmultidatasource;

import com.jtcoding.springbootmultidatasource.dao.first.UserDao;
import com.jtcoding.springbootmultidatasource.dao.second.SrcUserDao;
import com.jtcoding.springbootmultidatasource.model.SrcUser;
import com.jtcoding.springbootmultidatasource.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMultiDatasourceApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserDao userDao;

    @Autowired
    private SrcUserDao srcUserDao;

    @Test
    public void getUser() {
        User user = userDao.getUser(1);
        if (user != null) {
            SrcUser srcUser = srcUserDao.getSrcUser(user.getUserNum());
            if (srcUser != null) {
                System.out.println(user);
                System.out.println(srcUser);
            }
        }
    }

}

