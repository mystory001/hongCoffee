<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
 <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
    <script>

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth'
        });
        calendar.render();
      });

    </script>
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

#search {
	height: 300px;
	margin: 0 auto;
}

ul{
	list-style:none;
}

#search {
	height: 250px;
	width: 100%;
	border: 1px solid black;
}

.name {
	width: 100px;
	margin: 35px 0 20px 50px;
	text-align: left;
	font-size: 15px;
}

.choose {
	width: 300px;
		font-size: 15px;
}

#search li {
	width: 600px;
	height: 50px;
}

input[type=text]{
	width: 300px;
	margin-bottom: 10px;
	color: white;
}

.button{
	margin-left: 10px;
}

/* 항목 스타일 끝 */

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
   <h2>대시보드</h2>
         <fieldset>
           <div class="card" >
		<div class="card-body" >
                  <h4 class="card-title">실적 높은 TOP5 지점</h4>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<canvas id="bar-chart-horizontal" width="600" height="250"></canvas>
<script>
$(document).ready(function() {
    $.ajax({
        url: "${pageContext.request.contextPath}/emp/mainJson",
        method: "GET",
        success: function (result) {
            var sname=[];
            var ssales = [];
            for (var i in result) {
                sname.push(result[i].name);
                ssales.push(result[i].maechul);
            }
            console.log(ssales.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
            var data = {
                labels: sname,
                datasets: [{
                    label: "실적량",
                    backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
                    borderColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
                    data: ssales
                }],
            };
            
        	var myJ = new Chart(document.getElementById("bar-chart-horizontal"), {
            	type: 'horizontalBar',
            	data: data,
            	options: {
              		legend: { display: false },
              		title: {
                		display: true,
                		text: '지점 실적'
              			}
            	}
        	});
        	
        }
    	
    });
});

</script>
</div>
</div>
         </fieldset>
         <fieldset style="padding-top: 3px;">
          <div class="card" >
		<div class="card-body" >
                  <h4 class="card-title">일정</h4>
              <div id='calendar'></div>
                  
                  </div>
                  </div>
         </fieldset>

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
<%--   <script src="${pageContext.request.contextPath}/resources/vendors/chart.js/Chart.min.js"></script> --%>
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
  
<!--   nav 고유색 -->
<%-- <script src="${pageContext.request.contextPath}/resources/js/navSawon.js"></script> --%>
</body>

</html>

