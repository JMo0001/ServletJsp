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
	//JSP Tag -- java 문법
	String a = (String)request.getAttribute("aaa");
	String b = (String)request.getAttribute("bbb");
	int c = (int)request.getAttribute("ccc");
	List<StudentVo> volist  = (List<StudentVo>)request.getAttribute("studentList");
	%>
	<%-- <%= a %> --%>
	<%-- <%= b %> --%>
	<%-- <%= c %> --%>
	<%-- <%= volist %>	 --%>
	<table border ="1">
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
		for(int i=0; i<volist.size(); i++){
			StudentVo vo = volist.get(i);
		%>
		
		<tr>
			<td><%=vo.getStudentNo() %></td>
			<td><%=vo.getDepartmentNo() %></td>
			<td><%=vo.getStudentName() %></td>
			<td><%=vo.getStudentSsn() %></td>
			<td><%=vo.getStudentAddress() %></td>
			<td><%=vo.getEntranceDate() %></td>
			<td><%=vo.getAbsenceYn() %></td>
			<td><%=vo.getCoachProfessorNo() %></td>
		</tr>
		
		<%
		}
		%>
		
	</table>
</body>
</html>