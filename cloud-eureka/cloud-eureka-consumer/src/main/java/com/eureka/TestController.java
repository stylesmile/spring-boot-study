package com.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenye
 * @date 2018/11/27
 */
@RestController
public class TestController {
    @Value("{server.port}")
    String serverPort;
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/test2")
    @ResponseBody
    public String test(){
        return  serverPort+"cumsumer";
    }
    /**
     * Rest服务端使用RestTemplate发起http请求,然后得到数据返回给前端----gotoUser是为了区分getUser怕小伙伴晕头
     * @return
     */
    @GetMapping(value = "/test")
    @ResponseBody
    public String getUser(){
        /**
         * 小伙伴发现没有，地址居然是http://service-provider
         * 居然不是http://127.0.0.1:8082/
         * 因为他向注册中心注册了服务，服务名称service-provider,我们访问service-provider即可
         */
        String data = restTemplate.getForObject("http://cloud-eureka-client/test",String.class);
        return data;
    }

}
