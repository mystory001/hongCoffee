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
<form action="${pageContext.request.contextPath}/store/popup/consume_updatePro" method="post" class="form">
<h2 style="margin-left: 10px">소모 수정</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<input type="hidden" name="rs_num" value="${resultDTO.rs_num}">
<input type="hidden" name="stock_num" value="${resultDTO.stock_num}">
<input type="hidden" name="consumeBefore" value="${resultDTO.consume}">
				<div>
					<b>유형</b>
				</div>
					<input type="text" value="<c:if test="${resultDTO.item_type eq 0}">식품</c:if><c:if test="${resultDTO.item_type eq 1}">비식품</c:if>"  readonly ><br>
				<div>
					<b>재료명</b>
				</div>
					<input type="text" value="${resultDTO.item_name}" name="item_name" readonly ><br>
			<div>
				<b>단가</b>
			</div>
			<input type="text" name="item_price" id="item_price" value="${resultDTO.item_price}" readonly><br>
						<div>
				<b>영업일</b>
			</div>
			<input type="text" class="rs_date" value="${resultDTO.rs_date}" readonly><br>
			<div>
				<b>소모량</b>
			</div>
			<input type="text" name="consume" class="consume" value="${resultDTO.consume}"><br>
				<br>

<span style="float:right">
<input type="submit" value="수정하기" style="background-color: black; color: #EFBDBC;">  <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/store/popup/close'">취소하기</button>
</span>
</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
$(function() {
	$('.form').submit(
			function() {



				if ($('.consume').val() == ""
						|| $('.consume').val() == null
						|| $('.consume').val() == undefined) {
					alert("소모량을 입력해주세요");
					$('.consume').focus();
					return false;
				}
			});
});
</script>
</body>
</html>