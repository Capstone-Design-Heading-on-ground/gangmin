<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />  
<%
	String create = "";
	create = request.getParameter("create");
	if(create==null || "null".equals(create)){
		create = "normal";
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
    <%
		if(create.equals("success")){
	%>
		<script>alert("회원가입이 완료되었습니다.");</script>
	<%
		}else if(create.equals("login_invalid")){
  	%>
  		<script>alert("아이디가 존재하지 않습니다.");</script>
  	<%
		}else if(create.equals("unmatched_password")){
			
  	%>
  		<script>alert("비밀번호가 일치하지 않습니다.")</script>
  	<%
		}
  	%>
</head>
<body>
<script src="./js/login2.js"></script>
  <div class="vanner">
    <center>
      <img src="./images/gangmin.jpg" width="800">
    </center>
    <style>
    *{
      margin: 0%;
      padding: 0%;
    }
    .vanner {
      width: 100%;
      background-color:white;
      border-color:white;
    }
    </style>
  </div>
  <div class="login-page">    
    <div class="form">      
      <form class="login-form" name="frmlogin">
        <input type="text" placeholder="아이디" id="mid" name="mid"/>
        <input type="password" placeholder="비밀번호" id="mpw" name="mpw"/>
        <input type="button" onClick="test()" value="LOGIN">
        <p class="message">회원이 아니신가요?? <a href="./signin.jsp">회원가입하기</a></p>
      </form>
    </div>
  </div>
  <link rel="stylesheet" href="./css/login.css">
  
</body>
</html>