<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<style>
.detail1 {
    margin: 1.2em;
}
.detail2 {
    table-layout: fixed;
}
table {
    width: 100%;
    text-align: center;
    border-color: #6C7383;
    border-collapse: collapse;
    margin: 20px, 20px;
}
th{
	background-color: #EFBDBC;
     color: #fff; 
	text-align: -webkit-match-parent;

}

th, td{
width: 300px;
height: 45px;
font-size: 16px;
}
</style>
<head>
<meta charset="UTF-8">
<title>홍커피</title>
</head>
<body>
<div class="detail1">
<h3>사원 상세</h3>
<div class="detail2">
<table border="1">
<tr>
	<th>사원번호</th><td>${employeeDTO.emp_num} </td> <th>사원명</th><td>${employeeDTO.emp_name}</td>
</tr>
<tr>
	<th>연락처</th><td>${employeeDTO.emp_phone}</td>
   	<th>이메일</th><td>${employeeDTO.emp_email}</td>
</tr>
<tr>
	<th>생년월일</th><td>${employeeDTO.emp_birth}</td>
	<th>상태</th>
	<c:if test="${employeeDTO.emp_state eq 1}">
 		<td style="color:green;">재직</td>
 		</c:if>
 		<c:if test="${employeeDTO.emp_state eq 2}">
 		<td style="color:orange;">휴직</td>
 		</c:if>
 		<c:if test="${employeeDTO.emp_state eq 3}">
 		<td style="color:red;">퇴직</td>
 		</c:if>
</tr>
<tr>
	<th>부서</th>  <c:if test="${employeeDTO.emp_dept eq 0}">
    <td >소속없음</td>
    </c:if>
        <c:if test="${employeeDTO.emp_dept eq 1}">
    <td>인사팀</td>
    </c:if>
        <c:if test="${employeeDTO.emp_dept eq 2}">
    <td>영업팀</td>
    </c:if>
        <c:if test="${employeeDTO.emp_dept eq 3}">
    <td >재무팀</td>
    </c:if>
	<th>직급</th>
  <c:if test="${employeeDTO.emp_rank eq 0}">
    <td >직급없음</td>
    </c:if>
        <c:if test="${employeeDTO.emp_rank eq 1}">
    <td >대표</td>
    </c:if>
        <c:if test="${employeeDTO.emp_rank eq 2}">
    <td >팀장</td>
    </c:if>
        <c:if test="${employeeDTO.emp_rank eq 3}">
    <td>대리</td>
    </c:if>
        <c:if test="${employeeDTO.emp_rank eq 4}">
    <td >사원</td>
    </c:if>
</tr>
<tr>
<th>입사일</th><td>${employeeDTO.hire_date}</td>
<th>퇴사일</th><td>${employeeDTO.quit_date}</td>
   	
	
</tr>
<tr>
	
<c:if test="${sessionScope.emp_right eq 1 }">
	<th>권한</th><td>
	<c:if test="${employeeDTO.emp_right eq 1}">관리자</c:if>
   		<c:if test="${employeeDTO.emp_right eq 0}">일반</c:if>
   		</td>
   		</c:if>
	<c:if test="${sessionScope.emp_right eq 1 }">
   		<th>비밀번호</th><td>${employeeDTO.emp_pw}</td>
   		</c:if>
   		
</tr>
<tr>
	<th>적요</th><td colspan="3">${employeeDTO.emp_note}</td>
</tr>
</table>
</div>
</div>
<!-- <div id="buttons" style="text-align:center;"></div> -->


</body>
</html>