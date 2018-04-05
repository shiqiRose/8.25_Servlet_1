package com.lingzhuo.vo;

import java.io.Serializable;

public class PageVo implements Serializable{
	
	//封装分页参数，页码、总页数，总记录数，偏移量，每页显示的行记录数
	private Integer pagNow;//页码
	private Integer total;//总记录数
	private Integer pageSize=5;//每页显示的行记录数
	private Integer offset;//偏移量  每页第一行 在数据库中是第几条
	private Integer pageTotal;//总页数
	
	public Integer getPagNow() {
		
		return pagNow;
	}
	public void setPagNow(Integer pagNow) {
		this.pagNow = pagNow;	
		this.offset=this.pageSize*(this.pagNow-1)+1;//封装页码时，直接结算偏移量offset
	}
	public Integer getTotal() {
		
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
		if(this.total%this.pageSize==0){
			this.pageTotal=total/pageSize;//求总页数
		}else{
			this.pageTotal=total/pageSize+1;
		}
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	
	
	

}
