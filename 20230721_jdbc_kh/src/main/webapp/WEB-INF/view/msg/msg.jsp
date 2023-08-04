<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	var alertMsg = '${msg}'; // 반드시 따옴표로 걸어줄 것. 매우 중요.
	if(alertMsg){	// js에서는 ' '; 상태를 false로 인식함. 문자가 들어잇어야 true임.
		alert(alertMsg);
	}
	
</script>