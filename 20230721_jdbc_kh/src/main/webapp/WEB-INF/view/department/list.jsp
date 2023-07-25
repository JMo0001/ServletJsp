<%@page import="kh.test.jdbckh.department.model.vo.DepartmentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 리스트</title>
</head>
<body>
	<h2>학과 리스트</h2>
	
	
	<div>
		<form action ="<%=request.getContextPath()%>/department/list" method="get" >
			<input type="search" name="search">
			<input type="submit" value ="찾기">
		</form>
	</div>
	
	<% 
	List<DepartmentVo> volist = (List<DepartmentVo>)request.getAttribute("departmentList");
	String search = (String)request.getAttribute("search");
	if(search != null){
	%>
		
		<h3><%=search %>검색 결과</h3>
		<h3><a href = "<%=request.getContextPath() %>/department/list">전체 보기</a></h3>
	
	<%
	}
	if(volist == null || volist.size()==0){
		%>
		<h2>결과물이 없습니다.</h2>
		<%
	}else{
		%>

	<table border = "1">
		<tr>
		
		<%
		for(int i=0; i<volist.size();i++){
			DepartmentVo vo = volist.get(i);
		%>
			<th>학과 번호</th>
			<th>학과 이름</th>
		</tr>
		
		<tr>
			<td><a href="<%=request.getContextPath() %>/department/get?dno=<%=vo.getDepartmentNo() %>"><%=vo.getDepartmentNo() %></a></td>
			<td><%=vo.getDepartmentName() %></td>
		</tr>
		<%
		}
		%>
		
	</table>
	<% 
	}
	%>
</body>
</html>