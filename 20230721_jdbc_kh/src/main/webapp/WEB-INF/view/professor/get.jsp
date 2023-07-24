<%@page import="kh.test.jdbckh.professor.model.vo.ProfessorVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 get</title>
</head>
<body>
	<h2>교수 상세 정보</h2>
	
	<% ProfessorVo vo = (ProfessorVo)request.getAttribute("oneVo"); %>
	
	<table border="1">
		<tr>
			<th>교수 번호</th>
			<th>교수 이름</th>
			<th>교수 주민번호</th>
			<th>교수 주소</th>
			<th>학과 번호</th>
		</tr>
		
		<tr>
			<td><%=vo.getProfessorNo() %></td>
			<td><%=vo.getProfessorName() %></td>
			<td><%=vo.getProfessorSsn() %></td>
			<td><%=vo.getProfessorAddress() %></td>
			<td><%=vo.getDepartmentNo() %></td>
		</tr>
	</table>


</body>
</html>