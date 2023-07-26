<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 등록</title>
</head>
<body>
	<h2>학과 등록</h2>

	<div class="container">
		<form action = "<%=request.getContextPath() %>/department/insert.do" method="post">
			<table>
				<tr>
					<th>학과 번호</th>
					<td>
						<input type="text" name="departmentNo">
					</td>
				</tr>
				<tr>
					<th>학과 이름</th>
					<td>
						<input type="text" name="departmentName">
					</td>
				</tr>
				<tr>
					<th>계열</th>
					<td>
						<input type="text" name="category">
					</td>
				</tr>
				<tr>
					<th>개설 여부</th>
					<td>
						<input type="text" name="openYn">
					</td>
				</tr>
				<tr>
					<th>정원</th>
					<td>
						<input type="text" name="capacity">
					</td>
				</tr>
			</table>
			<button type="submit">학과 등록</button>
		</form>
	</div>
</body>
</html>