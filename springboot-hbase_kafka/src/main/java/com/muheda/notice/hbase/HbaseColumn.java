package com.muheda.notice.hbase;

import java.lang.annotation.*;

/**
 * @Author: Sorin
 * @Descriptions: 自定义注解，用于描述字段所属的 family与qualifier. 也就是hbase的列与列簇
 * @Date: Created in 2018/3/22
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD })
@Inherited
public @interface HbaseColumn {

    String family() default "";

    String qualifier() default "";

    boolean timestamp() default false;
}
