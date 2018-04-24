<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
	<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>註冊管理員</title>
</head>
<body>
	<div class="reg_box">

		<h2 class="box_title">註冊管理會員</h2>
		
		<form action="<c:url value="/manager/man.controller"/>" method="post">
			<table class="reg_table"> 
				<tr>
					<td><label for="Acc">帳號:</label></td>
					<td><input type="text" name="mAcc" id="Acc" value="${param.mAcc}" />
					<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.acc}</div>
					</td>
				</tr>
				<tr>
					<td><label for="Pwd">密碼:</label></td>
					<td><input type="password" name="mPwd" id="Pwd" value="${param.mPwd}"/>
					<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.password}</div>
					</td>
					
				</tr>
				<tr>
					<td><label for="Name">姓名:</label></td>
					<td><input type="text" name="mName" id="Name" value="${param.mName}"/>
					<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.name}</div>
					</td>
				</tr>
<!-- 				<tr> -->
<!-- 					<td><label for="eMail">電子信箱:</label></td> -->
<%-- 					<td><input type="email" name="mEmail" id="eMail" value="${param.mEmail}"/> --%>
<%-- 					<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.email}</div> --%>
<!-- 					</td> -->
<!-- 				</tr> -->
					<tr>
					<td></td>
					<td><input type="submit" value="送出" /></td>
					</tr> 
			</table>
					
		<div style="color:#FF0000; display: inline">${ErrorMsg.exception}</div>
		</form>
<a href="<c:url value='ManageCenter.jsp' /> ">回管理員中心</a>

	</div>
</body>
</html>