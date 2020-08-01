package com.futve.vo.loginuser;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取用户信息
 */
@Data
public class UserInfoRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7531509761002881936L;
    private Integer userId;
}
