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

    public static final class UserBuilder {
        private int id;
        private String name;
        private String password;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setPassword(password);
            return user;
        }
    }
}
