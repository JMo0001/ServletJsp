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
	<% 
	//JSP 태그. 자바 문법 쓸수 있다.
	String a = (String)request.getAttribute("aaa"); //OBJECT 모양으로 나온다.
	String b = (String)request.getAttribute("bbb");
	int c = (int)request.getAttribute("ccc");
	List<StudentVo> volist = (List<StudentVo>)request.getAttribute("studentList");
	%>
	
	<table border=1>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>입학일</th>
		</tr>
		<%
		for(int i=0; i<volist.size(); i++){
			StudentVo vo = volist.get(i);
		%>
		<tr>
			<td><%=vo.getStudentNo() %></td>
			<td><%=vo.getStudentName() %></td>
			<td><%=vo.getEntranceDate() %></td>
		</tr>
		<%
		}
		%>
	</table>
	
	
</body>
</html>