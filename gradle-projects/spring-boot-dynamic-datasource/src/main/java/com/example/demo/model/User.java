package com.example.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author chenye
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class User extends SecondUser {
    private Integer userNum;
    private String username;
    private String password;
}