package com.futve.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Integer id;

    private String roleName;

    private Long createTime;

    private Long updateTime;

    private String roleTag;

}