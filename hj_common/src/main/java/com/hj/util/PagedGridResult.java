package com.hj.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Title: PagedGridResult.java
 * @Package com.imooc.utils
 * @Description: 用来返回分页Grid的数据格式
 * Copyright: Copyright (c) 2021
 */
public class PagedGridResult {

	private int page;            // 当前页数
	private long total;            // 总页数
	private long records;        // 总记录数
	private List<?> rows;        // 每行显示的内容

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public static PagedGridResult setterPagedGrid(List<?> list, Integer page) {
		PageInfo<?> pageList = new PageInfo<>(list);
		PagedGridResult gridResult = new PagedGridResult();
		gridResult.setRows(list);
		gridResult.setPage(page);
		gridResult.setRecords(pageList.getTotal());
		gridResult.setTotal(pageList.getPages());
		return gridResult;
	}
}
