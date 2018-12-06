package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Email;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chenye
 * @date 2018/11/05
 */
@Mapper
public interface EmailMapper extends BaseMapper<Email> {
    /**
     * 更新流程实例ID
     * @param email
     * @return
     */
    public int updateProcessInstanceId(Email email);

    Email getByProcessInstanceId(String processInstanceId);
}
