package com.example;

import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;

@SpringBootTest
public class MultiMongoTests {

//    @Autowired
//    private MongoTemplate mongoTemplate;

//    @Resource
//    @Qualifier("tasksMongoTemplate")
//    private MongoTemplate tasksMongoTemplate;

    @Autowired
    @Qualifier("logsMongoTemplate")
    private MongoTemplate logsMongoTemplate;

    @Test
    public void save() {
        User user = new User("zhangsan", "123456");
        logsMongoTemplate.save(user, "test_user");
    }

    @Test
    public void query() {
        User user = logsMongoTemplate.findOne(
                new Query(
                        Criteria.where("name").is("zhangsan")
                ),
                User.class, "test_user");
        System.out.println(user);
    }
}
