package com.example.bootkafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试kafka生产者
 *
 * @author chenye
 */
@RestController
public class TestKafkaProducerController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;
    @Resource
    private KafkaSendResultHandler producerListener;

    @GetMapping("/send")
    public String send(@RequestParam("msg") String msg) {
        //回调
        kafkaTemplate.setProducerListener(producerListener);

        //发送消息
        ListenableFuture list = kafkaTemplate.send("test_topic", msg);

        return "success：" + msg+list.toString();
    }


}
