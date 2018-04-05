package com.lingzhuo.demo.control;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lingzhuo.dao.EmpDao;
import com.lingzhuo.daoImpl.EmpDaoImpl;
import com.lingzhuo.vo.DeptVo;
import com.lingzhuo.vo.EmpVo;
import com.lingzhuo.vo.PageVo;

@WebServlet("/testControl")
public class TestControl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("str", "qianqian");
		EmpVo emp=new EmpVo();
		emp.setEmpno(101);
		emp.setEname("shiqi");
		emp.setSal(new BigDecimal("10202"));
		emp.setHiredate(Date.valueOf("2017-8-26"));
		
		DeptVo dept=new DeptVo();
		dept.setDeptno(90);
		dept.setDname("fuwubu");
		emp.setDept(dept);
		
		req.setAttribute("empvo",emp);
		
		PageVo page=new PageVo();
		page.setPagNow(1);
		
		EmpDao dao=new EmpDaoImpl();
		try {
			List<EmpVo> list=dao.selectEmpPageTotal(page,emp);
			req.setAttribute("res", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("a", "SMITH");
		map.put("b","jones");
		req.setAttribute("m", map);
		
		req.getRequestDispatcher("success.jsp").forward(req, resp);
		
	}
	
	

}
