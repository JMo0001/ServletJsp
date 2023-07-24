<%@page import="kh.test.jdbckh.professor.model.vo.ProfessorVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 리스트</title>
</head>
<body>
	<h2>교수 리스트</h2>
	
	<%
	List<ProfessorVo> volist = (List<ProfessorVo>)request.getAttribute("professorList");
	%>
	
	<table border = "1">
		<tr>
			<th>교수 번호</th>
			<th>교수 이름</th>
		</tr>
		
		<%
		for (int i =0; i<volist.size(); i++){
			ProfessorVo vo = volist.get(i);
			
		%>
		<tr>
			<td><a href ="<%=request.getContextPath()%>/professor/get?pno=<%=vo.getProfessorNo() %>"><%=vo.getProfessorNo() %></a></td>
			<td><%=vo.getProfessorName() %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>