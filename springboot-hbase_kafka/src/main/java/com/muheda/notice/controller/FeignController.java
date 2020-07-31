package com.muheda.notice.controller;

import com.muheda.notice.utils.BaseController;
import com.muheda.notice.utils.ResultData;
import com.muheda.notice.utils.ResultType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Sorin
 * @Descriptions:
 * @Date: Created in 2018/3/23
 */
@RestController
@RequestMapping("/kafka")
public class FeignController extends BaseController{

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping(value = "/send/notice")
    public ResultData sendKafkaNotice(String message) {
        try {
            kafkaTemplate.send("notice", "key", message);
            logger.info("发送kafka成功.");
            return setResponseEntity(ResultType.SUCCESS.getDescription(), ResultType.SUCCESS.getCode(),null,true);
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            return setResponseEntity(ResultType.SERVER_ERROR.getDescription(),ResultType.SERVER_ERROR.getCode(),null,false);
        }
    }

    @GetMapping(value = "/send/notice2")
    public ResultData sendKafkaNotice2(String message) {
        try {
            kafkaTemplate.send("notice2", "key", message);
            logger.info("发送kafka成功.");
            return setResponseEntity(ResultType.SUCCESS.getDescription(), ResultType.SUCCESS.getCode(),null,true);
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            return setResponseEntity(ResultType.SERVER_ERROR.getDescription(),ResultType.SERVER_ERROR.getCode(),null,false);
        }
    }
}
