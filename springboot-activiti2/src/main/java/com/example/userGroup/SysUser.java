package com.example.userGroup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/*
*   用户实体
*
*/
@Data
public class SysUser implements java.io.Serializable{

	

	protected Long id;
	// 删除标识
	@JsonIgnore
	protected Integer delFlag= 0;
	// 创建时间
	protected Date createDate;
	// 登录名，编号
	private String code;
	// 用户姓名
	@NotBlank(message = "用户名不能为空")
	private String name;
	// 组织机构id
	private Long deptId;
	//涉密级别id
	private Integer usersecretId; 	
	//状态
	private Integer state;
	//邮箱大小
	private Long totalSize;
	private Long usedSize;
	//附件大小
	private Long attachmentSize;
	// 密码
	@JsonIgnore
	private String password;
	//生日
	private Date birthday;
	private Integer sex;
	private String email;
	//电话
	private String phone;
	//地址
	private String address;
	//域名
	private String domain;
	//拼音
	private String pinyin;
	//头像路径
	private String photo_url;
	//排序
	private String sort;
	//备注
	private String remark;
	private Date updateDate;
	private Integer secretLevelId;

	public SysUser(String name, String password) {
		this.name=name;
		this.password=password;
	}

	public SysUser(Integer id, String name, String password) {
		this.id=id.longValue();
		this.name=name;
		this.password=password;
	}

	public String getUserNames() {
		return this.getName()+"&lt;"+getCode()+"&gt;";
	}
	public String getStatusName() {
		if(this.state==null) return "";
		/*-1删除，0待审批，1正常，2锁  3禁用*/
		switch(this.state) {
		case 1:return "正常";
		case 2:return "锁定";
		case 3:return "禁用";
		default:return "";
		}
	}
	private List<SysRole> sysRoles;
	public List<SysRole> getSysRoles() {
		return sysRoles;
	}
	public void setSysRoles(List<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

}
