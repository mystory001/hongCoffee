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
<h3>지점 상세</h3>
<div class="detail2">
<table border="1">
<tr>
	<th>지점 번호</th><td>${storeDTO.num} </td> 
	<th>지점명</th><td>${storeDTO.name}</td>
</tr>
<tr>
	<th>점주명</th><td>${storeDTO.boss}</td>
   	 <th>연락처</th><td>${storeDTO.phone}</td>
</tr>
<tr>
	<th>전화번호</th><td>${storeDTO.tel}</td>
	<th>이메일</th><td>${storeDTO.email}</td>
</tr>
<tr>
	<th>주소</th><td>${storeDTO.address}</td>
	<th>상세주소</th><td>${storeDTO.address_detail}</td>	
</tr>
<tr>
	<th>우편번호</th><td>${storeDTO.postalcode}</td>
	<th>상태</th>
<c:if test="${storeDTO.state eq 1}">
      <td style=" color:green; ">정상영업</td>
  	</c:if>
  	  	<c:if test="${storeDTO.state eq 2}">
      <td style=" color:orange; ">미영업</td>
  		</c:if>
  	  	<c:if test="${storeDTO.state eq 3}">
      <td style=" color:red; ">폐업</td>
  	</c:if>
</tr>
<tr>
	<th>비밀번호</th><td>${storeDTO.pw}</td>
</tr>

<tr>
	<th>적요</th><td colspan="3">${storeDTO.note}</td>
</tr>
</table>
</div>
</div>
<!-- <div id="buttons" style="text-align:center;"></div> -->


</body>
</html>