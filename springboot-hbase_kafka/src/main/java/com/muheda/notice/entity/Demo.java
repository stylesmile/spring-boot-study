package com.muheda.notice.entity;

import com.muheda.notice.hbase.HbaseColumn;
import com.muheda.notice.hbase.HbaseTable;

/**
 * @Author: Sorin
 * @Descriptions:
 * @Date: Created in 2018/3/22
 */
@HbaseTable(tableName="t_demo")
public class Demo {

	@HbaseColumn(family="rowkey", qualifier="rowkey")
	private String id;

	@HbaseColumn(family="demo", qualifier="content")
	private String content;

	@HbaseColumn(family="demo", qualifier="avg")
	private String avg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}
}
