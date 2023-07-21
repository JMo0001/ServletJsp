<%@page import="kh.test.jdbctry.model.vo.TbClassVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>클래스 리스트</title>
</head>
<body>
	<h2>클래스 리스트</h2>
	<%
	String a = (String)request.getAttribute("aaa");
	List<TbClassVo> volist = (List<TbClassVo>)request.getAttribute("classlist");
	%>
	<div>
		<table border :1>
			<tr>
				<th>과목 번호</th>
				<th>학과 번호</th>
				<th>선수 과목 번호</th>
				<th>과목 이름</th>
				<th>과목 구분</th>
			</tr>
			<% 
				for(int i=0; i<volist.size(); i++){
					TbClassVo vo = volist.get(i);
			%>
			<tr>
				<td><%=vo.getClassNo() %></td>
				<td><%=vo.getDepartmentNo() %></td>
				<td><%=vo.getPreattendingClassNo() %></td>
				<td><%=vo.getClassName() %></td>
				<td><%=vo.getClassType() %></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	

</body>
</html>