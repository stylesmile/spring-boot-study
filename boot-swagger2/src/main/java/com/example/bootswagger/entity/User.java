package com.example.bootswagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author chenye
 */
@ApiModel(description = "用户")
@Getter
@Setter
public class User {

    private int id;

    @NotNull(message = "用户名不能为空")
    @Size(min = 6, max = 20, message = "用户名长度应该在6-20个字符之间")
    @Pattern(regexp = Const.PASSWD_REGEXP, message = "密码长度为6-20位，必须且只能包含数字和字母")
    @ApiModelProperty(value = "用户名", example = "13012344321", dataType="String")
    private String username;

    @NotNull(message = "年龄不能为空")
    @Size(min = 6, max = 20, message = "密码长度应该在6-20个字符之间")
    @ApiModelProperty(value = "年龄", example = "11", dataType = "Integer")
    private int age;

}