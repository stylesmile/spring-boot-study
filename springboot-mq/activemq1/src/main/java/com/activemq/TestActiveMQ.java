package com.activemq;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest(classes = ActivemqApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMQ {
    @Resource
    private IMessageProducerService messageProducer;

    @Test
    public void testSend() throws Exception {
        for (int x = 0; x < 10; x++) {
            this.messageProducer.sendMessage("study - " + x);
        }
    }
}