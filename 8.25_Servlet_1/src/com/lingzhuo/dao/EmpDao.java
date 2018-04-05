package com.lingzhuo.dao;

import java.util.List;

import com.lingzhuo.vo.DeptVo;
import com.lingzhuo.vo.EmpVo;
import com.lingzhuo.vo.PageVo;

public interface EmpDao {
	
	
	    //查询总记录数
		public int selectEmpTotal(EmpVo emp) throws Exception;
		//查询总页数
		public List<EmpVo> selectEmpPageTotal(PageVo pagevo,EmpVo empvo) throws Exception;
		//查询经理信息
		public List<EmpVo> selectMgr()throws Exception;
		//查询部门信息
		public List<DeptVo> selectDept()throws Exception;
		//查询新增员工信息
		public int saveEmp()throws Exception;
		//删除多条记录
		public int deleteItems(String[] items) throws Exception;
		

}
