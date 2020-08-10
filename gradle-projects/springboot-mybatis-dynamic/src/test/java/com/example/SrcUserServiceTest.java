package com.example;

import com.example.dao.second.SrcUserDao;
import com.example.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SrcUserServiceTest {

    @Resource
    private SrcUserDao srcUserDao;

    @Test
    public void query() {
        List<User> userList = srcUserDao.query();
        System.out.println(userList);
    }
}