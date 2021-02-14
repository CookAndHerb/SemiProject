<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<style>
.text {
	font-size: 25px;
	font-weight: 900;
	color: #b0c364;
}

#submitBtn {
	background: #b0c364;
	color: white;
}
#userId{
	display: none;
}
</style>
</head>
<body>
	<!-- 상단 공동 메뉴 -->
	<header id="top_section">
		<%@ include file="/template/top.jsp"%>
	</header>

	<!-- content 부분-->
	<section class="container p-5 col-sm-4">
		<div class="text">비밀번호 변경</div>
		<hr>
		<form action="findNewPw.do" method="post">
			<div id="userId">
			아이디 : <input type="text" class="form-control" name="userId" value="${userId }" readonly/><br>
			</div>
			<label for="userPw">새로운 비밀번호 : </label><input type="password" class="form-control" id="pwd1" name="userPw" placeholder="대소문자+숫자를 포함한 5~10글자"/><br>
			<label for="userPw_re">비밀번호 재입력 : </label><input type="password" class="form-control" id="pwd2" name="userPw_re" /><br>
			 <div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
      <div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
			<button type="submit" class="btn btn-light btn-block" id="submitBtn">완료</button>
		</form>
	</section>

<script>
	$(function(){	
	      $('#alert-success').hide();
	      $('#alert-danger').hide();

		$("input").keyup(function(){
	         var pwd1 = $("#pwd1").val();
	         var pwd2 = $("#pwd2").val();
	         
	      if(pwd1 != "" || pwd2 != ""){
	      if(pwd1 == pwd2){
	      $("#alert-success").show();
	      $("#alert-danger").hide();
	      $("#submit").removeAttr("disabled");
	      }else{

	      $("#alert-success").hide();   
	      $("#alert-danger").show();
	      $("#submit").attr("disabled", "disabled");
	      $("#submit").removeAttr("disabled");
	      }
	   }
	      
	});
		$('form').submit(function(){
			
			var userPw = $('#pwd1').val();
			var userPw_re =  $('#pwd2').val();
			
			//영어+숫자 섞어서 5글자~10글자
			if(!/^(?=.*[a-zA-Z])(?=.*[0-9]).{5,10}$/.test(userPw)){
				alert("비밀번호 입력 형식이 맞지 않습니다.");
				return false;
			}
			return true;
		});
	});
</script>


	<!-- ##### Catagory Area End ##### -->

	<br>
	<br>
	<br>

	<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp"%>
	</footer>
</body>
</html>