<%@page import="kh.test.jdbckh.board.model.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style>
.wrap-flex{
	display: flex;
}
.wrap-grid{
	display:grid;
	grid-template-columns: auto auto auto auto auto;
	
}
</style>
</head>
<body>
<div>
[<%= request.getSession().getAttribute("SsLoginId") %>]<hr>
[<%= session.getAttribute("SsLoginId") %> ]<hr>
[${SsLoginId } ]<hr>
[EL 내장객체명 : ${sessionScope.SsLoginId } ]<hr>
[${successMsg }]<hr>
[${successFailMsg }]<hr>
<script>
	var msg = "${successFailMsg}"
	if (msg){
		alert(msg);
	}
</script>
<c:choose>
	<c:when test="${not empty SsLoginId }">
		<a href="${pageContext.request.contextPath }/logout">로그아웃</a>
	</c:when>
	<c:otherwise>
		<a href="${pageContext.request.contextPath }/login">로그인</a>
	</c:otherwise>
</c:choose>
</div>


	<h2>게시글</h2>
	<div><a href="<%=request.getContextPath() %>/board/insert" >새글등록</a></div>
	<div class="wrap-grid">
		<div>번호</div>
		<div>제목</div>
		<div>작성자</div>
		<div>작성일</div>
		<div>옵션</div>
<%
List<BoardDto> boardList = (List<BoardDto>)request.getAttribute("boardList");
if(boardList != null && boardList.size()>0){
	for(int i=0; i<boardList.size(); i++){
		BoardDto vo = boardList.get(i);
%>
		<div><%=vo.getBno() %></div>
		<div><%=vo.getBtitle() %></div>
		<div><%=vo.getMid() %></div>
		<div><%=vo.getBwriteDate() %></div>
		<div><a href="<%=request.getContextPath() %>/board/insert?bno=<%=vo.getBno() %>" >답글</a></div>
<%
	}
}
%>
	</div>
</body>
</html>