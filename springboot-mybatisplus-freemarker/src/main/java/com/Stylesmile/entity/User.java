package com.example.entity;

import lombok.Data;

/**
 * @author chenye
 * @date 2018/11/04
 */
@Data
public class User {
    private int id;
    private String name;
    private String password;

    public User() {
    }
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

}
