package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenye
 * @date 2018/11/04
 */
@Data
public class User implements Serializable {
    private String id;
    private String name;
    private String password;
    private String email;

    public User() {
    }
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

}
