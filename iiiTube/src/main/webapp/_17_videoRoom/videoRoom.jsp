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

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
	background-image: url(../images/likefinalgray.jpg);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	background-size: 30px 30px;
	/* put the height and width of your image here */
	height: 30px;
	width: 30px;
	border: none;
	cursor: pointer;
/* 	border : solid 1px blue ; */
}

.unlikeButton {
	background-image: url(../images/unlikefinalgray.jpg);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	background-size: 30px 30px;
	/* put the height and width of your image here */
	height: 30px;
	width: 30px;
	border: none;
	cursor: pointer;
/* 	border : solid 1px blue ; */
}

.uploaderaccount {
	width: 4%;
	display: inline-block;
	/* 	border: black solid 1px; */
}

.uploaderaccount a {
	color: black;
}

.uploaderaccount a:hover {
	color: black;
	text-decoration: none;
}

.likeVideo, .unlikeVideo {
	width: 40%;
	display: inline-block;
	padding: 0px;
	margin: 0px;
	font-size: 35px;
/* 	float: right; */
/*   	border: yellow solid 1px;    */
/* 	float: left; */
}

.likeUnlikeBlock {
	text-align: right;
	float: right;
	width: 17%;
/*   	border: black solid 1px;    */
	display: inline-block;
	padding: 0px;
	margin: 0px;
}

.videoTitleInside {
	margin: 15px 0px;
	/* 	font-size: 20px; */
}

.advicedVideoTitle {
	/* 	border: solid 1px red; */
	height: 2.4em;
	overflow: hidden;
	margin-bottom: 0.5em;
}

.advicedVideoUploaderAccount {
	margin: 0px;
}

.videoBlock {
	
}

.videoBlock a {
	color: black;
}

.videoBlock a:hover {
	color: black;
	text-decoration: none;
}

.videoSmallWords {
	font-size: 7px;
	margin: 0px 0px;
}

.advicedVideoUploaderAccount {
	margin-top: 5px;
}

.videoDetail {
	line-height: 10px;
	/* 	padding-bottom: 0px; */
	/* 	border: solid 1px red; */
	margin-bottom: -15px;
}

#allComments>div>div>h5>span{
	color: gray;
	font-size: 10px;
	margin-left: 20px;
}

#allComments > div > div > div > div > h5 > span{
	color: gray;
	font-size: 10px;
	margin-left: 20px;
}


.replyButton{
	margin-bottom: 10px;
}
.hide{
	color: white;
}

.btn{
	font-size: 15px;
}

.subscriptionButton{
	float:right;
	-webkit-filter: grayscale(100%);
}






/* 以下聊天室 */

 .chat-sidebar {
            width: 150px;
            position: fixed;
            height: 94%;
            right: 0px;
            bottom: 0px;
            padding-top: 10px;
            padding-bottom: 10px;
            border: 1px solid rgba(29, 49, 91, .3);
            display: block;
			background-color:#CFCFCF;
        }

        .chat-sidebar>.sidebar-name>button {
            width: 100%;
            cursor: pointer;
            display: block;
            height: 100%;
            text-align: left;
            background-color:#CFCFCF;
        }



        .popup-box {
            display: none;
            position: fixed;
            bottom: 0px;
            right: 220px;
            height: 285px;
            background-color: rgb(237, 239, 244);
            width: 300px;
            border: 1px solid rgba(29, 49, 91, .3);
        }

        .box {
            background-color: aqua;
            width: 300px;
            height: 285px;
            right: 220px;
            position: fixed;
            bottom: 0px;
            border: solid 1px black;
        }

        .box-head {
            width: 100%;
            height: 30px;
            background-color: #4A0080;
            color: white;
            font-size: 20px;
            line-height: 25px;
        }

        .box-head>button {
            height: 30px;
            width: 30px;
            background-color: #4A0080;
            float: right;
            cursor: pointer;
        }

        .box-head>button:hover {
            background-color: #4A0080;
        }

        .box-head>i {
            background-color: white;
        }

        .box-head>span {
            margin-left: 10px;
        }

        .box-body {
            width: 100%;
            height: 230px;
            background-color: white;
        }

        .box-message {
            width: 100%;
            height: 23x;
            background-color: red;
        }

        .box-message>input {
            width: 100%;
            height: 23px;
        }










/* 以上聊天室 */


</style>
</head>

<body>

	<!-- Navigation -->
	<jsp:include page="/fragment/top.jsp" />

	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">${watchVideoBean.videoTitle}
			<small>Subheading</small>
		</h1>

		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.html">Home</a></li>
			<li class="breadcrumb-item active">Portfolio Item</li>
		</ol>

		<!-- Portfolio Item Row -->
		<div class="row">

			<div class="col-md-9">
				<!-- <img class="img-fluid" src="http://placehold.it/750x500" alt=""> -->
				<iframe class="video" width="1150" height="600"
					src="<c:out value="${watchVideoBean.videoFile}" />?autoplay=1&autoplay=1" frameborder="0"
					allow="autoplay; encrypted-media" allowfullscreen></iframe>
				<div class="col-md-12 ">
					<h1 class="lead videoTitleInside">${watchVideoBean.videoTitle}</h1>
					<hr>

					<!-- Date/Time -->
					<div class="media mb-4">
						<img class="d-flex mr-3 rounded-circle" width="50px" height="50px"
							src="${pageContext.request.contextPath}/_01_global/getImage?account=${LoginOK.account}&type=MEMBER"
							alt="">
						<!--             <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt=""> -->
						<div class="media-body videoDetail">
							<h5 class="mt-0 uploaderaccount">
								<a class="uploaderLink"
									href="<c:url value='/_18_uploaderRoom/UploaderRoom.do?uploaderAccount=${watchVideoBean.videoUploaderAccount}' />"><p>${watchVideoBean.videoUploaderAccount}</p></a>
							</h5>
							<div class="likeUnlikeBlock">
								<%-- 	              	${watchVideoBean.videoLikes}<button class="likeButton"></button> --%>
								<%-- 	              	${watchVideoBean.videoUnlikes}<button class="unlikeButton"></button> --%>



								
								<form name="likeVideo" class="likeVideo">
									<%-- 								action="<c:url value='/_09_likeUnlikeVideo/likeunlikeVideo.do'/>"method="POST"  --%>
									<span id="likeNumber">${watchVideoBean.videoLikes}</span><input type="hidden"
										name="videoSeqNo" value="${watchVideoBean.seqNo}"> <input
										type="hidden" name="userAccount" value="${LoginOK.account}">
									<input type="hidden" name="likeunlike" value="like">
									<button type="button" value="" class="likeButton"></button>
								</form>
								<form name="unlikeVideo" class="unlikeVideo">
									<%-- 									action="<c:url value='/_09_likeUnlikeVideo/likeunlikeVideo.do'/>" --%>
									<!-- 									method="POST"  -->
									<span id="unlikeNumber">${watchVideoBean.videoUnlikes}</span><input type="hidden"
										name="videoSeqNo" value="${watchVideoBean.seqNo}"> <input
										type="hidden" name="userAccount" value="${LoginOK.account}">
									<input type="hidden" name="likeunlike" value="unlike">
									<button type="button" value="" class="unlikeButton"></button>
								</form>
							</div>

							<p>上傳日期:${watchVideoBean.videoUploadDate}<button type="button" value="" class="btn btn-danger subscriptionButton">訂閱&nbsp;&nbsp;&nbsp;&nbsp;<i class="far fa-bell"></i></button></p>
							<p >影片觀看次數:${watchVideoBean.videoViews}</p>
							
						</div>
					</div>



					<hr>

					<!-- Post Content -->


					<p>影片描述:${watchVideoBean.videoDescription}</p>

					<!--           <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos, doloribus, dolorem iusto blanditiis unde eius illum -->
					<!--             consequuntur neque dicta incidunt ullam ea hic porro optio ratione repellat perspiciatis. Enim, iure!</p> -->

					<!--           <blockquote class="blockquote"> -->
					<!--             <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p> -->
					<!--             <footer class="blockquote-footer">Someone famous in -->
					<!--               <cite title="Source Title">Source Title</cite> -->
					<!--             </footer> -->
					<!--           </blockquote> -->

					<!--           <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error, nostrum, aliquid, animi, ut quas placeat totam -->
					<!--             sunt tempora commodi nihil ullam alias modi dicta saepe minima ab quo voluptatem obcaecati?</p> -->

					<!--           <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum, dolor quis. Sunt, ut, explicabo, aliquam tenetur -->
					<!--             ratione tempore quidem voluptates cupiditate voluptas illo saepe quaerat numquam recusandae? Qui, necessitatibus, -->
					<!--             est!</p> -->

					<hr>

					<!-- Comments Form -->
					<div class="card my-4">
						<h5 class="card-header">Leave a Comment:</h5>
						<div class="card-body">
							<form>
								<div class="form-group">
									<textarea class="form-control" rows="3" id="commentArea"></textarea>
								</div>
								<button type="button" class="btn btn-primary" id="commentButton">Submit</button>
							</form>
						</div>
					</div>
					
					<div id="allComments">
						

					
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<!-- <div class="my-3"> -->
				<h1>推薦影片</h1>
				<c:forEach var="aVideoBean" items="${bean}">
					<div class="media mt-4 videoBlock">
						<!--                 <img class="d-flex mr-3" src="http://placehold.it/50x50" alt=""> -->
						<a
							href="<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=${aVideoBean.seqNo}&userAccount=${LoginOK.account}' />">
							<img class="d-flex mr-3" height="80px" width="170px"
							src='${pageContext.request.contextPath}/_01_global/getImage?videoSeqNo=${aVideoBean.seqNo}&type=VIDEO'>
						</a>
						<div class="media-body">
							<div class="advicedVideoTitle">
								<h6 class="mt-0">
									<a
										href="<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=${aVideoBean.seqNo}&userAccount=${LoginOK.account}' />">
										<p>${aVideoBean.videoTitle}</p>
									</a>
								</h6>
							</div>

							<p class="advicedVideoUploaderAccount videoSmallWords">
								<a class="uploaderLink"
									href="<c:url value='/_18_uploaderRoom/UploaderRoom.do?uploaderAccount=${watchVideoBean.videoUploaderAccount}' />">${aVideoBean.videoUploaderAccount}</a>
							</p>
							<p class="videoSmallWords">觀看次數:${aVideoBean.videoViews}</p>
						</div>
					</div>
				</c:forEach>
				<!-- </div> -->




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
		<p class="m-0 text-center text-white">Copyright &copy; Your
			Website 2018</p>
	</div>
	<!-- /.container --> </footer>

	<!-- Bootstrap core JavaScript -->
	
	
<!-- 	以下聊天室--------------------------------------------------------------------------- -->
<div class="chat-sidebar">
        <div class="sidebar-name">
            <button type="button" class="sidebarUserButton" name="TIM" id="tim">
                <img width="30" height="30" src="../images/rufu.jpg">
                <span>Tim</span>
                
            </button>

        </div>


        <div class="sidebar-name">
            <button type="button" class="sidebarUserButton" name="LALALA" id="lalala">
                <img width="30" height="30" src="../images/rufu.jpg">
                <span>lalala</span>
            </button>

        </div>
        <div class="sidebar-name">
            <button type="button" class="sidebarUserButton" name="STEVEN" id="steven">
                <img width="30" height="30" src="../images/rufu.jpg">
                <span>Steven</span>
            </button>

        </div>


        <div class="sidebar-name">
            <button type="button" class="sidebarUserButton" name="KEVIN" id="kevin">
                <img width="30" height="30" src="../images/rufu.jpg">
                <span>Kevin</span>
            </button>

        </div>
        <div class="sidebar-name">
            <button type="button" class="sidebarUserButton" name="JACKY" id="jacky">
                <img width="30" height="30" src="../images/rufu.jpg">
                <span>Jacky</span>
            </button>

        </div>
        <div class="sidebar-name">
            <button type="button" class="sidebarUserButton" name="BOB" id="bob">
                <img width="30" height="30" src="../images/rufu.jpg">
                <span>Bob</span>
            </button>

        </div>

    </div>
    <div class="chatplace">


    </div>    
	
	
<!-- 	以上聊天室--------------------------------------------------------------------------- -->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
	<script>

	$(document).ready(function() {	
		
// 	 	以下聊天室--------------------------------------------------------------------------- 
		
		var count = 0;
        $('.sidebarUserButton').click(function () {
            var right = 220;
            var id = $(this).attr('id');

            right = $('div[class="box"]').length * 320 + right;
            if ($('div[id="' + id + '"]').length == 0) {
                if ($('div[class="box"]').length == 5) {
                    right = 220
                    var name = $(this).attr('name');


                    $('div[name=' + right + ']').remove()
                    $('.chatplace').prepend($('<div id = "' + id + '"><div class="box-head"><span> ' + id + '</span><button><i class="fas fa-window-close"></i></button></div><div class="box-body"></div><div class="box-message"><input type="text"></div></div>').addClass('box').css({ "right": right + "px" }).attr('name', right))
                    right = right + 320;
                    count++;
                } else {
                    var name = $(this).attr('name');


                    $('div[name=' + right + ']').remove()
                    $('.chatplace').append($('<div id = "' + id + '"><div class="box-head"><span> ' + id + '</span><button><i class="fas fa-window-close"></i></button></div><div class="box-body"></div><div class="box-message"><input type="text"></div></div>').addClass('box').css({ "right": right + "px" }).attr('name', right))
                    right = right + 320;
                    count++;
                }

            }



        })
        $(document).on('click', '.box-head>button', function () {
            var number = ($(this).parent('div').parent('div').attr('name') - 220) / 320
            $(this).parent('div').parent('div').remove();

            disp($(".box").toArray(), number);




        })



        function disp(divs, number) {

            for (var i = number; i < divs.length; i++) {
                console.log("before" + $(divs[i]).attr("name"))
                var boxname = $(divs[i]).attr("name");
                $(divs[i]).attr("name", parseInt(boxname) - 320)

                $(divs[i]).css({ 'right': parseInt(boxname) - 320 })
                console.log("after" + $(divs[i]).attr("name"))
                console.log(divs[i])
            }

        }		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//以上聊天室----------------------------------------------------------------------------------------------------------------------
		var userAccount = $('input[name="userAccount"]').val();
		var uploaderaccount = $('.uploaderaccount').find('p').text();
		
	
		$.getJSON('../_10_subscriptionUploader/showSubscription.do',{ 'userAccount': userAccount,'uploaderaccount': uploaderaccount},function(datareturn){
// 			alert(datareturn.status);
			if(datareturn.status == 'subscription'){
				$('.subscriptionButton').css({
					'-webkit-filter':'none'
					
// 						
					
				})
				$('.subscriptionButton').html('已訂閱&nbsp;&nbsp;&nbsp;&nbsp;<i class="far fa-bell"></i>')
			}else if(datareturn.status == 'notsubscription'){
				$('.subscriptionButton').css({
					'-webkit-filter':'grayscale(100%)'
					
				})
				$('.subscriptionButton').text('訂閱')
			}else{
				
			}
		})
		
		
		
		
		
		$('.subscriptionButton').click(function(){
// 			alert("aaaaaaa");

// 			alert(userAccount)

			$.getJSON('../_10_subscriptionUploader/subscriptionUploader.do',{ 'userAccount': userAccount,'uploaderaccount': uploaderaccount},function(datareturn){
// 				alert(datareturn.seqNo);
// 				alert(datareturn.userAccount);
// 				alert(datareturn.uploaderAccount);
// 				alert(datareturn.status);
// 				alert(datareturn.subscriptionUploaderDate);
// 				alert(datareturn.score);
				
				
				if(datareturn.status == 'subscription'){
						$('.subscriptionButton').css({
							'-webkit-filter':'none'
						})
						$('.subscriptionButton').html('已訂閱&nbsp;&nbsp;&nbsp;&nbsp;<i class="far fa-bell"></i>')
				}else if(datareturn.status == 'notsubscription'){
					$('.subscriptionButton').css({
						'-webkit-filter':'grayscale(100%)'
					})
					$('.subscriptionButton').text('訂閱')
				}else{
					
				}
				
			})
		})
		
		
		
		
		
		
		
// 		alert($('input[name="userAccount"]').val());
// 		alert("aaaa");
		var videoSeqNo = $('input[name="videoSeqNo"]').val();
		$.getJSON('../_11_comments/showComments.do',{ 'videoSeqNo': videoSeqNo},function(datareturn){
// 			alert("bbbbb");	
// 			alert(datareturn);	
			var docFrag = $(document.createDocumentFragment());
//	           var tb = $('#productTable>tbody');
//	           tb.empty();

				var allcomments = $('#allComments');
	           $.each(datareturn, function (idx,data) {
					
					 var cell1 = $('<img></img>').addClass("d-flex mr-3 rounded-circle").attr({height:"50px" , width:"50px",src:"/iiiProject3/_01_global/getImage?account=" + data.userAccount +"&type=MEMBER"}) 
					 var cell2 = $('<div></div>').addClass("media-body")
					 
					 var cell3 = $('<h5></h5>').addClass("mt-0").text(data.userAccount);
					 var cell7 = $('<span></span>').text(data.commentDate).append($('<span></span>').addClass("hide").text(data.seqNo));
					 var cell3 = cell3.append(cell7);
					 var cell4 = cell2.text(data.comments);
					 var cell8 = $('<p></p>').append(   $('<button></button>').addClass("btn btn-info replyButton").text("回復").append(   $('<i></i>').addClass("fas fa-comment") ));
					 var cell4 = cell4.append(cell8);
					 var cell5 = cell4.prepend(cell3);
					 var cell6 = $('<div></div>').addClass("media mb-4").attr({id:data.seqNo}).append([cell1,cell5]);
					 docFrag.append(cell6);
					 var outerseqno= data.seqNo;
// 					 alert(data.seqNo);
						 $.getJSON('../_11_comments/showReplyComments.do',{ 'commentSeqNo': data.seqNo},function(datareturn){
// 							 alert(datareturn.replyCommentsUserAccount);
							 $.each(datareturn, function (idx,data) {
// 								 alert(data.commentSeqNo);
								 var upperComment = $('#' + data.commentSeqNo).children('.media-body');
								 var cell1 = $('<img></img>').addClass("d-flex mr-3 rounded-circle").attr({height:"50px" , width:"50px",src:"/iiiProject3/_01_global/getImage?account=" + data.replyCommentsUserAccount +"&type=MEMBER"}) 
								 var cell2 = $('<div></div>').addClass("media-body")
								 var cell3 = $('<h5></h5>').addClass("mt-0").text(data.replyCommentsUserAccount);
								 var cell7 = $('<span></span>').text(data.replyCommentsDate).append($('<span></span>').addClass("hide").text(data.seqNo));
								 var cell3 = cell3.append(cell7);
								 var cell4 = cell2.text(data.replyComments);
//	 							 var cell8 = $('<p></p>').append(   $('<button></button>').addClass("btn btn-info replyButton").text("回復").append(   $('<i></i>').addClass("fas fa-pencil-alt ") ));
//	 							 var cell4 = cell4.append(cell8);
								 var cell5 = cell4.prepend(cell3);
								 var cell6 = $('<div></div>').addClass("media mb-4").append([cell1,cell5]);
								 upperComment.append(cell6);
							 })
						 })
					
					 
					 
	           })
	           allcomments.prepend(docFrag);
	           $(".replyButton").click(function(){
// 				    alert("The paragraph was clicked.");
					
// 					 alert($(this).parent('p').children('form').length);
					if($(this).parent('p').children('form').length == 0){
						var cell1 = $('<textarea></textarea>').addClass("form-control").attr({rows:"3",id:"replyArea"})
					    var cell2 = $('<div></div>').addClass("form-group")
					     var cell2 = cell2.append(cell1);
					    var cell3 = $('<button></button>').addClass("btn btn-primary replySubmit").attr({type:"button"}).text("Submit")
					     var cell4 = $('<form></form>')
					     var cell4 = cell4.append([cell2,cell3]);
					    $(this).after(cell4)
					}
				    
// 				    <form>
// 						<div class="form-group">
// 							<textarea class="form-control" rows="3" id="commentArea"></textarea>
// 						</div>
// 						<button type="button" class="btn btn-primary" id="commentButton">Submit</button>
// 					</form>
					 $(".replySubmit").click(function(){
							var thisinsubmit = $(this)
// 						 alert("aaa");
// 						 alert( thisinsubmit.parent('form').find('textarea').val());
						 var replywords = $(this).parent('form').find('textarea').val();
						 var userAccount = $('input[name="userAccount"]').val();
						 var commentSeqNo =  $(this).parents('.media-body').children('h5').find('.hide').text();
// 						 alert(commentSeqNo);
						 var seqNo = $('').val();
						 $.getJSON('../_11_comments/ReplyComments.do',{ 'replywords': replywords,'userAccount':userAccount ,'commentSeqNo':commentSeqNo},function(datareturn){
// 							 alert(datareturn.seqNo);
// 							 alert(datareturn.replyCommentsUserAccount);
// 							 alert(datareturn.commentSeqNo);
// 							 alert(datareturn.replyComments);
// 							 alert(datareturn.replyCommentsDate);
// 							 alert(this);
							 
							 var upperComment = thisinsubmit.parents('.media-body');
							 var cell1 = $('<img></img>').addClass("d-flex mr-3 rounded-circle").attr({height:"50px" , width:"50px",src:"/iiiProject3/_01_global/getImage?account=" + datareturn.replyCommentsUserAccount +"&type=MEMBER"}) 
							 var cell2 = $('<div></div>').addClass("media-body")
							 var cell3 = $('<h5></h5>').addClass("mt-0").text(datareturn.replyCommentsUserAccount);
							 var cell7 = $('<span></span>').text(datareturn.replyCommentsDate).append($('<span></span>').addClass("hide").text(datareturn.seqNo));
							 var cell3 = cell3.append(cell7);
							 var cell4 = cell2.text(datareturn.replyComments);
// 							 var cell8 = $('<p></p>').append(   $('<button></button>').addClass("btn btn-info replyButton").text("回復").append(   $('<i></i>').addClass("fas fa-pencil-alt ") ));
// 							 var cell4 = cell4.append(cell8);
							 var cell5 = cell4.prepend(cell3);
							 var cell6 = $('<div></div>').addClass("media mb-4").append([cell1,cell5]);
							 upperComment.append(cell6);
						 });
						 $(this).parent('form').find('textarea').val("")
					 });
				});
		})



		$('#commentButton').click(function(){
// 			alert("aaaaaa");
			var comments = $('#commentArea').val().replace(/\s+/g, "");
// 			alert(comment);
			if(comments != ""){
				var userAccount = $('input[name="userAccount"]').val();
				var videoSeqNo = $('input[name="videoSeqNo"]').val();
				$.getJSON('../_11_comments/comments.do',{ 'userAccount': userAccount,'videoSeqNo':videoSeqNo ,'comments':comments},function(datareturn){
// 				alert(datareturn);
// 				alert("aaaaa");
					 var allcomments = $('#allComments');
					 var cell1 = $('<img></img>').addClass("d-flex mr-3 rounded-circle").attr({height:"50px" , width:"50px",src:"/iiiProject3/_01_global/getImage?account=" + datareturn.userAccount +"&type=MEMBER"}) 
					 var cell2 = $('<div></div>').addClass("media-body")
					 var cell3 = $('<h5></h5>').addClass("mt-0").text(datareturn.userAccount);
					 var cell7 = $('<span></span>').text(datareturn.replyCommentsDate).append($('<span></span>').addClass("hide").text(datareturn.seqNo));
					 var cell3 = cell3.append(cell7);
					 var cell4 = cell2.text(datareturn.comments);
					 var cell8 = $('<p></p>').append(   $('<button></button>').addClass("btn btn-info replyButton").text("回復").append(   $('<i></i>').addClass("fas fa-pencil-alt ") ));
					 var cell4 = cell4.append(cell8);
					 var cell5 = cell4.prepend(cell3);
					 var cell6 = $('<div></div>').addClass("media mb-4").append([cell1,cell5]);
					 allcomments.prepend(cell6);
					 
						$(".replyButton").click(function(){
// 						    alert("The paragraph was clicked.");
							if($(this).parent('p').children('form').length == 0){
// 								 alert($(this).parent('p').children('form'));
								    var cell1 = $('<textarea></textarea>').addClass("form-control").attr({rows:"3",id:"replyArea"})
								    var cell2 = $('<div></div>').addClass("form-group")
								     var cell2 = cell2.append(cell1);
								    var cell3 = $('<button></button>').addClass("btn btn-primary replySubmit").attr({type:"button"}).text("Submit")
								     var cell4 = $('<form></form>')
								     var cell4 = cell4.append([cell2,cell3]);
//		 						    alert(this);
								    $(this).after(cell4)
							}
						   
//		 				    <form>
//		 						<div class="form-group">
//		 							<textarea class="form-control" rows="3" id="commentArea"></textarea>
//		 						</div>
//		 						<button type="button" class="btn btn-primary" id="commentButton">Submit</button>
//		 					</form>
							 $(".replySubmit").click(function(){
									var thisinsubmit = $(this)
//		 						 alert("aaa");
//		 						 alert( thisinsubmit.parent('form').find('textarea').val());
								 var replywords = $(this).parents('form').find('textarea').val();
								 var userAccount = $('input[name="userAccount"]').val();
								 var commentSeqNo =  $(this).parents('.media-body').find('.hide').text();
//		 						 alert(commentSeqNo);
								 var seqNo = $('').val();
								 $.getJSON('../_11_comments/ReplyComments.do',{ 'replywords': replywords,'userAccount':userAccount ,'commentSeqNo':commentSeqNo},function(datareturn){
//		 							 alert(datareturn.seqNo);
//		 							 alert(datareturn.replyCommentsUserAccount);
//		 							 alert(datareturn.commentSeqNo);
//		 							 alert(datareturn.replyComments);
//		 							 alert(datareturn.replyCommentsDate);
//		 							 alert(this);
									 
									 var upperComment = thisinsubmit.parents('.media-body');
									 var cell1 = $('<img></img>').addClass("d-flex mr-3 rounded-circle").attr({height:"50px" , width:"50px",src:"/iiiProject3/_01_global/getImage?account=" + datareturn.replyCommentsUserAccount +"&type=MEMBER"}) 
									 var cell2 = $('<div></div>').addClass("media-body")
									 var cell3 = $('<h5></h5>').addClass("mt-0").text(datareturn.replyCommentsUserAccount);
									 var cell7 = $('<span></span>').text(datareturn.replyCommentsDate).append($('<span></span>').addClass("hide").text(datareturn.seqNo));
									 var cell3 = cell3.append(cell7);
									 var cell4 = cell2.text(datareturn.replyComments);
//		 							 var cell8 = $('<p></p>').append(   $('<button></button>').addClass("btn btn-info replyButton").text("回復").append(   $('<i></i>').addClass("fas fa-pencil-alt ") ));
//		 							 var cell4 = cell4.append(cell8);
									 var cell5 = cell4.prepend(cell3);
									 var cell6 = $('<div></div>').addClass("media mb-4").append([cell1,cell5]);
									 upperComment.append(cell6);
								 });
								 $(this).parents('form').find('textarea').val("");
							 });
						    
						    
						    

						    
						    
						    
						    
						});

				})
			}
			$('#commentArea').val("")
		})

// 		$(".replyButton").on("click", function(){
// 		    alert("The paragraph was clicked.");
// 		});


		var dataLikeStart = $('form[name="likeVideo"]').serialize();
		$.getJSON('../_09_likeUnlikeVideo/GetLikeStatus.do',dataLikeStart,function(datareturn){
			if(datareturn.likeStatus == 'like'){
				$('.likeButton').css({
					
					'background-image': 'url(../images/likefinal.jpg)'
				})
			}else if(datareturn.likeStatus == 'unlike'){
				$('.unlikeButton').css({
					'background-image': 'url(../images/unlikefinal.jpg)'
				})
			}
// 			alert(datareturn.likes);
// 			alert(datareturn.unlikes);
			
			$('#likeNumber').text(datareturn.likes);
			$('#unlikeNumber').text(datareturn.unlikes);
			
		})
		$('.likeButton').click(function() {
// 			alert("aaaaaaaa");
			var datas = $('form[name="likeVideo"]').serialize();
// 			alert(datas);
			$.getJSON('../_09_likeUnlikeVideo/likeunlikeVideo.do',datas,function(datareturn){
				$('#likeNumber').text(datareturn.like);
				$('#unlikeNumber').text(datareturn.unlike);
// 				alert(typeof datareturn.likeStatus);
// 				likeButton.css
				if(datareturn.likeStatus == 'like'){
// 					alert('aaaaaaa');
					$('.unlikeButton').css({
						'background-image': 'url(../images/unlikefinalgray.jpg)'
					})
					$('.likeButton').css({
						
						'background-image': 'url(../images/likefinal.jpg)'
					})
				}else if(datareturn.likeStatus == 'unlike'){
// 					alert('bbbbb');
					$('.likeButton').css({
						
						'background-image': 'url(../images/likefinalgray.jpg)'
					})
					$('.unlikeButton').css({
						'background-image': 'url(../images/unlikefinal.jpg)'
					})
				}else if(datareturn.likeStatus == 'none'){
// 					alert('ccccccc');
					$('.unlikeButton').css({
						'background-image': 'url(../images/unlikefinalgray.jpg)'
							
					})
					$('.likeButton').css({
						'background-image': 'url(../images/likefinalgray.jpg)'
					})
				}
				
// 				alert(datareturn);
// 	    			alert(datareturn.like);
// 	    			alert(datareturn.unlike);
// 		    		$.each(datareturn,function(index,value){
// 		    			alert(value);
// 		    			alert(value.like);
// 		    			alert(value.unlike);
// 		    		})
// 		    		alert("qqqqqqqq");
// 					data
		    	});
		})

		$('.unlikeButton').click(function() {
// 			alert("bbbbbbbb");
			var datas = $('form[name="unlikeVideo"]').serialize();
// 			alert(datas);
			$.getJSON('../_09_likeUnlikeVideo/likeunlikeVideo.do',datas,function(datareturn){
				$('#likeNumber').text(datareturn.like);
				$('#unlikeNumber').text(datareturn.unlike);
				if(datareturn.likeStatus == 'like'){
// 					alert('aaaaaaa');
					$('.unlikeButton').css({
						'background-image': 'url(../images/unlikefinalgray.jpg)'
					})
					$('.likeButton').css({
						
						'background-image': 'url(../images/likefinal.jpg)'
					})
				}else if(datareturn.likeStatus == 'unlike'){
// 					alert('bbbbb');
					$('.likeButton').css({
						
						'background-image': 'url(../images/likefinalgray.jpg)'
					})
					$('.unlikeButton').css({
						'background-image': 'url(../images/unlikefinal.jpg)'
					})
				}else if(datareturn.likeStatus == 'none'){
// 					alert('ccccccc');
					$('.unlikeButton').css({
						'background-image': 'url(../images/unlikefinalgray.jpg)'
							
					})
					$('.likeButton').css({
						'background-image': 'url(../images/likefinalgray.jpg)'
					})
				}
// 				alert(datareturn.likeStatus);
// 				alert(datareturn);
//     			alert(datareturn.like);
//     			alert(datareturn.unlike);

	    	});
			
			
		})
	})
		
	</script>
</body>

</html>