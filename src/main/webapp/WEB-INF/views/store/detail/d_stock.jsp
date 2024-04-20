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
<h3>재료 상세</h3>
<div class="detail2">
<table border="1">
<tr>
	<th>재고 번호</th><td>${stockDTO.stock_num} </td> <th>재료명</th><td>${stockDTO.item_name}</td>
</tr>
<tr>
	<th>유형</th><c:if test="${stockDTO.item_type eq 0}">
   	  			<td style=" color:#4E342E;">식품</td>
   	  	</c:if>
   	  	 <c:if test="${stockDTO.item_type eq 1}">
   	  		<td style="color:#FF3D00;" >비식품</td>
   	  	</c:if>
   	  	 <th>단가</th>
   	  	 <td>${stockDTO.item_price}</td>
</tr>
<tr>
	<th>보유량</th><td>${stockDTO.amount}</td>
	<th>상태</th>	
	<c:if test="${stockDTO.item_state eq 0}">
      <td style="color:green;">취급</td>
  	</c:if>
  	<c:if test="${stockDTO.item_state eq 1}">
      <td style="color:red;">미취급</td>
  	</c:if>
 
</tr>
<tr>
	<th>적요</th><td colspan="3">${stockDTO.stock_note }</td>
</tr>
</table>
</div>
</div>
<!-- <div id="buttons" style="text-align:center;"></div> -->


</body>
</html>