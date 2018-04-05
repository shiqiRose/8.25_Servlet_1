package com.lingzhuo.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class EmpVo implements Serializable{
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private BigDecimal sal;
	private BigDecimal comm;
	private Integer deptno;
	
	private DeptVo dept;
	private SalGradeVo salGrade;
	
	//²éÑ¯Ìõ¼þ
	private BigDecimal minsal;
	private BigDecimal maxsal;
	
	private String getOrderFlg;
	public String getGetOrderFlg() {
		return getOrderFlg;
	}
	public void setGetOrderFlg(String getOrderFlg) {
		this.getOrderFlg = getOrderFlg;
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
	public DeptVo getDept() {
		return dept;
	}
	public void setDept(DeptVo dept) {
		this.dept = dept;
	}
	public SalGradeVo getSalGrade() {
		return salGrade;
	}
	public void setSalGrade(SalGradeVo salGrade) {
		this.salGrade = salGrade;
	}
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public BigDecimal getSal() {
		return sal;
	}
	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}
	public BigDecimal getComm() {
		return comm;
	}
	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
	

}
