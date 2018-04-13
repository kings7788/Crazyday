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
						
	            		<button class="btn btn-info create-user"><i class="fas fa-edit"></i></button>
	          			
	          			<button class="btn btn-danger delete-video"><i class="fas fa-trash-alt"></i></button>
	          			
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
	<div id="dialog-form" title="影片資料變更">
		<p class="validateTips">請輸入欲變更資料</p>
	
		<form id="myForm" name = "myForm" ENCTYPE="multipart/form-data">
			<fieldset>
				<input type="hidden" name="seqNo" id="seqNo" value="" >
				<input type="hidden" name="videoUploaderAccount" id="videoUploaderAccount" value="${LoginOK.account}" >
				<label for="videoTitle">影片標題</label>
				<input type="text" name="videoTitle" id="videoTitle" value="" class="text ui-widget-content ui-corner-all">
				<label for="videoDescription">影片描述</label>
				<input type="text" name="videoDescription" id="videoDescription" value="" class="text ui-widget-content ui-corner-all">
				<label for="song">影片種類</label>
				<input type="radio" name="videoType" id="song" value="音樂" class="updateRadio" >音樂
				<input type="radio" name="videoType" id="sport" value="運動" class="ui-corner-all updateRadio">運動
				<input type="radio" name="videoType" id="game" value="遊戲" class="ui-corner-all updateRadio">遊戲
				<input type="radio" name="videoType" id="news" value="新聞" class="ui-corner-all updateRadio">新聞
				<input type="radio" name="videoType" id="liveStream" value="直播" class="ui-corner-all updateRadio">直播
				<input type="radio" name="videoType" id="technology" value="科技" class="ui-corner-all updateRadio">科技
				<input type="radio" name="videoType" id="food" value="美食" class="ui-corner-all updateRadio">美食
				<input type="radio" name="videoType" id="politics" value="政治" class="ui-corner-all updateRadio">政治
				<input type="radio" name="videoType" id="fashion" value="時尚" class="ui-corner-all updateRadio">時尚
				<input type="radio" name="videoType" id="movie" value="電影" class="ui-corner-all updateRadio">電影
				<input type="radio" name="videoType" id="other" value="其他" class="ui-corner-all updateRadio">其他
				<label for="videoImage">影片照片</label>
				<input type="file" name="videoImage" id="videoImage" class="text ui-widget-content ui-corner-all">
	
				<!-- Allow form submission with keyboard without duplicating the dialog button -->
				<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
			</fieldset>
		</form>
	</div>
	
	<div id="insert-dialog-form" title="新增影片資料">
		<p class="validateTips">請輸入欲新增影片資料</p>
	
		<form id="insertForm" name = "insertForm" ENCTYPE="multipart/form-data">
			<fieldset>
			
				<input type="hidden" name="videoUploaderAccountInsert" id="videoUploaderAccountInsert" value="${LoginOK.account}" >
				<label for=videoFileInsert>影片嵌入碼</label>
				<input type="text" name="videoFileInsert" id="videoFileInsert" value="" class="text ui-widget-content ui-corner-all">
				<label for="videoTitleInsert">影片標題</label>
				<input type="text" name="videoTitleInsert" id="videoTitleInsert" value="" class="text ui-widget-content ui-corner-all">
				<label for="videoDescriptionInsert">影片描述</label>
				<input type="text" name="videoDescriptionInsert" id="videoDescriptionInsert" value="" class="text ui-widget-content ui-corner-all">
				<label for="song">影片種類</label>
				<input type="radio" name="videoTypeInsert" id="songInsert" value="音樂" class="updateRadio" >音樂
				<input type="radio" name="videoTypeInsert" id="sportInsert" value="運動" class="ui-corner-all updateRadio">運動
				<input type="radio" name="videoTypeInsert" id="gameInsert" value="遊戲" class="ui-corner-all updateRadio">遊戲
				<input type="radio" name="videoTypeInsert" id="newsInsert" value="新聞" class="ui-corner-all updateRadio">新聞
				<input type="radio" name="videoTypeInsert" id="liveStreamInsert" value="直播" class="ui-corner-all updateRadio">直播
				<input type="radio" name="videoTypeInsert" id="technologyInsert" value="科技" class="ui-corner-all updateRadio">科技
				<input type="radio" name="videoTypeInsert" id="foodInsert" value="美食" class="ui-corner-all updateRadio">美食
				<input type="radio" name="videoTypeInsert" id="politicsInsert" value="政治" class="ui-corner-all updateRadio">政治
				<input type="radio" name="videoTypeInsert" id="fashionInsert" value="時尚" class="ui-corner-all updateRadio">時尚
				<input type="radio" name="videoTypeInsert" id="movieInsert" value="電影" class="ui-corner-all updateRadio">電影
				<input type="radio" name="videoTypeInsert" id="otherInsert" value="其他" class="ui-corner-all updateRadio">其他
				<label for="videoImageInsert">影片照片</label>
				<input type="file" name="videoImageInsert" id="videoImageInsert" class="text ui-widget-content ui-corner-all">
	
				<!-- Allow form submission with keyboard without duplicating the dialog button -->
				<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
			</fieldset>
		</form>
	</div>
	<div id="delete-dialog-form" title="刪除資料">
		<p class="validateTips">確認刪除此資料?</p>
	
		<form id="deleteForm" name = "deleteForm" >
			<fieldset>
				<input type=hidden name="seqNoDelete" id="seqNoDelete" value="" >
				<p>影片名稱:<span id="videoTitleDelete"></span></p>
	
				<!-- Allow form submission with keyboard without duplicating the dialog button -->
				<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
			</fieldset>
		</form>
	</div>
	
	
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
	var selectedVideo;
// 	alert($( 'button:nth-child(1)' ).index());
	$( 'button:nth-child(1)' ).click(function(){
// 		alert($(this).index('button'));
// 		alert($(this).parents('.row').find('.videoDatas').find('h5').text())
		selectedVideo = $(this);
		$( '#videoTitle' ).empty();
		$( '#videoDescription' ).empty();
		$( '#seqNo' ).empty();
		$( '#videoTitle' ).val($.trim($(this).parents('.divOutside').find('.videoDatas').find('h5').text()))
		$( '#videoDescription' ).val($.trim($(this).parents('.divOutside').find('.videoDatas').find('.videoDescription').text()))
		$( '#seqNo' ).val($.trim($(this).parents('.divOutside').find('.videoDatas').find('.seqNo').text()))
	})
	$( function() {
		var dialog, form,

			// From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
			emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
			name = $( "#name" ),
			email = $( "#email" ),
			password = $( "#password" ),
			allFields = $( [] ).add( name ).add( email ).add( password ),
			tips = $( ".validateTips" );

		function updateTips( t ) {
			tips
				.text( t )
				.addClass( "ui-state-highlight" );
			setTimeout(function() {
				tips.removeClass( "ui-state-highlight", 1500 );
			}, 500 );
		}

		
	

		function addUser() {
// 			var valid = true;
// 			allFields.removeClass( "ui-state-error" );

// 			if ( valid ) {
// 				$( "#users tbody" ).append( "<tr>" +
// 					"<td>" + name.val() + "</td>" +
// 					"<td>" + email.val() + "</td>" +
// 					"<td>" + password.val() + "</td>" +
// 				"</tr>" );
// 				dialog.dialog( "close" );
// 			}
// 			return valid;
// 			 var datas = $('form[name="myForm"]').serialize();
// 			 console.log(datas);
// 	 		   	$.post('updateVideo.do',datas,function(data){
// 	 		   		alert(data);
// 	 		   		loadProduct(1);
// 	 		   	    $('#ProductID').val('').next('span').text('');
// 	 				$('#ProductName').val('');
// 	 				$('#UnitPrice').val('');
// 	 			    $('#UnitsInStock').val('');
// 	 		    });
// 				alert($('#videoTitle').val());
// 				alert($('#videoDescription').val());
// 				alert($('input[name=videoType]:checked').val());
// 				alert(selectedVideo.parents('.divOutside').find('.videoDatas').find('h5').text());
// 				alert(selectedVideo.parents('.divOutside').find('.videoDatas').find('.videoDescription').text());
// 				alert(selectedVideo.parents('.divOutside').find('.videoDatas').find('.videoType').text());
				
				
				
				
				
				
				
// 				selectedVideo.parents('.divOutside').find('.videoDatas').find('.videoType').text('aaaaaaa');
						
// 				selectedVideo.parents('.divOutside').find('.videoDatas').find('h5').text($('#videoTitle').val())
// 				selectedVideo.parents('.divOutside').find('.videoDatas').find('.videoDescription').text($('#videoDescription').val())
// 				selectedVideo.parents('.divOutside').find('.videoDatas').find('videoType').text($('input[name=videoType]:checked').val())
// 				alert($('input[name=videoType]:checked').val());
				var form = $('#myForm')[0];
// 				alert(form);
				var data = new FormData(form);
				$.ajax({
		            type: "POST",
		            enctype: 'multipart/form-data',
		            url: "updateVideo.do",
		            data: data,
		            processData: false,
		            contentType: false,
		            cache: false,
		            timeout: 600000,
		            success: function (data) {

// 		                $("#result").text(data);
		                console.log("SUCCESS : ", data);
// 		                $("#btnSubmit").prop("disabled", false);
// 						alert($(this).val());
						selectedVideo.parents('.divOutside').find('.videoDatas').find('h5').text($('#videoTitle').val());
						selectedVideo.parents('.divOutside').find('.videoDatas').find('.videoDescription').text($('#videoDescription').val());
						selectedVideo.parents('.divOutside').find('.videoDatas').find('.videoType').text($('input[name=videoType]:checked').val());
// 						selectedVideo.parents('.divOutside').find('.videoDatas').find('picVideo').attr("src",selectedVideo.parents('.divOutside').find('.videoDatas').find('picVideo').attr("src"));
						
						var pic = selectedVideo.parents('.divOutside').find('.picVideo').attr("src") + "&timestamp=" + new Date().getTime();
// 						alert(pic);
						selectedVideo.parents('.divOutside').find('.picVideo').removeAttr("src").attr("src",pic);
						
// 						selectedVideo.parents('.divOutside').find('.videoDatas').find('h5').text($('#videoTitle').text())
// 						selectedVideo.parents('.divOutside').find('.videoDatas').find('.videoDescription').text($('#videoDescription').text())
// 						selectedVideo.parents('.divOutside').find('.videoDatas').find('.seqNo').text($('input[name=videoType]:checked').val())
// 						$( '#videoDescription' ).val($('#videoDescription').text())
// 						$( '#videoDescription' ).val($('input[name=videoType]:checked').val())
						
						dialog.dialog( "close" );
		            },
		            error: function (e) {

// 		                $("#result").text(e.responseText);
		                console.log("ERROR : ", e);
		                
// 		                $("#btnSubmit").prop("disabled", false);
		                alert(e);
		                dialog.dialog( "close" );
		            }
		        });
// 			alert("hello");
		}

		dialog = $( "#dialog-form" ).dialog({
			autoOpen: false,
			height: 600,
			width: 600,
			modal: true,
			buttons: {
				"確認更新": addUser,
				"取消": function() {
					dialog.dialog( "close" );
				}
			},
			close: function() {
				form[ 0 ].reset();
				allFields.removeClass( "ui-state-error" );
			}
		});

		form = dialog.find( "form" ).on( "submit", function( event ) {
			event.preventDefault();
			addUser();
		});

		$( ".create-user" ).button().on( "click", function() {
			dialog.dialog( "open" );
		});
		//insert-----------------------------------------------------------------------------------------
		dialoginsert = $( "#insert-dialog-form" ).dialog({
			autoOpen: false,
			height: 600,
			width: 600,
			modal: true,
			buttons: {
				"確認新增": insertvideo,
				"取消": function() {
					dialoginsert.dialog( "close" );
				}
			},
			close: function() {
				form[ 0 ].reset();
				allFields.removeClass( "ui-state-error" );
			}
		});
		
		function insertvideo() {
				var form = $('#insertForm')[0];
				var data = new FormData(form);
				$.ajax({
		            type: "POST",
		            enctype: 'multipart/form-data',
		            url: "insertVideo.do",
		            data: data,
		            processData: false,
		            contentType: false,
		            cache: false,
		            timeout: 600000,
		            success: function (data) {

		                alert("SUCCESS : ", data);
		                
		                

	 	 		    	$.getJSON('SelectInsertVideo.do', {}, function (datas) {	 
			                var docFrag = $(document.createDocumentFragment());
			                
			                var dor = $('.divOutsideRow');
// 			                alert("aaaa");
			                $.each(datas, function (idx,product) {
			                	   var cell1 = $('<a></a>').attr("href","<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=" + product.seqNo +"&userAccount=" + product.videoUploaderAccount + "' />")
// 			                	   alert(cell1.attr("href"));
		 			               var cell2 = $('<img></img>').addClass("d-flex mr-3 picVideo").attr({height:"200px" , width:"400px", src:"/iiiProject3/_01_global/getImage?videoSeqNo=" + product.seqNo +"&type=VIDEO"	}) 
// 			                	   alert(cell2.attr("src"));
		 			               
		 			               var cell1 = cell1.append(cell2)
			                	   
// 		 			               alert("aaaa");
		 			               var cell3 = $('<div></div>').addClass("media-body videoDatas").attr({href:"<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=" + product.seqNo +"&userAccount=" + product.videoUploaderAccount + "' />"});
			                	   var cell17 = $('<a></a>').attr("href","<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=" + product.seqNo +"&userAccount=" + product.videoUploaderAccount + "' />")
								   
		 			               var cell4 = $('<h5></h5>').attr("class","mt-0").text(product.videoTitle);
			                	   var cell17 = cell17.append(cell4)
			                	   var cell5 = $('<p></p>').attr("class","seqNo" ).text(product.seqNo);
			                	   var cell6 = $('<p></p>').text("觀看次數:" + product.videoViews);
			                	   var cell7 = $('<p></p>').text("影片上傳日期時間:" + product.videoUploadDate);
			                	   var cell8 = $('<p></p>').attr("class","videoTypeOutSide" ).text("影片種類:");
			                	   var cell18 = $('<p></p>').addClass("videoType").text(product.videoType);
			                	   var cell9 = $('<p></p>').text("影片喜歡數:" + product.videoLikes);
			                	   var cell10 = $('<p></p>').text("影片不喜歡數:" + product.videoUnlikes);
			                	   var cell11 = $('<p></p>').text("影片播放清單類別:" + product.videoUploaderType);
			                	   var cell12 = $('<p></p>').attr("class","videoDescriptionOutSide" ).text("影片描述:")
			                	   var cell19 = $('<p></p>').addClass("videoDescription").text(product.videoDescription);
			                	   
			                	   var cell13 = cell3.append([cell17,cell5,cell6,cell7,cell8,cell18,cell9,cell10,cell11,cell12,cell19])
			                	   var cell1 = $('<div></div>').addClass("media mb-4").append([cell1,cell13])
			                	   var cell14 = $('<div></div>').attr("class","col-md-10").append([cell1])
			                	   
			                	   var cell15 = $('<div></div>').attr("class","col-md-2").html('<button class="btn btn-info create-user"><i class="fas fa-edit"></i></button><button class="btn btn-danger delete-video"><i class="fas fa-trash-alt"></i></button>')
			                	   var cell16 = $('<div></div>').attr("class","col-md-12 row divOutside").append([cell14,cell15])
			                	   
// 			                	   var cell1 = $('<td></td>').text(product.ProductID);
// 		 			               var cell2 = $('<td></td>').text(product.ProductName);
// 		 			               var cell3 = $('<td></td>').text(product.UnitPrice);
// 		 			               var cell4 = $('<td></td>').text(product.UnitsInStock);
// 		 			               var cell5 = $('<td></td>').html('<button class="btn btn-danger"><i class="fas fa-trash-alt"></i></button> <button class="btn btn-info"><i class="fas fa-edit"></i></button>');
	
// 		 			               var row = $('<tr></tr>').append([cell1, cell2, cell3, cell4,cell5]);
		 			               docFrag.append(cell16);
		 			        })
		 			        dor.prepend(docFrag);
			                
							
	 	 		    	})
// 						location.reload();
	 	 		    	dialoginsert.dialog( "close" );
	 	 		    	$('#videoFileInsert').empty();
	 	 		    	$('#videoTitleInsert').empty();
	 	 		    	$('#videoDescriptionInsert').empty();
	 	 		    	
		            },
		            error: function (e) {

		                console.log("ERROR : ", e);
		                
		                alert(e);
		                dialog.dialog( "close" );
		            }
		        });
		}
		
		
		$( "#insert-video" ).button().on( "click", function() {
			dialoginsert.dialog( "open" );
		});
		//delete------------------------------------------------------------------------------------------
		var selectedDeletedSeqNo;
		var selectedDivOutside;
		$( 'button:nth-child(2)' ).click(function(){
// 		alert($(this).index('button'));
// 		alert($(this).parents('.row').find('.videoDatas').find('h5').text())
// 			alert("yayayay");
// 			alert($.trim($(this).parents('.divOutside').find('.videoDatas').find('.seqNo').text()));
// 			selectedVideo = $(this);
			$( '#videoTitleDelete' ).empty();
			$( '#videoTitleDelete' ).text($.trim($(this).parents('.divOutside').find('.videoDatas').find('h5').text()))
			$( '#seqNoDelete' ).empty();
			$( '#seqNoDelete' ).val($.trim($(this).parents('.divOutside').find('.videoDatas').find('.seqNo').text()))
			selectedDeletedSeqNo = $( '#seqNoDelete' ).val();
			selectedDivOutside = $(this).parents('.divOutside');
		})
		dialogdelete = $( "#delete-dialog-form" ).dialog({
			autoOpen: false,
			height: 600,
			width: 600,
			modal: true,
			buttons: {
				"確認刪除": deletevideo,
				"取消": function() {
					dialogdelete.dialog( "close" );
				}
			},
			close: function() {
				form[ 0 ].reset();
				allFields.removeClass( "ui-state-error" );
			}
		});
		$( ".delete-video" ).button().on( "click", function() {
			dialogdelete.dialog( "open" );
		});
		
		function deletevideo() {
			
// 				var form = $('#deleteForm')[0];
// 				var data = new FormData(form);
// 				alert("aaaaa");
// 				alert(data);
				var seqNoDeleteEnd = selectedDeletedSeqNo;
// 				alert(seqNoDeleteEnd);
				$.post("deleteVideo.do",{"seqNoDelete":seqNoDeleteEnd},function(data){
					alert("刪除成功");
// 					alert("lalalaala");
					selectedDivOutside.remove();
					dialogdelete.dialog( "close" );
				})
		            
		}
		
	} );
	</script>
</body>

</html>