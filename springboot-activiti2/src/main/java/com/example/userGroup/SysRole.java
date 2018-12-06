package com.example.userGroup;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 角色
 * chenye
 * 2018年9月10日下午3:38:49
 */
@Data
public class SysRole implements java.io.Serializable {

	protected Long id;

	protected Date createTime;

	// 角色名称
	private String name;

	// 角色类型,系统的角色，工作流角色
	@NotBlank(message = "角色类型不能为空")
	private String type;

	private String remark;
	private Integer deptId;
}