package com.activemq;

/**
 * 建立消息的发送者服务，一般而言如果进行消息的发送往往会准备出一个业务接口来：
 */
public interface IMessageProducerService {
    public void sendMessage(String msg) ;
}