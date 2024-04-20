<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	font-weight: bold;
}

.search_div {
 	margin: 0 0 0 50px;
}

.choose, .choose2{
	width: 300px;
	height: 29.63px;
	font-size: 15px;
}

#search li {
	width: 600px;

	height: 30px;



}
input[type=text] {

    color: black !important;
}
input[type=text]{
	width: 300px;
	margin-bottom: 10px;
}

.button{
	margin-left: 10px;
}
input[type=text] {

    color: black !important;
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
/* 목록 스타일 끝 */
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

<body onload="cola()">
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
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
        <ul class="logo-nav">
			<img src="${pageContext.request.contextPath}/resources/imgs/logo.png" style="max-width: 100%; height: auto;"/>
		</ul>
          <li class="nav-item" id="pjh1">
            <a class="nav-link" href="${pageContext.request.contextPath}/emp/main">
              <i class="icon-grid menu-icon"></i>
              <span class="menu-title">대시 보드</span>
            </a>
          </li>
          <li class="nav-item" id="pjh2">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <i class="icon-layout menu-icon"></i>
              <span class="menu-title">기준 정보 관리</span>
              <i class="menu-arrow"></i>
            </a>
          <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/emp/store">지점 관리</a></li>
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/emp/item">재료 관리</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item" id="pjh3">
            <a class="nav-link" data-toggle="collapse" href="#form-elements" aria-expanded="false" aria-controls="form-elements">
              <i class="icon-columns menu-icon"></i>
              <span class="menu-title">영업 관리</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="form-elements">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/emp/order">수주 관리</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/emp/shipment">출하 관리</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#charts" aria-expanded="false" aria-controls="charts">
              <i class="icon-bar-graph menu-icon"></i>
              <span class="menu-title">사원 관리</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="charts">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/emp/emp">사원 관리</a></li>
              </ul>
            </div>
          </li>
 		</ul>
      </nav>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
		<h2>사원 관리</h2><br>
		<div><h3 style="margin-top: 15px;">사원 검색</h3></div>
		
		<form action="${pageContext.request.contextPath}/emp/empSearch" class="empSearch" method="get">
			<div id="search">
				<ul>

					<li><div class="search_div"><label class="search_name"><b>부서</b></label>
					<select class="choose" name="emp_dept">
					<option value="100">-----------------------------------------------</option>
					<option value="0">무소속</option>
					<option value="1">인사부</option>
					<option value="2">영업부</option>
					<option value="3">재무부</option></select></div></li>

				

					<li><div class="search_div"><label class="search_name"><b>직급</b></label>
					<select class="choose2" name="emp_rank">
					<option value="100">-----------------------------------------------</option>
					<option value="0">무보직</option>
					<option value="1">대표</option>
					<option value="2">팀장</option>
					<option value="3">대리</option>
					<option value="4">사원</option></select></div></li>

				

				<li><div class="search_div"><label class="search_name"><b>사원번호</b></label>
					<input type="text" class="emp_num" name="emp_num"></div></li>
					
				<li><div class="search_div"><label class="search_name"><b>사원이름</b></label>
					<input type="text" class="emp_name" name="emp_name">
					
					<span class="button"><button type="submit" style="background-color: black; color: #EFBDBC;">조회</button> <button type="reset" style="background-color: black; color: #EFBDBC;">초기화</button></span></div></li>

				</ul>	
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

		<hr>
   	
		<div style="width:50%; height:50px; float: left; vertical-align: bottom !important; "><h3 style="margin-top: 15px;">사원 목록</h3></div>
		<div style="width:50%; height:50px; float: left; text-align: right !important; padding-top: 15px;" >
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<button style="background-color: black; color: #EFBDBC;" onclick="window.open('${pageContext.request.contextPath}/emp/popup/emp_insert','홍커피','width=460,height=660,top=100,left=200')">추가</button>
		<button style="background-color: black; color: #EFBDBC;" onclick="emp_updateAdmin()">수정</button>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_MEMBER')">
		<button style="background-color: black; color: #EFBDBC;" onclick="window.open('${pageContext.request.contextPath}/emp/popup/emp_update?emp_num=${sessionScope.emp_num}','홍커피','width=460,height=660, top=100, left=200')">수정</button>
<%-- 		<button style="background-color: black; color: #EFBDBC;" onclick="window.open('${pageContext.request.contextPath}/emp/popup/emp_update?emp_num=${sessionScope.emp_num}','홍커피','width=370,height=520')">수정</button> --%>
		</sec:authorize>
		</div>
		
		
<!-- 		목록 -->
		<div style="width:100%;  height:700px; border: black 1px solid; float: left; text-align: center;">
		<table class="table">
  			<tr style="background-color: transparent !important;">
  			<sec:authorize access="hasRole('ROLE_ADMIN')">
    		<th style=" font-size:20px !important; color: black;">선택</th>
    		</sec:authorize>
    		<th style=" font-size:20px !important; color: black;">사원번호</th>
    		<th style=" font-size:20px !important; color: black;">이름</th>
    		<th style=" font-size:20px !important; color: black;">생년월일</th>
    		<th style=" font-size:20px !important; color: black;">부서</th>
    		<th style=" font-size:20px !important; color: black;">직급</th>
    		<sec:authorize access="hasRole('ROLE_ADMIN')">
    		<th style=" font-size:20px !important; color: black;">권한</th>
    		</sec:authorize>
    		<th style=" font-size:20px !important; color: black;">연락처</th>
    		<th style=" font-size:20px !important; color: black;">이메일</th>
    		<th style=" font-size:20px !important; color: black;">입사일</th>
    		<th style=" font-size:20px !important; color: black;">상태</th>
 		 </tr>
 		 <c:forEach var="EmployeeDTO" items="${empList}">

  <tr onclick="window.open('${pageContext.request.contextPath}/emp/detail/d_emp?emp_num=${EmployeeDTO.emp_num}','홍커피','width=1500,height=725,top=100, left=200,scrollbars=yes')">
  		<sec:authorize access="hasRole('ROLE_ADMIN')">
    <td style="text-align: center !important; font-size:20px !important;" onclick="event.cancelBubble=true"><label for="radio1-true"><input type="radio" name="radio1" id="radio1-true" value="${EmployeeDTO.emp_num }"></label></td>
 		</sec:authorize>

    <td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.emp_num}</td>
   	<td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.emp_name}</td>
   	<td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.emp_birth}</td>

    <c:if test="${EmployeeDTO.emp_dept eq 0}">
    <td style="text-align: center !important; font-size:20px !important;">소속없음</td>
    </c:if>
        <c:if test="${EmployeeDTO.emp_dept eq 1}">
    <td style="text-align: center !important; font-size:20px !important;">인사팀</td>
    </c:if>
        <c:if test="${EmployeeDTO.emp_dept eq 2}">
    <td style="text-align: center !important; font-size:20px !important;">영업팀</td>
    </c:if>
        <c:if test="${EmployeeDTO.emp_dept eq 3}">
    <td style="text-align: center !important; font-size:20px !important;">재무팀</td>
    </c:if>
    
         <c:if test="${EmployeeDTO.emp_rank eq 0}">
    <td style="text-align: center !important; font-size:20px !important;">직급없음</td>
    </c:if>
        <c:if test="${EmployeeDTO.emp_rank eq 1}">
    <td style="text-align: center !important; font-size:20px !important;">대표</td>
    </c:if>
        <c:if test="${EmployeeDTO.emp_rank eq 2}">
    <td style="text-align: center !important; font-size:20px !important;">팀장</td>
    </c:if>
        <c:if test="${EmployeeDTO.emp_rank eq 3}">
    <td style="text-align: center !important; font-size:20px !important;">대리</td>
    </c:if>
        <c:if test="${EmployeeDTO.emp_rank eq 4}">
    <td style="text-align: center !important; font-size:20px !important;">사원</td>
    </c:if>
   	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
   		<td style="text-align: center !important; font-size:20px !important;">
   			<c:if test="${EmployeeDTO.emp_right eq 1}">관리자</c:if>
   			<c:if test="${EmployeeDTO.emp_right eq 0}">일반</c:if>
   		</td>
	</sec:authorize>

 	<td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.emp_phone}</td>
 	<td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.emp_email}</td>
 	<td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.hire_date}</td>

 		<c:if test="${EmployeeDTO.emp_state eq 1}">
 		<td style="text-align: center !important; font-size:20px !important; color:green; ">재직</td>
 		</c:if>
 		
 		<c:if test="${EmployeeDTO.emp_state eq 2}">
 		<td style="text-align: center !important; font-size:20px !important; color:orange; ">휴직</td>
 		</c:if>
 		
 		<c:if test="${EmployeeDTO.emp_state eq 3}">
 		<td style="text-align: center !important; font-size:20px !important; color:red; ">퇴직</td>
 		</c:if>

  </tr>
  		</c:forEach>
  
 		 </table>
 		 
 		   <div id="page_control">
		<c:if test="${pageDTO.startPage > pageDTO.pageBlock}">
			<a href="${pageContext.request.contextPath}/emp/emp?pageNum=${pageDTO.startPage - pageDTO.pageBlock}">Prev</a>
		</c:if>
		
		<c:if test="${pageDTO.count ne -1}">
		<c:forEach var="i" begin="${pageDTO.startPage}" end="${pageDTO.endPage}" step="1">
			<a href="${pageContext.request.contextPath}/emp/emp?pageNum=${i}">${i}</a>
		</c:forEach>
		</c:if>
		
		<c:if test="${pageDTO.count eq -1}">
		<c:forEach var="i" begin="${employeeDTO.startPage}" end="${employeeDTO.endPage}" step="1">
			<a href="${pageContext.request.contextPath}/emp/empSearch?pageNum=${i}&emp_dept=${employeeDTO.emp_dept}
			&emp_rank=${employeeDTO.emp_rank}&emp_num=${employeeDTO.emp_num}
			&emp_name=${employeeDTO.emp_name}">${i}</a>
		</c:forEach>
		</c:if>

		<c:if test="${pageDTO.endPage < pageDTO.pageCount}">
			<a href="${pageContext.request.contextPath}/emp/emp?pageNum=${pageDTO.startPage + pageDTO.pageBlock}">Next</a>
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
function cola() {
	document.querySelector("#ui-basic").className = 'collapse';
	document.querySelector("#form-elements").className = 'collapse';
	document.querySelector("#pjh1").className = 'nav-item';
	document.querySelector("#pjh2").className = 'nav-item';
	document.querySelector("#pjh3").className = 'nav-item';
}


function emp_updateAdmin(){
	let enuma = $('input[name=radio1]:checked').val();
	if(enuma == null || enuma == undefined){
		alert('수정하고자 하는 내용을 선택해주세요');
		return false;
	}
	window.open('${pageContext.request.contextPath}/emp/popup/emp_update_admin?emp_num='+enuma, '홍커피','width=460,height=660, top=100, left=200');
}

$(function(){
    $('.empSearch').submit(function(){
        if($('.choose').val()=="100" && $('.choose2').val()=="100" && $('.emp_num').val() =="" && $('.emp_name').val() == ""){
            alert('직원를 조회하기 위해서는 부서, 직급, 사원 번호, 사원 이름 중 하나 이상 입력해야합니다.');
            return false;
        }
    });
});



</script>

</body>


</html>