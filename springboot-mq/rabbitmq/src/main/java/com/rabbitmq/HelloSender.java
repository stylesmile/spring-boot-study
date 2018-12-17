package com.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 发送者
 * 注意，发送者和接收者的queue name必须一致，不然不能接收
 */
public class HelloSender {
 
    @Autowired
    private AmqpTemplate rabbitTemplate;
 
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
 
}