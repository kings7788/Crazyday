<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="vroomdao" class="org.iii.ee10087.itube._17_videoRoom.model.VideoRoomDAOImpl"
	scope="application" />
<jsp:setProperty name="vroomdao" property='videoUploaderAccount'
	value='${watchVideoBean.videoUploaderAccount}' />
<c:set var="bean" value='${vroomdao.uploaderVideos}' scope='session' />


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

/* .likeUnlike { */
/* 	text-align: right; */
/* 	display: inline-block; */
/* 	width: 120px; */
/* 	/* 	border: solid yellow 1px; */ 
/* 	height: 50px; */
/* 	float: right; */
/* 	line-height: 40px; */
/* } */

/* .likeUnlike form { */
/* 	display: inline-block; */
/* } */

.likeButton {
	background-image: url(../images/like.jpg);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	background-size: 20px 20px;
	/* put the height and width of your image here */
	height: 20px;
	width: 20px;
	border: none;
	cursor: pointer;
}

.unlikeButton {
	background-image: url(../images/unlike.jpg);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	background-size: 20px 20px;
	/* put the height and width of your image here */
	height: 20px;
	width: 20px;
	border: none;
	cursor: pointer;
}
.uploaderaccount{
	width: 80%;
	display: inline-block;
}

.likeVideo, .unlikeVideo{
	width: 40%;
	display: inline-block;
	padding: 0px;
	margin: 0px;
}
.likeUnlikeBlock{
	float:right;
	width: 10%;
/* 	border: black solid 1px; */
	display: inline-block;
	padding: 0px;
	margin: 0px;
}
.videoTitleInside{
	margin: 15px 0px;
/* 	font-size: 20px; */
}
.advicedVideoTitle{
/* 	border: solid 1px red; */
	height: 2.4em;
	overflow: hidden;
	margin-bottom: 0.5em;
}
.advicedVideoUploaderAccount{
	margin:0px;
}
</style>
</head>

<body>

  <!-- Navigation -->
  <jsp:include page="/fragment/top.jsp" />

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">
      <small>Subheading</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">Home</a>
      </li>
      <li class="breadcrumb-item active">Portfolio Item</li>
    </ol>

    <!-- Portfolio Item Row -->
    <div class="row">

      <div class="col-md-9">
		<c:forEach var="aSubBean" items="${subscriptionUploader}">
          <div class="media mb-4">
<!--             <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt=""> -->
			<a href="<c:url value='/_18_uploaderRoom/UploaderRoom.do?uploaderAccount=${aSubBean.uploaderAccount}' />">
				<img height="100px" width="50px"	src='${pageContext.request.contextPath}/_01_global/getImage?account=${aSubBean.uploaderAccount}&type=MEMBER'>
			</a>
            <div class="media-body">
              <a href="<c:url value='/_18_uploaderRoom/UploaderRoom.do?uploaderAccount=${aSubBean.uploaderAccount}' />">
              	<h5 class="mt-0">${aSubBean.uploaderAccount}</h5>
              </a>
              <p>訂閱數:${aSubBean.uploaderSubscription}</p>
            </div>
          </div>
		</c:forEach>
          <!-- Comment with nested comments -->
          
      </div>

      

    </div>
    <!-- /.row -->

    <!-- Related Projects Row -->
    <!-- <h3 class="my-4">Related Projects</h3>

      <div class="row">

        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="">
          </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="">
          </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="">
          </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="">
          </a>
        </div>

      </div> -->
    <!-- /.row -->

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