<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!-- Bootstrap core CSS -->
  <link href="/global/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/global/css/modern-business.css" rel="stylesheet">
  <link href="/global/css/top.css" rel="stylesheet">
  
<style>
.searchButtonli {
	margin-right: 150px;
	width: 60px;
	float: right;
	/* 		display:inline-block */
}

.searchInput {
	
}

.searchInputOutside {
	display: inline-block;
}

.searchButton {
	width: 36px;
	height: 36px;
}
</style>
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
	    <div class="container">
	      <a class="navbar-brand" href="<c:url value='/' />">III Tube</a>
	      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive"
	        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	      </button>
	      <div class="collapse navbar-collapse" id="navbarResponsive">
	        <ul class="navbar-nav ml-auto">
	          <form  name="search" action="<c:url value='/_08_searchVideo/search.do'/>"method="POST" class="search">
		          <li class="nav-item searchInputOutside" >
			          <input name="searchinput" type="text" class="form-control searchInput" placeholder="Search for..." size="60">
	              </li>
	              <li class="nav-item searchButtonli">
	              	<span class="input-group-btn">
		               <button type="submit" class="btn btn-secondary searchButton">
		               	<i class="fas fa-search"></i>
		               </button>
		            </span>
	              </li>
              </form>
	          <li class="nav-item dropdown">
	            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	              	影片錦集
	            </a>
	            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
	              <a class="dropdown-item" href="<c:url value='/watchHistory/WatchHistory.do' />">瀏覽紀錄</a>
	              <a class="dropdown-item" href="<c:url value='/likeUnlikeVideos/ShowLikeVideos.do' />">喜歡的影片</a>
	              <a class="dropdown-item" href="videos/bob">影片管理</a>
	              <a class="dropdown-item" href="<c:url value='/subscriptionUploader/ShowSubscriptionUploader.do' />">訂閱III Tuber</a>
<!-- 	              <a class="dropdown-item" href="portfolio-item.html">Video room</a> -->
	            </div>
	          </li>
<!-- 	          <li class="nav-item dropdown"> -->
<!-- 	            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> -->
<!-- 	              Blog -->
<!-- 	            </a> -->
<!-- 	            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog"> -->
<!-- 	              <a class="dropdown-item" href="blog-home-1.html">Blog Home 1</a> -->
<!-- 	              <a class="dropdown-item" href="blog-home-2.html">Blog Home 2</a> -->
<!-- 	              <a class="dropdown-item" href="blog-post.html">temp</a> -->
<!-- 	            </div> -->
<!-- 	          </li> -->
<!-- 	          <li class="nav-item dropdown"> -->
<!-- 	            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> -->
<!-- 	              Other Pages -->
<!-- 	            </a> -->
<!-- 	            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog"> -->
<!-- 	              <a class="dropdown-item" href="full-width.html">Full Width Page</a> -->
<!-- 	              <a class="dropdown-item" href="sidebar.html">Sidebar Page</a> -->
<!-- 	              <a class="dropdown-item" href="faq.html">FAQ</a> -->
<!-- 	              <a class="dropdown-item" href="404.html">404</a> -->
<!-- 	              <a class="dropdown-item" href="pricing.html">Pricing Table</a> -->
<!-- 	            </div> -->
<!-- 	          </li> -->
	          
	          <li class="nav-item">
	            <a class="nav-link" href="<c:url value='/memberCenter/memberCenter.jsp' />">會員中心</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="<c:url value='_16_/customerreport/contact.jsp' />">客服中心</a>
	          </li>
	          <c:if test="${empty LoginOK}">
	          <li class="nav-item">
	            <a class="nav-link" href="<c:url value='/login/login.jsp' />">登入</a>
	          </li>

	          
	          
	          
	          <li class="nav-item">
	            <a class="nav-link" href="<c:url value='/register/register.jsp' />">註冊</a>
	          </li>
	          </c:if>
	          <c:if test="${!empty LoginOK}">
	          <li class="nav-item">
	            <a class="nav-link" href="<c:url value='/logout/logout.jsp' />">登出</a>
	          </li>
	          
	          <li class="nav-item">
	            <a class="nav-link" href="<c:url value='/memberCenter/memberCenter.jsp' />">${LoginOK.nickname}</a>
	          </li>
	          
	          <li class="nav-item">
	            <a class="nav-link" href=""><img height="30px" width="30px" src='${pageContext.request.contextPath}/global/GetImage.do?userAccount=${LoginOK.userAccount}&type=member'></a>
	          </li>
	          </c:if>
	        </ul>
	      </div>
	    </div>
  </nav>
  
<!--       <script src="../vendor/jquery/jquery.min.js"></script> -->
<!--     <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->