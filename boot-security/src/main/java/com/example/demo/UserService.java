package com.example.demo;

import org.springframework.stereotype.Service;

/**
 * @author chenye
 */
@Service
public class UserService {

    public String login(String name, String pwd) {
        return "success";
    }
}
