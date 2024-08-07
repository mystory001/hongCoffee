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
<h3>출하 상세</h3>
<div class="detail2">
<table border="1">
<tr>
	<th>출하번호</th><td>${shipmentDTO.od_num} </td> <th>지점명</th><td>${shipmentDTO.name}</td>
</tr>
<tr>
	<th>재료명</th><td>${shipmentDTO.item_name}</td>
   	<th>출하수량</th><td>${shipmentDTO.sh_amount}</td>
</tr>
<tr>
	<th>단가</th><td><fmt:formatNumber value="${shipmentDTO.item_price}" pattern="#,###"></fmt:formatNumber></td>
   	<th>총금액</th><td><fmt:formatNumber value="${shipmentDTO.item_price * shipmentDTO.sh_amount}" pattern="#,###"></fmt:formatNumber></td>
</tr>
<tr>
	<th>출하일시</th><td>${shipmentDTO.sh_time}</td>
	<th>입고여부</th>
	<c:if test="${shipmentDTO.received_not eq 0}">
      <td style="color:red; ">미입고</td>
  	</c:if>
  	 <c:if test="${shipmentDTO.received_not eq 1}">
      <td style=" color:green; ">입고완료</td>
  	</c:if>
</tr>
<tr>
<th>결제여부</th>
	<c:if test="${shipmentDTO.pay eq 0}">
      <td style="color:red;" colspan="3"><b>미결제</b></td>
  	</c:if>
  	 <c:if test="${shipmentDTO.pay eq 1}">
      <td style="color:green;" colspan="3"><b>결제완료</b></td>
  	</c:if>
</tr>
<tr>
	<th>적요</th><td colspan="3">${shipmentDTO.sh_note}</td>
</tr>
</table>
</div>
</div>
<!-- <div id="buttons" style="text-align:center;"></div> -->


</body>
</html>