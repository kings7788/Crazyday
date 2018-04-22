<%-- <%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%> --%>
<%-- <%@page import="org.springframework.web.context.WebApplicationContext"%> --%>
<%-- <%@page import="org.iii.iiiTube.videoManage.model.VideoManageDAO"%> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<%-- <% --%>
<!--  	WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext()); -->
<!--  	VideoManageDAO caBean0 = (VideoManageDAO) ctx.getBean(VideoManageDAO.class); -->
<!--  	pageContext.setAttribute("showVideoBean", caBean0); -->
<%-- %> --%>

<%-- <jsp:useBean id="showVideoBean" class="org.iii.iiiTube.videoManage.model.VideoManageDAOImpl" scope="application" /> --%>
<%-- <jsp:setProperty property="userAccount" name="showVideoBean" value="${LoginOK.userAccount}"/> --%>
<head>
<meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="description" content="">
	  <meta name="author" content="">
	
	  <title>管理影片</title>
	  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 
<!-- 	  <link rel="stylesheet" href="/resources/demos/style.css"> -->
	  <!-- Bootstrap core CSS -->
	  <link href="<c:url value='/global/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
	
	  <!-- Custom styles for this template -->
	  <link href="<c:url value='/global/css/modern-business.css'/>" rel="stylesheet">
	  <link href="<c:url value='/videoManage/css/videoManage.css'/>" rel="stylesheet">
</head>
<body>
<%-- 	<c:if test="${empty LoginOK}"> --%>
<%-- 		<c:redirect url="/login/login.jsp" /> --%>
<%-- 	</c:if> --%>
<%-- 	<jsp:include page="../global/fragment/top.jsp" /> --%>
	<%@ include file="/WEB-INF/views/global/fragment/top.jsp" %>
		<div class="container">
		
			<div class="row">
				<div class="col-md-10">
					<h1 class="mt-4 mb-3">影片管理
						<small>Subheading</small>
					</h1>
					
				</div>
				
				
				<div class="col-md-2 addVideoButtonDiv">
					<button class="btn btn-danger addVideoButton " id = "insert-video"><i class="fas fa-plus"></i>&nbsp;&nbsp;&nbsp;新增影片</button>
				</div>
			</div>
			<ol class="breadcrumb">
				<li class="breadcrumb-item">
					<a href="index.html">Home</a>
				</li>
				<li class="breadcrumb-item active">Portfolio 1</li>
			</ol>
			<div class="row divOutsideRow">
				<c:forEach var="aVideoBean" items="${userVideoList}">
					<div class="col-md-12 row divOutside">
						<div class="col-md-10">
							<div class="media mb-4">
<%-- 								<a	href="<c:url value='/videoRoom/VideoRoom.do?videoSeqNo=${aVideoBean.videoSeqNo}&userAccount=${LoginOK.account}' />"> --%>
<%-- 									<img class="d-flex mr-3 picVideo" height="200px" width="400px"	src='${pageContext.request.contextPath}/global/GetImage.do?path=${aVideoBean.videoImageFilePath}'> --%>
<!-- 								</a> -->
								
								<div class="media-body videoDatas">
<%-- 									<a href="<c:url value='/videoRoom/VideoRoom.do?videoSeqNo=${aVideoBean.videoSeqNo}&userAccount=${LoginOK.account}' />"> --%>
<%-- 										<h5 class="mt-0">${aVideoBean.videoTitle}</h5> --%>
<!-- 									</a> -->
									<p class="seqNo">${aVideoBean.videoSeqNo}</p>
									<p>觀看次數:${aVideoBean.videoViews}</p>
									<p>影片上傳日期時間:${aVideoBean.videoUploadDate}</p>
									<p class="videoTypeOutSide">影片種類:</p>
									<p class="videoType">${aVideoBean.videoType}</p>
									
									<p>影片喜歡數:${aVideoBean.videoLikes}</p>
									<p>影片不喜歡數:${aVideoBean.videoUnlikes}</p>
									<p>影片播放清單類別:${aVideoBean.videoUplodaerListType}</p>
									
									<p class="videoDescriptionOutSide">影片描述:</p>
									<p class="videoDescription">${aVideoBean.videoDescription}</p>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<button class="btn btn-info create-user"><i class="fas fa-edit"></i></button>
							<button class="btn btn-danger delete-video"><i class="fas fa-trash-alt"></i></button>
						</div>
					</div>
				</c:forEach>
			</div>
			<hr>
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
		<div id="dialog-form" title="影片資料變更">
			<p class="validateTips">請輸入欲變更資料</p>
			<form:form modelAttribute="VideoBean" id="myForm" name = "myForm" ENCTYPE="multipart/form-data">
			<fieldset>
				<form:input type="hidden" path="videoSeqNo" name="videoSeqNo" id="videoSeqNo" value="" />
				<form:input type="hidden" path="account" name="videoUploaderAccount" id="videoUploaderAccount" value="${LoginOK.userAccount}" />
				<label for="videoTitle">影片標題</label>
				<form:input type="text" path="videoTitle" name="videoTitle" id="videoTitle" value="" class="text ui-widget-content ui-corner-all"/>
				<label for="videoDescription">影片描述</label>
				<form:input type="text" path="videoDescription" name="videoDescription" id="videoDescription" value="" class="text ui-widget-content ui-corner-all"/>
				<label for="song">影片種類</label>
<%-- 				<form:input type="radio"  name="videoType" id="song" value="音樂" class="updateRadio" />音樂 --%>
<%-- 				<form:input type="radio" name="videoType" id="sport" value="運動" class="ui-corner-all updateRadio" />運動 --%>
<%-- 				<form:input type="radio" name="videoType" id="game" value="遊戲" class="ui-corner-all updateRadio" />遊戲 --%>
<%-- 				<form:input type="radio" name="videoType" id="news" value="新聞" class="ui-corner-all updateRadio" />新聞 --%>
<%-- 				<form:input type="radio" name="videoType" id="liveStream" value="直播" class="ui-corner-all updateRadio" />直播 --%>
<%-- 				<form:input type="radio" name="videoType" id="technology" value="科技" class="ui-corner-all updateRadio" />科技 --%>
<%-- 				<form:input type="radio" name="videoType" id="food" value="美食" class="ui-corner-all updateRadio" />美食 --%>
<%-- 				<form:input type="radio" name="videoType" id="politics" value="政治" class="ui-corner-all updateRadio" />政治 --%>
<%-- 				<form:input type="radio" name="videoType" id="fashion" value="時尚" class="ui-corner-all updateRadio" />時尚 --%>
<%-- 				<form:input type="radio" name="videoType" id="movie" value="電影" class="ui-corner-all updateRadio" />電影 --%>
<%-- 				<form:input type="radio" name="videoType" id="other" value="其他" class="ui-corner-all updateRadio" />其他 --%>
					<form:select path="videoType">
						<form:option value="-1" label="---" />
						<form:options items="${videoTypeList}" />
					</form:select>
				<label for="videoImage">影片照片</label>
				<form:input type="file" path="videoImage" name="videoImage" id="videoImage" class="text ui-widget-content ui-corner-all" />
				<input type="submit" tabindex="-1" style="position:absolute; top:-1000px" />
			</fieldset>
			</form:form>
		</div>
		
		<div id="insert-dialog-form" title="新增影片資料">
			<p class="validateTips">請輸入欲新增影片資料</p>
			<form:form modelAttribute="VideoBean" id="insertForm" name = "insertForm" ENCTYPE="multipart/form-data" method='POST'>
				<fieldset>
					<form:input type="hidden" name="videoUploaderAccountInsert" path="account" id="videoUploaderAccountInsert" value="${LoginOK.userAccount}" />
					<label for="videoTitleInsert">影片標題</label>
					<form:input type="text" name="videoTitleInsert" id="videoTitleInsert" path="videoTitle" value="" class="text ui-widget-content ui-corner-all"/>
					<label for="videoDescriptionInsert">影片描述</label>
					<form:input type="text" name="videoDescriptionInsert" id="videoDescriptionInsert" path="videoDescription" class="text ui-widget-content ui-corner-all"/>
					<label>影片種類</label>
<%-- 					<form:radiobutton name="videoTypeInsert" id="songInsert" path="videoType" value="音樂" class="updateRadio" />音樂 --%>
<%-- 					<form:radiobutton name="videoTypeInsert" id="sportInsert" path="videoType" value="運動" class="ui-corner-all updateRadio"/>運動 --%>
<%-- 					<form:radiobutton name="videoTypeInsert" id="gameInsert" path="videoType" value="遊戲" class="ui-corner-all updateRadio"/>遊戲 --%>
<%-- 					<form:radiobutton name="videoTypeInsert" id="newsInsert" path="videoType" value="新聞" class="ui-corner-all updateRadio"/>新聞 --%>
<%-- 					<form:radiobutton name="videoTypeInsert" id="liveStreamInsert" path="videoType" value="直播" class="ui-corner-all updateRadio"/>直播 --%>
<%-- 					<form:radiobutton name="videoTypeInsert" id="technologyInsert" path="videoType" value="科技" class="ui-corner-all updateRadio"/>科技 --%>
<%-- 					<form:radiobutton name="videoTypeInsert" id="foodInsert" path="videoType" value="美食" class="ui-corner-all updateRadio"/>美食 --%>
<%-- 					<form:radiobutton name="videoTypeInsert" id="politicsInsert" path="videoType" value="政治" class="ui-corner-all updateRadio"/>政治 --%>
<%-- 					<form:radiobutton name="videoTypeInsert" id="fashionInsert" path="videoType" value="時尚" class="ui-corner-all updateRadio"/>時尚 --%>
<%-- 					<form:radiobutton name="videoTypeInsert" id="movieInsert" path="videoType" value="電影" class="ui-corner-all updateRadio"/>電影 --%>
<%-- 					<form:radiobutton name="videoTypeInsert" id="otherInsert" path="videoType" value="其他" class="ui-corner-all updateRadio"/>其他 --%>
					<form:select path="videoType">
						<form:option value="-1" label="---" />
						<form:options items="${videoTypeList}" />
					</form:select>
<!-- 					<label for="videoImageInsert">影片照片</label> -->
<!-- 					<input type="file" name="videoImageInsert" id="videoImageInsert" class="text ui-widget-content ui-corner-all"> -->
					<label for="videofileInsert">影片檔案</label>
					<form:input type="file" name="videoFileInsert" id="videoFileInsert" path="videoFile" class="text ui-widget-content ui-corner-all"/>
					<input type="submit" tabindex="-1" style="position:absolute; top:-1000px"/>
					<video  height="300px" width="500px" src="" id="videoPreview" controls="controls"></video>
<!-- 					<div id=output></div> -->
					<p>影片封面截圖:</p>
					<canvas id=myCanvas></canvas>
<!-- 					<img id="myImage"> -->
				</fieldset>
			</form:form>
		</div>
<!-- 		<div id="delete-dialog-form" title="刪除資料"> -->
<!-- 			<p class="validateTips">確認刪除此資料?</p> -->
<%-- 			<form id="deleteForm" name = "deleteForm" > --%>
<!-- 				<fieldset> -->
<!-- 					<input type=hidden name="seqNoDelete" id="seqNoDelete" value="" > -->
<!-- 					<p>影片名稱:<span id="videoTitleDelete"></span></p> -->
<!-- 					<input type="submit" tabindex="-1" style="position:absolute; top:-1000px"> -->
<!-- 				</fieldset> -->
<%-- 			</form> --%>
<!-- 		</div> -->
	
		<footer class="py-5 bg-dark">
			<div class="container">
				<p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
			</div>
		</footer>
		<script src="<c:url value='/global/vendor/jquery/jquery.min.js'/>"></script>
		<script src="<c:url value='/global/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
		<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script src="<c:url value='/videoManage/js/videoManage.js'/>"></script>
		
</body>
</html>