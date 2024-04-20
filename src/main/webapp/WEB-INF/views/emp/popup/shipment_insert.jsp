<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
<form action="${pageContext.request.contextPath}/emp/popup/shipment_insertPro" method="post" class="form">
<h2 style="margin-left: 10px">출하 추가</h2>
<sub>&nbsp;&nbsp;<span style="color: red">*</span>포함된 항목은 필수항목입니다.</sub>
<fieldset style="border:0px">
<input type="hidden" name="od_num" value="${orderDTO.od_num }">
<input type="hidden" name="num" value="${orderDTO.num }">
<input type="hidden" name="item_num" value="${orderDTO.item_num }">
<div><b>지점명</b></div><input type="text" name="name" class="name" value="${orderDTO.name }"readonly><br>
<sub></sub>
<div><b>재료명</b></div><input type="text" name="item_name" class="item_name" value="${orderDTO.item_name }" readonly><br>
<sub></sub>
<div><b>출하량</b><span style="color: red">*</span></div><input type="text" name="sh_amount" class="sh_amount" value="${orderDTO.od_amount}"><br>
<sub></sub>
<div><b>단가</b></div><input type="text" name="item_price" class="item_price" value="${orderDTO.item_price}" readonly><br>
<sub></sub>
<div><b>출하일시</b></div><input type="datetime-local" name="sh_time" class="sh_time" style="width: 177px"><br>
<sub></sub>
<b>적요</b><br><textarea rows="30" cols="37" name="sh_note" style="height: 210px; width: 410px;"></textarea><br>
<sub></sub>
<br>
<span style="float:right">
<input type="submit" value="추가하기" style="background-color: black; color: #EFBDBC;">  <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">

$('.form').submit(function(){
	
	if($('.sh_amount').val()=='' || $('.sh_amount').val()==null||$('.sh_amount').val()==undefined){
		alert('출하량을 입력해주세요.');
		$('.sh_amount').focus();
		return false;
	}
	
	var amountCheck = RegExp(/^[0-9]*$/);
	if(!amountCheck.test($('.sh_amount').val())){
		alert('출하량은 숫자만 입력이 가능합니다.');
		$('.sh_amount').focus();
		return false;
	}
	
	if($('.sh_time').val()=='' || $('.sh_time').val()==null||$('.sh_time').val()==undefined){
		alert('출하일시를 입력해주세요.');
		$('.sh_time').focus();
		return false;
	}
	
});

document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('.form').addEventListener('submit', function(event) {
        var inputDate = new Date(document.querySelector('.sh_time').value);
        
        var today = new Date();
        
        if (inputDate > today) {
            alert("출하일시는 오늘 날짜 이후로 선택할 수 없습니다.");
            event.preventDefault();
        }
    });
});




</script>

</body>
</html>