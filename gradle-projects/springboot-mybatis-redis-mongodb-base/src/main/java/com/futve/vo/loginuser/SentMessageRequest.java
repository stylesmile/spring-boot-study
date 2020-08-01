package com.futve.vo.loginuser;

import lombok.Data;

/**
 * @author chenye
 */
@Data
public class SentMessageRequest {
    private String phone;
    private String code;
}
