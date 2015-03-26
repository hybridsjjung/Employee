<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp</title>
</head>
<body>

<hr>
<h1>날씨 정보 조회</h1>
<hr>

<c:url var="url" value="/desktop/weather/show"/>
<form action="${pageScope.url}" method="post">
<!-- <form action="/Employee/desktop/weather/show" method="post"> -->
Location : 
	<select name="city">
		<option value="서울" label="@서울"/>
		<option value="대구" label="@대구"/>
		<option value="대전" label="@대전" selected="selected"/>
		<option value="부산" label="@부산"/>
		<option value="광주" label="@광주"/>
	</select>
<input type="submit" value="조회"/> 

</form>

</body>
</html>