<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
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
/* 차트 스타일 */
#myChart{
/* width: 80% !important; */
/* height: 600px !important; */
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

      <!-- partial -->
      <!-- partial:partials/_sidebar.html -->

      
      
      <!--     include left -->
		<jsp:include page="inc/left.jsp"/>
      
    
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
        <h2>대시보드</h2>
      
      
      
         <fieldset>
    
	<script>
	
		</script>


		<div class="card">
		<div class="card-body" >
		<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
		<h4 class="card-title">재고 현황</h4>
	<canvas id="myChart"  ></canvas>
<script>
$(document).ready(function() {
    $.ajax({
        url: "${pageContext.request.contextPath}/store/mainJson",
        method: "GET",
        success: function (result) {
            var iname=[];
            var amount = [];
            for (var i in result) {
                iname.push(result[i].item_name);
                amount.push(result[i].amount);
            }
            var data = {
                labels: iname,
                datasets: [{
                    label: "양",
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 0.4,
                    data: amount
                }],
            };
            var myJ = new Chart(document.getElementById('myChart').getContext('2d'), {
                type: 'bar',
                data: data,
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                    
                        }
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
         <fieldset  style="padding-top: 3px;">
           <div class="card" >
		<div class="card-body" >
                  <h4 class="card-title">일별 실적그래프</h4>
                  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
					<canvas id="line-chart" width="300" height="250"></canvas>
					<script>
$(function() {
    $.ajax({
        url: "${pageContext.request.contextPath}/store/mainJson2",
        method: "GET",
        success: function (result) {
            var rdate=[];
            var maechul = [];
            var jichul = [];
            var income = [];
            for (var i in result) {
                var date = new Date(result[i].rs_date);
                rdate.push(date.toLocaleDateString());
                maechul.push(result[i].maechul);
                jichul.push(result[i].jichul);
                income.push(result[i].income);
            }
            console.log(rdate);
            var data2 = {
                labels: rdate,
                datasets: [{
                    label: "순이익",
                    borderColor: "#3e95cd",
                    fill: false,
                    data: income
                }, {
			        label: "매출",
			        borderColor: "#8e5ea2",
			        fill: false,
			        data: maechul
			    }, { 
			        data: jichul,
			        label: "지출",
			        borderColor: "#3cba9f",
			        fill: false
			    }]
            };
            new Chart(document.getElementById("line-chart"), {
				  type: 'line',
				  data: data2,
				  options: {
				    title: {
				      display: true,
				      text: '일별 기록'
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
<%--    <script src="${pageContext.request.contextPath}/resources/js/chart.js"></script> --%>
  <script src="${pageContext.request.contextPath}/resources/js/dashboard.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/Chart.roundedBarCharts.js"></script>
  <!-- End custom js for this page-->
  
<!--   nav 고유색 -->
<%-- <script src="${pageContext.request.contextPath}/resources/js/navSawon.js"></script> --%>
</body>

</html>

