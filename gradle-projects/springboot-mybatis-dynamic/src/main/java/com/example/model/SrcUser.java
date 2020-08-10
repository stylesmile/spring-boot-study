package com.example.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author jason.tang
 * @create 2019-02-13 12:41
 * @description
 */
@Data
@ToString
public class SrcUser {
    private Integer userNum;
    private String status;
    private String money;
}