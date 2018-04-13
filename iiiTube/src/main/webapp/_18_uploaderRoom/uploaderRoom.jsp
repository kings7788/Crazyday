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
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 
  <link rel="stylesheet" href="/resources/demos/style.css">
  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../css/modern-business.css" rel="stylesheet">
  
  


<style>
	.videoDescription{
		width:90%;
		overflow: hidden;
		height: 40px;
		line-height: 20px;
		display: inline-block;
		float:left;
/* 		border: blue solid 1px; */
		margin: -10px 0px;
	}
	.videoDescriptionOutSide{
		display: block;
/* 		border: red solid 1px; */
		float:left;
		height: 40px;
		line-height: 20px;
		margin: -10px 0px;
	}
	.videoTypeOutSide{
		display: block;
/*   		border: red solid 1px;   */
		float:left;
/* 		height: 40px; */
		line-height: 20px; 
 		width: 8%; 
		margin-top: -10px; 
		margin-bottom: 7px 
	}
	.videoType{
		width:92%;
		overflow: hidden;
/* 		height: 40px;  */
		line-height: 20px;
		display: block;
 		float:left; 
/*   		border: blue solid 1px;   */
  		margin-top: -10px; 
  		margin-bottom: 7px 
	}
	.videoDatas{
		font-size: 15px;
 		line-height: 5px; 
	}
	.addVideoButtonDiv{
/*  		border: blue solid 1px;  */
		 text-align: right;
		 height:50px;
		 margin-top:25px;
	}
	.addVideoButton{
		height:50px;
	}
	.updateRadio{
		display:inline-block
	}
	.seqNo{
		display:none
	}
	
	label, input { display:block; } 
	input.text { margin-bottom:12px; width:95%; padding: .4em; } 
	fieldset { padding:0; border:0; margin-top:25px; } 
	h1 { font-size: 1.2em; margin: .6em 0; } 
	div#users-contain { width: 350px; margin: 20px 0; } 
	div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; } 
	div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; } 
 	.ui-dialog .ui-state-error { padding: .3em; } 
	.validateTips { border: 1px solid transparent; padding: 0.3em; } 
</style>

</head>

<body>

  <!-- Navigation -->
  <jsp:include page="/fragment/top.jsp" />

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
    <div class="col-md-10">
    	<h1 class="mt-4 mb-3">影片管理
          <small>Subheading</small>
    	</h1>
    </div>
    
    
	 </div>
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">Home</a>
      </li>
      <li class="breadcrumb-item active">Portfolio 1</li>
    </ol>

    <!-- Project One -->
    <div class="row divOutsideRow">
    	<c:forEach var="aVideoBean" items="${videos_DPP}">
    		<div class="col-md-12 row divOutside">
		     	<div class="col-md-10">
				
		          <div class="media mb-4">
		<!--             <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt=""> -->
		
					<a	href="<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=${aVideoBean.seqNo}&userAccount=${LoginOK.account}' />">
						<img class="d-flex mr-3 picVideo" height="200px" width="400px"	src='${pageContext.request.contextPath}/_01_global/getImage?videoSeqNo=${aVideoBean.seqNo}&type=VIDEO'>
					</a>
					
		            <div class="media-body videoDatas">
		              <a href="<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=${aVideoBean.seqNo}&userAccount=${LoginOK.account}' />">
		              	<h5 class="mt-0">${aVideoBean.videoTitle}</h5>
		              </a>
		              <p class="seqNo">${aVideoBean.seqNo}</p>
		              <p>觀看次數:${aVideoBean.videoViews}</p>
		              <p>影片上傳日期時間:${aVideoBean.videoUploadDate}</p>
		              <p class="videoTypeOutSide">
		           		   影片種類:
		              	<p class="videoType">${aVideoBean.videoType}</p>
		              </p>
		              <p>影片喜歡數:${aVideoBean.videoLikes}</p>
					  <p>影片不喜歡數:${aVideoBean.videoUnlikes}</p>
					  <p>影片播放清單類別:${aVideoBean.videoUploaderType}</p>
		              
		              <p class="videoDescriptionOutSide">
		              		影片描述:
		              		<p class="videoDescription"> 
		              		${aVideoBean.videoDescription}
		              		</p>
		              </p>
		            </div>
		          </div>
		          
				
					
				</div>
				<div class="col-md-2">
						
<!-- 	            		<button class="btn btn-info create-user"><i class="fas fa-edit"></i></button> -->
	          			
<!-- 	          			<button class="btn btn-danger delete-video"><i class="fas fa-trash-alt"></i></button> -->
	          			
				</div>
			</div>
		</c:forEach>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Pagination -->
    <div class="col-md-12">
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
  <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>

	</script>
</body>

</html>