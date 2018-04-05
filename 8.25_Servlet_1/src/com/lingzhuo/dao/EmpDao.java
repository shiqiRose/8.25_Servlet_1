package com.lingzhuo.dao;

import java.util.List;

import com.lingzhuo.vo.DeptVo;
import com.lingzhuo.vo.EmpVo;
import com.lingzhuo.vo.PageVo;

public interface EmpDao {
	
	
	    //��ѯ�ܼ�¼��
		public int selectEmpTotal(EmpVo emp) throws Exception;
		//��ѯ��ҳ��
		public List<EmpVo> selectEmpPageTotal(PageVo pagevo,EmpVo empvo) throws Exception;
		//��ѯ������Ϣ
		public List<EmpVo> selectMgr()throws Exception;
		//��ѯ������Ϣ
		public List<DeptVo> selectDept()throws Exception;
		//��ѯ����Ա����Ϣ
		public int saveEmp()throws Exception;
		//ɾ��������¼
		public int deleteItems(String[] items) throws Exception;
		

}
