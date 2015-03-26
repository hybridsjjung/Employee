<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>weather.jsp</title>
</head>
<body>

<hr>
<h1>날씨 정보 조회 결과</h1>
<hr>
<h2> Current : </h2>
${requestScope.weather.current.temperature} <br>
${requestScope.weather.current.skycode} <br>
${requestScope.weather.current.skytext} <br>
${requestScope.weather.current.date} <br>
${requestScope.weather.current.observationtime} <br>
${requestScope.weather.current.observationpoint} <br>
${requestScope.weather.current.feelslike} <br>
${requestScope.weather.current.humidity} <br>
${requestScope.weather.current.winddisplay} <br>
${requestScope.weather.current.day} <br>
${requestScope.weather.current.shortday} <br>
${requestScope.weather.current.windspeed} <br>

<hr>
${requestScope.weather.forecast[0].low} <br>
${requestScope.weather.forecast[0].high} <br>
${requestScope.weather.forecast[0].date} <br>

</body>
</html>