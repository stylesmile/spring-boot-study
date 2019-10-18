package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author chenye
 */
@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    MongoTemplate mongotemplate;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/list")
    @ResponseBody
    public String home() {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("test"));
        String name = mongotemplate.findOne(query, User.class).getName();
        return name;
    }
    @RequestMapping("/list2")
    @ResponseBody
    public List list2(String name) {
        return userRepository.findAllByNameLike(name);
    }
    @RequestMapping("/add")
    @ResponseBody
    public void add(String name) {
        User user = new User();
        user.setName("test");
        user.setPassword("123456");
        user.setPhone("15002221111");
        userRepository.save(user);
    }



}