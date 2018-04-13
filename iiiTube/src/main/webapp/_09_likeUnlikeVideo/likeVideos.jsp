<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

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

    <!-- Navigation -->
    <jsp:include page="/fragment/top.jsp" />

    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">喜歡的影片
        <small>Subheading</small>
      </h1>
		
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">Portfolio 2</li>
      </ol>

      <div class="row">
      	<c:forEach var="aVideoBean" items="${likeVideos}">
        <div class="col-lg-6 portfolio-item">
          <div class="card h-100">
          <a href="<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=${aVideoBean.videoSeqNo}&userAccount=${LoginOK.account}' />">
			<img class="card-img-top" height="400px" width="200px" src='${pageContext.request.contextPath}/_01_global/getImage?videoSeqNo=${aVideoBean.videoSeqNo}&type=VIDEO'>
		  </a>
<!--             <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a> -->
            <div class="card-body">
              <h4 class="card-title">
                <a href="<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=${aVideoBean.videoSeqNo}&userAccount=${LoginOK.account}' />">
             	 ${aVideoBean.videoTitle}
                </a>
              </h4>
              <p class="card-text">${aVideoBean.videoDescription}</p>
            </div>
          </div>
        </div>
        </c:forEach>
        
        
        
        
      </div>
      <!-- /.row -->

      <!-- Pagination -->
      <ul class="pagination justify-content-center">
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
            <span class="sr-only">Previous</span>
          </a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">1</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">2</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">3</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
          </a>
        </li>
      </ul>

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
