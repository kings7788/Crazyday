<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>線上回報單填寫</title>
<style></style>
</head>
<body>
<h3>Welcome, </h3>
<h3>線上回報單填寫</h3>
	<form action="<c:url value="/customerreport/qa.controller" />" method="get">
		<table>
		<tr>
		<td>項目 :</td>
		<td><input type=text name="topic" value="${param.topic}"/></td>
		</tr>
		<tr>
		<td>帳號:</td>
		<td><input type="text" name="idd" value="${LoginOK.account}" readonly="readonly"/></td>
		</tr>
		<tr>
		<td>姓名:</td>
		<td><input type="text" name="name" value="${LoginOK.name}" readonly="readonly"/></td>
		<tr>
		<td>信箱:</td>
		<td><input type="text" name="mailbox" value="${LoginOK.email}"/></td>
		</tr>
		<tr>
		<td>主旨:</td>
		<td><input type="text" name="title" value="${param.title}"></td>
		</tr>
		<tr>
		<td>問題敘述:</td>
		<td><textarea rows="4" cols="50" name="report" value="${param.report}"></textarea></td>
		</tr>
		<tr>
		<td align="right">
			<input type="submit" name="prodaction" value="submit">
			<input type="reset" name="prodaction" value="clean">
		</td>		
		</tr>

				
		
		</table>
	</form>
</body>
</html>