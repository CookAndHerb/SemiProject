<%@page import="com.recipe.member.vo.MemberVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>template</title>
<style>
/* 본문 내부 간격 */
section#content_body {
	/* padding:20px 0; */
	/* 템플릿 적용시 전체 레이아웃 높이 조정 : 본문 가용화면 확보 : 
	     가용화면(viewport) - 상단메뉴 높이 - 하단 section 높이 - (padding(높이))  */
	min-height:calc(100vh - 50px - 70px);
}


	.container2{
	width:800px;
	margin-left:400px;
	}
	
	.container3{
	width:600px;
	margin-left :120px;
	}
	
	.my_kr{
	display: inline-block;
	width: 100px;
	font-weight: bold;
	}
	
	.my_in{
	display: inline-block;
	width: 300px;}
	
	.my_btn{
	width: 230px;
	height:50px;
	color: white;
	font-weight: bold;
	font-size: 17px;
	background:#b0c364;
	
	margin-left:250px;
	}
</style>
</head>
<body>

	<!-- 상단 공동 메뉴 -->
	<header id="top_section">
		<%@ include file="/template/top.jsp" %>
	</header>
	    <!-- ##### Hero Area Start ##### -->
<%
	MemberVO mvo = (MemberVO)session.getAttribute("member");
%>
 <br><br><br>
 
<div class="container2 col-6">
  <h2 style="color: #b0c364;">탈퇴</h2>
  <br>
  <h5>비밀번호 재확인</h5>
  <p>회원님의 정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인해주세요.</p>

<br>
<hr>
  <form action="/memberWithdraw.do" method="POST" >
    <div class="form-col container3">
      
       <div class="my_kr">아이디</div><div class="my_in"><input type="text" class="form-control" value="${member.userId}"  name="userId" readonly="readonly"></div>
      <br>
      <br>
      <div class="my_kr">
        비밀번호<span style="color:red;">＊</span></div><div class="my_in"><input type="password" class="form-control" placeholder="Enter password" name="userPw" autofocus></div>
      
    </div>
    <hr>
    <br>
    <button type="submit" class="btn my_btn">탈퇴</button>
  </form>
</div>
   
   <br><br><br><br><br><br>
    
    <!-- ##### Catagory Area End ##### -->
	<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
	
</body>
</html>