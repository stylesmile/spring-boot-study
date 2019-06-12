package com.example.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
//
//    @GetMapping("/user/{id}")
//    public User getUser(@PathVariable("id") Integer id){
//
//        User user = userRepository.findOne(id);
//        List<User> list = userRepository.findByEmail("aa@qq.com");
//        System.out.println(list.get(0));
//        return user;
//    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }

}