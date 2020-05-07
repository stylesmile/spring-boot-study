package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenye
 */
@RestController
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/")
    public String home(String name, String pwd) {
        return userService.login(name, pwd);
    }
    @RequestMapping("/login")
    public String login(String name, String pwd) {
        return userService.login(name, pwd);
    }
}
