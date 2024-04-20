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
<form action="${pageContext.request.contextPath}/store/popup/stock_updatePro" method="post" class="form">
<h2 style="margin-left: 10px">재고 수정</h2>
<input type="hidden" name="stock_num" value="${stockDTO.stock_num}">
<fieldset style="border:0px">
				<div>
					<b>유형</b>
				</div>
					<input type="text" value="<c:if test="${stockDTO.item_type eq 0}">식품</c:if><c:if test="${stockDTO.item_type eq 1}">비식품</c:if>" name="item_type" readonly ><br>
				<div>
					<b>재료명</b>
				</div>
					<input type="text" value="${stockDTO.item_name}" readonly ><br>
			<div>
				<b>단가</b>
			</div>
			<input type="text" id="item_price" value="${stockDTO.item_price}" readonly><br>
			<div>
				<b>보유량</b>
			</div>
			<input type="text" name="amount" class="amount" value="${stockDTO.amount}"><br>
			<div>
				<b>적요</b>
			</div>
			<textarea name="stock_note" rows="30" cols="37" style="height: 210px; width: 410px;">${stockDTO.stock_note}</textarea><br>

<span style="float:right">
<input type="submit" value="수정하기" style="background-color: black; color: #EFBDBC;"> <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/store/popup/close'">취소하기</button>
</span>
</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
$(function() {
	$('.form').submit(
			function() {
				if ($('.amount').val() == ""
						|| $('.amount').val() == null
						|| $('.amount').val() == undefined) {
					alert("보유량을 입력해주세요");
					$('.amount').focus();
					return false;
				}
			});
});
</script>
</body>
</html>