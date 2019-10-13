package com.example.bootswagger.entity;

/**
 * 定义常见的常量
 *
 * @author carfield
 */
public class Const {

    /**
     * 国内电话 正则表达式
     */
    public static final String PHONE = "\\d{3}-\\d{8}|\\d{4}-\\{7,8}";
    /**
     * 邮箱 正则表达式
     */
    public static final String MAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
    /**
     * 密码正则表达式 密码由数字和字母混合组成，6到20位
     */
    public static final String PASSWD_REGEXP = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";
    /**
     * 中文 正则表达式
     */
    public static final String CHINESE_REGEXP = "[\\u4e00-\\u9fa5]";

    /**
     * 手机号码正则表达式,如果开放其他号段，在次修改
     * (\\+\\d+)?1[34578]\\d{9}$
     */
    public static final String MOBILE_REGEXP = "(\\+\\d+)?1\\d{10}$";

}
