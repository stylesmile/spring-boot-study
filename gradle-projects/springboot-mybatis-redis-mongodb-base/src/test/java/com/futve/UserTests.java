package com.futve;

import com.futve.entity.User;
import com.futve.mapper.RegistryUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class UserTests {
    @Resource
    RegistryUserMapper userMapper;

    @Test
    public void test() {
        System.out.println("hello");
    }

    @Test
    public void save() {
        User user = User.builder()
                .name("zhagnsan")
                .phone("15002220000")
                .build();
        userMapper.insert(user);
    }

    @Test
    public void query() {
        List<User> userList = userMapper.selectByMap(new HashMap());
        System.out.println(userList);
    }

    @Test
    public void getUserList() {
        List<User> userList = userMapper.getUserList();
        System.out.println(userList);
    }
}
