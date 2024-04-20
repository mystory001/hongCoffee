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
	display: inline-block; width: 120px
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/emp/popup/store_updatePro" method="post" class="form">
<h2 style="margin-left: 10px">지점 수정</h2>
<sub>&nbsp;&nbsp;<span style="color: red">*</span>포함된 항목만 수정이 가능합니다.</sub>
<fieldset style="border:0px">
<div class="check"></div><br>
<div><b>지점번호</b></div><input type="text" name="num"  value="${storeDTO.num}" readonly><br>
<sub></sub>
<div><b>지점명</b></div><input type="text" name="name" value="${storeDTO.name}" readonly><br>
<sub></sub>
<div><b>비밀번호</b><span style="color: red">*</span></div><input type="password" name="pw" value="${storeDTO.pw}" class="pw"><br>
<sub>비밀번호를 변경을 원할 시 재작성해주세요.</sub><br>
<div><b>대표자명</b><span style="color: red">*</span></div><input type="text" name="boss" value="${storeDTO.boss}" class="boss"><br>
<sub></sub>
<div><b>연락처</b><span style="color: red">*</span></div><input type="tel" name="phone" value="${storeDTO.phone}" class="phone"><br>
<sub></sub>
<div><b>지점 전화번호</b><span style="color: red">*</span></div><input type="tel" name="tel" class="tel"><br>
<sub></sub>
<div><b>이메일</b><span style="color: red">*</span></div><input type="email" name="email" class="email"><br>
<sub></sub>
<div><b>우편번호</b></div><input type="text" id="sample4_postcode" value="${storeDTO.postalcode}" name="postalcode" readonly><br>
<sub></sub>
<div><b>도로명주소</b></div><input type="text" id="sample4_roadAddress" value="${storeDTO.address}" name="address" readonly><br>
<sub></sub>
<div><b>상세주소</b><span style="color: red">*</span></div><input type="text" id="sample4_detailAddress" value="${storeDTO.address_detail}" name="address_detail" ><br>
<sub></sub>
<div><b>상태</b><span style="color: red">*</span></div>
<select name="state" class="state" style="width: 177px">
<option value="1" <c:if test="${storeDTO.state eq '1'}"> selected </c:if>>정상영업</option>
<option value="2" <c:if test="${storeDTO.state eq '2'}"> selected </c:if>>미영업</option>
<option value="3" <c:if test="${storeDTO.state eq '3'}"> selected </c:if>>폐업</option>
</select><br>
<sub></sub>
<b>적요</b><span style="color: red">*</span><br><textarea rows="30" cols="35" name="note" style="height: 210px; width: 410px;">${storeDTO.note }</textarea><br>
<sub></sub>
<br>
<span style="float:right">
<input type="submit" value="수정하기" style="background-color: black; color: #EFBDBC;"> <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
$(function(){
	
})

$(function(){
	$('.form').submit(function(){
		
		//비밀번호 : 영문 대소문자 + 숫자 + 특수문자 1개 이상씩 4자 이상 20자 이하
		if($('.pw').val()=='' || $('.pw').val()==null||$('.pw').val()==undefined){
			alert('비밀번호를 입력해주세요.');
			$('.pw').focus();
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
			
		//연락처
		if($('.phone').val()=='' || $('.phone').val()==null||$('.phone').val()==undefined){
			alert('대표자명을 입력해주세요.');
			return false;
		}
		var phoneCheck = RegExp(/^[0-9\-]{9,13}$/);
		if( ! phoneCheck.test($('.phone').val()) ){
			alert("숫자만 입력가능합니다.");
			$('.phone').focus();
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