package com.demo.service.impl;

import com.demo.dao.first.UserDao;
import com.demo.model.SrcUser;
import com.demo.model.User;
import com.demo.service.SrcUserService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jason.tang
 * @create 2019-02-13 14:36
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SrcUserService srcUserService;

    @Transactional
    @Override
    public User addUser(User user) {
        int rtn = userDao.addUser(user);
        if (rtn != 0) {
            if (user.getMoney().isEmpty()) {
                user.setMoney("0");
            }
            rtn = srcUserService.addSrcUser(user);
        }
        return user;
    }

    @Transactional
    @Override
    public int deleteUser(Integer userNum) {
        int rtn = userDao.deleteUser(userNum);

        if (rtn != 0) {
            rtn = srcUserService.deleteSrcUser(userNum);
        }
        return rtn;
    }

    @Override
    public User getUserByNum(Integer userNum) {
        User user = userDao.getUser(1);
        if (user != null) {
            SrcUser srcUser = srcUserService.getSrcUser(user.getUserNum());
            if (srcUser != null) {
                user.setMoney(srcUser.getMoney());
                user.setStatus(srcUser.getStatus());
            }
        }
        return user;
    }
}