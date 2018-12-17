package com.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收者
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
 
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }
 
}