package com.example.bootkafka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenye
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootKafkaProducerApplication.class})
public class ProducerTest {

    @Autowired(required = false)
    private KafkaTemplate defaultKafkaTemplate;

    @Test
    public void testDefaultKafkaTemplate() {
        defaultKafkaTemplate.send("test_topic", "I`m send msg to default topic");
    }


    @Before
    public void testBefore() {
        System.out.println("before");
    }

    @After
    public void testAfter() {
        System.out.println("after");
    }
}
