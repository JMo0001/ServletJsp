<%@page import="kh.test.jdbckh.department.model.vo.DepartmentVo"%>
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
	<h2>학과 정보</h2>
<c:if test="${empty dvo }">
	<h2>찾는 학과 정보가 없습니다.</h2>
</c:if>
<c:if test="${not empty dvo }">
	<h4>${dvo.departmentNo }</h4>
	학과이름 : ${dvo.departmentName }<br>
	계열 : ${dvo.category }<br>
	개설여부 : ${dvo.openYn }<br>
	정원 : ${dvo.capacity }<br>
</c:if>
	<a href="${pageContext.request.contextPath }/department/list">다시 찾기</a>	
	
	
	<%-- <% DepartmentVo vo = (DepartmentVo)request.getAttribute("oneVo"); %>

	<table border ="1">
		<tr>
			<th>학과 번호</th>
			<th>학과 이름</th>
			<th>계열</th>
			<th>개설 여부</th>
			<th>정원</th>
		</tr>
		<tr>
			<td><%=vo.getDepartmentNo() %></td>
			<td><%=vo.getDepartmentName() %></td>
			<td><%=vo.getCategory() %></td>
			<td><%=vo.getOpenYn() %></td>
			<td><%=vo.getCapacity() %></td>
		</tr>
	</table> --%>
</body>
</html>