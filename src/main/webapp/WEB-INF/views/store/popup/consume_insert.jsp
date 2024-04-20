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
        action="${pageContext.request.contextPath}/store/popup/consume_insertPro"
        method="post" class="form">
        <input type="hidden" name="num" value="${sessionScope.num}">
        <h2 style="margin-left: 10px">소모 추가</h2>
        <sub>반드시 유형을 먼저 선택해주셔야합니다.</sub>
        <fieldset style="border: 0px">
            <div class="check"></div>
            <br>
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
                <b>영업일</b>
            </div>
            <input type="date" name="rs_date" class="rs_date"><br>
            <div>
                <b>소모량</b>
            </div>
            <input type="text" name="consume" id="consume"><br>
            <br> 
            <span style="float: right">
            <input
                type="submit" value="추가하기"
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
        $('.form').submit(function() {
            if ($('.rs_date').val() == "" || $('.rs_date').val() == null || $('.rs_date').val() == undefined) {
                alert("영업일을 선택해주세요");
                $('.rs_date').focus();
                return false;
            }

            if ($('#consume').val() == "" || $('#consume').val() == null || $('#consume').val() == undefined) {
                alert("소모량을 입력해주세요");
                $('#consume').focus();
                return false;
            }

//             $.ajax({
//                 type: "get",
//                 url: "${pageContext.request.contextPath}/store/check",
//                 data: {
//                     item_name: $('#item_name').val() 
//                 },
//                 success: function(result) {
//                 	var itemName = [];
//                 	var amount = [];
//                 	var nam = $('#item_name').val();
//                 	var con = $('#consume').val();
//                     for (var i in result) {
//                         itemName.push(result[i].item_name);
//                         amount.push(result[i].amount);
//                     }
//                     if (itemName.includes(nam) == false || con > amount[itemName.index(nam)]) {
//                         alert("재고가 부족하거나 선택된 재료가 없습니다.");
//                     }
                    
//                 },
//                 error: function() {
//                     alert("재고 조회 중 오류가 발생했습니다");
//                     return false;
//                 }
//             });
//             event.preventDefault();
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
                	'우유 2L' : '우유 2L',
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