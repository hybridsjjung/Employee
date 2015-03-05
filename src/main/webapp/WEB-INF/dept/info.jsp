<%@page import="webapp.model.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>info.jsp</title>
</head>
<body>

<hr>
<h1> 부서 정보</h1>
<hr>

<!-- Scriptlet -->
<%
	Dept dept = (Dept)request.getAttribute("dept");

	out.println("deptno = " + dept.getDeptno() + "<br>");
	out.println("dname = " + dept.getDname() + "<br>");
	out.println("loc = " + dept.getLoc() + "<br>");
%>
<hr>

<!-- EL -->
deptno = ${requestScope.dept.deptno} <br>
dname = ${requestScope.dept.dname} <br>
loc = ${requestScope.dept.loc} <br>

</body>
</html>