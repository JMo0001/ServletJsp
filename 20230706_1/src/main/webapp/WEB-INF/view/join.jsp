<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
	.hint{
		color:blue;
		font-size:.7em;
		visibility:hidden;
		
	}
</style>
<script>
	window.onload = loadedHandler;
	function loadedHandler(){
		console.log("loadedHandler");
		$("[type=text]").focus(focusHandler);
		$("[type=password]").focus(focusHandler);
		$("[type=email]").focus(focusHandler);
		$("[type=text]").blur(blurHandler);
		$("[type=password]").blur(blurHandler);
		$("[type=email]").blur(blurHandler);
		
	}
	function focusHandler(e){
		console.log("focus")
		console.log(this);
		console.log($(this).parents("tr").next(".hint"));
		$(".hint").css("visibility","hidden");
		var $hint = $(this).parents("tr").next(".hint");
		$hint.css("visibility","visible");
		
	}
	function blurHandler(e){
		console.log("blur")
		var $hint = $(this).parents("tr").next(".hint");
		$hint.css("visibility","hidden");
	}
	
</script>
<title>join</title>
</head>
<body>
	<h1>회원가입</h1>
	<div>
		<%-- <form action="<%=request.getContextPath() %>/join" method="post"> --%>
		<form id="frmJoin">	
			<table>
				<tr>
					<th>아이디</th>
						<td><input type="text" name="mid" placeholder="(5-16, 영문자로시작,숫자,특수기호(_만 가능) 못씀)">
						</td>
				</tr>
				<tr class="hint">
					<td></td>
					<td>5-16, 영문자로시작,숫자,특수기호(_만 가능) 못씀</td>
				</tr>
				<tr><th>패스워드</th><td>
				<input type="password" name="mpwd" placeholder="(5-9, 대문자,소문자,숫자,특수문자(!_#) 최소1개이상 포함)">
				</td></tr>
				<tr class="hint">
					<td></td>
					<td>5-9, 대문자,소문자,숫자,특수문자(!_#) 최소1개이상 포함</td>
				</tr>
				<tr><th>이름</th>	<td><input type="text" name="mname" placeholder="(2-10)"></td></tr>
				<tr class="hint">
					<td></td>
					<td>2-10</td>
				</tr>
				<tr><th>전화번호</th><td><input type="text" name="mtel" placeholder="(7-좀전...)"></td></tr>
				<tr class="hint">
					<td></td>
					<td>7-좀전...</td>
				</tr>
				<tr><th>이메일</th><td><input type="email" name="memail" placeholder="(5-100, 일단생략)"></td></tr>
				<tr class="hint">
					<td></td>
					<td>5-100, 일단생략</td>
				</tr>
				<tr><th>주민번호</th><td><input type="text" name="msno" placeholder="(14, 좀전)"></td></tr>
				<tr class="hint">
					<td></td>
					<td>14, 좀전...</td>
				</tr>
				<tr><td colspan="2"><input type="button" value="회원가입" ></td></tr>
			</table>
		</form>
	</div>
<script>
	/* 유효성검사 = 버튼이 눌리면 검사를 하고 오류에 focus. */
	$("[type=button]").click(testHandler);
	function testHandler(e){
		console.log("가입버튼 누름");
		var midval= $("[name=mid]").val()
		var reg_idval = /^[a-zA-Z] $/
	}
</script>
</body>
</html>