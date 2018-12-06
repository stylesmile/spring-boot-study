package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenye
 * @date 2018/11/04
 */
@Data
public class Role implements Serializable {
    private String id;
    private String name;
    private String type;

    public Role() {
    }
}
