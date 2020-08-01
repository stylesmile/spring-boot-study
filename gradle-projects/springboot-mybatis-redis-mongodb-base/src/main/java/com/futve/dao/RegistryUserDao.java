package com.futve.dao;

import com.futve.common.constant.RedisPrefixConstant;
import com.futve.common.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * User Dao操作
 * @author chenye
 */
@Slf4j
@Repository
public class RegistryUserDao {

//    @Resource
//    private RedisHelper redisHelper;
      @Resource
      private RedisUtil redisUtil;

    /**
     * 设置短信登录验证码缓存
     *
     * @param code 验证码
     */
    public void setMessageLoginCode(String phone, String code) {
        redisUtil.set(
                String.format(RedisPrefixConstant.UserConstant.USER_MESSAGE_LOGIN_CODE, phone),
                code,
                RedisPrefixConstant.RedisExpireConstant.USER_MESSAGE_LOGIN_CODE);
    }

}
