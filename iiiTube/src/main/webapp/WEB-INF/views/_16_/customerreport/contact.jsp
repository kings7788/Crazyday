<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modern Business - Start Bootstrap Template</title>

   <!-- Bootstrap core CSS -->
<link href="<c:url value='/global/vendor/bootstrap/css/bootstrap.min.css'/> " rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value='/global/css/modern-business.css'/>" rel="stylesheet">

  </head>

  <body>

    	 <!-- Navigation -->
<%--     	<jsp:include page="../partial/header.html" /> --%>
<%@ include file="/WEB-INF/views/global/fragment/top.jsp" %>
    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">線上回報單
        <small></small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">Contact</li>
      </ol>

      

      <!-- Contact Form -->
      <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
      <div class="row">
        <div class="col-lg-8 mb-4">
          <h3>讓我們知道您的意見~</h3>
          <form:form modelAttribute="memberFAQBean" name="sentMessage" id="contactForm" enctype="multipart/form-data"  method="post">
            <div class="control-group form-group">
              <div class="controls">
                <label>項目:</label>
<!--                 <input type="text" class="form-control" id="topic"  name="topic" > -->
	                <form:select path="topic" class="form-control"  id="topic"  name="topic">
					  <form:option value="直播">直播</form:option>
					  <form:option value="商城">商城</form:option>
					  <form:option value="競標">競標</form:option>
					  <form:option value="影音">影音</form:option>
					</form:select>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>Account/帳號<span style="color:red">*</span></label>
                <form:input type="text" path="idd" class="form-control" id="account" name="idd" value="${LoginOK.account}" />
                <p class="help-block">${errors.errorIDEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>Name/姓名與職稱<span style="color:red">*</span></label>
                <form:input type="text" path="name" class="form-control" id="nickname"  name="name" value="${LoginOK.name}" required="required" />
                <p class="help-block">${errors.errorNameEmpty}</p>
              </div>
            </div>
           
            <div class="control-group form-group">
              <div class="controls">
                <label>Email/電子信箱<span style="color:red">*</span></label>
                <form:input type="email" path="mailbox" class="form-control" id="email" name="mailbox" value="${LoginOK.email}"/>
                <p class="help-block">${errors.errormailEmpty}</p>
              </div>
            </div>

            <div class="control-group form-group">
              <div class="controls">
                <label>Title/主旨<span style="color:red">*</span></label>
                <form:input type="text" path="title" id="title" name="title"  value="${param.title}"/>
                <p class="help-block">${errors.errortitleeEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>Messeage/聯絡訊息<span style="color:red">*</span></label>
                <form:textarea path="report" rows="4" cols="180"  class="form-control" name="report" value="${param.report}" required="required"/>${param.report}
                <p class="help-block"></p>
              </div>
            </div>

            <div class="control-group form-group">
              <div class="controls">
                <label>照片:</label>
                <form:input type="file" path="videoTitle" class="form-control" id="picture" name="picture" />
                <div class="help-block">${errors.errPicture}</div>
              </div>
            </div>
<!--                    <div class="control-group form-group"> -->
<!--               <div class="controls"> -->
<!--                 <label>照片:</label> -->
<!--                 <input type="file" class="form-control" id="picture" name="picture" > -->
<!--               </div> -->
<!--             </div> -->
<!--             <div id="success"></div> -->
            <!-- For success/fail messages -->
            <input type="submit" class="btn btn-primary" id="sendMessageButton" name="prodaction" value="submit"/>
          </form:form>
        </div>

      </div>
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
   <script src="<c:url value='/global/vendor/jquery/jquery.min.js'/> "></script>
	<script src="<c:url value='/global/vendor/bootstrap/js/bootstrap.bundle.min.js'/> "></script>

    <!-- Contact form JavaScript -->
    <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
<!--     <script src="../js/jqBootstrapValidation.js"></script> -->
<!--     <script src="js/contact_me.js"></script> -->

  </body>

</html>