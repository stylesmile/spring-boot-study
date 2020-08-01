package com.futve.vo.loginuser;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserResultWithPage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6286594198583151490L;
	private long totalCount;
	private int pageNo;
    private int pageSize;
    private List<SysUser> userList;
}