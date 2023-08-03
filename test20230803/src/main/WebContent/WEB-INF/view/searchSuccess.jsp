<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 결과</title>
</head>
<body>
	<h2>회원정보</h2>
	<table border="1">
		<tr>
			<th>회원 번호</th>
			<th>회원 아이디</th>
			<th>회원 이름</th>
			<th>회원 나이</th>
		</tr>
		<tr>
			<th>${udto.userNo }</th>
			<th>${udto.userId }</th>
			<th>${udto.userName }</th>
			<th>${udto.userAge }</th>
		</tr>
		
	</table>
	
	<a href="${pageContext.request.contextPath }/" >메인페이지로 돌아가기</a>
</body>
</html>