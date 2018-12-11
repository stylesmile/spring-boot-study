package com.Stylesmile.entity;

import lombok.Data;

/**
 * @author chenye
 * @date 2018/12/10
 */
@Data
public class SysRole {
    private int id;
    private String name;
    private String code;
    private String sort;

    public SysRole() {}

    public SysRole(int id, String name, String code, String sort) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.sort = sort;
    }
}
