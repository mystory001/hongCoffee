<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="${pageContext.request.contextPath}/store/popup/stock_insertPro" method="post" class="form">
<h2 style="margin-left: 10px">재고 추가</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<div><b>유형</b></div>
<select style="width: 177px" name="item_type">
<option value="">선택해주세요</option>
<option value="0">식품</option>
<option value="1">비식품</option>
</select>
<sub></sub><br>
<div><b>재료명</b></div><input type="text" name="item_name"><br>
<sub></sub>
<div><b>단가</b></div><input type="text" name="item_price"><br>
<sub></sub>
<div><b>발주량</b></div><input type="text" name="od_amount"><br>
<sub></sub>
<div><b>적요</b></div><input type="text" name="od_note"><br>
<sub></sub>
<input type="submit" value="추가하기">
</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">

</script>
</body>
</html>