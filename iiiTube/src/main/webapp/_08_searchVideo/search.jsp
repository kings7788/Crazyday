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
<style>
	.videoDescription{
		width:100%;
		overflow: hidden;
		height: 50px;;
	}
</style>
</head>

<body>

  <!-- Navigation -->
  <jsp:include page="/fragment/top.jsp" />

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">搜尋
          <small>Subheading</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">Home</a>
      </li>
      <li class="breadcrumb-item active">Portfolio 1</li>
    </ol>

    <!-- Project One -->
    <div class="row">
      <div class="col-md-12">
		<c:forEach var="aVideoBean" items="${searchResult1}">
          <div class="media mb-4">
<!--             <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt=""> -->

			<a	href="<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=${aVideoBean.seqNo}&userAccount=${LoginOK.account}' />">
				<img class="d-flex mr-3" height="200px" width="400px"	src='${pageContext.request.contextPath}/_01_global/getImage?videoSeqNo=${aVideoBean.seqNo}&type=VIDEO'>
			</a>
			
            <div class="media-body">
              <a href="<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=${aVideoBean.seqNo}&userAccount=${LoginOK.account}' />">
              	<h5 class="mt-0">${aVideoBean.videoTitle}</h5>
              </a>
              <p><a class="uploaderLink"
							href="<c:url value='/_18_uploaderRoom/UploaderRoom.do?uploaderAccount=${aVideoBean.videoUploaderAccount}' />">${aVideoBean.videoUploaderAccount}</a></p>
              <p>觀看次數:${aVideoBean.videoViews}</p>
              <p>${aVideoBean.videoUploadDate}</p>
              
              <p class="videoDescription">${aVideoBean.videoDescription}</p>
            </div>
          </div>
		</c:forEach>
    </div>
    <!-- /.row -->

    <hr>

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