package com.futve.vo.loginuser;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8800905438834188655L;
	private String name;
	private String phone;
	private String pwd;
	private String login_kind;
	
}
