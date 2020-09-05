package com.demo.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class RouterConfig {

    @Autowired
    private HelloWorldHandler helloWorldHandler;

    @Bean
    public RouterFunction<?> helloRouter() {
        return RouterFunctions.route(RequestPredicates.GET("/hello"), helloWorldHandler::helloWorld);
    }
    @Bean
    public RouterFunction<?> helloRouter2() {
        return RouterFunctions.route(RequestPredicates.GET("/hello2"), helloWorldHandler::helloWorld2);
    }

}