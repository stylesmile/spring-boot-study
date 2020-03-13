package com.example.springbootjpa.service;

import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.entity.UserRole;
import com.example.springbootjpa.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleService {

    @Resource
    UserRoleRepository userRoleRepository;



    public void saveUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}
