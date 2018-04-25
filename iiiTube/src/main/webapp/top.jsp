<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="target" value="${pageContext.request.servletPath}" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Navigation</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/modern-business.css" rel="stylesheet">

</head>
<body>
	<!-- Navigation -->
	<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index.html">III Tube</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
					data-toggle="collapse" data-target="#navbarResponsive"
					aria-controls="navbarResponsive" aria-expanded="false"
					aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><input type="text" class="form-control" placeholder="找點什麼...?"></li>
				<li class="nav-item"><span class="input-group-btn"><button class="btn btn-secondary" type="button">Go!</button></span></li>
				<li><a class="nav-link" href="about.html">商城</a></li>
				<li class="nav-item"><a class="nav-link" href="services.html">直播間</a></li>
				<li class="nav-item"><a class="nav-link" href="contact.html">影片集錦</a></li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownPortfolio" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">物流管理</a>
					<div class="dropdown-menu dropdown-menu-right"
						 aria-labelledby="navbarDropdownPortfolio">
						<a class="dropdown-item" href="portfolio-1-col.html">1 Column Portfolio</a> 
						<a class="dropdown-item" href="portfolio-2-col.html">2 Column Portfolio</a>
						<a class="dropdown-item" href="portfolio-3-col.html">3 Column Portfolio</a>
						<a class="dropdown-item" href="portfolio-4-col.html">4 Column Portfolio</a>
						<a class="dropdown-item" href="portfolio-item.html">Single Portfolio Item</a>
					</div></li>
				<li class="nav-item active dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" 
					   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">客服中心</a>
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
						<a class="dropdown-item" href="blog-home-1.html">Blog Home 1</a>
						<a class="dropdown-item" href="blog-home-2.html">Blog Home 2</a>
						<a class="dropdown-item active" href="blog-post.html">Blog Post</a>
					</div></li>
					
			<!-- 	登入前的導覽列 -->
			
				<c:if test="${empty LoginOK}">

					<li class="nav-item">
						<button class="btn btn-info" type="button" data-toggle="modal" data-target="#popregister">註冊</button>
					</li>
					<li>&nbsp;</li>
					<li class="nav-item">
						<button class="btn btn-success" type="button" data-toggle="modal" data-target="#poplogin">登入</button>
					</li>
			</ul>
		</div>
	</div>
	</nav>
				</c:if>
				
			<!-- 	登入後的導覽列 -->
			
				<c:if test="${not empty LoginOK}">
	
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle"	href="#" 
					   id="navbarDropdownBlog" data-toggle="dropdown"
					   aria-haspopup="true" aria-expanded="false">${LoginOK.account}</a>
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
						<a class="dropdown-item" href="full-width.html">Full Width Page</a>
						<a class="dropdown-item" href="sidebar.html">Sidebar Page</a>
						<a class="dropdown-item" href="faq.html">FAQ</a> 
						<a class="dropdown-item" href="404.html">404</a> 
						<a class="dropdown-item" href="pricing.html">Pricing Table</a>
					</div></li>
				<li>&nbsp;</li>
				<li class="nav-item"><a href="<c:url value="/logout.do"/>"><button class="btn btn-success" type="button" >登出</button></a></li>
			</ul>
		</div>
	</div>
	</nav>
	</c:if>

	<!-- 	註冊彈窗開始	 -->

	<div class="modal fade" id="popregister" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">註冊會員</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					
					<form:form method="POST" modelAttribute="MemberBean" class = "form-horizontal" enctype="multipart/form-data"> 
					
					<label></label>
					
					
					</form:form>


						<form action="<c:url value="/register.do"/>"
 							enctype="multipart/form-data" method="post"> 
							<table class="reg_table">
								<tr>
									<td><label for="Acc">帳號:</label></td>
									<td><input type="text" name="account" id="Acc"	value="${param.mAcc}">
										<div style="color: #FF0000; font-size: 60%; display: inline">${errorMessage.account}</div>
									</td>
								</tr>
								<tr>
									<td><label for="Pwd">密碼:</label></td>
									<td><input type="password" name="password" id="Pwd">
										<div style="color: #FF0000; font-size: 60%; display: inline">${errorMessage.password}</div>
									</td>

								</tr>
								<tr>
									<td><label for="Name">姓名:</label></td>
									<td><input type="text" name="name" id="Name" value="${param.mName}">
										<div style="color: #FF0000; font-size: 60%; display: inline">${errorMessage.name}</div>
									</td>
								</tr>
								<tr>
									<td><label for="eMail">電子信箱:</label></td>
									<td><input type="email" name="email" id="eMail" value="${param.mEmail}">
										<div style="color: #FF0000; font-size: 60%; display: inline">${errorMessage.email}</div>
									</td>
								</tr>
								<tr>
									<td><label for="Addr">地址:</label></td>
									<td><input type="text" name="address" id="Addr" value="${param.mAddr}">
										<div style="color: #FF0000; font-size: 60%; display: inline">${errorMessage.address}</div>
									</td>
								</tr>
								<tr>
									<td>照片:</td>
									<td><input type="file" name="photo"></td>
								</tr>

								<tr>
									<td></td>
									<td><input type="submit" value="註冊" /></td>
								</tr>
							</table>

							<div style="color: #FF0000; display: inline">${ErrorMsg.exception}</div>
						</form>



				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"	data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 	註冊彈窗結束	 -->



	<!--	登入彈窗開始	 -->

	<div class="modal fade" id="poplogin" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">登入系統</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="login_box">


						<form class="login_form" action="<c:url value='/login.do'/>"	method="post">
							<input type="text" name="account" value="${param.mAcc}" placeholder="帳號">
								<small><Font color='red' size="-1">${ErrorMsgKey.AccountEmptyError}</Font></small><br>
							<input type="password" name="password" value="" placeholder="密碼" />
								<small><Font color='red' size="-1">${ErrorMsgKey.PasswordEmptyError}</Font></small><br>
							<Font color='red' size="-1">${ErrorMsgKey.LoginError}&nbsp;</Font>
							<div class="sub_box">
								<input class="sub_but" type="submit" value="登入" />
							</div>
						</form>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>

	<!--	登入彈窗結束 	-->

	<!-- Bootstrap core JavaScript -->
	<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script>
		
	</script>


</body>
</html>