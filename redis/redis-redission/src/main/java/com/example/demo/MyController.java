package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author : chenye
 * @date : 2020-12-17 23:14
 * @describe :
 */
@Slf4j
@RestController
public class MyController {
    @Resource
    private Redisson redisson;

    /**
     * localhost:8080?a=test1
     * localhost:8080?a=test2
     */
    @GetMapping("/")
    public String test(String a) {
        RLock lock = redisson.getLock("myProduct");
        lock.lock(30, TimeUnit.SECONDS);
        try {
            for (int i = 0; i < 900000; i++) {
                log.info(a + "," + i);
            }
            //doSomething
        } finally {
            lock.unlock();
        }
        return "操作完成";
    }

}
