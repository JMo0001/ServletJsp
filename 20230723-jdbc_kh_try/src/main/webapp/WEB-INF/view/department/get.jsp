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
	<h2>학과 번호 검색 결과</h2>
	
	<div>
<c:if test="${not empty dto }">
		<table border="1">
			<tr>
				<td>학과번호</td>
				<td>학과이름</td>
				<td>계열</td>
				<td>개설여부</td>
				<td>정원</td>
			</tr>
			<tr>
				<td>${dto.departmentNo }</td>
				<td>${dto.departmentName }</td>
				<td>${dto.category }</td>
				<td>${dto.openYn }</td>
				<td>${dto.capacity }</td>
			</tr>
		</table>
</c:if>
	</div>
	<a href="${pageContext.request.contextPath }/department/list">다시 찾기</a>
</body>
</html>