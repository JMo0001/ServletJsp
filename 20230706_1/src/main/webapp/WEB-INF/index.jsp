<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test3</title>
</head>
<body>
	<h1>index</h1>
	<a href="<%=request.getContextPath()%>/login3"><p>로그인 페이지</p></a>
	<a href="<%=request.getContextPath()%>/join3"><p>회원가입 페이지</p></a>
	console.log("<%=request.getContextPath()%>");
	
</body>
</html>