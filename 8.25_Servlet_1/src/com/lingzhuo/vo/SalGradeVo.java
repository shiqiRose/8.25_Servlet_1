package com.lingzhuo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class SalGradeVo implements Serializable{
	
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public BigDecimal getMinsal() {
		return minsal;
	}
	public void setMinsal(BigDecimal minsal) {
		this.minsal = minsal;
	}
	public BigDecimal getMaxsal() {
		return maxsal;
	}
	public void setMaxsal(BigDecimal maxsal) {
		this.maxsal = maxsal;
	}
	private Integer grade;
	private BigDecimal minsal;
	private BigDecimal maxsal;
	
}