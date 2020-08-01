package com.futve;

import com.futve.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class MongoTests {

    @Autowired
    private MongoTemplate mongoTemplate;


//    @Autowired
//    //@Qualifier("logsMongoTemplate")
//    private MongoTemplate logsMongoTemplate;

    @Test
    public void save() {
        Map map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", "11");
        mongoTemplate.save(map, "test_user");
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
