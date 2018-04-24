<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理員中心</title>
</head>
<body>
<c:if test="${empty LoginOK}">
	<a href="Register.jsp">管理員註冊</a><br>
	<a href="ManagerLogin.jsp">管理員登入</a><br>
</c:if>
<c:if test="${not empty LoginOK}">
	<h2>${LoginOK.manageId}管理員，您好</h2>
		
	<a href="<c:url value="ManageContactList.jsp"/>">查詢會員問題回復</a><br>
	<a href="<c:url value="../ManageContactServlet"/>">查詢會員問題回復JSP</a><br>
	<a href="<c:url value="Logout.jsp"/>">管理員登出</a>
</c:if>	

</body>
</html>