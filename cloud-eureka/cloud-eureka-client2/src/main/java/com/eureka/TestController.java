package com.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author chenye
 * @date 2018/11/27
 */
@RestController
public class TestController {
    @Value("${server.port}")
    String serverPort;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        String hostAddress = "";
        try {
            InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
            hostAddress = address.getHostAddress();//
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostAddress +":"+serverPort;
    }
}
