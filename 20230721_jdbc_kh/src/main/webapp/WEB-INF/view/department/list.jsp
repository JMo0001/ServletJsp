<%@page import="kh.test.jdbckh.department.model.vo.DepartmentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 리스트</title>
</head>
<body>
	<h2>학과 리스트</h2>
	
	<div>
	<a href="<%=request.getContextPath()%>/department/insert">학과 등록</a>
	</div>
	<div>
		<form action ="<%=request.getContextPath()%>/department/list" method="get" >
			<input type="search" name="search">
			<input type="submit" value ="찾기">
		</form>
	</div>
	

<c:if test="${not empty search }">
	<c:choose>
		<c:when test="${not empty departmentList }">
			<h3>${search }검색 결과</h3>
			<h3><a href = "<%=request.getContextPath() %>/department/list">전체 보기</a></h3>
			
				<table border = "1">
					<tr>
						<th>학과 번호</th>
						<th>학과 이름</th>
						<th>계열</th>
						<th>개설 여부</th>
						<th>정원</th>
					</tr>
					<c:forEach items="${departmentList }" var="var">
					<tr>
						<td><a href="<%=request.getContextPath() %>/department/get?dno=${var.departmentNo} ">${var.departmentNo }</a></td>
						<td>${var.departmentName }</td>
						<td>${var.category }</td>
						<td>${var.openYn }</td>
						<td>${var.capacity }</td>
					</tr>
					</c:forEach>
				</table>
				
		</c:when>
		<c:otherwise>
			<h2>결과물이 없습니다.</h2>
			<h3><a href = "<%=request.getContextPath() %>/department/list">전체 보기</a></h3>
		</c:otherwise>
	</c:choose>
</c:if>

<c:if test="${empty search }">
	
		<table border = "1">
			<c:forEach items="${departmentList }" var="var">
			<tr>
				<th>학과 번호</th>
				<th>학과 이름</th>
			</tr>
			<tr>
				<td><a href="<%=request.getContextPath() %>/department/get?dno=${var.departmentNo} ">${var.departmentNo }</a></td>
				<td>${var.departmentName }</td>
			</tr>
			</c:forEach>
		</table>
	
</c:if>

<div>		
<c:if test="${startPageNum >1 }">
	<c:choose>
		<c:when test="${not empty search }">
			<a href="<%=request.getContextPath()%>/department/list?pageNo=${startPageNum -1 }&search=${search}">
				<span>이전</span></a>
		</c:when>
		<c:when test="${empty search }">
			<a href="<%=request.getContextPath()%>/department/list?pageNo=${startPageNum -1 }">
				<span>이전</span></a>
		</c:when>
	</c:choose>
</c:if>
<c:forEach begin="${startPageNum }" end="${endPageNum }" var="i">
	<c:choose>
		<c:when test="${not empty search }">
			<a href ="<%=request.getContextPath()%>/department/list?pageNo=${i}&search=${search}" >
				<span>${i }</span></a>
		</c:when>
		<c:otherwise>
			<a href="<%=request.getContextPath()%>/department/list?pageNo=${i}">
				<span>${i }</span></a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<c:if test="${endPageNum < totalPageNum }">
	<c:choose>
		<c:when test="${not empty search }">
			<a href= "<%=request.getContextPath() %>/department/list?pageNo=${endPageNum+1 }&search=${search}">
				<span>다음</span></a>
		</c:when>
		<c:otherwise>
			<a href= "<%=request.getContextPath() %>/department/list?pageNo=${endPageNum +1}">
				<span>다음</span></a>
		</c:otherwise>
	</c:choose>
</c:if>
</div>
</body>
</html>