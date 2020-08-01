package com.futve.vo.loginuser;

import lombok.Data;

/**
 * 用户修改密码请求
 */
@Data
public class EditPasswordRequest {
    private Integer id;
    private String old_pwd;
    private String new_pwd;

}
