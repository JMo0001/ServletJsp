<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage ="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error500</title>
</head>
<body>
Error info : <%=exception.getClass().getName() %>
<hr>
오류페이지
<a href ="${pageContext.request.contextPath }">main 가기</a>
</body>
</html>