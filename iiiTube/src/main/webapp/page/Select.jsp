<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%-- <jsp:useBean id="memberBean" class="ch05_09.MemberDAO" />  --%>
<c:set var="subTitle" value="查詢會員資料" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<c:if test="${empty LoginOK}"> 
   <c:set var="target" value="${pageContext.request.servletPath}" scope="session" />
   <c:redirect url="Login.jsp" />
</c:if>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${subTitle}</title>
</head>
<body>
  <c:choose>
      <c:when test="${ empty contextMemberBean}">
          目前尚未有任何會員資料
      </c:when>
      <c:otherwise>
      
            會員資料如下：<BR>
            <TABLE border='1'>
                <TR>
            <TH width=‘120’>會員帳號</TH>
            <TH width=‘120’>密碼</TH>
            <TH width='140'>姓名</TH>
            <TH width='360'>電子郵件</TH>
            <TH width='360'>地址</TH>
            <TH width='130'>電話</TH>
            <TH width='150'>註冊日期</TH>
            <TH width='150'>最後上線時間</TH>
        </TR>
       <c:forEach var="aBean" items="${contextMemberBean}" >
        <TR>
            <TD> ${aBean.account}</TD>
            <TD> ${aBean.password}</TD>
            <TD> ${aBean.name}</TD>
            <TD> ${aBean.email}</TD>
            <TD> ${aBean.address}</TD>
            <TD> ${aBean.phone}</TD>
            <TD> ${aBean.registerdate}</TD>
            <TD> ${aBean.lastlogin}</TD>
         </TR>
        </c:forEach>
    </TABLE>
  </c:otherwise>
</c:choose>
<br>
<!-- 
<a href="../index.jsp">回首頁</a>
 -->
<a href="<c:url value='../MemberCenter.jsp' /> ">回會員中心</a>
</body>
</html>