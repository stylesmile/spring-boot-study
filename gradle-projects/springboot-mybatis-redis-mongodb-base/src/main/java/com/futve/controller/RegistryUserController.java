package com.futve.controller;

import com.futve.common.base.GlobalResponse;
import com.futve.common.base.RequestForm;
import com.futve.common.constant.ArtCommonConstant;
import com.futve.entity.RegistryUser;
import com.futve.service.RegistryUserService;
import com.futve.user.SentMessageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (RegistryUser)表控制层
 *
 * @author chenye
 * @since 2020-07-31 16:01:11
 */
@RestController
@RequestMapping("user")
@Api(value = ArtCommonConstant.ServerConfig.CONTEXT + "/swagger/user")
public class RegistryUserController {
    /**
     * 服务对象
     */
    @Resource
    private RegistryUserService registryService;

    /**
     * 通过主键查询单条数据
     *
     * @param requestForm 参数
     * @return 单条数据
     */
    @GetMapping("codeLogin")
    public RegistryUser codeLogin(RequestForm requestForm) {
        SentMessageRequest sentMessageRequest = requestForm.getContent(SentMessageRequest.class);
        return this.registryService.codeLogin(sentMessageRequest);
    }

    /**
     * 发送短信验证码
     */
    @ApiOperation(notes = "/sendMessageCode", value = "发送短信验证码")
    @RequestMapping(value = {"/sendMessageCode"}, method = RequestMethod.POST)
    public GlobalResponse<String> sendMessageCode(RequestForm requestForm) {
        SentMessageRequest sentMessageRequest = requestForm.getContent(SentMessageRequest.class);
        return registryService.sendMessageCode(sentMessageRequest);
    }
}