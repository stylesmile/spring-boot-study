package com.futve.vo.loginuser;

import lombok.Data;

import java.io.Serializable;

/**
 * 新增/编辑工会
 */
@Data
public class OrgRequest implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -24617427639016957L;
	private Integer id;
	private String orgName;
    private Integer isDelete;
    private String orgFullName;
    private String coName;
	private String email;
}
