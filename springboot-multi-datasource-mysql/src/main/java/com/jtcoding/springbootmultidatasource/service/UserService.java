package com.jtcoding.springbootmultidatasource.service;

import com.jtcoding.springbootmultidatasource.model.User;

/**
 * @author jason.tang
 * @create 2019-02-13 14:35
 * @description
 */
public interface UserService {
    int deleteUser(Integer userNum);

    User getUserByNum(Integer userNum);

    User addUser(User user);
}
