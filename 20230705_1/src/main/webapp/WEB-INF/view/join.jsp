<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
.hint{
		/* display:table-row; */
		font-size:.7em;
		color:blue;
		/*display:none; */
		visibility:hidden;
	}
</style>
<script>
	window.onload = loadedHandler;
	function loadedHandler(){
		$("[type=text]").click(inputClickHandler);
		$("[type=password]").click(inputClickHandler);
		$("[type=email]").click(inputClickHandler);
	}
	function inputClickHandler(e){
		console.log("inputClickHandler");
		console.log(this);
		console.log($(this).parents("tr").next(".hint"));
		$(".hint").css("visibility","hidden");
		var $hintElement = $(this).parents("tr").next(".hint");
		$hintElement.css("visibility","visible");
	}
</script>
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
	$("#frmJoin [type=button]").click(sumbitHandler);
	function sumbitHandler(){
		var result = checkRegularExpression1();
		if(result == false){
			return;
		}
		//전달
		var queryString = $("#frmJoin").serialize();
		console.log(queryString);
		//queryString : ?n1=v1&n2=v2
		//var queryStringEx = "?"+"mid"+$("[name-mid]").val()+"&mpwd="+$("[name=mpwd]").val();
		
	}
	function checkRegularExpression1(){
		console.log("여기 들어완?")
		//유효성 검사
		var id = $("[name=mid]").val();
		var regEx_id = /^[a-zA-Z][A-Za-z0-9_!]{4,8}$/; 
		console.log(typeof(regEx_id));
		if(!regEx_id.test(id)){
			alert("아이디는 5-16자 영문자와 숫자만 입력해주세요.");
			$("[name=mid]").focus();
			return;
	}
		/* if(id.length<5 || id.length>16){
			//오류 조건식으로 체크함
			alert("아이디는 5-16자 이내로 입력해주세요.");
			$("[name=mid]").focus();
			return;
		} */
		//String 객체 메소드
		//includes("a")
		
		// id가 정상적으로 입력되어있다면 다음 pwd 체크함.
		var pwd = $("[name=mpwd]").val();
		var regEx_pwd = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!_#])[a-zA-Z0-9!_#]{5,9}$/; 
		if(!regEx_pwd.test(pwd)){
			console.log("정규표현식 부적합");
			alert("비밀번호는 5-9자 이내로 대소문자, 특수문자 포함하여 입력해주세요.");
			$("[name=mpwd]").focus();
			return;
		}else{
			console.log("정규표현식 적합");
		}
		/* if(pwd.length<8 || pwd.length>20){
			//오류 조건식으로 체크함
			alert("비밀번호는 8-20자 이내로 입력해주세요.");
			$("[name=mpwd]").focus();
			return;
		} */
		var name = $("[name=mname]").val();
		var regEx_name = /^[가-힣]{2,10}$/;
		if(!regEx_name.test(name)){
			console.log("정규표현식 부적합");
			alert("이름은2~10자 사이의 한글을 입력해 주세요.");
			$("[name=mname]").focus();
			return;
		}
		var tel = $("[name=mtel]").val();
		var regEx_tel = /^[0-9]{3}-[0-9]{4}$/;
		if(!regEx_tel.test(tel)){
			$("[name=mtel]").focus();
			alert("-기호를 포함하여 0부터 9까지의 숫자 7자리를 작성해 주세요.")
			return;
		}
		
		var sno = $("[name=msno]").val()
		var regEx_sno = /^[0-9]{6}-[1-4][0-9]{6}$/;
		if(!regEx_sno.test(sno)){
			$("[name=msno]").focus();
			alert("-기호를 포함하여 0부터 9까지의 숫자를 이요하여 13자리 주민번호를 입력해 주세요.")
			return;
		}
		
	}
	
</script>	
</body>
</html>