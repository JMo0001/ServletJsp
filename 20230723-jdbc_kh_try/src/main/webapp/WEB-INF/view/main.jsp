<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<h2>메인</h2>
	
	<table border="1">
		<tr>
			<th>학과번호</th>
			<th>학과이름</th>
			<th>계열</th>
			<th>개설여부</th>
			<th>정원</th>
		</tr>
<c:if test="${not empty deptList }">
	<c:forEach items="${deptList }" var="dto">
		<tr>
			<td>${dto.departmentNo }</td>
			<td>${dto.departmentName }</td>
			<td>${dto.category }</td>
			<td>${dto.openYn }</td>
			<td>${dto.capacity }</td>
		</tr>
	</c:forEach>
</c:if>
	</table>

</body>
</html>