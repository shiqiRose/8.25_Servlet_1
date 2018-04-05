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
	 float:right;height:15px;padding-top:5px;font-size:13px;color:#fff;
}
#grid,#typeDiv{float:left;margin-left:20px;
}
#typeDiv{display:none;}
#reportAddDiv{clear:both;margin-left:20px;padding-top:50px;
}
</style>
<script type="text/javaScript">
    function  mainPage(){//查询首页
    	var form=document.getElementById("searchForm");
    	form.setAttribute("action","EmpControl?action=page&pageNow=1");
    	form.submit();
    } 
    function lastPage(pagNow){//查询上一页
    	var form =document.getElementById("searchForm");
    	if(pagNow==1){
    		form.setAttribute("action","EmpControl?action=page&pageNow=1");
    	}else{
    		form.setAttribute("action","EmpControl?action=page&pageNow="+(parseInt(pagNow)-1));
    	}
    	form.submit();
    }
   function  nextPage(pagNow,pageTotal){//查询下一页
    	  var form =document.getElementById("searchForm");
    	  if(pagNow==pageTotal){
    	      form.setAttribute("action","EmpControl?action=page&pageNow="+pageTotal);
    	   }else{
    	      form.setAttribute("action","EmpControl?action=page&pageNow="+(parseInt(pagNow)+1));
    	   }
    	  form.submit();
    }
   function totalPage(pageTotal){
	   var form=document.getElementById("searchForm");
   	   form.setAttribute("action","EmpControl?action=page&pageNow="+pageTotal);
       form.submit();
   }
   function hiredateOrder(){
	   var form =document.getElementById("searchForm");
	   var orderFlg1=document.getElementById("orderFlg");
	   if(orderFlg1.value==1){
		   orderFlg1.value=0;
	   }else{
		   orderFlg1.value=1;
	   }
	   form.setAttribute("action","EmpControl?action=page&pageNow=1");
       form.submit();
   }
</script>
</head>
<body>

<div id="main">

	  <!--显示数据表格-->
       <div id="grid">
	       <table class="outerTable">
		     <tr>
			    <td style="padding-top:20px;" >
			    
			   <form id="searchForm"   method="post">
			    
			     <!-- hiredate排序标示-->
			           <c:if test="${orderFlg1==1 }">  
			           
			              <input type="text" value="1" name="orderFlg" id="orderFlg">
			           </c:if>
			           <c:if test="${orderFlg1==0 }">
			              <input type="text" value="0" name="orderFlg" id="orderFlg">
			           </c:if>
			     
				  <label>
				  姓名：<input type="text"  name="ename" value=${ename }>
				  </label>
				  <label>
				 工资：<input type="text" name="minsal" value="${minsal }" style="width:40px">-<input style="width:40px" type="text" name="maxsal" value="${maxsal}">
			   
				  </label>
				  <label>
					  
					  <a  href="javascript:void(0)" class="btn" onclick="mainPage()"> 查询</a>
					  <a  href="EmpControl?action=loadAddEmpPage" class="btn" >添加</a>
					  <a  href="javascript:void(0)" class="btn">删除</a>
				  </label>
				
				 </form>
				</td>
			 </tr>
		     <tr>
			    <td>
				   <table>
				  
				     <tr>
					   <th><input type="checkbox"></th>
					   <th>序号</th>
					   <th>员工编号</th>
					   <th>员工姓名</th>
					   <th>工作类型</th>
					   <th>入职日期&nbsp;
					  
					   <a href="javascript:void(0)"    onclick="hiredateOrder()">
					    <c:if test="${orderFlg1==1 }">
					    <image src="image/a2.gif"></image>
					   </c:if>
					  
					    <c:if test="${orderFlg1==0 }">
					    <image src="image/a1.gif"></image>
					    </c:if>
					   </a>
					   </th>
					   <th>工资</th>
					   <th>部门</th>
					   <th>工资等级</th>
					   <th>操作</th>
					   
					 </tr>
			<c:forEach  items="${rows }"  var="vo"  varStatus="a">
				     <tr>
					   <td><input type="checkbox"></td>
					    <td>${a.count }</td>
					    <td>${vo.empno }</td>
						<td>${vo.ename }</td>
						<td>${vo.job }</td>
						<td>${vo.hiredate }</td>
						<td>${vo.sal }</td>
					    <td>${vo.dept.deptno }-${vo.dept.dname }</td>
						<td>${vo.salGrade.grade }</td>
						<td><a href="#">删除</a></td>
						
					 </tr>
					 </c:forEach>
					 
					
					 
				   </table>
				</td>
			 </tr>
			 <%-- <tr>
					<td>
					  <a href="EmpControl?action=page&pageNow=1">首页</a>
					  <a href="EmpControl?action=page&pageNow=<%=pagevo.getPagNow()==1?1:(pagevo.getPagNow()-1)%>">上一页</a>
					  <a href="EmpControl?action=page&pageNow=<%=pagevo.getPagNow()==pagevo.getPageTotal()?pagevo.getPageTotal():(pagevo.getPagNow()+1)%>">下一页</a>
					  <a href="EmpControl?action=page&pageNow=<%=pagevo.getPageTotal()%>">尾页</a>
					 第<%=pagevo.getPagNow() %>页;总记录数：<%=pagevo.getTotal()%> ;总页数：<%=pagevo.getPageTotal()%> ;
				</td>
			 </tr>  --%>
			
			 <tr>
					<td>
					  <a href="EmpControl?action=page&pageNow=1">首页</a>
					  <a href="EmpControl?action=page&pageNow=<c:if test="${pageVo.pagNow==1}">1</c:if><c:if test="${pageVo.pagNow!=1}">${pageVo.pagNow-1}</c:if>">上一页</a>
					  <a href="EmpControl?action=page&pageNow=<c:if test="${pageVo.pagNow==pageVo.pageTotal}">${pageVo.pageTotal }</c:if><c:if test="${pageVo.pagNow!=pageVo.pageTotal}">${pageVo.pagNow+1}</c:if>">下一页</a>
					  <a href="EmpControl?action=page&pageNow=${pageVo.pageTotal }">尾页</a>
				              第${pageVo.pagNow }页;总记录数：${pageVo.total } ;总页数：${pageVo.pageTotal} ;
				</td>
			 </tr> 
			 
			 <tr>
			   <td>
			   提交表单查询条件
			     <a href="javaScript:void(0)" onclick="mainPage()">首页</a>
			     <a href="javaScript:void(0)" onclick="lastPage('${pageVo.pagNow}')">上一页 </a>
			     <a href="javaScript:void(0)" onclick="nextPage('${pageVo.pagNow}','${pageVo.pageTotal }')">下一页 </a>
			     <a href="javaScript:void(0)" onclick="totalPage('${pageVo.pageTotal}')">尾页</a>
			               第${pageVo.pagNow }页;总记录数：${pageVo.total } ;总页数：${pageVo.pageTotal} ;
			   </td>
			 </tr>
			
		   </table>
	   </div>
	  
	</div>
</body>
</html>