2<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />  

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
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
      <form class="login-form">
        <input type="text" placeholder="아이디"/>
        <input type="password" placeholder="비밀번호"/>
        <button>login</button>
        <p class="message">회원이 아니신가요?? <a href="./signin.jsp">회원가입하기</a></p>
      </form>
    </div>
  </div>
  <link rel="stylesheet" href="./css/login.css">
  
  
</body>
</html>