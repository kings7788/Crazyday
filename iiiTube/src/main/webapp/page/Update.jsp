<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>會員資料修改</title>
</head>
<body>

<jsp:include page="/top.jsp" />
	
	
	
	<form action="update.do" method="post" enctype="multipart/form-data">

		<table>
			<thead>
				<tr>
					<td>修改會員資料</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="file" name="photo"></td>
				</tr>
				<tr>
					<td>帳號:</td>
					<td><input type="text" name="account" value="${LoginOK.account}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>密碼:</td>
					<td><input type="password" name="password" value="${MemberBean.password}"></td>
					<td><span>${errorMessage.password}</span></td>
				</tr>
				<tr>
					<td>電子信箱:</td>
					<td><input type="email" name="email" value="${MemberBean.email}"></td>
					<td><span>${errorMessage.email}</span></td>
				</tr>
				<tr>
					<td>地址:</td>
					<td><input type="text" name="address"
						value="${MemberBean.address}"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="修改完成"><input type="reset" value="還原資料"></td>

				</tr>
				<tr>
					<td><span>${errorMessage.sql}<c:if test="${not empty Update}">${Update.name}資料更新成功!</c:if></span></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>