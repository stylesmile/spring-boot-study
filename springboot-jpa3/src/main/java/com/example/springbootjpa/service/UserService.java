package com.example.springbootjpa.service;

import com.example.springbootjpa.demain.UserDemain;
import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.filter.UserFilter;
import com.example.springbootjpa.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService extends BaseCURDService<UserDemain ,User, UserFilter,Integer> {

    @Resource
    UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    protected User toEntity(UserDemain model) {
        User user = new User();
        BeanUtils.copyProperties(model, user);
        return user;
    }

    @Override
    protected UserDemain toView(User entity) {
        return null;
    }

    @Override
    protected Integer getID(UserDemain model) {
        return model.getId();
    }

    @Override
    protected Specification<User> toFilter(UserFilter filter) {
        return null;
    }
}
