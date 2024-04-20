<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html lang="ko">
<!-- 목록 스타일 템플릿 -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
	height: 20px;
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
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
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

            <!-- partial -->
      <!-- partial:partials/_sidebar.html -->
    
         
      <!--     include left -->
		<jsp:include page="inc/left.jsp"/>
		
	
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
		<h2>발주 관리</h2><br>
		<div><h3 style="margin-top: 15px;">발주 검색</h3></div>
		

		<form action="${pageContext.request.contextPath}/store/orderSearch"  class="orderSearch"  method="get">

			<div id="search">
				<ul>
					<li><div class="search_div"><label class="search_name"><b>재료명</b></label>
						<input type="text" name="item_name" class="item_name"></div></li>
						
					<li><div class="search_div"><label class="search_name"><b>단가</b></label>
						<input type="text" name="item_minPrice" class="item_minPrice" placeholder="최소 금액" style="width : 140.5px;"> ~
						<input type="text" name="item_maxPrice" class="item_maxPrice" placeholder="최대 금액" style="width : 140.5px;"></div></li>
						
					<li><div class="search_div"><label class="search_name"><b>발주일시</b></label>
						<input type="date" name="od_minTime"  class="od_minTime"  max="9999-12-31" style="width : 140.5px;"> ~
						<input type="date" name="od_maxTime"  class="od_maxTime" max="9999-12-31" style="width : 140.5px;"></div></li>
						
					<li><div class="search_div"><label class="search_name"><b>입고여부</b></label>
						<select class="choose" name="received_not">
							<option value="100">-----------------------------------------------</option>
							<option value="0">미입고</option>
							<option value="1">입고완료</option>
						</select>

					<span class="button"><button type="submit" style="background-color: black; color: #EFBDBC;">조회</button> <button type="reset" style="background-color: black; color: #EFBDBC;">초기화</button></span></div></li>

				</ul>	
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

		<hr>
   	
		<div style="width:50%; height:50px; float: left; vertical-align: bottom !important; "><h3 style="margin-top: 15px;">발주 목록</h3></div>
		<div style="width:50%; height:50px; float: left; text-align: right !important; padding-top: 15px;" >
		<button style="background-color: black; color: #EFBDBC" onclick="receive_insert()">입고 추가</button>
		<button style="background-color: black; color: #EFBDBC" onclick="window.open('${pageContext.request.contextPath}/store/popup/order_insert','홍커피','width=450px,height=550px,top=100,left=200')">발주 추가</button>
		<button style="background-color: black; color: #EFBDBC" onclick="order_update()">발주 수정</button>
		<button style="background-color: black; color: #EFBDBC" onclick="order_delete()">발주 삭제</button></div>
		
<!-- 		목록 -->
		<div style="width:100%;  height:700px; border: black 1px solid; float: left; text-align: center;">
		<table class="table">
  			<tr style="background-color: transparent !important;">
    		<th style=" font-size:20px !important; color: black;">선택</th>
    	
    		<th style=" font-size:20px !important; color: black;">재료명</th>
    		<th style=" font-size:20px !important; color: black;">발주량</th>
    		<th style=" font-size:20px !important; color: black;">단가</th>
    		<th style=" font-size:20px !important; color: black;">총금액</th>
    		<th style=" font-size:20px !important; color: black;">발주일시</th>
    		<th style=" font-size:20px !important; color: black;">출하여부</th>
    		<th style=" font-size:20px !important; color: black;">입고여부</th>
 		 </tr>
 		 <c:forEach var="OrderDTO" items="${orderList}">
  <tr onclick="window.open('${pageContext.request.contextPath}/store/detail/d_order?od_num=${OrderDTO.od_num}','홍커피','width=1500,height=725,top=100, left=200,scrollbars=yes')">
  <td style="text-align: center !important; font-size:20px !important;" onclick="event.cancelBubble=true"><label for="radio1-true"><input type="radio" name="radio1" id="radio1-true" value="${OrderDTO.od_num }"></label></td>

   	<td style="text-align: center !important; font-size:20px !important;">${OrderDTO.item_name}</td>

   	<td style="text-align: center !important; font-size:20px !important;">${OrderDTO.od_amount}</td>
    <td style="text-align: center !important; font-size:20px !important;">
    <fmt:formatNumber value="${OrderDTO.item_price}" pattern="#,###"></fmt:formatNumber>
    </td>
   	<td style="text-align: center !important; font-size:20px !important;">
   	<fmt:formatNumber value="${OrderDTO.item_price * OrderDTO.od_amount}" pattern="#,###"></fmt:formatNumber>
   	</td>
   	 <td style="text-align: center !important; font-size:20px !important;">${OrderDTO.od_time}</td>
	
	<c:if test="${OrderDTO.shipment_not eq 0}">
      <td style="text-align: center !important; font-size:20px !important; color:red; ">미출하</td>
  	</c:if>
  	<c:if test="${OrderDTO.shipment_not eq 1}">
      <td style="text-align: center !important; font-size:20px !important; color:green; ">출하완료</td>
  	</c:if>

	
	
	<c:if test="${OrderDTO.received_not eq 0}">
      <td style="text-align: center !important; font-size:20px !important; color:red; ">미입고</td>
  	</c:if>
  	<c:if test="${OrderDTO.received_not eq 1}">
      <td style="text-align: center !important; font-size:20px !important; color:green; ">입고완료</td>
  	</c:if>

  </tr>
  		</c:forEach>
  
 		 </table>
 		 
 		   <div id="page_control">
		<c:if test="${pageDTO.startPage > pageDTO.pageBlock}">
			<a href="${pageContext.request.contextPath}/store/order?pageNum=${pageDTO.startPage - pageDTO.pageBlock}">Prev</a>
		</c:if>
		
		<c:if test="${pageDTO.count ne -1}">
		<c:forEach var="i" begin="${pageDTO.startPage}" end="${pageDTO.endPage}" step="1">
			<a href="${pageContext.request.contextPath}/store/order?pageNum=${i}">${i}</a>
		</c:forEach>
		</c:if>
		
		<c:if test="${pageDTO.count eq -1}">
		<c:forEach var="i" begin="${orderDTO.startPage}" end="${orderDTO.endPage}" step="1">
			<a href="${pageContext.request.contextPath}/store/orderSearch?pageNum=${i}
			&item_name=${orderDTO.item_name}&item_minPrice=${orderDTO.item_minPrice}&item_maxPrice=${orderDTO.item_maxPrice}
			&od_minTime=${orderDTO.od_minTime}&od_maxTime=${orderDTO.od_maxTime}&received_not=${orderDTO.received_not}">${i}</a>
		</c:forEach>
		</c:if>

		<c:if test="${pageDTO.endPage < pageDTO.pageCount}">
			<a href="${pageContext.request.contextPath}/store/order?pageNum=${pageDTO.startPage + pageDTO.pageBlock}">Next</a>
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
// window.open('${pageContext.request.contextPath}/store/popup/stock_update?stock_num=1','홍커피','width=370,height=520')
// function receive_insert() {
// 	let rnum = $('input[name=radio1]:checked').val();
// 	if(rnum == null   || rnum == undefined){
// 		alert('입고 추가 하려는 내용을 선택해주세요');
// 		return false;
// 	}
//     window.open('${pageContext.request.contextPath}/store/popup/receive_insert?od_num=' + rnum, '홍커피', 'width=450px,height=490px,top=100,left=200');
// }
function receive_insert() {
    // 선택된 발주 번호 가져오기
    let selectedOrderNum = $('input[name=radio1]:checked').val();
    
    if (selectedOrderNum == null || selectedOrderNum == undefined) {
        alert('입고 추가할 발주를 선택해주세요.');
        return false;
    }

    // 선택된 발주의 출하 여부와 입고 여부 확인
    let shipmentStatus = $('input[name=radio1]:checked').closest('tr').find('td:eq(6)').text().trim();
    let receivedStatus = $('input[name=radio1]:checked').closest('tr').find('td:eq(7)').text().trim();

    if (shipmentStatus === '미출하') {
        alert('아직 출하되지 않은 발주입니다.');
        return false;
    }

    if (receivedStatus === '입고완료') {
        alert('이미 입고된 발주입니다.');
        return false;
    }

    // 입고 추가 팝업 창 열기
    window.open('${pageContext.request.contextPath}/store/popup/receive_insert?od_num=' + selectedOrderNum, '홍커피', 'width=450px,height=490px,top=100,left=200');
}

function order_update() {
	let onum = $('input[name=radio1]:checked').val();
	if(onum == null   || onum == undefined){
		alert('발주 수정 하려는 내용을 선택해주세요');
		return false;
	}
    window.open('${pageContext.request.contextPath}/store/popup/order_update?od_num=' + onum, '홍커피', 'width=450px,height=490px,top=100,left=200');
}
function order_delete() {
	let onum = $('input[name=radio1]:checked').val();
	if(onum == null   || onum == undefined){
		alert('발주 삭제 하려는 내용을 선택해주세요');
		return false;
	}
    location.href='${pageContext.request.contextPath}/store/popup/order_delete?od_num='+onum
}

$('.orderSearch').submit(function(){
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
	
	$('.orderSearch').submit(function(){
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
	
$(function(){
    $('.orderSearch').submit(function(){
        if($('.choose').val()=="100" && $('.od_minTime').val() =="" && $('.od_maxTime').val() =="" && $('.item_minPrice').val() == "" && $('.item_maxPrice').val() == "" && $('.item_name').val() == ""){
            alert('발주를 조회하기 위해서는 재료명, 발주일시 범위, 최소 금액, 최대 금액, 입고 여부 중 하나 이상 입력해야합니다.');
            return false;
        }
    });
});

document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('.orderSearch').addEventListener('submit', function(event) {
        var inputDate = new Date(document.querySelector('.od_minTime').value);
        var inputDate2 = new Date(document.querySelector('.maxTime').value);
        
        var today = new Date();
        
        if (inputDate > today || inputDate2 > today) {
            alert("발주일시는 오늘 날짜 이후로 선택할 수 없습니다.");
            event.preventDefault();
        }
        
        if(inputDate > inputDate2 ){
        	alert("발주일시는 이전 날짜가 왼쪽에 와야합니다.");
            event.preventDefault();
        }
        
    });
});

</script>
</body>
</html>
