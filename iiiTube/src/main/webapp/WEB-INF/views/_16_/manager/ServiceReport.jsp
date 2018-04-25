<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:if test="${empty LoginOK}">
	<c:redirect url="ManagerLogin.jsp" />
	</c:if>
	<title>回應問題頁面</title>
	<!-- Custom styles for this template -->
    <link href="../css/modern-business.css" rel="stylesheet">
	<!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
</head>
<body>
 	<!-- Navigation -->
<%--     <jsp:include page="../partial/header.html" /> --%>
	<!-- Page Content -->
    <div class="container">
	<!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">會員回報單 編號:${HaveBean.memberQuesNum}
        <small></small>
      </h1>	
      
    
      <!-- Contact Form -->
      <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
      <div class="row">
        <div class="col-lg-8 mb-4">
          <h3></h3>
          <form  action="<c:url value=""/>" name="sentMessage" id="contactForm" enctype="multipart/form-data"  method="post">
            <div class="control-group form-group">
              <div class="controls">
                <label>項目:</label>
                 <input type="text" class="form-control" id="account" name="idd" value="${HaveBean.memTopic}" readonly>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>Account/帳號<span style="color:red">*</span></label>
                <input type="text" class="form-control" id="account" name="idd" value="${HaveBean.memId}" readonly>
                <p class="help-block"></p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>Name/姓名與職稱<span style="color:red">*</span></label>
                <input type="text" class="form-control" id="nickname"  name="name" value="${HaveBean.memName}" readonly>
              </div>
            </div>
           
            <div class="control-group form-group">
              <div class="controls">
                <label>Email/電子信箱<span style="color:red">*</span></label>
                <input type="email" class="form-control" id="email" name="mailbox" value="${HaveBean.memMail}" readonly>
              </div>
            </div>

            <div class="control-group form-group">
              <div class="controls">
                <label>Title/主旨<span style="color:red">*</span></label>
                <input type="text" class="form-control" id="title" name="title"  value="${HaveBean.memTitle}" readonly >
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>Messeage/聯絡訊息<span style="color:red">*</span></label>
                <textarea rows="4" cols="180"  class="form-control" name="report" value="" readonly>${HaveBean.memAsk}</textarea>
              </div>
            </div>

            <div class="control-group form-group">
              <div class="controls">
                <label>照片:</label>
                 <img height='500' width='500' 
         	src='${pageContext.servletContext.contextPath}/getImageServlet?id=${HaveBean.memberQuesNum}'>             
              </div>
            </div>
               
            <div id="success"></div>
            <!-- For success/fail messages -->
            <input type="button" class="btn btn-primary" id="sendMessageButton" name="prodaction" value="回覆"/>
          </form>
        </div>

      </div>
      <!-- /.row -->

	</div>
<%-- 	<jsp:include page="../partial/footer.html" /> --%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>