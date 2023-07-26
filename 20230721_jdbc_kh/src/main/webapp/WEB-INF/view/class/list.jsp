<%@page import="kh.test.jdbckh.tbclass.model.vo.TbClassVo"%>
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
	<div>
		<form action ="<%=request.getContextPath()%>/class/list" method = "get">
			<input type="search" name="searchWord">
			<input type="submit" value="찾기">
		</form>
	</div>
	
	
	
	<%
	List<TbClassVo> volist = (List<TbClassVo>)request.getAttribute("tbClassList"); 
	String searchWord = (String)request.getAttribute("searchWord");
	if(searchWord != null){
	%>	
		<h2><%=searchWord %>검색 결과</h2>
		<h3><a href ="<%=request.getContextPath()%>/class/list">전체보기</a></h3>
	<%	
	}
	if(volist == null | volist.size() ==0){
	%>
		<h2>결과물이 없습니다.</h2>
	<%
	}else{
	%>
		
	
	<table border ="1">
		<tr>
			<th>과목 번호</th>
			<th>과목 이름</th>
		</tr>
		
		<% 
			for(int i=0; i<volist.size();i++){
				TbClassVo vo = volist.get(i);
		%>
		<tr>
			<td><a href="<%=request.getContextPath()%>/class/get?cno=<%=vo.getClassNo() %>"><%=vo.getClassNo() %></a></td>
			<td><%=vo.getClassName() %></td>
		</tr>
		
		<%
			}
		%>
	</table>
	<%
	}	//	searh- else
	%>
</body>
</html>