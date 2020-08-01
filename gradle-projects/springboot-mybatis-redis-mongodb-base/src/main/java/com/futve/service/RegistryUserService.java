package com.futve.service;

import com.futve.common.base.GlobalResponse;
import com.futve.common.tools.altools.SendSmsUtils;
import com.futve.dao.RegistryUserDao;
import com.futve.entity.RegistryUser;
import com.futve.mapper.RegistryUserMapper;
import com.futve.user.SentMessageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (RegistryUser)表服务实现类
 *
 * @author chenye
 * @since 2020-07-31 16:01:10
 */
@Service("registryUserService")
public class RegistryUserService {

    @Resource
    private RegistryUserDao registryUserDao;
    @Resource
    private RegistryUserMapper registryUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public RegistryUser queryById(Integer id) {
        return null;
    }

    /**
     * 发送短信验证码
     */
    public GlobalResponse<String> sendMessageCode(SentMessageRequest sentMessageRequest) {
        String phone = sentMessageRequest.getPhone();
        String code = String.valueOf(
                (
                        (Double) (Math.random() * 10000)
                ).intValue()
        );
        registryUserDao.setMessageLoginCode(sentMessageRequest.getPhone(), code);
        SendSmsUtils.send(sentMessageRequest.getPhone(), code);
        return GlobalResponse.success();
    }

    /**
     * @param sentMessageRequest
     * @return
     */
    public RegistryUser codeLogin(SentMessageRequest sentMessageRequest) {
//        RegistryUser user = registryUserMapper.getUserByPhone(sentMessageRequest.getPhone());
//        if (user != null) {
//
//        }
        return null;
    }
}