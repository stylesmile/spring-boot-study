package com.example.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author chenye
 */
@Data
@ToString
public class User extends SrcUser {
    private Integer userNum;
    private String username;
    private String password;
}