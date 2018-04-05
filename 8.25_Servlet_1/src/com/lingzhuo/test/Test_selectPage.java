package com.lingzhuo.test;

import java.util.List;

import com.lingzhuo.dao.EmpDao;
import com.lingzhuo.daoImpl.EmpDaoImpl;
import com.lingzhuo.vo.EmpVo;
import com.lingzhuo.vo.PageVo;

public class Test_selectPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     EmpDao dao =new EmpDaoImpl();
     try {
    	 EmpVo emp=new EmpVo();
		int total =dao.selectEmpTotal(emp);
		 System.out.println("-----------total------------"+total);
	   PageVo page= new PageVo();
	   page.setPagNow(1);	//查询第N页  封装页码，计算了偏移量
	   page.setTotal(total);//封装总记录数，计算了总页数
	   
	   List<EmpVo> list =dao.selectEmpPageTotal(page,emp);
	   for(EmpVo vo:list){
		   System.out.println(	vo.getEmpno()+":"+vo.getEname()+":"+vo.getSal()+":"+vo.getSalGrade().getGrade()+":"+
			     vo.getDept().getDname());
	   }
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
	
     		e.printStackTrace();	
	}
     
     
	}

}
