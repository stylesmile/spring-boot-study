package com.futve.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private Long createdAt;

    private Long updatedAt;

    private String wwid;

    private String email;

    private String phone;

    private String displayName;

    private Integer role;

    private String password;

    private Integer organization;

    private Integer status;

    private String name;

    private String orgName;

    private Integer type;

    /**
     * 质检抽取比例
     */
    private Integer chosePercent;
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