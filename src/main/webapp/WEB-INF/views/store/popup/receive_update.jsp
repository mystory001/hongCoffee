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
<form action="${pageContext.request.contextPath}/store/popup/receive_updatePro" method="post" class="form">
<h2 style="margin-left: 10px">입고 수정</h2>
<fieldset style="border:0px">
<input type="hidden" name="od_num" value="${receiveDTO.od_num}">
<input type="hidden" name="num" value="${receiveDTO.num}">
<input type="hidden" name="item_num" value="${receiveDTO.item_num}">
<input type="hidden" name="rc_amountBefore" value="${receiveDTO.rc_amount}">
<div class="check"></div><br>
<div><b>유형</b></div><input type="text" value="<c:if test="${receiveDTO.item_type eq 0}">식품</c:if><c:if test="${receiveDTO.item_type eq 1}">비식품</c:if>" readonly><br>
<div><b>재료명</b></div><input type="text" name="item_name" value="${receiveDTO.item_name}" readonly><br>
<div><b>단가</b></div><input type="text" name="item_price" value="${receiveDTO.item_price}" readonly><br>
<div><b>입고량</b></div><input type="text" name="rc_amount" class="rc_amount" value="${receiveDTO.rc_amount}"><br>
<div><b>적요</b></div><br>
<textarea name="rc_note" rows="30" cols="37" style="height: 210px; width: 410px;">${receiveDTO.rc_note}</textarea>
<br> 
<span style="float:right">
<input type="submit" value="수정하기" style="background-color: black; color: #EFBDBC;">  <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
$(function() {
	$('.form').submit(
			function() {
				if ($('.rc_amount').val() == ""
						|| $('.rc_amount').val() == null
						|| $('.rc_amount').val() == undefined) {
					alert("입고량을 입력해주세요");
					$('.rc_amount').focus();
					return false;
				}
			});
});
</script>
</body>
</html>