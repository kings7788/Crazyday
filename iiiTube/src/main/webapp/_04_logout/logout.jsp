<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

  </head>

  <body>
	<c:remove var="LoginOK" scope="session" />
	<c:set var="funcName" value="OUT" scope="session"/>
	<c:set var="logoutMessage" scope="request"/>
	<jsp:useBean id='logoutBean'  
	    class='org.iii.ee10087.itube._04_logout.model.LogoutBean' scope='page' />
	<c:set target='${logoutBean}' 
	   property='session'    value='${pageContext.session}'/>
	   
	${ logoutBean.logout }
	<c:redirect url="/_04_logout/logoutSuccess.jsp"/>
    <!-- Navigation -->
    <jsp:include page="/fragment/top.jsp" />

    <!-- Page Content -->
    <div class="container">
	
      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">登出成功
        <small>Subheading</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">登出成功</a>
        </li>
        <li class="breadcrumb-item active">Full Width</li>
      </ol>

      <p>Most of Start Bootstrap's unstyled templates can be directly integrated into the Modern Business template. You can view all of our unstyled templates on our website at
        <a href="http://startbootstrap.com/template-categories/unstyled">http://startbootstrap.com/template-categories/unstyled</a>.</p>

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
