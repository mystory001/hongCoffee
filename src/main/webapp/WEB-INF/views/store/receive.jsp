<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html lang="ko">
<!-- 목록 스타일 템플릿 -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<style>
/* 항목 스타일 */
.sidebar .nav:not(.sub-menu) > .nav-item.active{
   background: #EFBDBC !important;
}
.sidebar .nav .nav-item.active > .nav-link
{
    background: #EFBDBC !important;
}
.sidebar .nav.sub-menu {
    margin-bottom: 0;
    margin-top: 0;
    list-style: none;
    padding: 0.25rem 0 0 3.07rem;
    background: #EFBDBC !important;
    padding-bottom: 12px;
}

.sidebar .nav:not(.sub-menu) > .nav-item > .nav-link[aria-expanded="true"] {
    border-radius: 8px 8px 0 0;
  	background: #EFBDBC !important;
    color: #fff;
}


.sidebar-icon-only .sidebar .nav .nav-item .nav-link .menu-title{
  	background: #EFBDBC !important;
}

.sidebar .nav:not(.sub-menu) > .nav-item:hover > .nav-link, .sidebar .nav:not(.sub-menu) > .nav-item:hover[aria-expanded="true"]
{ 	background: #EFBDBC !important;
}
#settings-trigger{
  	background: #EFBDBC !important;
}

ul{
	list-style:none;
}

#search {
	height: 250px;
	padding-top: 35px;
	width: 100%;
	border: 1px solid black;
}

.search_name {
	width: 100px;
	text-align: left;
	font-size: 15px;
}

.search_div {
 	margin: 0 0 0 50px;
}

.choose {
	width: 300px;
	height: 29.63px;
	font-size: 15px;
}

#search li {
	width: 600px;
	height: 30px;
}

input[type=text]{
	width: 300px;
	margin-bottom: 10px;
	color: black !important;
}

input[type=date]{
	width: 300px;
	margin-bottom: 10px;
}

.button{
	margin-left: 10px;
}

/* 항목 스타일 끝 */
/* 목록 스타일 */
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color: #F0F0F0;}
/* 목록 스타일 끝 */


/* 라디오 스타일 */
 input[type=radio]{
  -webkit-appearance:none;
  -moz-appearance:none;
  appearance:none;
  outline:0;
  box-shadow:none;
  border:none;
}
label input[type=radio]:after{
  content:'';
  display: inline-block;
  width: 15px;
  height: 15px;
  margin-left: 3px;
  border:1px solid #8b8b8b;
  border-radius:100%;
  vertical-align:middle;
  cursor:pointer;
}
label input[type=radio]:checked:after{
  background: url('https://lostinyou4.github.io/leesm/study/images/radio_check.png') 0 0 no-repeat;
  background-size: contain;
  border:1px #fff;
}

/* 알림 */
/*토스트 메시지*/
#tost_message {
    opacity: 0;
    position: fixed;
	bottom: -100px; 
    left: 50%;
    transform: translate(-50%,0);
    padding: 10px 50px;
    background: rgba(0, 0, 0, 0.70);
    border-radius: 100px;
    color: #fff;
    box-shadow: 3px 4px 11px 0px #00000040;
    transition: all 0.5s;
}
/*토스트 메시지 활성화 되었을 때*/
#tost_message.active {
    opacity: 100%;
    bottom: 50px;
}

</style>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>홍커피</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendors/feather/feather.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- Plugin css for this page -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/js/select.dataTables.min.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/imgs/logo.png" />
</head>
<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->

		<!--     include top -->
		<jsp:include page="inc/top.jsp"/>
		
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_settings-panel.html -->
      <div class="theme-setting-wrapper">
        <div id="settings-trigger"><i class="ti-settings"></i></div>
        <div id="theme-settings" class="settings-panel">
          <i class="settings-close ti-close"></i>
          <p class="settings-heading">사이드바 색상</p>
          <div class="sidebar-bg-options selected" id="sidebar-light-theme"><div class="img-ss rounded-circle bg-light border mr-3"></div>Light</div>
          <div class="sidebar-bg-options" id="sidebar-dark-theme"><div class="img-ss rounded-circle bg-dark border mr-3"></div>Dark</div>
          <p class="settings-heading mt-2">헤더 색상</p>
          <div class="color-tiles mx-0 px-4">
            <div class="tiles success"></div>
            <div class="tiles warning"></div>
            <div class="tiles danger"></div>
            <div class="tiles info"></div>
            <div class="tiles dark"></div>
            <div class="tiles default"></div>
          </div>
        </div>
      </div>

            <!-- partiala -->
      <!-- partial:partials/_sidebar.html -->

      
      <!--     include left -->
		<jsp:include page="inc/left.jsp"/>
  
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
		<h2>입고 관리</h2><br>
		<div><h3 style="margin-top: 15px;">입고 검색</h3></div>
		
		<div id="tost_message"></div>
<!--     <button id="tost_btn" type="button">클릭하면 토스트 메시지가 나옵니다!</button> -->
  <script>
//1. 토스트 메시지, 버튼요소를 변수에 대입
  let tostMessage = document.getElementById('tost_message');
  let tostBtn = document.getElementById('tost_btn');

  let date = new Date();
  let d = date.getDate();
  if(d == 15){
	  tostMessage.innerText = '결제일 5일 전입니다';
  }
  if(d == 16){
	  tostMessage.innerText = '결제일 4일 전입니다';
  }
  if(d == 17){
	  tostMessage.innerText = '결제일 3일 전입니다';
  }
  if(d == 18){
	  tostMessage.innerText = '결제일 2일 전입니다';
  }
  if(d == 19){
	  tostMessage.innerText = '결제일 1일 전입니다';
  }
  if(d == 20){
	  tostMessage.innerText = '결제 당일 입니다';
  }
  if(d >= 15 && d <=20){
  	//2. 토스트 메시지 노출-사라짐 함수 작성
  	function tostOn(){
      	tostMessage.classList.add('active');
      	setTimeout(function(){
         	 tostMessage.classList.remove('active');
      	},2000);
  	}
  }
  //3. 토스트 버튼에 이벤트 연결
window.addEventListener('load',function(){
      console.log('이벤트가 잘 연결 됐는지 확인');
      tostOn()
  });
  </script>
		
		
		<form action="${pageContext.request.contextPath}/store/receiveSearch" class="receiveSearch" method="get">
			<div id="search">
				<ul>
					<li><div class="search_div"><label class="search_name"><b>재료명</b></label>
						<input type="text" name="item_name" class="item_name"></div></li>
						
					<li><div class="search_div"><label class="search_name"><b>단가</b></label>
						<input type="text" name="item_minPrice" class="item_minPrice" placeholder="최소 금액" style="width : 140.5px;"> ~
						<input type="text" name="item_maxPrice" class="item_maxPrice" placeholder="최대 금액" style="width : 140.5px;"></div></li>
						
					<li><div class="search_div"><label class="search_name"><b>입고일시</b></label>
						<input type="date" name="rc_minTime" class="rc_minTime"  max="9999-12-31" style="width: 140.5px;"> ~
						<input type="date" name="rc_maxTime" class="rc_maxTime"  max="9999-12-31" style="width: 140.5px;"></div></li>
						
					<li><div class="search_div"><label class="search_name"><b>결제여부</b></label>
						<select class="choose" name="pay">
							<option value="100">-----------------------------------------------</option>
							<option value="0">미결제</option>
							<option value="1">결제완료</option>
						</select>

						<span class="button"><button type="submit" style="background-color: black; color: #EFBDBC;">조회</button> <button type="reset" style="background-color: black; color: #EFBDBC;">초기화</button></span></div></li>

				</ul>	
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

		<hr>
   	
		<div style="width:50%; height:50px; float: left; vertical-align: bottom !important; "><h3 style="margin-top: 15px;">입고 목록</h3></div>
		<div style="width: 50%; height: 50px; float: left; text-align: right !important; padding-top: 15px;">
			<button style="background-color: black; color: #EFBDBC" onclick="receive_update()">수정</button>
		</div> 
		
<!-- 		목록 -->
		<div style="width:100%;  height:700px; border: black 1px solid; float: left; text-align: center;">
		<table class="table">
  			<tr style="background-color: transparent !important;">
    		<th style=" font-size:20px !important; color: black;">선택</th>
    		<th style=" font-size:20px !important; color: black;">재료명</th>
    		<th style=" font-size:20px !important; color: black;">입고량</th>
    		<th style=" font-size:20px !important; color: black;">단가</th>
    		<th style=" font-size:20px !important; color: black;">총금액</th>
    		<th style=" font-size:20px !important; color: black;">입고일시</th>
    		<th style=" font-size:20px !important; color: black;">결제여부</th>
 		 </tr>
 		 <c:forEach var="ReceiveDTO" items="${receiveList}">
  <tr onclick="window.open('${pageContext.request.contextPath}/store/detail/d_receive?od_num=${ReceiveDTO.od_num}','홍커피','width=1500,height=725,top=100, left=200,scrollbars=yes')">
<td style="text-align: center !important; font-size:20px !important;" onclick="event.cancelBubble=true"><label for="radio1-true"><input type="radio" name="radio1" id="radio1-true" value="${ReceiveDTO.od_num}"></label></td>
   	<td style="text-align: center !important; font-size:20px !important;">${ReceiveDTO.item_name}</td>
   	<td style="text-align: center !important; font-size:20px !important;">${ReceiveDTO.rc_amount}</td>

    <td style="text-align: center !important; font-size:20px !important;">
    <fmt:formatNumber value="${ReceiveDTO.item_price}" pattern="#,###"></fmt:formatNumber>
    </td>
   	<td style="text-align: center !important; font-size:20px !important;">
   	<fmt:formatNumber value="${ReceiveDTO.item_price * ReceiveDTO.rc_amount}" pattern="#,###"></fmt:formatNumber>
   	</td>
   	   	 <td style="text-align: center !important; font-size:20px !important;"><fmt:formatDate value="${ReceiveDTO.rc_time}" pattern="yyyy.MM.dd HH:mm:ss"/></td>
   	<c:if test="${ReceiveDTO.pay eq 0}">
      <td style="text-align: center !important; font-size:20px !important; color:red; ">미결제</td>
  	</c:if>
  	 <c:if test="${ReceiveDTO.pay eq 1}">
      <td style="text-align: center !important; font-size:20px !important; color:green; ">결제완료</td>
  	</c:if>
   	

 	</tr>
 	
 	
  		</c:forEach>
  
 		 </table>
 		 
 		 <div id="page_control">
		<c:if test="${pageDTO.startPage > pageDTO.pageBlock}">
			<a href="${pageContext.request.contextPath}/store/receive?pageNum=${pageDTO.startPage - pageDTO.pageBlock}">Prev</a>
		</c:if>
		
		<c:if test="${pageDTO.count ne -1}">
		<c:forEach var="i" begin="${pageDTO.startPage}" end="${pageDTO.endPage}" step="1">
			<a href="${pageContext.request.contextPath}/store/receive?pageNum=${i}">${i}</a>
		</c:forEach>
		</c:if>
		
		<c:if test="${pageDTO.count eq -1}">
		<c:forEach var="i" begin="${receiveDTO.startPage}" end="${receiveDTO.endPage}" step="1">
			<a href="${pageContext.request.contextPath}/store/receiveSearch?pageNum=${i}&item_name=${receiveDTO.item_name}&item_type=${receiveDTO.item_type}&item_minPrice=${receiveDTO.item_minPrice}
			&item_maxPrice=${receiveDTO.item_maxPrice}&rc_minTime=${receiveDTO.rc_minTime}&rc_maxTime=${receiveDTO.rc_maxTime}&pay=${receiveDTO.pay}">${i}</a>
		</c:forEach>
		</c:if>

		<c:if test="${pageDTO.endPage < pageDTO.pageCount}">
			<a href="${pageContext.request.contextPath}/store/receive?pageNum=${pageDTO.startPage + pageDTO.pageBlock}">Next</a>
		</c:if>

		</div>
 		 
 		 
 		 
 		 
		</div>
        
        
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        
        <!--     include bottom -->
		<jsp:include page="inc/bottom.jsp"/>

        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>   
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

  <!-- plugins:js -->
  <script src="${pageContext.request.contextPath}/resources/vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page -->
  <script src="${pageContext.request.contextPath}/resources/vendors/chart.js/Chart.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendors/datatables.net/jquery.dataTables.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/dataTables.select.min.js"></script>

  <!-- End plugin js for this page -->
  <!-- inject:js -->
  <script src="${pageContext.request.contextPath}/resources/js/off-canvas.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/hoverable-collapse.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/template.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/settings.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="${pageContext.request.contextPath}/resources/js/dashboard.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/Chart.roundedBarCharts.js"></script>
  <!-- End custom js for this page-->
  
  <!-- nav mouseover 고유색 -->
<%--   <script src="${pageContext.request.contextPath}/resources/js/navByJaeHwan.js"></script> --%>

<script>
$(function() {
	$.ajax({
    	url: "${pageContext.request.contextPath}/store/autoPay",
    	method: "GET",
    	success: function (result) {
        	console.log(result);
    	}
	});
});


// window.open('${pageContext.request.contextPath}/store/popup/stock_update?stock_num=1','홍커피','width=370,height=520')
function receive_update() {
	let rnum = $('input[name=radio1]:checked').val();
	if(rnum == null   || rnum == undefined){
		alert('수정하고자 하는 내용을 선택해주세요');
		return false;
	}
    window.open('${pageContext.request.contextPath}/store/popup/receive_update?od_num=' + rnum, '홍커피', 'width=450px,height=480px,top=100,left=200');
}

$('.receiveSearch').submit(function(){
	  var minPrice = $('.item_minPrice').val();
	  var maxPrice = $('.item_maxPrice').val();

	  if (minPrice !== '' && maxPrice !== '') {
	     if (parseFloat(minPrice) > parseFloat(maxPrice)) {
	        alert('최소 금액은 최대 금액보다 클 수 없습니다.');
	        return false; 
	        }
	    }
	    return true;
	});
	
	$('.receiveSearch').submit(function(){
	var priceCheck = RegExp(/^[0-9]*$/);
	if(!priceCheck.test($('.item_minPrice').val())){
		alert('단가는 숫자만 입력이 가능합니다.');
		$('.item_minPrice').focus();
		return false;
	}
	if(!priceCheck.test($('.item_maxPrice').val())){
		alert('단가는 숫자만 입력이 가능합니다.');
		$('.item_maxPrice').focus();
		return false;
	}
		
});
	
	document.addEventListener('DOMContentLoaded', function() {
	    document.querySelector('.receiveSearch').addEventListener('submit', function(event) {
	        var inputDate = new Date(document.querySelector('.rc_time').value);
	        
	        var today = new Date();
	        
	        if (inputDate > today) {
	            alert("입고일시는 오늘 날짜 이후로 선택할 수 없습니다.");
	            event.preventDefault();
	        }
	    });
	});
	
	
	

$(function(){
  $('.receiveSearch').submit(function(){
      if($('.rc_minTime').val() =="" && $('.rc_maxTime').val() =="" && $('.item_minPrice').val() == "" && $('.item_maxPrice').val() == "" && $('.item_name').val() == "" && $('.choose').val() == ""){
          alert('입고를 조회하기 위해서는 재료명, 최소 금액, 최대 금액, 입고 일시, 결제 여부 중 하나 이상 입력해야합니다.');
          return false;
      }
  });
});


</script>

</body>

</html>