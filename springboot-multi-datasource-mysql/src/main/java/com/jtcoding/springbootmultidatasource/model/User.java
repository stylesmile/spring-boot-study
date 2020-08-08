package com.jtcoding.springbootmultidatasource.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author jason.tang
 * @create 2019-02-13 12:40
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class User extends SrcUser {
    private Integer userNum;
    private String username;
    private String password;
}