package com.futve.vo.loginuser;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class RoleResult implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3874961141773014575L;

    /**
     * 角色名称
     */
    private String name;

    /**
     * id
     */
    private int id;

    /**
     * 角色标记
     */
    private String roleTag;

    /**
     * 角色用户人数
     */
    private Long urNo;

    public RoleResult(int id) {
        this.id = id;
    }
}
