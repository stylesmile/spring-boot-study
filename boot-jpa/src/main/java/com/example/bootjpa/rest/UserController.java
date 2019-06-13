package com.example.bootjpa.rest;

import com.example.bootjpa.entity.UserEntity;
import com.example.bootjpa.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    UserService accountService;

    @GetMapping("/list")
    public List list() {
        return accountService.getList();
    }
    @GetMapping("/add")
    public UserEntity list(UserEntity user) {
        return accountService.add(user);
    }

}
