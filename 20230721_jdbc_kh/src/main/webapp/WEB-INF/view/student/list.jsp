<%-- <%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%> --%>
<%-- <%@page import="java.util.List"%> --%>
<!--jstl/el 사용하면 변수선언 안해도 되므로 자료형 import 필요 없어짐.  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%!
//함수 만들어 사용할 수 있음. > taglib에 넣어두고 사용하는 경우가 많음.

%>
	
	
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트</title>
</head>
<body>
	<h2>학생 리스트</h2>
	<div>
		<a href="<%=request.getContextPath()%>/student/insert">학생등록</a>
	</div>
	<div>
		<form action = "<%=request.getContextPath()%>/student/list" method="get">
			<input type="search" name="searchWord">
			<input type="submit" value="찾기">
		</form>
	</div>
	


<c:if test="${not empty searchWord }">
	<h3>${searchWord} 검색결과</h3>
	<h3><a href = "<%=request.getContextPath()%>/student/list">전체보기</a></h3>	
</c:if>
<c:if test="${empty studentList }">
	<h2>결과물이 없습니다.</h2>
</c:if>
<c:if test="${not empty studentList }">
	<table border="1">
		<tr>
			<th>학생 번호</th>
			<th>학과 번호</th>
			<th>학생 이름</th>
			<th>학생 주민번호</th>
			<th>학생 주소</th>
			<th>입학 년도</th>
			<th>휴학 여부</th>
			<th>지도 교수 번호</th>
		</tr>
	<c:forEach items="${studentList }" var="item">
		<tr>
			<td><a href="<%=request.getContextPath()%>/student/get?sno=${item.studentNo}">${item.studentNo }</a></td>
			<td>${item.departmentNo }</td>
			<td>${item.studentName }</td>
			<td>${item.studentSsn }</td>
			<td>${item.studentAddress }</td>
			<td>${item.entranceDate }</td>
			<td>${item.absenceYn }</td>
			<td>${item.coachProfessorNo }</td>
		</tr>
	</c:forEach>
	</table>
</c:if>	
<div>
<c:if test="${startPageNum !=1 }">
	<c:choose>
		<c:when test="${not empty searchWord }">
			<a href="<%=request.getContextPath()%>/student/list?pageNo=${startPageNum-1 }&searchWord=">
			<span>이전</span></a>
		</c:when>
		<c:otherwise>
			<a href="<%=request.getContextPath()%>/student/list?pageNo=${startPageNum-1}">
			<span>이전</span></a>
		</c:otherwise>
	</c:choose>
</c:if>
<c:forEach begin="${startPageNum }" end="${endPageNum }" var="i">
	<c:if test="${not empty searchWord }">
		<a href="<%=request.getContextPath()%>/student/list?pageNo=${i }&searchWord=${searchWord}">
		<span>${i }</span></a>
	</c:if>
	<c:if test="${empty searchWord }">
		<a href="<%=request.getContextPath()%>/student/list?pageNo=${i}">
		<span>${i }</span></a>
	</c:if>
</c:forEach>
<c:if test="${endPageNum < totalPageNum }">
	<c:choose>
		<c:when test="${not empty searchWord }">
			<a href="<%=request.getContextPath()%>/student/list?pageNo=${endPageNum+1 }&searchWord=${searchWord}">
		<span>다음</span></a>
		</c:when>
		<c:when test="${empty searchWord }">
			<a href="<%=request.getContextPath()%>/student/list?pageNo=${endPageNum+1}">
			<span>다음</span></a>
		</c:when>
	</c:choose>
</c:if>
</div>
</body>
</html>