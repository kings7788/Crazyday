var selectedVideo;
$( 'button:nth-child(1)' ).click(function(){
	selectedVideo = $(this);
//	alert("aaaaa");
	$( '#videoTitle' ).empty();
	$( '#videoDescription' ).empty();
	$( '#seqNo' ).empty();
	$( '#videoTitle' ).val($.trim($(this).parents('.divOutside').find('.videoDatas').find('h5').text()))
	$( '#videoDescription' ).val($.trim($(this).parents('.divOutside').find('.videoDatas').find('.videoDescription').text()))
	$( '#seqNo' ).val($.trim($(this).parents('.divOutside').find('.videoDatas').find('.seqNo').text()))
	$('#myForm :input[value="'+$(this).parents('.divOutside').find('.videoDatas').find('.videoType').text()+'"]').prop("checked",true)
//	alert($(this).parents('.divOutside').find('.videoDatas').find('.videoType').text());
})
$( function() {
	var dialog, form,
	tips = $( ".validateTips" );
	function updateTips( t ) {
		tips.text( t ).addClass( "ui-state-highlight" );
		setTimeout(function() {
			tips.removeClass( "ui-state-highlight", 1500 );
		}, 500 );
	}
	function addUser() {
		var form = $('#myForm')[0];
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
				console.log("SUCCESS : ", data);
				selectedVideo.parents('.divOutside').find('.videoDatas').find('h5').text($('#videoTitle').val());
				selectedVideo.parents('.divOutside').find('.videoDatas').find('.videoDescription').text($('#videoDescription').val());
				selectedVideo.parents('.divOutside').find('.videoDatas').find('.videoType').text($('input[name=videoType]:checked').val());
				var pic = selectedVideo.parents('.divOutside').find('.picVideo').attr("src") + "&timestamp=" + new Date().getTime();
				selectedVideo.parents('.divOutside').find('.picVideo').removeAttr("src").attr("src",pic);
				dialog.dialog( "close" );
			},
			error: function (e) {
				console.log("ERROR : ", e);
				alert(e);
				dialog.dialog( "close" );
			}
		});
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
//			allFields.removeClass( "ui-state-error" );
		}
	});
	form = dialog.find( "form" ).on( "submit", function( event ) {
		event.preventDefault();
		addUser();
	});
	$( ".create-user" ).button().on( "click", function() {
		dialog.dialog( "open" );
	});
	dialoginsert = $( "#insert-dialog-form" ).dialog({
		autoOpen: false,
		height: 800,
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
//			allFields.removeClass( "ui-state-error" );
		}
	});
	function dataURItoBlob(dataURI) {
	    // convert base64/URLEncoded data component to raw binary data held in a string
	    var byteString;
	    if (dataURI.split(',')[0].indexOf('base64') >= 0)
	        byteString = atob(dataURI.split(',')[1]);
	    else
	        byteString = unescape(dataURI.split(',')[1]);

	    // separate out the mime component
	    var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];

	    // write the bytes of the string to a typed array
	    var ia = new Uint8Array(byteString.length);
	    for (var i = 0; i < byteString.length; i++) {
	        ia[i] = byteString.charCodeAt(i);
	    }

	    return new Blob([ia], {type:mimeString});
	}
	function insertvideo() {
		alert("bbbbb");
		var form = $('#insertForm')[0];
		console.log(form);
		alert("ccccc");
		var data = new FormData(form);
		console.log(data);
		alert("eeeee");
		var imgbuffer = document.getElementById("myCanvas").toDataURL("image/jpeg", 1.0);
		var blob = dataURItoBlob(imgbuffer);
		data.append("videoImage",blob,"videoImage.jpeg")
		console.log("data =    "+data);
		alert("aaaaaa");
		$.ajax({
			type: "POST",
			enctype: 'multipart/form-data',
			url: "add",
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
					$.each(datas, function (idx,product) {
						var cell1 = $('<a></a>').attr("href","<c:url value='/_07_watchHistory/watchHistory.do?videoSeqNo=" + product.seqNo +"&userAccount=" + product.videoUploaderAccount + "' />")
						var cell2 = $('<img></img>').addClass("d-flex mr-3 picVideo").attr({height:"200px" , width:"400px", src:"/iiiProject3/_01_global/getImage?videoSeqNo=" + product.seqNo +"&type=VIDEO"	}) 
						var cell1 = cell1.append(cell2)
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
						docFrag.append(cell16);
					})
					dor.prepend(docFrag);
				})
				dialoginsert.dialog( "close" );
				$('#videoFileInsert').empty();
				$('#videoTitleInsert').empty();
				$('#videoDescriptionInsert').empty();
			},
			error: function (e) {
				console.log("ERROR : " + e);
				alert("ERROR : " + e);
				dialog.dialog( "close" );
			}
		});
	}
			
			
	$("#insert-video").button().on( "click", function() {
		dialoginsert.dialog( "open" );
	});
	
	
    $("#videoFileInsert").change(function(){
        var objUrl = getObjectURL(this.files[0]) ;
        console.log("objUrl = "+objUrl) ;
        if (objUrl) {
            $("#videoPreview").attr("src", objUrl) ;
        }
        var v = document.getElementById("videoPreview");
        var c = document.getElementById("myCanvas");
        var ctx = c.getContext("2d");
        var i;
        i = window.setInterval(function() {ctx.drawImage(v,5,5,260,125)},20)
        v.addEventListener("play", function() {
        		i = window.setInterval(function() {
        				ctx.drawImage(v,5,5,260,125)
        				
        			},20);
        	}, false);
        v.addEventListener("pause", function() {window.clearInterval(i);}, false);
        v.addEventListener("ended", function() {clearInterval(i);}, false); 
    }) ;

    //建立一个可存取到该file的url
    function getObjectURL(file) {
        var url = null ;
        if (window.createObjectURL!=undefined) { // basic
            url = window.createObjectURL(file) ;
        } else if (window.URL!=undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file) ;
        } else if (window.webkitURL!=undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file) ;
        }
        return url ;
    }

	//delete------------------------------------------------------------------------------------------
	var selectedDeletedSeqNo;
	var selectedDivOutside;
	$( 'button:nth-child(2)' ).click(function(){
		$( '#videoTitleDelete' ).empty();
		$( '#videoTitleDelete' ).text($.trim($(this).parents('.divOutside').find('.videoDatas').find('h5').text()))
		$( '#seqNoDelete' ).empty();
		$( '#seqNoDelete' ).val($.trim($(this).parents('.divOutside').find('.videoDatas').find('.seqNo').text()))
		selectedDeletedSeqNo = $('#seqNoDelete').val();
		selectedDivOutside = $(this).parents('.divOutside');
	})
	dialogdelete = $("#delete-dialog-form").dialog({
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
			form[0].reset();
//			allFields.removeClass( "ui-state-error" );
		}
	});
	$(".delete-video").button().on("click",function(){
		dialogdelete.dialog("open");
	});
	function deletevideo() {
		var seqNoDeleteEnd = selectedDeletedSeqNo;
		$.post("deleteVideo.do",{"seqNoDelete":seqNoDeleteEnd},function(data){
			alert("刪除成功");
			selectedDivOutside.remove();
			dialogdelete.dialog( "close" );
		})
	}
});