<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/modern-business.css" rel="stylesheet">

</head>
<body>
	<div class="row">
		<div class="col-lg-8 mb-4">
			<h3>回覆訊息</h3>
			<form action="<c:url value="/ans.do"/>"
				name="sentMessage" id="contactForm" enctype="multipart/form-data"
				method="get">

				 <div class="control-group form-group">
              <div class="controls">
                <label>Messeage/客服回應訊息<span style="color:red">*</span></label>
                <textarea rows="4" cols="180"  class="form-control" name="report"  value="${param.report}" required="required"></textarea>
              </div>
            </div>

				<!-- <div id="success"></div> -->
				<!-- For success/fail messages -->
				<input type="submit" class="btn btn-primary" id="sendMessageButton"
					name="prodaction" value="submit" />
			</form>
		</div>
	</div>
</body>
</html>