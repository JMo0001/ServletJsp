<%@page import="kh.test.jdbckh.tbclass.model.vo.TbClassVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 get</title>
</head>
<body>
	<h2>과목 상세정보</h2>
	<% 
	TbClassVo vo = (TbClassVo)request.getAttribute("oneVo"); 
	if(vo == null){
	%>
	<h3> 결과값이 없습니다. </h3>	
	<%
	} else {
	%>
	
	<table border="1">
		<tr>
			<th>과목 번호</th>
			<th>학과 번호</th>
			<th>선수 과목 번호</th>
			<th>과목 이름</th>
			<th>과목 구분</th>
			<th>선수 과목 이름</th>
		</tr>
		
		<tr>
			<td><%=vo.getClassNo() %></td>
			<td><%=vo.getDepartmentNo() %></td>
			<td><%=vo.getPreattendingClassNo() %></td>
			<td><%=vo.getClassName() %></td>
			<td><%=vo.getClasstype() %></td>
			<td><%=vo.getClassname2() %></td>
		</tr>
	</table>
	<%
	}
	%>
</body>
</html>