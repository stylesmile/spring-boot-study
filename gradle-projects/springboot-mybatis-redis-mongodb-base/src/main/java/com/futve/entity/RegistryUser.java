package com.futve.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (RegistryUser)实体类
 *
 * @author chenye
 * @since 2020-07-31 16:01:06
 */
@Data
public class RegistryUser implements Serializable {
    private static final long serialVersionUID = 242434444667391122L;

    private Integer id;

    private Long createdAt;

    private Long updatedAt;

    private String wwid;

    private String email;

    private String phone;

    private String displayName;

    private Integer role;
    /**
     * 密码
     */
    private String password;
    /**
     * 工会
     */
    private Integer organization;
    /**
     * 0:初始化,1:启用,2:禁用
     */
    private Integer status;
    /**
     * 名称
     */
    private String name;
    /**
     * 工会名称
     */
    private String orgName;
    /**
     * 用户性质
     */
    private Integer type;

    private Integer chosePercent;

    private Integer age;

    private String idcard;

    private String region;

}