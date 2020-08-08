package com.jtcoding.springbootmultidatasource.controller;

import com.jtcoding.springbootmultidatasource.model.User;
import com.jtcoding.springbootmultidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jason.tang
 * @create 2019-02-13 15:16
 * @description
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userNum}")
    public User getUserByNum(@PathVariable Integer userNum) {
        return userService.getUserByNum(userNum);
    }

    @DeleteMapping("/{userNum}")
    public Boolean deleteUser(@PathVariable Integer userNum) {
        return userService.deleteUser(userNum) > 0;
    }

    @PostMapping({"", "/"})
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}