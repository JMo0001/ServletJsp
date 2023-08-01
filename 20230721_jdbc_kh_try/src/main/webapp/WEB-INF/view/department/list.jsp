<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 리스트</title>
</head>
<body>
	<h2>학과 리스트</h2>
	<div>
		<form action="<%=request.getContextPath() %>/dept/get" method="get">
			<h3>학과 번호로 검색 : <input type="text" name="departmentNo">
			<input type="submit" value="search">		
			</h3>	
		</form>
	</div>
	<table border="1">
		<tr>
			<td>학과 번호</td>
			<td>학과 이름</td>
			<td>계열</td>
			<td>개설 여부</td>
			<td>정원</td>
		</tr>
<c:forEach items="${departmentList }" var="dto">
		<tr>
			<td>${dto.departmentNo }</td>
			<td>${dto.departmentName }</td>
			<td>${dto.category }</td>
			<td>${dto.openYn }</td>
			<td>${dto.capacity }</td>
		</tr>
</c:forEach>
	</table>
</body>
</html>