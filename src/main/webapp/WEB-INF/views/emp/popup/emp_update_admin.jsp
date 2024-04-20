<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>홍커피</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/imgs/logo.png" />
<style>
div{
	display: inline-block; width: 100px
}
select{
	width: 177px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/emp/popup/emp_updateProAdmin" method="post" class="form">
<h2 style="margin-left: 10px">사원 수정</h2>
<sub>&nbsp;&nbsp;<span style="color: red">*</span>포함된 항목만 수정이 가능합니다.</sub>
<fieldset style="border:0px">
<div><b>사원번호</b></div><input type="text" name="emp_num" value="${employeeDTO.emp_num }" readonly><br>
<sub></sub>
<div><b>비밀번호</b><span style="color: red">*</span></div><input type="password" name="emp_pw" class="emp_pw" value="${employeeDTO.emp_pw }"><br>
<sub></sub>
<div><b>사원명</b><span style="color: red">*</span></div><input type="text" name="emp_name" value="${employeeDTO.emp_name }"><br>
<sub></sub>
<div><b>생년월일</b><span style="color: red">*</span></div><input type="date" name="emp_birth" class="emp_birth" style="width: 177px" value="${employeeDTO.emp_birth }"><br>
<sub></sub>
<div><b>부서</b><span style="color: red">*</span></div>
<select name="emp_dept">
<option value="0" <c:if test="${employeeDTO.emp_dept eq '0'}"> selected </c:if>>무소속</option>
<option value="1" <c:if test="${employeeDTO.emp_dept eq '1'}"> selected </c:if>>인사팀</option>
<option value="2" <c:if test="${employeeDTO.emp_dept eq '2'}"> selected </c:if>>영업팀</option>
<option value="3" <c:if test="${employeeDTO.emp_dept eq '3'}"> selected </c:if>>재무팀</option>
</select><br>
<sub></sub>
<div><b>직급</b><span style="color: red">*</span></div>
<select name="emp_rank">
<option value="0" <c:if test="${employeeDTO.emp_rank eq '0'}"> selected </c:if>>무보직</option>
<option value="4" <c:if test="${employeeDTO.emp_rank eq '4'}"> selected </c:if>>사원</option>
<option value="3" <c:if test="${employeeDTO.emp_rank eq '3'}"> selected </c:if>>대리</option>
<option value="2" <c:if test="${employeeDTO.emp_rank eq '2'}"> selected </c:if>>팀장</option>
<option value="1" <c:if test="${employeeDTO.emp_rank eq '1'}"> selected </c:if>>대표</option>
</select><br>
<sub></sub>
<div><b>권한</b><span style="color: red">*</span></div>
<select name="emp_right">
<option value="0" <c:if test="${employeeDTO.emp_right eq '0'}"> selected </c:if>>사원</option>
<option value="1" <c:if test="${employeeDTO.emp_right eq '1'}"> selected </c:if>>관리자</option>
</select><br>
<sub></sub>
<div><b>연락처</b><span style="color: red">*</span></div><input type="text" name="emp_phone" class="emp_phone" value="${employeeDTO.emp_phone }"><br>
<sub></sub>
<div><b>이메일</b><span style="color: red">*</span></div><input type="email" name="emp_email" class="emp_email" value="${employeeDTO.emp_email }"><br>
<sub></sub>
<div><b>입사일</b><span style="color: red">*</span></div><input type="date" name="hire_date" style="width: 177px" value="${employeeDTO.hire_date }"><br>
<sub></sub>
<div><b>상태</b><span style="color: red">*</span></div>
<select name="emp_state">
<option value="1" <c:if test="${employeeDTO.emp_state eq '1'}"> selected </c:if>>재직</option>
<option value="2" <c:if test="${employeeDTO.emp_state eq '2'}"> selected </c:if>>휴직</option>
<option value="3" <c:if test="${employeeDTO.emp_state eq '3'}"> selected </c:if>>퇴직</option>
</select><br>
<sub></sub>
<b>적요</b><span style="color: red">*</span><br><textarea rows="30" cols="37" name="emp_note" style="height: 210px; width: 410px;">${employeeDTO.emp_note }</textarea><br>
<sub></sub>
<br>
<span style="float:right">
<input type="submit" value="등록하기" style="background-color: black; color: #EFBDBC;">  <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
$(function(){
	$('.form').submit(function(){
		
		//비밀번호
		if($('.emp_pw').val()=='' || $('.emp_pw').val()==null||$('.emp_pw').val()==undefined){
			alert('비밀번호를 입력해주세요.');
			$('.emp_pw').focus();
			return false;
		}

// 		var phoneCheck = RegExp(/^[0-9\-]{9,13}$/);
// 		if( ! phoneCheck.test($('.emp_name').val()) ){
// 			alert("숫자만 입력가능합니다.");
// 			$('.emp_name').focus();
// 			return false;
// 		}
		
		
	});
});	
	
$(".emp_phone").on('keydown keyup', function() {
	this.value = this.value.replace(/[^0-9]/g, '');

	var str = this.value;
	var tmp = '';
	var bullet = '-';

	if (str.length > 3 && str.length < 8) {
		tmp += str.substr(0, 3);
		tmp += bullet;
		tmp += str.substr(3);
		this.value = tmp;
	} else if (str.length == 8) {
		tmp += str.substr(0, 4);
		tmp += bullet;
		tmp += str.substr(4);
		this.value = tmp;
	} else if (str.length == 10) {
		tmp += str.substr(0, 2);
		tmp += bullet;
		tmp += str.substr(2, 4);
		tmp += bullet;
		tmp += str.substr(6); // 10자리일때
		this.value = tmp;
	} else if (str.length > 8) {
		tmp += str.substr(0, 3);
		tmp += bullet;
		tmp += str.substr(3, 4);
		tmp += bullet;
		tmp += str.substr(7, 4);
		this.value = tmp;
	} else {
		this.value = str;
	}
	
});

document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('.form').addEventListener('submit', function(event) {
        var inputDate2 = new Date(document.querySelector('.emp_birth').value);
        
        var today = new Date();
        
        if (inputDate2 > today) {
            alert("생년월일은 오늘 날짜 이후로 선택할 수 없습니다.");
            event.preventDefault();
        }
    });
});


</script>

</body>
</html>