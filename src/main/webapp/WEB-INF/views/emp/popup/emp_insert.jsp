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
<form action="${pageContext.request.contextPath}/emp/popup/emp_insertPro" method="post" class="form">
<h2 style="margin-left: 10px">사원 추가</h2>
<fieldset style="border:0px">
<div id="dupnum" style="width: 300px"></div><br>
<div><b>사원번호</b></div><input type="text" name="emp_num" class="emp_num" onblur="empDup()"><br>
<div><b>비밀번호</b></div><input type="password" name="emp_pw" class="emp_pw"><br>
<sub></sub>
<div><b>사원명</b></div><input type="text" name="emp_name" class="emp_name"><br>
<sub></sub>
<div><b>생년월일</b></div><input type="date" name="emp_birth" class="emp_birth" style="width: 177px"><br>
<sub></sub>
<div><b>부서</b></div>
<select name="emp_dept" id="emp_dept"  >
<option value="100">선택해주세요.</option>
<option value="0">무소속</option>
<option value="1">인사팀</option>
<option value="2">영업팀</option>
<option value="3">재무팀</option>
</select><br>
<sub></sub>
<div><b>직급</b></div>
<select name="emp_rank" class="emp_rank">
<option value="100" >선택해주세요.</option>
<option value="0">무보직</option>
<option value="4">사원</option>
<option value="3">대리</option>
<option value="2">팀장</option>
<option value="1">대표</option>
</select><br>
<sub></sub>
<div><b>권한</b></div>
<select name="emp_right" class="emp_right">
<option value="100">선택해주세요.</option>
<option value="1">관리자</option>
<option value="0">사원</option>
</select><br>
<sub></sub>
<div><b>연락처</b></div><input type="text" name="emp_phone" class="emp_phone"><br>
<sub></sub>
<div><b>이메일</b></div><input type="email" name="emp_email" class="emp_email"><br>
<sub></sub>
<div><b>입사일</b></div><input type="date" name="hire_date" class="hire_date" style="width: 177px"><br>
<sub></sub>
<b>적요</b><br><textarea rows="30" cols="37" name="emp_note" style="height: 210px; width: 410px;"></textarea><br>
<sub></sub>
<br>
<span style="float:right">
<input type="submit" value="등록하기" style="background-color: black; color: #EFBDBC;">  <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
function empDup() {
    var empNum = document.querySelector('.emp_num').value; // 입력 필드의 값 가져오기

    $.ajax({
        type: 'GET',
        url: '${pageContext.request.contextPath}/emp/emp_numCheck',
        data: {
            emp_num: empNum
        },
        dataType: 'html',
        success: function(result) {
            if (result.trim() === 'emp_numDup') {
                $("#dupnum").text('사용할 수 없는 사원번호입니다.').css("color", "red");
            } else {
                $("#dupnum").text('사용할 수 있는 사원번호입니다.').css("color", "green");
            }
        },
        error: function(xhr, status, error) {
            console.error('에러 발생:', status, error);
            alert("에러");
        }
    });
}

	$(function() {
		$('.form').submit(
				function() {

					if ($('.emp_num').val() == ''
							|| $('.emp_num').val() == null
							|| $('.emp_num').val() == undefined) {
						alert('사원 번호를 입력해주세요.');
						$('.emp_num').focus();
						return false;
					}

					var numCheck = RegExp(/^[0-9]{2,10}$/);
					if (!numCheck.test($('.emp_num').val())) {
						alert("숫자로만 입력 가능합니다.");
						$('.emp_num').focus();
						return false;
					}

					if ($('.emp_pw').val() == '' || $('.emp_pw').val() == null
							|| $('.emp_pw').val() == undefined) {
						alert('비밀번호를 입력해주세요.');
						$('.emp_pw').focus();
						return false;
					}

					if ($('.emp_name').val() == ''
							|| $('.emp_name').val() == null
							|| $('.emp_name').val() == undefined) {
						alert('사원명을 입력해주세요.');
						$('.emp_name').focus();
						return false;
					}

					// 		var nameCheck = RegExp(/^[가-핳]{2,20}$/);
					// 		if( ! nameCheck.test($('.emp_name').val()) ){
					// 				alert("한글 2자이상 20자이하만 입력 가능합니다.");
					// 				$('.emp_name').focus();
					// 				return false;
					// 		}

					if ($('.emp_phone').val() == ''
							|| $('.emp_phone').val() == null
							|| $('.emp_phone').val() == undefined) {
						alert('연락처를 입력해주세요.');
						$('.emp_phone').focus();
						return false;
					}
					// 		var phoneCheck = RegExp(/^[0-9\-]{11,14}$/);
					// 		if( ! nameCheck.test($('.emp_num').val()) ){
					// 				alert("숫자와 -만 입력 가능합니다.");
					// 				$('.emp_num').focus();
					// 				return false;
					// 		}

					if ($('.emp_birth').val() == ''
							|| $('.emp_birth').val() == null
							|| $('.emp_birth').val() == undefined) {
						alert('생년월일를 선택해주세요.');
						$('.emp_birth').focus();
						return false;
					}

					if ($('.emp_state').val() == "100") {
						alert('상태를 선택해주세요.');
						$('.emp_state').focus();
						return false;
					}

					if ($('.emp_rank').val() == "100") {
						alert('직급을 선택해주세요.');
						$('.emp_rank').focus();
						return false;
					}

					if ($('.emp_right').val() == "100") {
						alert('권한을 선택해주세요.');
						$('.emp_state').focus();
						return false;
					}

					if ($('.hire_date').val() == ''
							|| $('.hire_date').val() == null
							|| $('.hire_date').val() == undefined) {
						alert('입사일을 선택해주세요.');
						$('.hire_date').focus();
						return false;
					}

				});

	});

	$(".emp_phone").on('keydown keyup', function() {
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