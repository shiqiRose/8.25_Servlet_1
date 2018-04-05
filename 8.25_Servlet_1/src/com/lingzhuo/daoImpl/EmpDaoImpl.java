package com.lingzhuo.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lingzhuo.dao.EmpDao;
import com.lingzhuo.db.DBConnection;
import com.lingzhuo.vo.DeptVo;
import com.lingzhuo.vo.EmpVo;
import com.lingzhuo.vo.PageVo;
import com.lingzhuo.vo.SalGradeVo;

public class EmpDaoImpl implements EmpDao{
    private PreparedStatement pst;
    private Connection conn;
    private ResultSet res;
	@Override
	public int selectEmpTotal(EmpVo empvo) throws Exception {
		// TODO Auto-generated method stub
		DBConnection db=new DBConnection();
		conn=db.getConn();
		StringBuffer sql= new StringBuffer("select count(*) from emp e,dept d,salgrade s where 1=1 ");
		if(empvo!=null){
			if(empvo.getEname()!=null&&!empvo.getEname().equals("")){
				sql.append(" and e.ename like '%"+empvo.getEname()+"%' ");
			}
			if(empvo.getMinsal()!=null&&!empvo.getMinsal().toString().equals("")){
				sql.append(" and e.sal>="+empvo.getMinsal());
			}
			if(empvo.getMaxsal()!=null&&!empvo.getMaxsal().toString().equals("")){
				sql.append(" and e.sal<="+empvo.getMaxsal());
				
			}
			
			
		}
		sql.append(" and  e.deptno=d.deptno and e.sal between minsal and maxsal");
		pst=conn.prepareStatement(sql.toString());
		System.out.println(sql);
		
		res =pst.executeQuery();
		int total=0;
		while(res.next()){
			total=res.getInt(1);
		}
		pst.close();
		conn.close();
		return total;
	}

	@Override
	public List<EmpVo> selectEmpPageTotal(PageVo pagevo,EmpVo empvo) throws Exception {
		// TODO Auto-generated method stub
		List<EmpVo> list =new ArrayList<EmpVo>();
		DBConnection db =new DBConnection();
		conn=db.getConn();
		StringBuffer sql= new StringBuffer("select a.empno,a.ename,a.job,a.sal,a.hiredate,a.deptno,a.dname,a.grade,a.minsal,a.maxsal "
		+" from(select rownum r,e.empno,e.ename,e.job,e.sal,e.hiredate,d.deptno,d.dname,s.grade,s.minsal,s.maxsal "
		+ " from emp e,dept d,salgrade s where  1=1 ");
		if(empvo!=null){
			if(empvo.getEname()!=null&&!empvo.getEname().equals("")){
				sql.append(" and e.ename like '%"+empvo.getEname()+"%' ");
			}
			if(empvo.getMinsal()!=null&&!empvo.getMinsal().toString().equals("")){
				sql.append(" and e.sal>="+empvo.getMinsal());
			}
			if(empvo.getMaxsal()!=null&&!empvo.getMaxsal().toString().equals("")){
				sql.append(" and e.sal<="+empvo.getMaxsal());
				
			}
		}
		
		sql.append( " and e.deptno=d.deptno and e.sal between s.minsal and s.maxsal)a  "+" where a.r between ");
		sql.append( pagevo.getOffset()+" and "+(pagevo.getOffset()+pagevo.getPageSize()-1)+" order by a.hiredate");
		if(empvo.getGetOrderFlg()!=null&&empvo.getGetOrderFlg().equals("1")){
			System.out.println("-------asc-------"+empvo.getGetOrderFlg());
			sql.append(" asc ");
		}else if(empvo.getGetOrderFlg()!=null&&empvo.getGetOrderFlg().equals("0")){
			sql.append(" desc ");
			System.out.println("-------desc-------"+empvo.getGetOrderFlg());
		}
		pst=conn.prepareStatement(sql.toString());
		
		System.out.println(sql);
		
		res=pst.executeQuery();
		while(res.next()){
			
			EmpVo empvo1=new EmpVo();
			empvo1.setEmpno(res.getInt(1));
			empvo1.setEname(res.getString(2));
			empvo1.setJob(res.getString(3));
			empvo1.setHiredate(res.getDate(5));
			empvo1.setSal(res.getBigDecimal(4));
			
			DeptVo deptvo=new DeptVo();
			deptvo.setDeptno(res.getInt(6));
			deptvo.setDname(res.getString(7));
			
			SalGradeVo salvo =new SalGradeVo();
			salvo.setGrade(res.getInt(8));
			salvo.setMinsal(res.getBigDecimal(9));
			salvo.setMaxsal(res.getBigDecimal(10));
			
			empvo1.setDept(deptvo);
			empvo1.setSalGrade(salvo);
			
			list.add(empvo1);
		}
		pst.close();
		conn.close();
		return list;
	}



	@Override
	public List<EmpVo> selectMgr() throws Exception {
		// TODO Auto-generated method stub
		List<EmpVo> list =new ArrayList<EmpVo>();
		DBConnection db =new DBConnection();
		conn=db.getConn();
		String sql=" select distinct e.empno,e.ename from emp e,emp d where e.empno=d.mgr";
		pst=conn.prepareStatement(sql);
		res=pst.executeQuery();
		while(res.next()){
			EmpVo emp=new EmpVo();
			emp.setEmpno(res.getInt(1));
			emp.setEname(res.getString(2));
			list.add(emp);
		}
		pst.close();
		conn.close();
		return list;
	}

	@Override
	public List<DeptVo> selectDept() throws Exception {
		// TODO Auto-generated method stub
		List<DeptVo> list =new ArrayList<DeptVo>();
		DBConnection db =new DBConnection();
		conn=db.getConn();
		String sql="select d.deptno,d.dname,d.loc from dept d";
		pst=conn.prepareStatement(sql);
		res=pst.executeQuery();
		
		while(res.next()){
			DeptVo dept=new DeptVo();
			dept.setDeptno(res.getInt(1));
			dept.setDname(res.getString(2));
			dept.setLoc(res.getString(3));
			list.add(dept);
		}
		pst.close();
		conn.close();
		return list;
	}

	@Override
	public int saveEmp() throws Exception {
		// TODO Auto-generated method stub
		DBConnection db =new DBConnection();
		conn=db.getConn();
		String sql="insert into emp(empno,ename,job,mgr,hiredate,sal,deptno)  values(EMP_EMPNO,?,?,?,?,?,?)";
		pst=conn.prepareStatement(sql);
		int i=pst.executeUpdate();
		EmpVo emp=new EmpVo();
		pst.setString(1, emp.getEname());
		pst.setString(2,emp.getJob());
		pst.setInt(3, emp.getMgr());
		pst.setDate(4,emp.getHiredate());
		pst.setBigDecimal(5, emp.getSal());
		pst.setInt(6, emp.getDeptno());
		
		pst.close();
		conn.close();
		return i;
	}

	@Override
	public int deleteItems(String[] items) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
