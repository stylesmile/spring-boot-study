package com.Stylesmile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.dao") //或在mapper 加@mapper  //扫描dao
public class StylesmileApplication {

    public static void main(String[] args) {
        SpringApplication.run(StylesmileApplication.class, args);
    }

}
