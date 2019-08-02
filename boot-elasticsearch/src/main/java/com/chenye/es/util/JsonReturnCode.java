package com.chenye.es.util;

/**
 * 描述: json格式数据返回码
 *<ul>
 *      <li>100 : 用户未登录 </li>
 *      <li>200 : 成功 </li>
 *      <li>300 : 失败 </li>
 * </ul>
 * @author  Administrator
 */
public enum JsonReturnCode {

    SUCCESS ("200","成功")
    ,FAIL ("500","内部失败")
	,ACCESS_ERROR ("403","禁止访问")
	,NOT_FOUND ("404","页面未发现")
	,RUN_EXCEPTION ("600","运行时异常")
    ,NOT_LOGIN("100","未登录或登录超时");

    private String code;
    private String desc;

    JsonReturnCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
