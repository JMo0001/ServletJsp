<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 결과</title>
</head>
<body>
	<h2>검색 결과창</h2>
	<div>
		<table border="1">
			<tr>
				<td>학과 번호</td>
				<td>학과 이름</td>
				<td>계열</td>
				<td>개설 여부</td>
				<td>정원</td>
			</tr>
			<c:if test="${not empty getList }">
			<tr>
				<td>${getList.departmentNo }</td>
				<td>${getList.departmentName }</td>
				<td>${getList.category }</td>
				<td>${getList.openYn }</td>
				<td>${getList.capacity }</td>
			</tr>
			</c:if>
		</table>
	</div>
	<div>
		<a href="${pageContext.request.contextPath }/dept/list">돌아가기</a>
	</div>
</body>
</html>