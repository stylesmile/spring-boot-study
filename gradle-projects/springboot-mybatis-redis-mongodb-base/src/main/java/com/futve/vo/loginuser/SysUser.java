package com.futve.vo.loginuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 登录的用户信息类
 * 用户表记录用户登录账号和联系方式等基本信息
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6336846002436741226L;
    /**
     * 用户主表(user) id
     */
    private int id;
    /**
     * 用户手机号码
     */
    private String phone;
    /**
     * 用户名称
     */
    private String name;
    /**
     *
     */
    private String displayName;
    /**
     * 工会ID
     */
    private Integer orgId;
    /**
     * 工会名称
     */
    private String orgName;
    /**
     * 更新时间
     */
    private Long updated_at;
    /**
     * 用户性质
     */
    private Integer type;
    /**
     * 角色列表
     */
    private List<RoleResult> roles;
    /**
     * 账号状态
     */
    private Integer status;


}