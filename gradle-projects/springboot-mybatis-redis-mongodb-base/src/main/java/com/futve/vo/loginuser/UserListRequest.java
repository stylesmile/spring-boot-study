package com.futve.vo.loginuser;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 获取用户列表
 */
@Data
public class UserListRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7531509761002881936L;
    private String phone;
    private String display_name;
    private Integer orgId;
    private String orgName;
    private String name;
    private Integer roleId;
    private Integer type;
    private List<Integer> types;
    /**
     * 0或无:排除禁用状态数据，1:所有数据
     */
    private Integer status;
}
