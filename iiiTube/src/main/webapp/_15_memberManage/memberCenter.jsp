<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modern Business - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/modern-business.css" rel="stylesheet">
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
  </head>

  <body>

    <!-- Navigation -->
    <jsp:include page="/fragment/top.jsp" />

    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">會員中心
        <small>Subheading</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">會員中心</li>
      </ol>

      <!-- Intro Content -->
      <div class="row">
        <div class="col-lg-6">
          <img class="img-fluid rounded mb-4" src="${pageContext.request.contextPath}/_01_global/getImage?account=${LoginOK.account}&type=MEMBER" alt="">
        </div>
        <div class="col-lg-6">
          <h2><a href="updateMember.jsp">修改基本資料</a></h2>
          
          <p><i class="far fa-address-card"></i>帳號:${LoginOK.account}</p>
          <p><i class="far fa-address-card"></i>密碼:${LoginOK.password}</p>
          <p><i class="far fa-address-card"></i>暱稱:${LoginOK.nickname}</p>
          <p><i class="far fa-address-card"></i>名字:${LoginOK.firstname}</p>
          <p><i class="far fa-address-card"></i>姓氏:${LoginOK.lastname}</p>
          <p><i class="far fa-address-card"></i>手機:${LoginOK.cellphone}</p>
          <p><i class="far fa-address-card"></i>住址:${LoginOK.address}</p>
          <p><i class="far fa-address-card"></i>信箱:${LoginOK.email}</p>
          <p><i class="far fa-address-card"></i>生日:${LoginOK.birthday}</p>
          <p><i class="far fa-address-card"></i>性別:${LoginOK.gender}</p>
          <p><i class="far fa-address-card"></i>註冊時間:${LoginOK.registerTime}</p>
<!-- 		  <p><i class="far fa-address-card"></i>照片: <img height="40px" width="30px" -->
<%-- 				src='${pageContext.request.contextPath}/_01_global/getImage?account=${LoginOK.account}&type=MEMBER'></p> --%>
		  <p><i class="far fa-address-card"></i>照片檔名:${LoginOK.fileName}</p>
        </div>
      </div>
      <!-- /.row -->

      <!-- Team Members -->
<!--       <h2>Our Team</h2> -->

<!--       <div class="row"> -->
<!--         <div class="col-lg-4 mb-4"> -->
<!--           <div class="card h-100 text-center"> -->
<!--             <img class="card-img-top" src="http://placehold.it/750x450" alt=""> -->
<!--             <div class="card-body"> -->
<!--               <h4 class="card-title">Team Member</h4> -->
<!--               <h6 class="card-subtitle mb-2 text-muted">Position</h6> -->
<!--               <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus aut mollitia eum ipsum fugiat odio officiis odit.</p> -->
<!--             </div> -->
<!--             <div class="card-footer"> -->
<!--               <a href="#">name@example.com</a> -->
<!--             </div> -->
<!--           </div> -->
<!--         </div> -->
<!--         <div class="col-lg-4 mb-4"> -->
<!--           <div class="card h-100 text-center"> -->
<!--             <img class="card-img-top" src="http://placehold.it/750x450" alt=""> -->
<!--             <div class="card-body"> -->
<!--               <h4 class="card-title">Team Member</h4> -->
<!--               <h6 class="card-subtitle mb-2 text-muted">Position</h6> -->
<!--               <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus aut mollitia eum ipsum fugiat odio officiis odit.</p> -->
<!--             </div> -->
<!--             <div class="card-footer"> -->
<!--               <a href="#">name@example.com</a> -->
<!--             </div> -->
<!--           </div> -->
<!--         </div> -->
<!--         <div class="col-lg-4 mb-4"> -->
<!--           <div class="card h-100 text-center"> -->
<!--             <img class="card-img-top" src="http://placehold.it/750x450" alt=""> -->
<!--             <div class="card-body"> -->
<!--               <h4 class="card-title">Team Member</h4> -->
<!--               <h6 class="card-subtitle mb-2 text-muted">Position</h6> -->
<!--               <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus aut mollitia eum ipsum fugiat odio officiis odit.</p> -->
<!--             </div> -->
<!--             <div class="card-footer"> -->
<!--               <a href="#">name@example.com</a> -->
<!--             </div> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
<!--       /.row -->

<!--       Our Customers -->
<!--       <h2>Our Customers</h2> -->
<!--       <div class="row"> -->
<!--         <div class="col-lg-2 col-sm-4 mb-4"> -->
<!--           <img class="img-fluid" src="http://placehold.it/500x300" alt=""> -->
<!--         </div> -->
<!--         <div class="col-lg-2 col-sm-4 mb-4"> -->
<!--           <img class="img-fluid" src="http://placehold.it/500x300" alt=""> -->
<!--         </div> -->
<!--         <div class="col-lg-2 col-sm-4 mb-4"> -->
<!--           <img class="img-fluid" src="http://placehold.it/500x300" alt=""> -->
<!--         </div> -->
<!--         <div class="col-lg-2 col-sm-4 mb-4"> -->
<!--           <img class="img-fluid" src="http://placehold.it/500x300" alt=""> -->
<!--         </div> -->
<!--         <div class="col-lg-2 col-sm-4 mb-4"> -->
<!--           <img class="img-fluid" src="http://placehold.it/500x300" alt=""> -->
<!--         </div> -->
<!--         <div class="col-lg-2 col-sm-4 mb-4"> -->
<!--           <img class="img-fluid" src="http://placehold.it/500x300" alt=""> -->
<!--         </div> -->
<!--       </div> -->
<!--       /.row -->
			<br><br><br><br><br>
    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
