<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="vdao" class="org.iii.ee10087.itube._05_videoManage.model.VideoDAOImpl"
	scope="page" />
<c:choose>
	<c:when test="${not empty param.seqNo}">
		<jsp:setProperty name="vdao" property='seqNo' value='${param.seqNo}' />
		<c:set var="bean" value='${vdao.video}' scope='session' />
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上傳影片</title>
<style>
* {
	padding: 0px;
	margin: 0px;
}

.allPage {
	margin: 3em;
	text-align: center;
}

.allPage h2 {
	margin-bottom: 1em;
	/* 		border: red solid 1px; */
}

.insertVideoForm {
	display: inline-block;
	text-align: center;
	width: 50em;
	/* 	border: red solid 1px; */
}

.insertVideoForm fieldset {
	display: inline-block;
	text-align: left;
	width: 45em;
	border-radius: 20px;
	/*  		border: blue solid 1px;  */
}

.insertVideoForm fieldset legend {
	margin-left: 1.5em;
}

.insertVideoForm fieldset div {
	display: inline-block;
	/* 		border-bottom: solid #E8E8E8 1px; */
	width: 95%;
	margin: 0.25em 0em 0.25em 1em;
	/*  		border: yellow solid 1px;  */
}

.insertVideodatatitle {
	width: 5em;
	display: inline-block;
	margin: 0.5em 0em;
	font-size: 20px;
}

.insertVideodatainput {
	width: 8em;
	display: inline;
	margin: 2em;
}

.insertVideodataerror {
	color: red;
	display: inline;
	font-size: 0.5em;
}

.sub {
	margin: 0.5em;
}

.sub input {
	margin: 1em;
	border-radius: 100px;
	width: 5em;
	height: 2em;
	font-size: 1em;
}

.insertMessage {
	color: red;
	height: 2em;
}
</style>
<script type="text/javascript">
	//由<body>的onLoad事件處理函數觸發此函數
	function setFocusToUserId() {
		document.forms[0].userId.focus(); // 將游標放在userId欄位內
	}
</script>
</head>
<body onLoad="setFocusToUserId()">
<c:choose>
   <c:when test="${not empty param.seqNo }">
   <!-- 
     <c:out value="第一次"/>
      -->
     <c:set var="videoTitle" value='${bean.videoTitle}' />
     <c:set var="videoUploaderAccount" value='${bean.videoUploaderAccount}' />
     <c:set var="videoFile" value='${bean.videoFile}' />
     <c:set var="videoDescription" value='${bean.videoDescription}' />
     <c:set var="videoType" value='${bean.videoType}' />
   </c:when>
   <c:otherwise>
   <!-- 
     <c:out value="第二次"/>
      -->
     <c:set var="videoTitle" value='${bean.videoTitle}' />
     <c:set var="videoUploaderAccount" value='${bean.videoUploaderAccount}' />
     <c:set var="videoFile" value='${bean.videoFile}' />
     <c:set var="videoDescription" value='${bean.videoDescription}' />
     <c:set var="videoType" value='${bean.videoType}' />
   </c:otherwise>
</c:choose>
	<jsp:include page="/fragment/top.jsp" />
	<div class="allPage">
		<div class="insertMessage">${successMsgKey.success}${ErrorMsgKey.Exception}</div>
		<form ENCTYPE="multipart/form-data" name="updateVideo"
			action="<c:url value='updateVideo.do'/>" method="POST"
			class="insertVideoForm">
			<fieldset>

				<legend>請輸入上傳影片資料:</legend>
				<div>
					<p class="insertVideodatatitle">
						<label for="videoTitle1"><font>影片標題:</font></label>
					</p>
					<p class="insertVideodatainput">
						<input type="text" name="videoTitle" id="videoTitle1"
							value="${videoTitle}">
					</p>
					<p class="insertVideodataerror">${ErrorMsgKey.VideoTitleEmptyError}</p>

				</div>
				<input type=hidden name="videoUploaderAccount"
					id="videoUploaderAccount1" value="${ LoginOK.account }"> <input
					type=hidden name="videoFile" id="videoFile1"
					value="${ videoFile }"> <input type=hidden
					name="seqNo" id="seqNo1" value="${ param.seqNo }">


				<div>
					<p class="insertVideodatatitle">
						<label for="videoDescription1"><font>影片描述:</font></label>
					</p>
					<p class="insertVideodatainput">
						<input type="text" name="videoDescription" id="videoDescription1"
							value="${videoDescription}">
					</p>
					<p class="insertVideodataerror">${ErrorMsgKey.VideoDescriptionEmptyError}</p>

				</div>


				<div>
					<p class="insertVideodatatitle">
						<label for="videoType1"><font>影片種類:</font></label>
					</p>
					<p class="insertVideodatainput">
						<input type="radio" name="videoType" id="song1" value="song"><label
							for="song1">音樂</label> <input type="radio" name="videoType"
							id="sport1" value="sport"><label for="sport1">運動</label>
						<input type="radio" name="videoType" id="game1" value="game"><label
							for="game1">遊戲</label> <input type="radio" name="videoType"
							id="news1" value="news"><label for="news1">新聞</label> <input
							type="radio" name="videoType" id="liveStream1" value="liveStream"><label
							for="liveStream1">直播</label> <input type="radio" name="videoType"
							id="technology1" value="technology"><label
							for="technology1">科技</label> <input type="radio" name="videoType"
							id="food1" value="food"><label for="food1">美食</label> <input
							type="radio" name="videoType" id="politics1" value="politics"><label
							for="politics1">政治</label> <input type="radio" name="videoType"
							id="fashion1" value="fashion"><label for="fashion1">時尚</label>
						<input type="radio" name="videoType" id="movie1" value="movie"><label
							for="movie1">電影</label> <input type="radio" name="videoType"
							id="other1" value="other"><label for="other1">其他</label>
					</p>
					<p class="insertVideodataerror">${ErrorMsgKey.VideoTypeEmptyError}</p>

				</div>

				<div>
					<p class="insertVideodatatitle">
						<label for="videoImage1"><font>影片照片:</font></label>
					</p>
					<p class="insertVideodatainput">
						<input type="file" name="videoImage" id="videoImage1"
							value="${param.videoImage}">
					</p>
					<img height='120' width='96' 
                     src='${pageContext.servletContext.contextPath}/_01_global/getImage?videoSeqNo=${param.seqNo}&type=VIDEO'  />
				</div>

			</fieldset>
			<div class="sub">
				<p>
					<input type="submit" value="送出">
				</p>
			</div>
		</form>
	</div>
	<c:remove var="ErrorMsgKey" scope='session' />
	<c:remove var="successMsgKey" scope='session' />
</body>
</html>