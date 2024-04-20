<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
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
<h3>입고 상세</h3>
<div class="detail2">
<table border="1">
<tr>
	<th>거래번호</th><td>${receiveDTO.od_num} </td> <th>지점명</th><td>${receiveDTO.name}</td>
</tr>
<tr>
	<th>재료명</th><td>${receiveDTO.item_name}</td>
   	<th>입고수량</th><td>${receiveDTO.rc_amount}</td>
</tr>
<tr>
	<th>단가</th><td><fmt:formatNumber value="${receiveDTO.item_price}" pattern="#,###"></fmt:formatNumber></td>
   	<th>총금액</th><td> <fmt:formatNumber value="${receiveDTO.item_price * receiveDTO.rc_amount}" pattern="#,###"></fmt:formatNumber></td>
</tr>
<tr>
	<th>입고일시</th><td>${receiveDTO.rc_time}</td>
	<th>결제여부</th>
	<c:if test="${receiveDTO.pay eq 0}">
      <td style="color:red; ">미결제</td>
  	</c:if>
	<c:if test="${receiveDTO.pay eq 1}">
		<td style=" color:green; ">결제완료</td>
	</c:if>
</tr>
<tr>
	<th>적요</th><td colspan="3">${receiveDTO.rc_note}</td>
</tr>
</table>
</div>
</div>
<!-- <div id="buttons" style="text-align:center;"></div> -->


</body>
</html>