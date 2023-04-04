<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="./js/memberdelete.js"></script>
<div class="form">      
      <form class="login-form" name="frmlogin">
        <input type="text" placeholder="아이디" id="mid" name="mid"/>
        <input type="password" placeholder="비밀번호" id="mpw" name="mpw"/>
        <input type="button" onClick="deletetest()" value="회원탈퇴">
      </form>
    </div>
</body>
</html>