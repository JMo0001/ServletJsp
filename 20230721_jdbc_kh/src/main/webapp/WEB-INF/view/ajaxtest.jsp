<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax test</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
.grid-rwap{
	display: grid;
	grid-template-columns: auto auto;
}
</style>
</head>
<body>
	<h2>ajax test</h2>
	<input type="text">
	<button id="btnajax1">ajax1</button>
	<button id="btnajax2">ajax2</button>
<div class="grid-wrap">
	<div>학과번호</div><div>학과이름</div>
</div>
<div>
	<h2>로그인</h2>
	<form id="frm-login">
		id : <input type="text" name = "mid" required="required">
		pw : <input type="password" name = "mpwd" required="required">
		<button type="button" id ="btnajax3">로그인</button>	
	</form>
</div>
<div>
	<h2>여러회원가입(장바구니선택)</h2>
	<div class = "singup">
		id : <input type="text" name = "mid" required="required"><br>
		pw : <input type="password" name = "mpwd" required="required"><br>
		이름 : <input type="text" name = "mname" required="required"><br>
		이메일 : <input type="text" name = "memail" required="required"><br>
	</div>
	<div class = "singup">
		id : <input type="text" name = "mid" required="required"><br>
		pw : <input type="password" name = "mpwd" required="required"><br>
		이름 : <input type="text" name = "mname" required="required"><br>
		이메일 : <input type="text" name = "memail" required="required"><br>
	</div>
	<div class = "singup">
		id : <input type="text" name = "mid" required="required"><br>
		pw : <input type="password" name = "mpwd" required="required"><br>
		이름 : <input type="text" name = "mname" required="required"><br>
		이메일 : <input type="text" name = "memail" required="required"><br>
	</div>
		
	<button type="button" id ="btnajax4">회원가입 TODO</button>	
</div>
	
<script>
$("#btnajax1").click(ajax1ClickHandler);
$("#btnajax2").click(ajax2ClickHandler);
$("#btnajax3").click(ajax3ClickHandler);
$("#btnajax4").click(ajax4ClickHandler);

function ajax4ClickHandler(){
	var dataArr = [];	// << js array - json 따옴표
	$(".singup").each(function(idx){
		var dataObj = {
			mid:$(this)/* .child() */.find("[name=mid]").val()
			, mpwd:$(this).find("[name=mpwd]").val()
			, mname:$(this).find("[name=mname]").val()
			, memail:$(this).find("[name=memail]").val()
		};	
		
		dataArr.push(dataObj);
	});
	console.log(dataArr);
	console.log(JSON.stringify(dataArr));	// json 으로 변형되면서 String 형태. 자료형 String
	
	$.ajax({
		url:"${pageContext.request.contextPath}/ajax4"
		, type:"post"
		, data: JSON.stringify(dataArr)
			/* dataQuery << 변수에 담기보다 위에처럼 씀.*/
			/* {
				mid:$("[name=mid]").val(),
				mpwd:$("[name=mpwd]").val()
				} */
		,success:function(result){
			console.log("success:")
			console.log(result)
		}
		,error:function(){
			console.log("error:")
			console.log(result)
			
		}
	});
}



function ajax3ClickHandler(){
	console.log("ajax3ClickHandler");
	/* form엘리먼트객체.serialize() */
	/* var dataQuery = $("#frm-login").serialize();
	console.log(dataQuery); */
	$.ajax({
		url:"${pageContext.request.contextPath}/ajax3"
		, type:"post"
		, data: $("#frm-login").serialize()
			/* dataQuery << 변수에 담기보다 위에처럼 씀.*/
			/* {
				mid:$("[name=mid]").val(),
				mpwd:$("[name=mpwd]").val()
				} */
		,success:function(result){
			console.log("success:")
			console.log(result)
		}
		,error:function(){
			console.log("error:")
			console.log(result)
			
		}
	});
	
}

function ajaxSuccess(result){
	console.log("controller로부터 데이터 전달받음.-3");
	console.log(result);
	alert(result);
}
function ajaxSuccess2(result){
	console.log("controller2로부터 데이터 전달받음.-3");
	console.log(result);
	//console.log(result.deptList);
	if(result){
		for(var i=0; i<result.length; i++){
			var dvo = result[i];
			console.log(dvo.departmentNo);
		}
	}
	displayDepartment(result);
}

function ajax1ClickHandler(){
	console.log("btnajax1 click");
	/* $.ajax(object형태로매개인자전달해야함.); */
	/* var obj = {키:값, k1:12, k2:'asdfasd', k3:function(){}}; */
	console.log("ajax로 데이터 전달 전-0");
	$.ajax({
		url : "${pageContext.request.contextPath}/ajax1"
		, type : "get" /* "post" */
		, data : {n1:'값도가나?', n2:123}
		/* , success : function(result){
			console.log("controller로부터 데이터 전달받음.-3");
			console.log(result);
			}//보통 result 말고 data로 줌. */ //위쪽에 함수로 뺴버림 success : function
		, success : ajaxSuccess	
		
		});
	console.log("ajax로 데이터 전달 중-1");
}

function ajax2ClickHandler(){
	console.log("btnajax2 click");
	$.ajax({
		url : "${pageContext.request.contextPath}/ajax2"
		, type : "post" 
		, success : ajaxSuccess2
		, dataType : "json"
		});
}

function displayDepartment(deptList){
	htmlVal = "<div>학과번호</div><div>학과이름</div>";
	for(var i=0; i<deptList.length;i++){
		var dvo = deptList[i];
		
	htmlVal += "<div>"+dvo.departmentNo+"</div>";
	htmlVal +="<div>"+dvo.departmentName+"</div>";
	
	}
	$('.grid-wrap').html(htmlVal);
	
	
}

</script>
	
</body>
</html>