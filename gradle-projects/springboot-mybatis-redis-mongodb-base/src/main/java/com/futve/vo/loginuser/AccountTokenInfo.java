package com.futve.vo.loginuser;

import lombok.Data;

/**
 * 用来缓存token相关信息
 * 
 * @author liu
 *
 */
@Data
public class AccountTokenInfo {
	/**
	 * accountToken
	 */
	private String accountToken;
	/**
	 * 用户基础信息
	 */
	private LoginUserResult loginUser;

	public AccountTokenInfo() {
	}

	public AccountTokenInfo(String accountToken, LoginUserResult loginUser) {
		this.accountToken = accountToken;
		this.loginUser = loginUser;
	}

}
