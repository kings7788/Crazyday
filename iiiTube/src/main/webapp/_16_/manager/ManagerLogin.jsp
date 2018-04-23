<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>管理員登入</title>
</head>
<body>
	<div class="login_box">
		<h2 class="box_title">管理員登入</h2>
		
		<form class="login_form" action="<c:url value='/manager/Managerlogin.do'/>" method="post">
			
			<input type="text" name="mAcc" value="${param.mAcc}" placeholder="帳號" />
			 <small><Font color='red' size="-1">${ErrorMsgKey.AccountEmptyError}</Font></small><br /> 
			
			<input type="password" name="mPwd" value="${param.mPwd}" placeholder="密碼" />
			<small><Font color='red'  size="-1">${ErrorMsgKey.PasswordEmptyError}</Font></small><br />
			<Font color='red' size="-1">${ErrorMsgKey.LoginError}&nbsp;</Font>
			
			<div class="sub_box">
				<input class="sub_but" type="submit" value="登入" />
			</div>
		</form>
	</div>
</body>
</html>