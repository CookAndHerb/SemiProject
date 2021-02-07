<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CookCookRecipe</title>
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
</style>

</head>
<body>
<!--  메인 페이지 -->

<!-- 상단 공동 메뉴 -->
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>

	    
	    
<!-- content 부분-->
 <section class="container p-5 col-sm-4" method="POST">
 			<div class="login">Login</div>
            <hr>
            <form action="/memberLogin.do" method="post">
                <div class="form-inline">
                  <input type="text" class="form-control col-12" placeholder="아이디를 입력하세요" name="userId">
                </div>
                <br>
                <div class="form-inline">
                  <input type="password" class="form-control col-12" placeholder="비밀번호를 입력하세요" name="userPw">
                </div><br>
                <div class="find">
				<a href="/views/memberFindId.jsp" class="find-font">아이디 찾기</a> | 
				<a href="/views/memberFindPw.jsp" class="find-font">비밀번호 찾기</a>
			</div><br>
                <button type="submit" class="btn btn-light btn-block ">로그인</button>
                <button type="button" class="btn btn-light btn-block ">회원가입</button>
                <div class="form-group form-check float-right">                  
                </div>
              </form>
         
        </section>   
   
    
    <!-- ##### Catagory Area End ##### -->
	
	<br><br><br>

<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
</body>
</html>