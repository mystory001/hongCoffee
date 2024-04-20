<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>홍커피</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/imgs/logo.png" />
<style>
div {
	display: inline-block;
	width: 100px
}

select {
	width: 177px;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/store/popup/sell_updatePro"
		method="post" class="form">
		<h2 style="margin-left: 10px">판매 수정</h2>
		<fieldset style="border: 0px">
			<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
			<input type="hidden" name="rs_num" value="${resultDTO.rs_num}">
			<input type="hidden" name="prod_num" value="${resultDTO.prod_num}">
			<div>
				<b>유형</b>
			</div>
			<input type="text"
				value="<c:if test="${resultDTO.prod_type eq 0}">커피</c:if><c:if test="${resultDTO.prod_type eq 1}">음료</c:if><c:if test="${resultDTO.prod_type eq 2}">디저트</c:if>"
				readonly><br>
			<div>
				<b>상품명</b>
			</div>
			<input type="text" value="${resultDTO.prod_name}" name="prod_name"
				readonly><br>
			<div>
				<b>판매가</b>
			</div>
			<input type="text" name="prod_price" id="prod_price"
				value="${resultDTO.prod_price}" readonly><br>
			<div>
				<b>영업일</b>
			</div>
			<input type="text" class="rs_date" value="${resultDTO.rs_date}"
				readonly><br>
			<div>
				<b>판매량</b>
			</div>
			<input type="text" name="sales" class="sales"
				value="${resultDTO.sales}"><br>
			<br> <span style="float: right"> <input type="submit"
				value="수정하기" style="background-color: black; color: #EFBDBC;">
				<button type="button"
					style="background-color: black; color: #EFBDBC;"
					onclick="location.href='${pageContext.request.contextPath}/store/popup/close'">취소하기</button>
			</span>
		</fieldset>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>

	<script type="text/javascript">
		$(function() {
			$('.form').submit(
					function() {
						if ($('.sales').val() == ""
								|| $('.sales').val() == null
								|| $('.sales').val() == undefined) {
							alert("판매량을 입력해주세요");
							$('.sales').focus();
							return false;
						}
					});
		});
	</script>
</body>
</html>