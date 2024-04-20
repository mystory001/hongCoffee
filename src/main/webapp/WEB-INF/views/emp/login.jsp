<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>홍커피</title>
<style>
.container{
text-align: center;
}
.inner{
text-align: center;
}
.employee_num, .employee_pw{
background-color: #EEEEEE;
}
</style>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/imgs/logo.png" />
</head>
<body>
<div class="container">
<img src="${pageContext.request.contextPath}/resources/imgs/logo.png" width="265" height="265" alt="Hong Coffee"><br>
<div class="loginform">
<form action="${pageContext.request.contextPath}/login" method="post" id="login">
<label></label>
<div id="checkdiv"></div>
<div class="inner">
<label>사원번호</label>
<input type="text" name="emp_num" class="emp_num" id="userId"><br>
<label>비밀번호</label>
<input type="password" name="emp_pw" class="emp_pw"><br>
<input type="submit" value="로그인" class="submit" style="margin-left: 70px; width: 177px; background-color: #C9DAF8">
<hr width="315">
<input type="checkbox" class="rememberCheck" id="idSaveCheck">사원번호 기억하기
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</div>
</form>
</div>
</div>
<script type="text/javascript">


	$(function(){
		$('#login').submit(function(){
		if($('.emp_num').val() === ''|| $('.emp_num').val === null || $('.emp_num').val === undefined){
			$('#checkdiv').html("사원번호를 입력해주세요.").css("color","red");
			$('.emp_num').focus();
			return false;
		}
		
		if($('.emp_pw').val() === ''|| $('.emp_pw').val === null || $('.emp_pw').val === undefined){
			$('#checkdiv').html("비밀번호를 입력해주세요.").css("color","red");
			$('.emp_pw').focus();
			return false;
		}
		var numCheck = RegExp(/^[0-9]{2,10}$/);
			if (!numCheck.test($('.emp_num').val())) {
				alert("사원번호 또는 비밀 번호를 확인해주세요."); //보안상 메세지 내용을 이와 같이함
				$('.emp_num').focus();
				return false;
			}		
	});
});
	
	$(document).ready(function(){
		  
	    
	    var key = getCookie("key");
	    $("#userId").val(key); 
	      
	    if($("#userId").val() != ""){
	        $("#idSaveCheck").attr("checked", true); 
	    }
	      
	    $("#idSaveCheck").change(function(){ 
	        if($("#idSaveCheck").is(":checked")){ 
	            setCookie("key", $("#userId").val(), 7); 
	        }else{ 
	            deleteCookie("key");
	        }
	    });
	      
	    
	    $("#userId").keyup(function(){ 
	        if($("#idSaveCheck").is(":checked")){ 
	            setCookie("key", $("#userId").val(), 7); 
	        }
	    });
	});
	  
	function setCookie(cookieName, value, exdays){
	    var exdate = new Date();
	    exdate.setDate(exdate.getDate() + exdays);
	    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
	    document.cookie = cookieName + "=" + cookieValue;
	}
	  
	function deleteCookie(cookieName){
	    var expireDate = new Date();
	    expireDate.setDate(expireDate.getDate() - 1);
	    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
	}
	  
	function getCookie(cookieName) {
	    cookieName = cookieName + '=';
	    var cookieData = document.cookie;
	    var start = cookieData.indexOf(cookieName);
	    var cookieValue = '';
	    if(start != -1){
	        start += cookieName.length;
	        var end = cookieData.indexOf(';', start);
	        if(end == -1)end = cookieData.length;
	        cookieValue = cookieData.substring(start, end);
	    }
	    return unescape(cookieValue);
	}



</script>

</body>
</html>