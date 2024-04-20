<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
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
</style>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<body>
<form action="${pageContext.request.contextPath}/emp/popup/order_updatePro" class="form" method="post" class="form">
<h2 style="margin-left: 10px">수주 수정</h2>
<sub>&nbsp;&nbsp;<span style="color: red">*</span>포함된 항목만 수정이 가능합니다.</sub>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<input type="hidden" name="od_num" value="${orderDTO.od_num}"> 
<div><b>지점명</b></div><input type="text" name="name" value="${orderDTO.name}" readonly><br>
<sub></sub>
<div><b>재료명</b></div><input type="text" name="item_name" value="${orderDTO.item_name}" readonly><br>
<sub></sub>
<div><b>수주량</b><span style="color: red">*</span></div><input type="text" name="od_amount" class="od_amount" value="${orderDTO.od_amount}"><br>
<sub></sub>
<div><b>수주일시</b></div><input type="text" name="od_time" value="${orderDTO.od_time}" readonly><br>
<sub></sub>
<b>적요</b><span style="color: red">*</span><br><textarea rows="30" cols="37" name="ob_note" style="height: 210px; width: 410px;">${orderDTO.ob_note}</textarea><br>
<sub></sub>
<br>
<span style="float:right">
<input type="submit" value="수정하기" style="background-color: black; color: #EFBDBC;">  <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
$('.form').submit(function(){
		
	var amountCheck = RegExp(/^[0-9]*$/);
	if(!amountCheck.test($('.od_amount').val())){
		alert('수주량은 숫자만 입력이 가능합니다.');
		$('.od_amount').focus();
		return false;
	}

});


</script>

</body>
</html>