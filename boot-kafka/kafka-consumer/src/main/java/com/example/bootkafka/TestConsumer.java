package com.example.bootkafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka消费者测试
 *
 * @author chenye
 */
@Component
public class TestConsumer {

    @KafkaListener(topics = "test_topic")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
    }
}
