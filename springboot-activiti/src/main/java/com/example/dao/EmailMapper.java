package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Email;

/**
 * @author chenye
 * @date 2018/11/05
 */
public interface EmailMapper extends BaseMapper<Email> {
    /**
     * 更新流程实例ID
     * @param email
     * @return
     */
    public int updateProcessInstanceId(Email  email);

    Email getByProcessInstanceId(String processInstanceId);
}
