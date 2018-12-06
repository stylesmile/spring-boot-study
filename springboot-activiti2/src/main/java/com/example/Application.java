package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
//@MapperScan("com.example.dao") //或在mapper 加@mapper  //扫描dao
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
