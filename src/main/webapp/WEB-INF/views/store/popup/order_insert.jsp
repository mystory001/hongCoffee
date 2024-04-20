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
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/store/popup/order_insertPro"
		method="post" class="form">
		<h2 style="margin-left: 10px">발주 추가</h2>
		<sub>반드시 유형을 먼저 선택해주셔야합니다.</sub>
		<fieldset style="border: 0px">
			<input type="hidden" name="num" value="${sessionScope.num}">
			<div class="check"></div><br>
			<div class="box-body">
				<table>
					<tr>
						<td>
							<div>
								<b>유형</b>
							</div>
						</td>
						<td>
							<div class="input-group">
								<select class="form-control" style="width: 177px"
									name="item_type" class="item_type">
									<option value="100">선택해주세요</option>
									<option value="0">식품</option>
									<option value="1">비식품</option>
								</select>
							</div>
						</td>
						<td><sub></sub></td>
					<tr>
						<td>
							<div>
								<b>재료명</b>
							</div>
						</td>
						<td>
							<div class="input-group">
								<select class="form-control" name="item_name" id="item_name">
									<option value="100">선택해주세요</option>
								</select>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<b>단가</b>
			</div>
			<input type="text" name="item_price" id="item_price" readonly><br>
			<div>
				<b>발주량</b>
			</div>
			<input type="text" name="od_amount" class="od_amount"><br>
			<div>
				<b>적요</b>
			</div>
			<br>
			<textarea name="od_note" rows="30" cols="37"
				style="height: 210px; width: 410px;"></textarea>
			<br> <sub></sub> <span style="float: right"> <input
				type="submit" value="추가하기"
				style="background-color: black; color: #EFBDBC;">
				<button type="button"
					style="background-color: black; color: #EFBDBC;"
					onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button></span>
		</fieldset>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>

	<script type="text/javascript">
		$(function() {
			$('.form').submit(
					function() {

						if ($('.od_amount').val() == ""
								|| $('.od_amount').val() == null
								|| $('.od_amount').val() == undefined) {
							alert("보유량을 입력해주세요");
							$('.od_amount').focus();
							return false;
						}
					});
		});


$(function() {
    $('select[name="item_type"]').on('change', function() {
        let arrType = getAgreeType();
        let optionType = $(this).parents('.box-body').find('select[name="item_name"]');
        optionType.empty();

        if ($(this).val() == '0') {
            for (let prop in arrType['식품']) {
                optionType.append('<option value="' + prop + '">' + arrType['식품'][prop] + '</option>');
            }
        } else {
            for (let prop in arrType['비식품']) {
                optionType.append('<option value="' + prop + '">' + arrType['비식품'][prop] + '</option>');
            }
        }
    });

    $('select[name="item_name"]').change(function() {
        let itemName = $(this).val();
        let itemPrice = $('#item_price');

        switch (itemName) {
            case "에티오피아 250g":
            case "콜롬비아 250g":
            case "우유 2L":
                itemPrice.val(3500);
                break;
            case "바닐라 시럽 500g":
            case "초코 시럽 500g":
            case "딸기 시럽 500g":
            case "생크림 500ml":
            case "카라멜 500ml":
            case "딸기잼 500g":
            case "초콜릿 500g":
            case "망고 500g":
            case "자몽 500g":
                itemPrice.val(4000);
                break;
            case "유자 500g":
            case "오렌지 500g":
            case "타피오카펄 500g":
                itemPrice.val(5000);
                break;
            case "레몬 500g":
            case "사과 500g":
                itemPrice.val(7000);
                break;
            case "딸기 500g":
            case "녹차 300g":
            case "카모마일 300g":
            case "자스민 300g":
            case "라벤더 300g":
            case "얼그레이 300g":
                itemPrice.val(10000);
                break;
            case "꿀 500g":
                itemPrice.val(12000);
                break;
            default:
                itemPrice.val(10);
                break;
        }
    });
});

function getAgreeType() {
    let obj = {
        "식품": {
            '100': '선택해주세요',
            '에티오피아 250g': '에티오피아 250g',
            '콜롬비아 250g': '콜롬비아 250g',
            '바닐라 시럽 500g': '바닐라 시럽 500g',
            '초코 시럽 500g': '초코 시럽 500g',
            '딸기 시럽 500g': '딸기 시럽 500g',
            '생크림 500ml': '생크림 500ml',
            '카라멜 500ml': '카라멜 500ml',
            '토피넛 500g': '토피넛 500g',
            '딸기잼 500g': '딸기잼 500g',
            '초콜릿 500g': '초콜릿 500g',
            '딸기 500g': '딸기 500g',
            '레몬 500g': '레몬 500g',
            '망고 500g': '망고 500g',
            '자몽 500g': '자몽 500g',
            '유자 500g': '유자 500g',
            '사과 500g': '사과 500g',
            '오렌지 500g': '오렌지 500g',
            '탄산수 1L': '탄산수 1L',
            '우유 2L': '우유 2L',
            '꿀 500g': '꿀 500g',
            '타피오카펄 500g': '타피오카펄 500g',
            '녹차 300g': '녹차 300g',
            '카모마일 300g': '카모마일 300g',
            '자스민 300g': '자스민 300g',
            '라벤더 300g': '라벤더 300g',
            '얼그레이 300g': '얼그레이 300g',
        },
        "비식품": {
            '100': '선택해주세요',
            '유리컵M': '유리컵M',
            '유리컵L': '유리컵L',
            '종이컵M': '종이컵M',
            '종이컵L': '종이컵L',
            '플라스틱컵M': '플라스틱컵M',
            '플라스틱컵L': '플라스틱컵L',
            '컵홀더': '컵홀더',
            '스트로우M': '스트로우M',
            '스트로우L': '스트로우L',
            '버블티스트로우': '버블티스트로우',
            '2컵캐리어': '2컵캐리어',
            '4컵캐리어': '4컵캐리어',
        }
    };
    return obj;
}







	</script>
</body>
</html>