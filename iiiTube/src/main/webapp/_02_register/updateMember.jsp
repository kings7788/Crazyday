<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>註冊</title>
<script type="text/javascript">
//由<body>的onLoad事件處理函數觸發此函數
function setFocusToUserId(){   
	 document.forms[0].mid.focus();   // 將游標放在mid欄位內
}
</script>
<style>
	*{
		padding:0px;
		margin:0px;
	}
	.allPage{
		margin: 3em;
		text-align: center;
		
	}
	.allPage h2{
		margin-bottom: 1em;
/* 		border: red solid 1px; */
	}
	.updateMemberForm{
		display: inline-block;
		text-align: center;
		width:30em;
/* 		border: red solid 1px; */
	}
	
	.updateMemberForm fieldset{
		display: inline-block;
		text-align: left;
		width:30em;
		border-radius: 20px;
/* 		border: blue solid 1px; */
		
	}
	.updateMemberForm fieldset legend{
		margin-left: 1.5em;		
	}
	
	.updateMemberForm fieldset div{
		display: inline-block;
/* 		border-bottom: solid #E8E8E8 1px; */
		width: 95%;
		margin: 0.25em 0em 0.25em 1em;
/* 		border: yellow solid 1px; */
	}
	
	
	.registerdatatitle{
		width: 5em;
		display:inline-block;
		margin: 0.5em 0em;
		font-size: 20px;
	}
	
	.registerdatainput{
		width: 8em;
		display:inline;
		margin: 2em;
	}
	
	.registerdataerror{
		color: red;
		display:inline;
		font-size: 0.5em;
	}
	
	.sub{
		margin: 0.5em;
		
	}
	.sub input{
		margin: 1em;
		border-radius: 100px;
		width: 5em;
		height: 2em;
		font-size:1em;
	}
	
	.pictureDiv input{
		margin-rigth: 0px;
/* 		border: red solid 1px; */
		width: 14em;
	}
	
</style>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
<div class="allPage">

		<h2>修改基本資料</h2>
		<form ENCTYPE="multipart/form-data" name="registerMember" action="<c:url value='updateMember.do' />" method="POST" class="updateMemberForm">
																		
			
			<fieldset>
			<legend>個人資料</legend>
					<p class="registerdatainput"><input type="hidden" name="account" id="account1" value="${LoginOK.account}"></p>
					<p class="registerdataerror">${MsgOK.UpdateOK}</p>
				
				
				
				<div>
					<p class="registerdatatitle"><label for="nickname1"><font>暱稱:</font></label></p>
					<p class="registerdatainput"><input type="text" name="nickname" id="nickname1" value="${param.nickname}"></p>
				</div>
				
				<div>
					<p class="registerdatatitle"><label for="firstname1"><font>名字:</font></label></p>
					<p class="registerdatainput"><input type="text" name="firstname" id="firstname1" value="${param.firstname}"></p>
				</div>
				
				<div>
					<p class="registerdatatitle"><label for="lastname1"><font>姓氏:</font></label></p>
					<p class="registerdatainput"><input type="text" name="lastname" id="lastname1" value="${param.lastname}"></p>
				</div>
				
				<div>
					<p class="registerdatatitle"><label for="cellphone1"><font>電話:</font></label></p>
					<p class="registerdatainput"><input type="text" name="cellphone" id="cellphone1" value="${param.cellphone}"></p>
				</div>
				<div>
					<p class="registerdatatitle"><label for="address1"><font>地址:</font></label></p>
					<p class="registerdatainput"><input type="text" name="address" id="address1" value="${param.address}"></p>
				</div>
				<div>
					<p class="registerdatatitle"><label for="email1"><font>E-mail:</font></label></p>
					<p class="registerdatainput"><input type="email" name="email" id="email1" value="${param.email}"></p>
				</div>
				
				<div>
					<p class="registerdatatitle"><label for="birthday1"><font>生日:</font></label></p>
					<p class="registerdatainput"><input type="date" name="birthday" id="birthday1"></p>
				</div>
				
				<div>
					<p class="registerdatatitle"><font>性別:</font></p>
					<p class="registerdatainput"><label for="male1"><font>男:</font></label><input type="radio" name="gender" value="male" id="male1" ><label for="female1"><font>女:</font></label><input type="radio" name="gender" value="female" id="female1"></p>
				</div>
				
				<div class="pictureDiv">
					<p class="registerdatatitle"><label for="picture1"><font>照片:</font></label></p>
					<p class="registerdatainput"><input type="file" name="picture" id="picture1"></p>
				</div>
				
				
			</fieldset>
				<div class="sub">
					<p><input type="submit" value="送出"><input type="reset" value="重新填寫"></p>
				</div>
		</form>
	</div>
	<c:remove var="MsgOK" scope='session' />
</body>
</html>