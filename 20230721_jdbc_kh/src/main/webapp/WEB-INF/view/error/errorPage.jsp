<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage ="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<%-- Error info : <%=exception.getClass().getName() %> --%>
<hr>
오류페이지
<a href="javascript:window.history.back();">이전페이지로 이동</a>
<a href ="${pageContext.request.contextPath }/main">main 가기</a>
</body>
</html>