package com.futve.vo.loginuser;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取用户列表
 */
@Data
public class MarkerChsoePercentRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7531509761002881936L;
    private Integer orgId;
    private Integer userId;
    private Integer chosePercent;
}
