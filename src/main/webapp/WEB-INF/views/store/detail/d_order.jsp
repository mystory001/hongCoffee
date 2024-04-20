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
<h3>발주 상세</h3>
<div class="detail2">
<table border="1">
<tr>
	<th>발주번호</th><td>${orderDTO.od_num} </td> <th>지점명</th><td>${orderDTO.name}</td>
</tr>
<tr>
	<th>재료명</th><td>${orderDTO.item_name}</td>
   	<th>발주량</th><td>${orderDTO.od_amount}</td>
</tr>
<tr>
	<th>단가</th><td><fmt:formatNumber value="${orderDTO.item_price}" pattern="#,###"></fmt:formatNumber></td>
   	<th>총금액</th><td> <fmt:formatNumber value="${orderDTO.item_price * orderDTO.od_amount}" pattern="#,###"></fmt:formatNumber></td>
</tr>
<tr>
	<th>발주일시</th><td>${orderDTO.od_time}</td>
	<th>출하여부</th>
	<c:if test="${orderDTO.shipment_not eq 0}">
      <td style="color:red; ">미출하</td>
  	</c:if>
	<c:if test="${orderDTO.shipment_not eq 1}">
		<td style=" color:green; ">출하완료</td>
	</c:if>
</tr>
<tr>
	<th>입고여부</th>
	<c:if test="${orderDTO.received_not eq 0}">
      <td style="color:red; ">미입고</td>
  	</c:if>
	<c:if test="${orderDTO.received_not eq 1}">
		<td style=" color:green; ">입고완료</td>
	</c:if>

</tr>
<tr>
	<th>적요</th><td colspan="3">${orderDTO.od_note}</td>
</tr>
</table>
</div>
</div>
<!-- <div id="buttons" style="text-align:center;"></div> -->


</body>
</html>