<%@page import="com.recipe.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
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
	#key, #getKey, #waitmsg{
		display: none;
	}
	#getKey, #keyBtn{
		color: #b0c364;
		border: 1px solid #b0c364;
		background: white;
	}
	#submitBtn{
		background: #b0c364;
		color: white;
	}
</style>

</head>
<body>
<%
	MemberVO mvo = (MemberVO)session.getAttribute("member");
%>

<!--  메인 페이지 -->

<!-- 상단 공동 메뉴 -->
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>

	    
	    
<!-- content 부분-->
 <section class="container p-5 col-sm-4">
 			<div class="login" >PW 찾기</div>
            <hr>
            <form action="/memberFindPw.do" method="post">
                <div class="form-inline">
                  <input type="text" class="form-control col-12" placeholder="아이디를 입력하세요" id="userId" name="userId" required>
                </div>
                <br>
                <div class="form-inline">
                <input type="hidden" name="findpw" value="findpw" />
                  <input type="email" class="form-control col-9" placeholder="이메일을 입력하세요" id="userEmail" name="userEmail" required>
                  <input type="button" class="btn btn-light btn-block col-3" id="keyBtn" value="인증번호" ><br><br>
                  <p id="waitmsg">전송완료 창이 뜰 때까지 잠시만 기다려주세요.</p>
                  <input type="text" class="form-control col-9" id="key" placeholder="인증번호를 입력하세요" name="authenticationUser">
                  <input type="button" class="btn btn-light btn-block col-3" id="getKey" value="확인"><br><br>
                </div><br>
                <button type="submit" class="btn btn-light btn-block" id="submitBtn" disabled>비밀번호 변경</button>
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
	
	<script type="text/javascript">
		$(function(){
			$('#keyBtn').click(function(){
				$('#key').css('display','inline-block');
				$('#getKey').css('display','inline-block');
				$('#waitmsg').css('display','inline-block');
			});
		});
		
		$(function(){ //onload()
			$('#keyBtn').on('click', function(){
				
				var userId = $('#userId').val();
				var userEmail = $('#userEmail').val();

				$.ajax({
					url:'/memberFindPwEmail.do',
					data: {"userId":userId, "userEmail":userEmail},
					type: 'post',
					success : function(data){
						if(data.ok==""){
							alert('아이디와 이메일 주소가 일치하지 않습니다.');
							console.log("서버 호출을 정상적으로 완료하였습니다.");
							console.log(data.ok);
						}else{
							alert('메일 전송 완료. 인증번호를 확인하세요.');
							console.log("서버 호출을 정상적으로 완료하였습니다.");
							console.log(data.ok);
						}
						 $('#waitmsg').css('display','none'); 
					},
					 error : function(data){
						alert('전송 오류. 아이디와 비밀번호를 확인해주세요.');
						console.log("서버 호출을 정상적으로 처리하지 못 했습니다.");
						console.log(data.ok);
						$('#waitmsg').css('display','none');
					} 
				});
			});
		});
		
		$(function(){ //onload()
			$('#getKey').on('click', function(){
				
				var keyStr = $('#key').val();
				
				$.ajax({
					url:'/emailKey.do',
					data: {"authenticationUser" : keyStr}, //{key : value} 값을 url에 전송
					type: 'get',
					success : function(data){
						if(data.ok=="ok"){
						alert('인증 완료');
						console.log("서버 호출을 정상적으로 완료하였습니다.");
						console.log(data.ok);
						
						$('#submitBtn').removeAttr("disabled");
						}else{
							alert('인증번호가 일치하지 않습니다.');
							console.log("서버 호출을 정상적으로 완료하였습니다.");
							console.log(data.ok);
						}
					},
					error : function(){
						alert('인증번호가 일치하지 않습니다.');
						console.log("서버 호출을 정상적으로 처리하지 못 했습니다.");
						console.log(data.ok);
					}
				});
			});
		});
	</script>
</body>
</html>