package com.futve.vo.loginuser;

import lombok.Data;

import java.io.Serializable;

/**
 * 新增/编辑用户
 * 根据传递的手机号等信息
 */
@Data
public class UserAddOrUpdateRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -24617427639016957L;
    private Integer id;
    private String phone;
    private String email;
    private String displayName;
    private Integer orgId;
    private String name;
    private String roles;
    private Integer type;
    private Integer status;
    /**
     * 籍贯
     */
    private String region;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 身份证
     */
    private String idcard;
}
