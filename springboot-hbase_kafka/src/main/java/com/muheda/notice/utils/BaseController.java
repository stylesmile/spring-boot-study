package com.muheda.notice.utils;

public class BaseController {

	/**
	 * @param reason
	 * @param obj
	 * @return ResultData
	 * @author Sorin
	 * @Description: json返回统一格式
	 * @date 2017年9月6日 上午11:05:33
	 */
	public ResultData setResponseEntity(String reason, String code, Object obj, boolean success) {
		ResultData body = new ResultData();
		body.setMessage(reason);
		body.setCode(code);
		body.setData(obj);
		body.setSuccess(success);
		return body;
	}
}
