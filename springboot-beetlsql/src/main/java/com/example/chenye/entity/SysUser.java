package com.example.chenye.entity;

import lombok.Data;

@Data
public class SysUser{
    private Integer id;
    private String name;
    private String password;
    private String nickName;
    private String email;
}
