package com.lingzhuo.control;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

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

/**
 * Servlet implementation class EmpControl
 */
@WebServlet("/EmpControl")
public class EmpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static EmpDao empDao; 
    static{
    	empDao=new EmpDaoImpl();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action =request.getParameter("action");
		if(action.equals("page")){
			String ename=request.getParameter("ename");
			String minsal=request.getParameter("minsal");
			String maxsal=request.getParameter("maxsal");
			
			String orderFlg=request.getParameter("orderFlg");
			 
		    if(orderFlg==null||orderFlg.equals("")){
		    	orderFlg="1";
		    }
			
			String pageNow=request.getParameter("pageNow");//当前页码
			if(pageNow==null){
				pageNow="1";
			}
			try {
			EmpVo empvo=new EmpVo();	
		    empvo.setEname(ename);
		    empvo.setMinsal(minsal!=null&&!minsal.toString().equals("")&&!minsal.toString().equals("null")?new BigDecimal(minsal):null);
		    empvo.setMaxsal(maxsal!=null&&!maxsal.toString().equals("")&&!maxsal.toString().equals("null")?new BigDecimal(maxsal):null);
		    
		    empvo.setGetOrderFlg(orderFlg);//按日期排序
		    
		   
			int total=empDao.selectEmpTotal(empvo);//查询总记录数
			System.out.println("-----total------"+total);
			
			
			PageVo pagevo=new PageVo();
			pagevo.setPagNow(Integer.parseInt(pageNow));//封装页码 计算偏移量
			pagevo.setTotal(total);//封装总记录数  计算总页数
			
			List<EmpVo> list =empDao.selectEmpPageTotal(pagevo,empvo);	//查询每页显示的数据  每页5条
			request.setAttribute("rows", list);//赋值
			request.setAttribute("pageVo", pagevo);//总页数 总记录数 当前页码
			
			request.setAttribute("ename",ename);//请求获得页面传来数据
			request.setAttribute("minsal", minsal);
			request.setAttribute("maxsal", maxsal);
			request.setAttribute("orderFlg1", orderFlg);
			
			request.getRequestDispatcher("main.jsp").forward(request, response);//服务器端跳转
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else if(action.equals("loadAddEmpPage")){
			try {
				List<EmpVo> emp=empDao.selectMgr();
				List<DeptVo> dept=empDao.selectDept();
				request.setAttribute("empRows",emp);
				request.setAttribute("deptRows", dept);
				
				request.getRequestDispatcher("addEmp.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}
		
		else if(action.equals("add")){
			String ename=request.getParameter("ename");
			String job=request.getParameter("job");
			String hiredate =request.getParameter("hiredate");
			String deptno=request.getParameter("deptno");
			String sal=request.getParameter("sal");
			String mgr=request.getParameter("mgr");
			
			EmpVo emp =new EmpVo();
			emp.setEname(ename);
			emp.setMgr(mgr!=null&&!mgr.toString().trim().equals("")?Integer.parseInt(mgr):null);
            emp.setHiredate(hiredate!=null&&!hiredate.toString().trim().equals("")?Date.valueOf(hiredate):null);
			emp.setJob(job);
			emp.setDeptno(Integer.parseInt(deptno));
			emp.setSal(sal!=null&&!sal.toString().trim().equals("")?new BigDecimal(sal):null);
			
			try {
				int i=empDao.saveEmp();
				if(i>0){
					response.sendRedirect("EmpControl?action=page&pageNow=1");
				}else{
				   request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
			
		}
		
	}

}
