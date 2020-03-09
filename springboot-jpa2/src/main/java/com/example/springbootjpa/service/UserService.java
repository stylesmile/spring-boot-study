package com.example.springbootjpa.service;

import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
