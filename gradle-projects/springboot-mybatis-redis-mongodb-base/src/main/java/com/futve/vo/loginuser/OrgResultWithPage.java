package com.futve.vo.loginuser;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 工会
 */
@Data
public class OrgResultWithPage implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -24617427639016957L;
	private long totalCount;
	private int pageNo;
    private int pageSize;
    private List<OrgResult> orgResult;
}
