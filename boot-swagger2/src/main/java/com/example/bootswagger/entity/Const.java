package com.example.bootswagger.entity;

/**
 * 定义常见的常量
 *
 * @author carfield
 */
public class Const {

    /**
     * KEY_CAPTCHA :session里面图形验证码对应的key
     */
    public static final String KEY_CAPTCHA = "KEY_CAPTCHA";
    /**
     * KEY_SMS : session里面短信验证码对应的key
     */
    public static final String KEY_SMS = "KEY_SMS";

    /**
     * 手机号码正则表达式,如果开放其他号段，在次修改
     * (\\+\\d+)?1[34578]\\d{9}$
     */
    public static final String MOBILE_REGEXP = "(\\+\\d+)?1\\d{10}$";

    /**
     * 密码正则表达式 密码由数字和字母混合组成，6到20位
     */
    public static final String PASSWD_REGEXP = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";
    public static final String OPTIONS = "OPTIONS";
}
