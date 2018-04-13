<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>會員中心-首頁</title>
</head>
<body>

<c:if test="${empty LoginOK}">
	<a href="page/Register.jsp">會員註冊</a><br>
	<a href="page/Login.jsp">會員登入</a><br>
</c:if>
<c:if test="${not empty LoginOK}">

	<a href="<c:url value="page/Select.jsp"/>">查詢會員</a><br>
	<a href="<c:url value="page/Update.jsp"/>">修改會員資料</a><br>
	<a href="<c:url value="customerreport/contact.jsp"/>">客服中心</a><br>
	<a href="<c:url value="page/Logout.jsp"/>">會員登出</a>
	<a href="">商品上架</a>
</c:if>	
</body>
</html>	