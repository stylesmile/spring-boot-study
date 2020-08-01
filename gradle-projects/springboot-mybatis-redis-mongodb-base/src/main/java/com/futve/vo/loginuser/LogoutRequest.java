package com.futve.vo.loginuser;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户修改密码
 */
@Data
public class LogoutRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5464003320179798299L;
	private Integer id;
}
