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
	display: inline-block; width: 120px
}
select{
	width: 177px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/emp/popup/store_insertPro" method="post" class="form">
<h2 style="margin-left: 10px">지점 추가</h2>
<sub>&nbsp;&nbsp;<span style="color: red">*</span>포함된 항목은 필수항목입니다.</sub>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<div><b>지점명</b><span style="color: red">*</span></div><input type="text" name="name" class="name"><br>
<sub></sub>
<div><b>비밀번호</b><span style="color: red">*</span></div><input type="password" name="pw" class="pw"><br>
<sub></sub>
<div><b>대표자명</b><span style="color: red">*</span></div><input type="text" name="boss" class="boss"><br>
<sub></sub>
<div><b>연락처</b><span style="color: red">*</span></div><input type="tel" name="phone" class="phone"><br>
<sub></sub>
<div><b>이메일</b></div><input type="email" name="email" class="email"><br>
<sub></sub>																																
<div><b>우편번호</b><span style="color: red">*</span></div><input type="text" id="sample4_postcode" placeholder="우편번호" name="postalcode"> <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" style="float:right; ;background-color: black; color: #EFBDBC;"><br>
<sub></sub>
<div><b>도로명주소</b><span style="color: red">*</span></div><input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address"><br>
<sub></sub>
<div><b>상세주소</b></div><input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address_detail"><br>
<sub></sub>
<div><b>상태</b><span style="color: red">*</span></div>
<select name="state" class="state">
<option value="100">상태를 선택해주세요</option>
<option value="1">정상영업</option>
<option value="2">미영업</option>
<option value="3">폐업</option>
</select><br>
<sub></sub>
<b>적요</b><br><textarea rows="30" cols="35" name="note" style="height: 210px; width: 410px;"></textarea><br>
<sub></sub>
<br>
<span style="float:right">
<input type="submit" value="추가하기" style="background-color: black; color: #EFBDBC;"> <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<!-- 주소 찾기 API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
var isPopupOpened = false; 

function sample4_execDaumPostcode() {
	
    if (isPopupOpened) {
        return;
    }
	
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }

        }).open();
        
        isPopupOpened = true;
    }
    
    //===========================================================
    	
    	$(function(){
	$('.form').submit(function(){

		//지점명 : 한글 2자 이상 20자 이하
		if($('.name').val()=='' || $('.name').val()==null||$('.name').val()==undefined){
			alert('지점명을 입력해주세요.');
			return false;
		}
		var nameCheck = RegExp(/^[가-핳]{2,20}$/);
		if( ! nameCheck.test($('.name').val()) ){
				alert("한글 2자이상 20자이하만 입력 가능합니다.");
				$('.name').focus();
				return false;
		}
		
		if($('.pw').val()=='' || $('.pw').val()==null||$('.pw').val()==undefined){
			alert('비밀번호를 입력해주세요.');
			return false;
		}
					
		//이름 : 한글 2~20자
		if($('.boss').val()=='' || $('.boss').val()==null||$('.boss').val()==undefined){
			alert('대표자명을 입력해주세요.');
			return false;
		}
		var bossCheck = RegExp(/^[가-힣]{2,6}$/);
			if( ! bossCheck.test($('.boss').val()) ){
				alert("한글 2자 이상 6자 이하만 입력가능합니다.");
				$('.boss').focus();
				return false;
		}		
		
		//select 상자
		if($('.state').val() == "100"){
				alert("상태를 선택하세요.");
				$('.state').focus();
				return false;
			}

		
	});
	
});
	
	$(".phone").on('keydown keyup',function() {
        this.value = this.value.replace(/[^0-9]/g, '');

        var str = this.value;
        var tmp = '';
        var bullet = '-';

        if (str.length > 3 && str.length < 8) {
            tmp += str.substr(0, 3);
            tmp += bullet;
            tmp += str.substr(3);
            this.value = tmp;
        } else if (str.length == 8) {
            tmp += str.substr(0, 4);
            tmp += bullet;
            tmp += str.substr(4);
            this.value = tmp;
        } else if (str.length == 10) {
            tmp += str.substr(0, 2);
            tmp += bullet;
            tmp += str.substr(2, 4);
            tmp += bullet;
            tmp += str.substr(6); // 10자리일때
            this.value = tmp;
        } else if (str.length > 8) {
            tmp += str.substr(0, 3);
            tmp += bullet;
            tmp += str.substr(3, 4);
            tmp += bullet;
            tmp += str.substr(7, 4);
            this.value = tmp;
        } else {
            this.value = str;
        }
    });
</script>

</body>
</html>