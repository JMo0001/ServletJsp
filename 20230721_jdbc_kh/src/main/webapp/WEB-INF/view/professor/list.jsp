<%@page import="kh.test.jdbckh.professor.model.vo.ProfessorVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 리스트</title>
</head>
<body>
	<h2>교수 리스트</h2>
	
	<div>
		<form action = "<%=request.getContextPath()%>/professor/list" method="get">
			<input type="search" name="search">
			<input type="submit" value="찾기">
		</form>
	</div>
<c:if test="${not empty search } }">
	<h2>${search } 검색 결과</h2>
	<h3><a href = "<%=request.getContextPath()%>/professor/list">전체 보기</a></h3>
</c:if>
<c:if test="${empty professorList }">
	<h2>결과물이 없습니다.</h2>
</c:if>
<c:if test="${not empty professorList }">
	<table border = "1">
	<c:forEach items="${professorList }" var="p">
		<tr>
			<th>교수 번호</th>
			<th>교수 이름</th>
		</tr>
		<tr>
			<td><a href ="<%=request.getContextPath()%>/professor/get?pno=${p.professorNo}">${p.professorNo }</a></td>
			<td>${p.professorName }</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
	<div>
	<c:if test="${startPageNum != 1 }">
		<c:choose>
			<c:when test="${not empty search }">
				<a href="<%=request.getContextPath()%>/professor/list?pageNo=${startPageNum-1 }>&search=${search}">
				<span>이전</span></a>
			</c:when>
			<c:otherwise>
				<a href="<%=request.getContextPath()%>/professor/list?pageNo=${startPageNum-1}" >
				<span>이전</span></a>
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:forEach begin="${startPageNum }" end="${endPageNum }" var="i">
		<c:choose>
			<c:when test="${not empty search }">
				<a href="<%=request.getContextPath()%>/professor/list?pageNo=${i }&search=${search }">
					<span>${i }</span></a>
			</c:when>
			<c:otherwise>
				<a href="<%=request.getContextPath()%>/professor/list?pageNo=${i}">
					<span>${i }</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum < totalPageNum }">
		<c:choose>
			<c:when test="${not empty search }">
				<a href="<%=request.getContextPath()%>/professor/list?pageNo=${endPageNum+1 }&search=${search}">
				<span>다음</span></a>
			</c:when>
			<c:otherwise>
				<a href="<%=request.getContextPath()%>/professor/list?pageNo=${endPageNum+1}">
				<span>다음</span></a>
			</c:otherwise>
		</c:choose>
	</c:if>
	</div>	
</body>
</html>