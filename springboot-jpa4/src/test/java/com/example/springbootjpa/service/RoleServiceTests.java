package com.example.springbootjpa.service;


import com.example.springbootjpa.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleServiceTests {

    @Resource
    RoleService RoleService;

    @Test
    public void getRoleListtest() {
        List<Role> RoleList = RoleService.getRoleList();
        System.out.println(RoleList);
    }

    @Test
    public void saveTest() {
        Role role = Role.newBuilder().name("zhagnsan").build();
        RoleService.save(role);
        System.out.println(role);
    }

}
