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
<form action="${pageContext.request.contextPath}/emp/popup/emp_updatePro" method="post" class="form">
<h2 style="margin-left: 10px">사원 수정</h2>
<sub>&nbsp;&nbsp;<span style="color: red">*</span>포함된 항목만 수정이 가능합니다.</sub>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<div><b>사원번호</b></div><input type="text" name="emp_num" value="${employeeDTO.emp_num}" readonly><br>
<sub></sub>
<div><b>비밀번호</b><span style="color: red">*</span></div><input type="password" name="emp_pw" value="${employeeDTO.emp_pw }"><br>
<sub></sub>
<div><b>사원명</b><span style="color: red">*</span></div><input type="text" name="emp_name" value="${employeeDTO.emp_name}"><br>
<sub></sub>
<div><b>생년월일</b></div><input type="text" name="emp_birth" value="${employeeDTO.emp_birth}" readonly style="width: 177px"><br>
<sub></sub>
<div><b>부서</b></div><input type="text" name="emp_dept" value="<c:if test="${employeeDTO.emp_dept eq 0}">무소속</c:if><c:if test="${employeeDTO.emp_dept eq 1}">인사팀</c:if><c:if test="${employeeDTO.emp_dept eq 2}">영업팀</c:if><c:if test="${employeeDTO.emp_dept eq 3}">재무팀</c:if>" readonly><br>
<sub></sub>
<div><b>직급</b></div><input type="text" name="emp_rank" value="<c:if test="${employeeDTO.emp_rank eq 0}">무보직</c:if><c:if test="${employeeDTO.emp_rank eq 1}">대표</c:if><c:if test="${employeeDTO.emp_rank eq 2}">팀장</c:if><c:if test="${employeeDTO.emp_rank eq 3}">대리</c:if><c:if test="${employeeDTO.emp_rank eq 4}">사원</c:if>" readonly><br>
<sub></sub>
<div><b>연락처</b><span style="color: red">*</span></div><input type="tel" name="emp_phone" value="${employeeDTO.emp_phone}"><br>
<sub></sub>
<div><b>이메일</b><span style="color: red">*</span></div><input type="email" name="emp_email" value="${employeeDTO.emp_email }"><br>
<sub></sub>
<div><b>입사일</b></div><input type="text" name="hire_date" value="${employeeDTO.hire_date }" readonly ><br>
<sub></sub>
<br>
<span style="float:right; margin-right: 50px">
<input type="submit" value="수정하기" style="background-color: black; color: #EFBDBC;">  <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
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

</script>
</body>
</html>