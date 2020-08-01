package com.futve.vo.loginuser;

import lombok.Data;

/**
 * 用来缓存token相关信息
 * 
 * @author chenye
 *
 */
@Data
public class TokenUserInfo {
	/**
	 * accountToken
	 */
	private String accountToken;
	/**
	 * 用户基础信息
	 */
	private LoginUser loginUser;

	public TokenUserInfo() {
	}

	public TokenUserInfo(String accountToken, LoginUser loginUser) {
		this.accountToken = accountToken;
		this.loginUser = loginUser;
	}

}
