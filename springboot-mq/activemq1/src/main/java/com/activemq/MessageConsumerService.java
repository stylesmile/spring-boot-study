package com.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
/**
 * 随后定义一个消息的消费者，消费者主要是进行一个监听控制，
 * 在 SpringBoot 里面可以直接利用注解@JmsListener进行监听：
  */
@Service
public class MessageConsumerService {
    @JmsListener(destination="study.msg.queue")
    public void receiveMessage(String text) {    // 进行消息接收处理
        System.err.println("【*** 接收消息 ***】" + text);
    }
}