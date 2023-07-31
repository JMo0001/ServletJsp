<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
.wrap-flex{
	display:flex;
	}
.wrap-grid{
	displsy:grid;
	grid-template-columns: auto auto auto auto auto;
}
</style>
</head>
<body>
	<h2>게시판</h2>
	<div class="wrap-grid">
		<div>번호</div>
		<div>제목</div>
		<div>작성자</div>
		<div>작성일</div>
		<div>옵션</div>
		<c:if test="${not empty boardList }">
			<c:forEach items="${boardList }" var="vo">
				<div>${vo.bno }</div>
				<div>
					<c:forEach begin="1" end="${vo.breLevel }"></c:forEach>
					${vo.btitle }
				</div>
				<div>${vo.mid }</div>
				<div>${vo.bwriteDate }</div>
				<div>답글</div>
			</c:forEach>
		</c:if>
	</div>
	
</body>
</html>