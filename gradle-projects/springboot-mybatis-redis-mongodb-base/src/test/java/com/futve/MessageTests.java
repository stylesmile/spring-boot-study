package com.futve;

import com.futve.service.RegistryUserService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MessageTests {
    @Resource
    RegistryUserService RegistryUserService;

//    @Test
//    public void sendMessage(){
//        SentMessageRequest sentMessageRequest = SentMessageRequest.builder()
//                .code("code")
//                .phone("15002770045")
//                .build();
//        RegistryUserService.sendMessageCode(sentMessageRequest);
//    }
}
