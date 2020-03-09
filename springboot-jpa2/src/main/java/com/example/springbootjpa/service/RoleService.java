package com.example.springbootjpa.service;

import com.example.springbootjpa.entity.Role;
import com.example.springbootjpa.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {

    @Resource
    RoleRepository RoleRepository;

    public List<Role> getRoleList() {
        return RoleRepository.findAll();
    }

    public void save(Role role) {
        RoleRepository.save(role);
    }
}
