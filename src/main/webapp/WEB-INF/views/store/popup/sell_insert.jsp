<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

.box-body {
	display: inline-block;
}

.input-group {
	display: inline-block;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/store/popup/sell_insertPro"
		method="post" class="form">
		<input type="hidden" name="num" value="${sessionScope.num}">
		<h2 style="margin-left: 10px">판매 추가</h2>
		<sub>반드시 상품 유형을 먼저 선택해주셔야합니다.</sub>
		<fieldset style="border: 0px">
			<div class="check"></div>
			<br>
			<div class="box-body">
				<table>
					<tr>
						<td>
							<div>
								<b>상품 유형</b>
							</div>
						</td>
						<td>
							<div class="input-group">
								<select class="form-control" style="width: 177px"
									name="prod_type" class="prod_type">
									<option value="100">선택해주세요</option>
									<option value="0">커피</option>
									<option value="1">음료</option>
									<option value="2">디저트</option>
								</select>
							</div>
						</td>
					<tr>
						<td>
							<div>
								<b>상품명</b>
							</div>
						</td>
						<td>
							<div class="input-group">
								<select class="form-control" name="prod_name" id="prod_name">
									<option value="100">선택해주세요</option>
								</select>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<b>판매가</b>
			</div>
			<input type="text" name="prod_price" id="prod_price" readonly><br>
			<div>
				<b>영업일</b>
			</div>
			<input type="date" name="rs_date" id="rs_date"><br>
			<div>
				<b>판매량</b>
			</div>
			<input type="text" name="sales" class="sales"><br><br>
			<span style="float: right">
			<input type="submit" value="추가하기"
				style="background-color: black; color: #EFBDBC;">
			<button type="button"
				style="background-color: black; color: #EFBDBC;"
				onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
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

		$(function() {
			$('select[name="prod_type"] ').on(
					'change',
					function() {
						let arrType = getAgreeType();
						let optionType = $(this).parents('.box-body').find(
								$('select[name="prod_name"]'));
						optionType.empty();

						if ($(this).val() == '0') {
							for (prop in arrType['커피']) {
								optionType.append('<option value='+prop+' >'
										+ arrType['커피'][prop] + '</option>');
							}
						} else if ($(this).val() == '1') {
							for (prop in arrType['음료']) {
								optionType.append('<option value='+prop+' >'
										+ arrType['음료'][prop] + '</option>');
							}
						} else {
							for (prop in arrType['디저트']) {
								optionType.append('<option value='+prop+' >'
										+ arrType['디저트'][prop] + '</option>');
							}
						}
					});

			$('#prod_name').change(
					function() {
						if ($('#prod_name').val() == "아메리카노"
								|| $('#prod_name').val() == "카페라떼"
								|| $('#prod_name').val() == "콜드브루"
								|| $('#prod_name').val() == "아이스아메리카노"
								|| $('#prod_name').val() == "아이스카페라떼"
								|| $('#prod_name').val() == "에스프레소"
								|| $('#prod_name').val() == "마키야또"
								|| $('#prod_name').val() == "아인슈타인") {
							$('#prod_price').val(2000);
						} else if ($('#prod_name').val() == "사과주스"
								|| $('#prod_name').val() == "수박주스"
								|| $('#prod_name').val() == "바나나주스"
								|| $('#prod_name').val() == "매실주스"
								|| $('#prod_name').val() == "망고주스"
								|| $('#prod_name').val() == "토마토주스"
								|| $('#prod_name').val() == "치약초코"
								|| $('#prod_name').val() == "초콜렛"
								|| $('#prod_name').val() == "딸기주스"
								|| $('#prod_name').val() == "포도주스") {
							$('#prod_price').val(3000);
						} else if ($('#prod_name').val() == "카스테라"
								|| $('#prod_name').val() == "죽빵") {
							$('#prod_price').val(3500);
						} else if ($('#prod_name').val() == "쿠키"
								|| $('#prod_name').val() == "허니브레드"
								|| $('#prod_name').val() == "와플") {
							$('#prod_price').val(1500);
						} else {
							$('#prod_price').val(5000);
						}

					});
		});

		function getAgreeType() {
			var obj = {
				"커피" : {
					'100' : '선택해주세요',
					'아메리카노' : '아메리카노',
					'카페라떼' : '카페라떼',
					'콜드브루' : '콜드브루',
					'아이스아메리카노' : '아이스아메리카노',
					'아이스카페라떼' : '아이스카페라떼',
					'에스프레소' : '에스프레소',
					'마키야또' : '마키야또',
					'아인슈타인' : '아인슈타인'
				},
				"음료" : {
					'100' : '선택해주세요',
					'사과주스' : '사과주스',
					'수박주스' : '수박주스',
					'바나나주스' : '바나나주스',
					'매실주스' : '매실주스',
					'망고주스' : '망고주스',
					'토마토주스' : '토마토주스',
					'치약초코' : '치약초코',
					'초콜렛' : '초콜렛',
					'딸기주스' : '딸기주스',
					'포도주스' : '포도주스',
				},
				"디저트" : {
					'100' : '선택해주세요',
					'카스테라' : '카스테라',
					'죽빵' : '죽빵',
					'쿠키' : '쿠키',
					'허니브레드' : '허니브레드',
					'와플' : '와플',
					'초코케익' : '초코케익',
					'치약케익' : '치약케익'
				}

			}
			return obj;

		}
		
    	document.addEventListener('DOMContentLoaded', function() {
    	    document.querySelector('.form').addEventListener('submit', function(event) {
    	        var inputDate = new Date(document.querySelector('.rs_date').value);
    	        
    	        var today = new Date();
    	        
    	        if (inputDate > today) {
    	            alert("영업일은 오늘 날짜 이후로 선택할 수 없습니다.");
    	            event.preventDefault();
    	        }
    	    });
    	});
	</script>
</body>
</html>