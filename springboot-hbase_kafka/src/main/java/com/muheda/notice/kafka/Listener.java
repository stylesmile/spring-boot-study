package com.muheda.notice.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @Author: Sorin
 * @Descriptions:
 * @Date: Created in 2018/3/23
 */
@Component("listener")
public class Listener {


    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = {"notice"})
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("kafka的key: " + record.key());
        logger.info("kafka的value: " + record.value().toString());

    }

    @KafkaListener(topics = {"notice2"})
    public void listen2(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment) {
        logger.info("kafka2的key: " + record.key());
        logger.info("kafka2的value: " + record.value().toString());
        // 手动提交偏移量
        acknowledgment.acknowledge();
    }
}
