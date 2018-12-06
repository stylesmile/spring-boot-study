package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy    //开启Zuul 网关
@EnableEurekaServer //开启EurekaServer
@SpringBootApplication
public class EurekaServerXuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerXuulApplication.class, args);
    }
}
