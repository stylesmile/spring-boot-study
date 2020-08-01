package com.example;

import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootTest
public class MongoTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void save() {
        User user = new User("zhangsan", "123456");

        mongoTemplate.save(user, "test_user");
    }

    @Test
    public void query() {
        User user = mongoTemplate.findOne(
                new Query(
                        Criteria.where("name").is("zhangsan")
                ),
                User.class, "test_user");
        System.out.println(user);
    }
}
