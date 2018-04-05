<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.*,com.lingzhuo.vo.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
<style type="text/css">
table{border:solid 1px #666;border-collapse:collapse;border-spacing:0px;
}
table tr td,table tr th{border:solid 1px #666;text-align:center;padding:5px;
}
.outerTable{width:820px;
}
.outerTable tr td table{width:818px;
}
.outerTable tr td label{width:240px;display:block;float:left;
}
.btn{display:block;width:80px;text-decoration:none;background-color:#666;border:solid 1px #fff;
	 height:15px;padding-top:5px;font-size:13px;color:#fff;
}
#grid,#typeDiv{float:left;margin-left:20px;
}
#typeDiv{display:none;}
#reportAddDiv{clear:both;margin-left:20px;padding-top:50px;
}
</style>

<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javaScript">
 function addEmp(){
	var ename=document.getElementById("ename").value;
	var enameAlt=document.getElementById("ename").nextSibling||document.getElementById("ename").nextElementSibling;
	if(ename==""){
		enameAlt.innerHTML="用户名不能为空！";
		return;
	}else{
		enameAlt.innerHTML="";
	}
	
	
	
	document.getElementById("addForm").submit();
} 
</script>
</head>
<body>
 <div id="main">
    <div id="grid">
          <form action="EmpControl?action=add" method="post" id="addForm">
	       <table class="outerTable">
		     <tr>
			    <td style="padding-top:20px;" >
			     <table>
			    
			    
			     <tr>
			         <td> 姓名：</td>
			         <td><input type="text" name="ename" id ="ename">  <span style="color:red">*</span></td>
			         <td>工作类型：</td>
			          <td><input type="text" name="job">
			         </td>
			      </tr>
			      <tr>
			         <td>
			                         经理：
			         </td>
			         <td>
			              <select name="mgr">
			              <option>--请选择经理--</option>
			              <c:forEach items="${empRows }" var="e">
			              <option value="${e.empno }">${e.ename }</option>
			              </c:forEach>
			              </select>          
			         </td>
			         <td>
			                         部门 ：
			          </td>
			          <td>               
			              <select name="deptno" id="deptno">
			              <option>--请选择部门--</option>
			              <c:forEach items="${deptRows }" var="d">
			              <option value="${d.deptno }">${d.dname }</option>
			              </c:forEach>
			              </select> 
			                 <span style="color:red" id="deptALT">*</span>
			         </td>
			      </tr>
			     <tr>
			         <td> 入职日期：</td>
			         <td>  <input type="text" name="hiredate" class="Wdate"  onFocus="WdatePicker()" readonly>
			         </td>
			         <td>  工资：</td>
			         <td><input type="text" name="sal">
			         </td>
			     </tr>
				  <tr>
				  <td colspan="4">
				        <a  href="javascript:void(0)" class="btn" style="margin-left:356px"  onclick="addEmp()">保存</a>
				  </td>
				  </tr>
				  
				  
		         	</table>
				</td>
			 </tr>
		   </table>
		</form> 
	   </div>
	</div>
</body>
</html>