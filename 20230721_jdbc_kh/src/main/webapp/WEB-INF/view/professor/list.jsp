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
	
	<div>
		<form action = "<%=request.getContextPath()%>/professor/list" method="get">
			<input type="search" name="search">
			<input type="submit" value="찾기">
		</form>
	</div>
	
	
	<%
	List<ProfessorVo> volist = (List<ProfessorVo>)request.getAttribute("professorList");
	String search = (String)request.getAttribute("search");
	if(search != null){
	%>
	<h2><%=search %> 검색 결과</h2>
	<h3>
		<a href = "<%=request.getContextPath()%>/professor/list">전체 보기</a></h3>
	<%
	}
	if(volist == null || volist.size() == 0){
	%>
		<h2>결과물이 없습니다.</h2>
	<%	
	}else{
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
		}	//for
		%>
	</table>
	
	<div>
	<%
	int startPageNum = (Integer)request.getAttribute("startPageNum");
	int endPageNum = (Integer)request.getAttribute("endPageNum");
	int currentPage = (Integer)request.getAttribute("currentPage");
	int totalPageNum = (Integer)request.getAttribute("totalPageNum");
	if(startPageNum != 1 && search != null){ 
	%>
	<a href="<%=request.getContextPath()%>/professor/list?pageNo=<%=startPageNum-1%>&search=<%=search%>">
		<span>이전</span></a>
	<%
	}else if(startPageNum != 1 && search == null){
	%>
	<a href="<%=request.getContextPath()%>/professor/list?pageNo=<%=startPageNum-1%>" >
		<span>이전</span></a>
	<%
	}
	for(int i=startPageNum;i<=endPageNum;i++){
		if(search != null){
//			if(currentPage == i){	}
		%>
		<a href="<%=request.getContextPath()%>/professor/list?pageNo=<%=i%>&search=<%=search%>"><span><%=i%></span></a>
		
		<%
		} else {
	%>
		<a href="<%=request.getContextPath()%>/professor/list?pageNo=<%=i%>"><span><%=i%></span></a>
		
	<%
		} // else
	}  // for
	if(endPageNum < totalPageNum  && search != null){
		%>
		<a href="<%=request.getContextPath()%>/professor/list?pageNo=<%=endPageNum+1%>&search=<%=search%>">
			<span>다음</span></a>
		
		<%
	} else if(endPageNum < totalPageNum  && search == null){
		%>
		<a href="<%=request.getContextPath()%>/professor/list?pageNo=<%=endPageNum+1%>">
			<span>다음</span></a>
		<%
	}
	%>
	</div>
	<%
	}	// search - else
	%>
		
</body>
</html>