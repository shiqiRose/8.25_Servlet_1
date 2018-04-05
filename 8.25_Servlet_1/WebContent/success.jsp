<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
${str};

${empvo.empno};${empvo.ename};${empvo.sal};
<br>
${empvo.dept.deptno};${empvo.dept.dname};
<br>
${m.a};
${m.b};
<br>
--------------------------------JSTL-----------------------------
<br>
<c:out value="${str}"></c:out>


<br>
<c:forEach items="${res}"  var="e"  varStatus="a">
<br>
序号：${a.count }--------${a.index }
${empvo.ename }-----${empvo.empno }----------${empvo.sal }
   <c:choose>
    <c:when test="${empvo.sal>8000 }">>10000</c:when>
    <c:when test="${empvo.sal<3000 }"><=8000</c:when>
    <c:otherwise>其他</c:otherwise>
   </c:choose>
   
   
<br>
格式化日期:

<fmt:formatDate value="${empvo.hiredate }"  pattern="yyyy年-MM月-dd日       HH:mm:ss "/>
<br>
格式化数字:
<fmt:formatNumber value="${empvo.sal+1 }"  pattern="###,###,####.#####" maxFractionDigits="5"></fmt:formatNumber>
<br>
<fmt:formatNumber value="0.123" type="percent" maxFractionDigits="2"></fmt:formatNumber>
<br>
</c:forEach>

</body>
</html>