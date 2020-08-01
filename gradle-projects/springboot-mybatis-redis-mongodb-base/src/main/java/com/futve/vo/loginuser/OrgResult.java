package com.futve.vo.loginuser;

import com.futve.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 工会
 */
@Data
public class OrgResult implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -24617427639016957L;
	private Integer id;
	private String orgName;
	private String coName;
	private Long userNum;
    private Integer isDelete;
    private Long create_at;
    private Integer createUser;
    private String createName;
	private List<User> chairmans;
	private String email;
}
