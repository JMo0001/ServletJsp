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
	<a href="<%=request.getContextPath()%>/department/insert">학과 등록</a>
	</div>
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
		<table border = "1">
			<tr>
		<%
		for(int i=0; i<volist.size();i++){
			DepartmentVo vo = volist.get(i);
		%>
				<th>학과 번호</th>
				<th>학과 이름</th>
				<th>계열</th>
				<th>개설 여부</th>
				<th>정원</th>
			</tr>
		
			<tr>
				<td><a href="<%=request.getContextPath() %>/department/get?dno=<%=vo.getDepartmentNo() %>"><%=vo.getDepartmentNo() %></a></td>
				<td><%=vo.getDepartmentName() %></td>
				<td><%=vo.getCategory() %></td>
				<td><%=vo.getOpenYn() %></td>
				<td><%=vo.getCapacity() %></td>
			</tr>
		<%
		}	//	search - for
		%>
		
	</table>
	
	
	
	<%
	} else{
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
		}	//	result(기본화면) - for
		%>
		
	</table>
	<% 
	}	//	null result - else
	%>
	
	<div>
	<% 
		for(int i=1; i<=10; i++){
	%>
		<a href="<%=request.getContextPath() %>/department/list?pageNo=<%=i %>"><span><%=i %></span></a>
	</div>
	<%
		}	//	paging - for
	%>
	<%
	}	//	search - else
	%>
</body>
</html>