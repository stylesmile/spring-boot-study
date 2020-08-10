package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author chenye
 */
@Data
@ToString
public class SrcUser {
    private Integer userNum;
    private String status;
    private String money;
}