package com.example;

import com.example.dao.UserMapper;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbTests {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserService userService;

    @Test
    public void testData() {
        for (int i = 10000; i < 100; i++) {
            User user = User.UserBuilder.anUser().name(i + "").password(UUIDUtil.getUUID()).build();
            userService.save(user);
        }
    }

    @Test
    public void testData2() {
        log.info("<<<<<<<<< start  >>>>>>>>>>");
        long startTime = System.currentTimeMillis();

        List<User> userList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            User user = new User(i + "", UUID.randomUUID().toString().replace("-", ""));
            userList.add(user);
            if (userList.size() >= 3000) {
                insertData(userList);
                userList = new LinkedList<>();
            }
        }
        insertData(userList);
        long endTime = System.currentTimeMillis();
        log.info("运行时间:" + (endTime - startTime) + "ms");
    }

    @Async
    void insertData(List<User> userList) {
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        userService.saveBatch(userList);
    }

}
