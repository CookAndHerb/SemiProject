<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>
	.login{
		font-size: 25px;
		font-weight: 900;
		color: #b0c364;
	}
	.find{
		text-align: right;
	}
	.find-font{
		font-size: 13px;
		font-weight: normal;
		color: #b0c364;
	}
	.id{
		color: black;
		font-size: 18px;
	}
</style>
</head>
<body>
	<!-- 상단 공동 메뉴 -->
	<header id="top_section">
			<%@ include file="/template/top.jsp" %>
	</header>
	
	<!-- content 부분-->
 <section class="container p-5 col-sm-4">
 			<div class="login">ID 찾기 결과</div>
            <hr>
           <p align="center"> 회원님의 ID는 [  <b class="id">${userId}</b> ]입니다. </p>
         	 <button type="button" class="btn btn-light btn-block " onclick="location.href='/memberLogin.do'">로그인</button>
         	  <button type="button" class="btn btn-light btn-block " onclick="location.href='/memberFindPw.do'">비밀번호 찾기</button>
        </section>   
   
    
    <!-- ##### Catagory Area End ##### -->
	
	<br><br><br>
	
	<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
</body>
</html>