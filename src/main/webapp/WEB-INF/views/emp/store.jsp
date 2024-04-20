<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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
	padding-top: 10px;
	width: 100%;
	border: 1px solid black;
}

input[type=text] {
	color: black !important; 
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
                 <p class="settings-heading">사이드바 색상 및 바로가기</p>
          <div class="sidebar-bg-options selected" id="sidebar-light-theme"><div class="img-ss rounded-circle bg-light border mr-3"></div>light</div>
          <div class="sidebar-bg-options" id="sidebar-dark-theme"><div class="img-ss rounded-circle bg-dark border mr-3"></div>dark</div>
          <p class="settings-heading mt-2">헤더 색상</p>
          <div class="color-tiles mx-0 px-4">
            <div class="tiles success"></div>
            <div class="tiles warning"></div>
            <div class="tiles danger"></div>
            <div class="tiles info"></div>
            <div class="tiles dark"></div>
            <div class="tiles default"></div>
          </div>
          <button style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/store/login'">지점 페이지</button>

        </div>
      </div>

      <!-- partial -->
      <!-- partial:partials/_sidebar.html -->

      
		<!--     include left -->
		<jsp:include page="inc/left.jsp"/>
		

      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
        	<h2>지점 관리</h2><br>
		<div><h3 style="margin-top: 15px;">지점 검색</h3></div>
		<form action="${pageContext.request.contextPath}/emp/storeSearch" class="storeSearch" method="get">

			<div id="search">
				<ul>
					<li><div class="search_div"><label class="search_name"><b>지점명</b></label>
						<input type="text" name="name" class="storeName"></div></li>
					
					<li><div class="search_div"><label class="search_name"><b>대표자명</b></label>
						<input type="text" name="boss" class="boss"></div></li>	
				
					<li><div class="search_div"><label class="search_name"><b>주소</b></label>
						<input type="text" name="address" class="address"></div></li>	
						
					<li><div class="search_div"><label class="search_name"><b>연락처</b></label>
						<input type="text" name="phone" class="phone"></div>
				
					<li><div class="search_div"><label class="search_name"><b>상태</b></label>
						<select name="state" class="choose">
							<option value="100">-----------------------------------------------</option>
							<option value="1">정상영업</option>
							<option value="2">미영업</option>
							<option value="3">폐업</option></select>

					<span class="button"><button type="submit" style="background-color: black; color: #EFBDBC;">조회</button> <button type="reset" style="background-color: black; color: #EFBDBC;">초기화</button></span></div></li>
				</ul>	

			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

		<hr>
		<div style="width:50%; height:50px; float: left; vertical-align: bottom !important; "><h3 style="margin-top: 15px;">지점 목록</h3></div>
		<div style="width:50%; height:50px; float: left; text-align: right !important; padding-top: 15px;" >
		<input type="button" value="추가" name="store_insert" style="background-color: black; color: #EFBDBC;" onclick="window.open('${pageContext.request.contextPath}/emp/popup/store_insert','홍커피','width=460px,height=640px,top=100,left=200')"> 
		<input type="button" value="수정" name="store_update" style="background-color: black; color: #EFBDBC;" onclick="store_update()"></div>
		
<!-- 		목록 -->
		<div style="width:100%;  height:700px; border: black 1px solid; float: left; text-align: center;">
		<table class="table">
  			<tr style="background-color: transparent !important;">
    		<th style=" font-size:20px !important; color: black;">선택</th>
    		<th style=" font-size:20px !important; color: black;">지점번호</th>
    		<th style=" font-size:20px !important; color: black;">지점명</th>
    		<th style=" font-size:20px !important; color: black;">대표자명</th>
    		<th style=" font-size:20px !important; color: black;">연락처</th>
    		<th style=" font-size:20px !important; color: black;">이메일</th>
    		<th style=" font-size:20px !important; color: black;">주소</th>
    		<th style=" font-size:20px !important; color: black;">상태</th>
 		 </tr>
 		 <c:forEach var="StoreDTO" items="${storeList}">

  <tr onclick="window.open('${pageContext.request.contextPath}/emp/detail/d_store?num=${StoreDTO.num}','홍커피','width=1500,height=725,top=100, left=200,scrollbars=yes')">
    <td style="text-align: center !important; font-size:20px !important;" onclick="event.cancelBubble=true"><label for="radio1-true"><input type="radio" name="radio1" id="radio1-true" value="${StoreDTO.num}"></label></td>
	<td style="text-align: center !important; font-size:20px !important;">${StoreDTO.num}</td>
   	<td style="text-align: center !important; font-size:20px !important;">${StoreDTO.name}</td>
   	<td style="text-align: center !important; font-size:20px !important;">${StoreDTO.boss}</td>
    <td style="text-align: center !important; font-size:20px !important;">${StoreDTO.phone}</td>
   	<td style="text-align: center !important; font-size:20px !important;">${StoreDTO.email}</td>
   	<td style="text-align: center !important; font-size:20px !important;">${StoreDTO.address}</td>
   	<c:if test="${StoreDTO.state eq 1}">
      <td style="text-align: center !important; font-size:20px !important; color:green; ">정상영업</td>
  	</c:if>
  	  	<c:if test="${StoreDTO.state eq 2}">
      <td style="text-align: center !important; font-size:20px !important; color:orange; ">미영업</td>
  		</c:if>
  	  	<c:if test="${StoreDTO.state eq 3}">
      <td style="text-align: center !important; font-size:20px !important; color:red; ">폐업</td>
  	</c:if>
  </tr>
  		</c:forEach>
 		 </table>
 		 
 		 
 		 <div id="page_control">
		<c:if test="${pageDTO.startPage > pageDTO.pageBlock}">
			<a href="${pageContext.request.contextPath}/emp/store?pageNum=${pageDTO.startPage - pageDTO.pageBlock}">Prev</a>
		</c:if>
		
		<c:if test="${pageDTO.count ne -1}">
		<c:forEach var="i" begin="${pageDTO.startPage}" end="${pageDTO.endPage}" step="1">
			<a href="${pageContext.request.contextPath}/emp/store?pageNum=${i}">${i}</a>
		</c:forEach>
		</c:if>
		
		<c:if test="${pageDTO.count eq -1}">
		<c:forEach var="i" begin="${storeDTO.startPage}" end="${storeDTO.endPage}" step="1">
			<a href="${pageContext.request.contextPath}/emp/storeSearch?pageNum=${i}&name=${storeDTO.name}&boss=${storeDTO.boss}&address=${storeDTO.address}&phone=${storeDTO.phone}&state=${storeDTO.state}">${i}</a>
		</c:forEach>
		</c:if>

		<c:if test="${pageDTO.endPage < pageDTO.pageCount}">
			<a href="${pageContext.request.contextPath}/emp/store?pageNum=${pageDTO.startPage + pageDTO.pageBlock}">Next</a>
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

<script type="text/javascript">

function store_update() {
	let snum = $('input[name=radio1]:checked').val();
	if(snum == null   || snum == undefined){
		alert('수정하고자 하는 목록을 선택해주세요');
		return false;
	}
    window.open('${pageContext.request.contextPath}/emp/popup/store_update?num=' + snum, '홍커피', 'width=460px,height=700px,top=100,left=200');
}

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

$(function(){
    $('.storeSearch').submit(function(){
        if($('.choose').val()=="100" && $('.storeName').val() =="" && $('.boss').val() == "" && $('.address').val() == "" && $('.phone').val() ==""){
            alert('지점을 조회하기 위해서는 지점명, 대표자명, 주소, 연락처, 상태 중 하나 이상 입력해야합니다.');
            return false;
        }
    }); 
});
</script>


</body>

</html>

