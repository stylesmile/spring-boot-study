package com.jtcoding.springbootmultidatasource.service.impl;

import com.jtcoding.springbootmultidatasource.dao.second.SrcUserDao;
import com.jtcoding.springbootmultidatasource.model.SrcUser;
import com.jtcoding.springbootmultidatasource.model.User;
import com.jtcoding.springbootmultidatasource.service.SrcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jason.tang
 * @create 2019-02-13 14:45
 * @description
 */
@Service
public class SrcUserServiceImpl implements SrcUserService {
    @Autowired
    private SrcUserDao srcUserDao;


    @Transactional
    @Override
    public int deleteSrcUser(Integer userNum) {
        return srcUserDao.deleteSrcUser(userNum);
    }

    @Override
    public SrcUser getSrcUser(Integer userNum) {
        return srcUserDao.getSrcUser(userNum);
    }

    @Transactional
    @Override
    public int addSrcUser(User user) {
        return srcUserDao.addSrcUser(user);
    }
}