<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 	<!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<Script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
</head>
<body>

		 <!-- Navigation -->
<%--     	<jsp:include page="../partial/header.html" /> --%>
    	
	
	<div class="card">
		<div class="card-header">jQuery 練習</div>
		<div class="card-body">
			<!-- 每頁不同的內容從這裡開始 -->
			<table id="productTable" class="table table-bordered">
				<thead>
					<tr>
						<th>問題編號</th>
						<th>項目</th>
						<th>Account/帳號</th>
						<th>Name/姓名與職稱</th>
						<th>Email/電子信箱</th>
						<th>Title/主旨</th>
						<th>Messeage/聯絡訊息</th>
						
					</tr>
				</thead>
				<tbody>

				</tbody>
				<tfoot>
<!-- 						<form name="myForm"> -->
<!-- 					<tr> -->
<!-- 							<td><input type="hidden" id="QuesNum" name="QuesNum"><span></span></td> -->
<!-- 							<td><input type="text" style="width: 100px"  -->
<!-- 								class="form-control" id="QuesAcc" name="QuesAcc"   -->
<!-- 								placeholder="帳號"></td> -->
<!-- 							<td><input type="text" style="width: 100px" -->
<!-- 								class="form-control" id="QuesName" name="QuesName" -->
<!-- 								placeholder="姓名與職稱"></td> -->
<!-- 							<td><input type="text" style="width: 100px" -->
<!-- 								class="form-control" id="QuesMail" name="QuesMail" -->
<!-- 								placeholder="電子信箱"></td> -->
<!-- 							<td><input type="text" style="width: 100px" -->
<!-- 								class="form-control" id="QuesTitle" name="QuesTitle" -->
<!-- 								placeholder="主旨"></td> -->
<!-- 							<td><input type="text" style="width: 100px" -->
<!-- 								class="form-control" id="QuesMessage" name="QuesMessage" -->
<!-- 								placeholder="聯絡訊息"></td> -->
							
<!-- 							<td><button id="buttonAdd" type="button" -->
<!-- 									class="btn btn-primary"> -->
<!-- 									<i class="fas fa-plus"></i> -->
<!-- 								</button> -->
<!-- 								<button id="buttonUpdate" type="button" class="btn btn-success"> -->
<!-- 									<i class="fas fa-pencil-alt"></i> -->
<!-- 								</button></td> -->
<!-- 					</tr> -->
			
<!-- 					</form> -->
				</tfoot>
			</table>
			<!-- 每頁不同的內容到這裡結束 -->
		</div>
	</div>
<!-- footer -->
<%-- 	<jsp:include page="../partial/footer.html" /> --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
	
		$.getJSON("../contactservlet",function(datas){
			console.log(datas);
 			var docFrag = $(document.createDocumentFragment());
			   $.each(datas,function(idx,bean){
				   console.log(bean.MemId);
				   
				   console.log(bean.memName);
				   	var cell1 = $('<td></td>').text(bean.MemQuesNum);
				   	var cell2 = $('<td></td>').text(bean.MemTopic);
		               var cell3 = $('<td></td>').text(bean.MemId);
		               var cell4 = $('<td></td>').text(bean.MemName);
 		               var cell5 = $('<td></td>').text(bean.MemEmail);
 		               var cell6 = $('<td></td>').text(bean.MemTitle);
 		               var cell7 = $('<td></td>').text(bean.MemMessage);
		               var cell8 = $('<td></td>').html('<button class="btn btn-danger"><i class="fas fa-trash-alt"></i></button> <button class="btn btn-info"><i class="fas fa-edit"></i></button>');
				       var row = $('<tr></tr>').append([cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8]);
		              docFrag.append(row);						   
		   })
			   $('#productTable>tbody').append(docFrag);
		   })
		})
</script>
</body>
</html>