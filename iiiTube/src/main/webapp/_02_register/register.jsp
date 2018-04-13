<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modern Business - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/modern-business.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->

	<jsp:include page="/fragment/top.jsp" />

    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">註冊
        <small>Subheading</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">註冊</li>
      </ol>

      

      <!-- Contact Form -->
      <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
      <div class="row">
        <div class="col-lg-8 mb-4">
          <h3>Send us a Message</h3>
          <form ENCTYPE="multipart/form-data" name="registerMember" action="<c:url value='registerMember.do' />" method="POST" novalidate>
            <div class="control-group form-group">
              <div class="controls">
                <label>account:</label>
                <input type="text" class="form-control" id="account" name="account" value="${param.account}" required data-validation-required-message="Please enter your name.">
                <p class="help-block">${ErrorMsg.errorAccountEmpty}${ErrorMsg.errorAccountDup}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>password:</label>
                <input type="password" class="form-control" id="password"  name="password" value="${param.password}"  required data-validation-required-message="Please enter your phone number.">
              	<p class="help-block">${ErrorMsg.errorPasswordEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>checkpassword:</label>
                <input type="password" class="form-control" id="checkpassword"  name="checkpassword" value="${param.checkpassword}"  required data-validation-required-message="Please enter your phone number.">
              	<p class="help-block">${ErrorMsg.errorCheckpasswordEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>nickname:</label>
                <input type="text" class="form-control" id="nickname"  name="nickname" value="${param.nickname}"  required data-validation-required-message="Please enter your email address.">
              	<p class="help-block">${ErrorMsg.errorNicknameEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>firstname:</label>
                <input type="text" class="form-control" id="firstname" name="firstname"  value="${param.firstname}"  required data-validation-required-message="Please enter your email address.">
              	<p class="help-block">${ErrorMsg.errorFirstnameEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>lastname:</label>
                <input type="text" class="form-control" id="lastname" name="lastname"  value="${param.lastname}"  required data-validation-required-message="Please enter your email address.">
              	<p class="help-block">${ErrorMsg.errorLastnameEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>cellphone:</label>
                <input type="text" class="form-control" id="cellphone" name="cellphone"  value="${param.cellphone}"  required data-validation-required-message="Please enter your email address.">
             	<p class="help-block">${ErrorMsg.errorCellphoneEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>address:</label>
                <input type="text" class="form-control" id="address" name="address"  value="${param.address}"  required data-validation-required-message="Please enter your email address.">
              	<p class="help-block">${ErrorMsg.errorAddressEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>email:</label>
                <input type="email" class="form-control" id="email" name="email"  value="${param.email}"  required data-validation-required-message="Please enter your email address.">
              	<p class="help-block">${ErrorMsg.errorEmailEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>birthday:</label>
                <input type="date" class="form-control" id="birthday" name="birthday"  value="${param.birthday}"  required data-validation-required-message="Please enter your email address.">
              	<p class="help-block">${ErrorMsg.errorBirthdayEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>gender:</label>
               	男:<input type="radio" id="gender" name="gender" value="male" required data-validation-required-message="Please enter your email address.">
               	 女:<input type="radio" id="gender"  name="gender" value="female" required data-validation-required-message="Please enter your email address.">
              	<p class="help-block">${ErrorMsg.errorGenderEmpty}</p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>照片</label>
                <input type="file" class="form-control" id="picture" name="picture"  required data-validation-required-message="Please enter your email address.">
              	<p class="registerdataerror">${ErrorMsg.errPicture}</p>
              </div>
            </div>
            <div id="success"></div>
            <!-- For success/fail messages -->
            <button type="submit" class="btn btn-primary" id="sendMessageButton">Send Message</button>
          </form>
        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

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

    <!-- Contact form JavaScript -->
    <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
    <script src="../js/jqBootstrapValidation.js"></script>
    <script src="../js/contact_me.js"></script>

  </body>

</html>
