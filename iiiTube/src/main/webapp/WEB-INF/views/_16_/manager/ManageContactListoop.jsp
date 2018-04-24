<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page import="org.iii.ee10087.itube.QA.bean.*"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <jsp:useBean id="MemberQABean" class="org.iii.ee10087.itube.QA.bean.MemberQABean" --%>
<%-- 	scope="page" /> --%>
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
<%-- 	<jsp:include page="../partial/header.html" /> --%>
	<div class="card">
		<div class="card-header">待處理問題回報</div>
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
					<c:forEach var="anQABean" varStatus="stat" items="${MapKey}">
						<tr>
							<td><a
								href="../contactlistdetail.do?quesnum=${anQABean.memberQuesNum}">${anQABean.memberQuesNum}</a></td>
							<td>${anQABean.memTopic }</td>
							<td>${anQABean.memId }</td>
							<td>${anQABean.memName }</td>
							<td>${anQABean.memMail }</td>
							<td>${anQABean.memTitle }</td>
							<td>${anQABean.memAsk }</td>
<%-- 							<td>${anQABean.mem }</td> --%>
						</tr>
					</c:forEach>

				</tbody>
				<tfoot>
				</tfoot>
			</table>
		</div>
	</div>
	<!-- 每頁不同的內容到這裡結束 -->
<%-- 	<jsp:include page="../partial/footer.html" /> --%>
</body>
</html>