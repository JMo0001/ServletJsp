<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트</title>
</head>
<body>
	<h2>학생 리스트</h2>
	
	<div>
		<form action = "<%=request.getContextPath()%>/student/list" method="get">
			<input type="search" name="searchWord">
			<input type="submit" value="찾기">
		</form>
	</div>
	
	
	<%
	//JSP Tag -- java 문법
	List<StudentVo> volist = (List<StudentVo>) request.getAttribute("studentList");
	String searchWord = (String)request.getAttribute("searchWord");
	if(searchWord != null){
	%>
		<h3><%=searchWord %> 검색결과</h3>	
		<h3><a href = "<%=request.getContextPath()%>/student/list">전체보기</a> </h3>	
	<%
	}
	// if(volist.size()==0){
	if(volist == null || volist.size() == 0){
	
		%>
		<h2>결과물이 없습니다.</h2>
		<%		
	} else {
	%>
	
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
		<%
		for (int i = 0; i < volist.size(); i++) {
			StudentVo vo = volist.get(i);
		%>

		<tr>
			<td><a href="<%=request.getContextPath()%>/student/get?sno=<%=vo.getStudentNo()%>"><%=vo.getStudentNo()%></a></td>
			<td><%=vo.getDepartmentNo()%></td>
			<td><%=vo.getStudentName()%></td>
			<td><%=vo.getStudentSsn()%></td>
			<td><%=vo.getStudentAddress()%></td>
			<td><%=vo.getEntranceDate()%></td>
			<td><%=vo.getAbsenceYn()%></td>
			<td><%=vo.getCoachProfessorNo()%></td>
		</tr>

		<%
		}	//for
		%>

	</table>
	<div>
	<%
	for(int i=1; i<=10;i++){
		
	%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=i %>"><span><%=i %></span></a>
	<%
	}	//for
	%>
	</div>
	<%
	}	//else
	%>
</body>
</html>