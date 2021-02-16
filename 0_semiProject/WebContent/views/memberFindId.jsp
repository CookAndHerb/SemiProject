<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 			<div class="login">ID 찾기</div>
            <hr>
            <form action="/memberFindId.do" method="post">
                <div class="form-inline">
                  <input type="text" class="form-control col-12" placeholder="이름을 입력하세요" name="userName" required>
                </div>
                <br>
                <div class="form-inline">
                  <input type="text" class="form-control col-12" placeholder="번호를 입력하세요('-'제외)" name="userPhone" required>
                </div><br>
                <button type="submit" class="btn btn-light btn-block ">ID 찾기</button>
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