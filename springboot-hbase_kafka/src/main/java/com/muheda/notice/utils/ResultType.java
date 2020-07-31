package com.muheda.notice.utils;

/**
 * webapi接口全局返回枚举
 * @author Sorin
 * @date 2017年9月6日 上午11:11:39
 */
public enum ResultType {

	/** 系统繁忙 */
	SYSTEM_BUSY("-1", "系统繁忙"),

	/** 请求成功 */
	SUCCESS("200", "请求成功"),

	/** 服务器异常, 请联系我们 */
	SERVER_ERROR("500", "服务器异常, 请联系我们"),

	/** 获取key错误，或者access_token无效 */
	APP_SECRET_ERROR("40001", "获取key错误，或者key无效"),

	/** 不合法的ID */
	PARAMS_ERROR("400", "参数不合法"),

	/** 不合法的ID */
	ILLEGAL_OPEN_ID("401", "不合法的uuid"),

	/** 不合法的请求字符 */
	ILLEGAL_REQUEST_STRING("403", "不合法的请求字符"),
	
	/** 不合法的请求字符 */
	RIDINGLOGS_NULL("407", "未查询到骑行信息"),

	/** 编号重复 */
	START_END_TIME_ERROR("406", "编号重复"),

	/** token无效 */
	TOKEN_INVALID("408", "token无效"),

	/** 未登录 */
	USER_NO_LOGIN("409", "未登录");
	
	/** 结果码 */
	String code;

	/** 结果描述 */
	String description;

	/**
	 * @Description: 返回结果枚举构造方法
	 * @param code 结果码
	 * @param description 结果描述
	 * @author Sorin
	 * @date 2017年9月6日 上午11:10:07
	 */
	private ResultType(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	/**
	 * @Description: 通过code得到返回结果对象
	 * @param code 结果码
	 * @return
	 * @return ResultType 结果枚举对象
	 * @author Sorin
	 * @date 2017年9月6日 上午11:10:23
	 */
	public static ResultType get(String code) {
		ResultType[] list = values();
		for (ResultType resultType : list) {
			if (code.equals(resultType.getCode())) {
				return resultType;
			}
		}
		return null;
	}

	/**
	 * @Description: 获得结果码
	 * @return 结果码
	 * @return String
	 * @author Sorin
	 * @date 2017年9月6日 上午11:10:40
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @Description: 获得结果描述
	 * @return
	 * @return String
	 * @author Sorin
	 * @date 2017年9月6日 上午11:11:19
	 */
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "ResultType{" + "code=" + code + ", description='" + description + '\'' + '}';
	}
}
