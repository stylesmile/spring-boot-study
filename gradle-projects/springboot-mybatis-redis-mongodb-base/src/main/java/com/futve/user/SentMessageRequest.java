package com.futve.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenye
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SentMessageRequest {
    private String phone;
    private String code;
}
