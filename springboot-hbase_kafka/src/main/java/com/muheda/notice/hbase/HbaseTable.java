package com.muheda.notice.hbase;

import java.lang.annotation.*;

/**
 * @Author: Sorin
 * @Descriptions: 自定义注解，用于获取table
 * @Date: Created in 2018/3/22
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE })
@Inherited
public @interface HbaseTable {
    String tableName() default "";
}
