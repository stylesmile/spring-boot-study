package com.example;

import com.example.dao.UserMapper;
import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class UserTests {
    @Resource
    UserMapper userMapper;

    @Test
    public void test() {
        System.out.println("hello");
    }

    @Test
    public void save() {
        //User user = new User("zhangsan", "123456");
        User user = new User("zhangsan2", "123456");
        //userMapper.insert(user);
        //userMapper.in(user);
    }

    @Test
    public void query() {
        //List<User> userList = userMapper.query();
        //System.out.println(userList);
    }

    @Test
    public void getUserList() {
        List<User> userList = userMapper.getUserList();
        System.out.println(userList);
    }
}
