package com.futve.common.tools.altools;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.futve.common.tools.JsonUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 发送短信
 *
 * @author chenye
 */
public class SendSmsUtils {

    private static final String REGION_ID = "cn-hangzhou";
    private static final String SMS_SCCESS_KEY_ID = "LTAI4GBZDWmBKtjYRax9dDGN";
    private static final String ACCESS_SECRET = "Nq3UMIB0cWJwUTq3Q7n40E8lR04t2h";
    private static final String SIGN_NAME = "未有科技";

    public static void send(String phone, String code) {
        // TODO 根据返回码判断是否发送成功
        DefaultProfile profile = DefaultProfile.getProfile(REGION_ID, SMS_SCCESS_KEY_ID, ACCESS_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        //短信签名
        request.putQueryParameter("SignName", SIGN_NAME);
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("TemplateCode", "SMS_192826408");

        Map<String, String> codeMap = new ConcurrentHashMap<>(1);
        codeMap.put("code", code);

        request.putQueryParameter("TemplateParam", JsonUtil.toJson(codeMap));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            System.out.println(response.getData());
            System.out.println(response.getData());
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Integer code = (int) (Math.random() * 10000);
        System.out.println(code);
        send("15671673885", String.valueOf(code));
    }
}
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.5.0</version>
</dependency>
*/
