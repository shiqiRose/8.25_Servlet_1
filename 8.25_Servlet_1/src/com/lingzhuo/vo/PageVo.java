package com.lingzhuo.vo;

import java.io.Serializable;

public class PageVo implements Serializable{
	
	//��װ��ҳ������ҳ�롢��ҳ�����ܼ�¼����ƫ������ÿҳ��ʾ���м�¼��
	private Integer pagNow;//ҳ��
	private Integer total;//�ܼ�¼��
	private Integer pageSize=5;//ÿҳ��ʾ���м�¼��
	private Integer offset;//ƫ����  ÿҳ��һ�� �����ݿ����ǵڼ���
	private Integer pageTotal;//��ҳ��
	
	public Integer getPagNow() {
		
		return pagNow;
	}
	public void setPagNow(Integer pagNow) {
		this.pagNow = pagNow;	
		this.offset=this.pageSize*(this.pagNow-1)+1;//��װҳ��ʱ��ֱ�ӽ���ƫ����offset
	}
	public Integer getTotal() {
		
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
		if(this.total%this.pageSize==0){
			this.pageTotal=total/pageSize;//����ҳ��
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
