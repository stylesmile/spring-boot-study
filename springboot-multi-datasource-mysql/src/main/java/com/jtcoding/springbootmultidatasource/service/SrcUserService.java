package com.jtcoding.springbootmultidatasource.service;

import com.jtcoding.springbootmultidatasource.model.SrcUser;
import com.jtcoding.springbootmultidatasource.model.User;

/**
 * @author jason.tang
 * @create 2019-02-13 14:45
 * @description
 */
public interface SrcUserService {
    int deleteSrcUser(Integer userNum);

    SrcUser getSrcUser(Integer userNum);

    int addSrcUser(User user);
}
