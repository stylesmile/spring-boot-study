package com.example.bootjpa.service;

import com.example.bootjpa.entity.UserEntity;
import com.example.bootjpa.repository.AccountRepository;
import org.hibernate.id.UUIDGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenye
 * @date 2019-06-12
 */
@Service
public class UserService {

    @Resource
    AccountRepository accountRepository;

    public List<UserEntity> getList() {
        return accountRepository.findAll();
    }

    public UserEntity add(UserEntity user) {
        return accountRepository.save(user);
    }
}
