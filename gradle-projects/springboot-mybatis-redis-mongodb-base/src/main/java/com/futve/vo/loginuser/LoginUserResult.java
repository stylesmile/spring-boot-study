package com.futve.vo.loginuser;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LoginUserResult implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4267941084513384638L;
	private String access_token;
    private String secret_key;
    private SysUser sysUser;
    private List<RoleResult> roles;
}
