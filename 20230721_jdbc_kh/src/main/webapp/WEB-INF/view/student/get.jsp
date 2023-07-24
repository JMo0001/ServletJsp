<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 상세 정보</title>
</head>
<body>
	<h2>학생 상세 정보</h2>
	
	<%
	StudentVo vo = (StudentVo)request.getAttribute("oneVo");
	%>
	
	<table border ="1">
		<tr>
			<th>학생 번호</th>
			<th>학과 번호</th>
			<th>학생 이름</th>
			<th>학과 이름</th>
		</tr>
		<tr>
			<td><%=vo.getStudentNo() %></td>
			<td><%=vo.getDepartmentNo() %></td>
			<td><%=vo.getStudentName() %></td>
			<td><%=vo.getDepartmentName() %></td>
		</tr>
	</table>
	
	
</body>
</html>