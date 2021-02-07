<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	fieldset{
	width:700px;
	height:400px;
	margin:0 auto;
	}
	legend{
	text-align: center;
	}
</style>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>

</head>
<body>
<form action="/memberJoin.do" method="post">
	<fieldset>
		<legend>회원가입</legend>
		회원ID : <input type="text" name="userId" /><span></span><br>
		비밀번호 : <input type="password" name="userPw" /><span></span><br>
		비밀번호(re) : <input type="password" name="userPw_re" placeholder="비밀번호 재입력"/><span></span><br>
		이름 : <input type="text" name="userName" /><br>
		이메일 : <input type="email" name="userEmail" placeholder="ex)cook@cook.com"/><br>
		성별 : <input type="radio" name="userGender" value="남"/>남
		 	 <input type="radio" name="userGender" value="여" checked/>여<br>
		닉네임 : <input type="text" name="userNickname" /><br>
		생년월일 : <input type="text" name="userBirth" /><span></span><br>	
		휴대폰 : <input type="text" name="userPhone" /><span></span><br>
		 	  <input type="submit" value="회원가입"/>
		 	  <input type="reset" value="취소"/>
		 	  <a href="/CookCookRecipe/index.jsp">메인페이지로 돌아가기</a>
	</fieldset>
	</form>
<script>
	$(function(){
		$('form').submit(function(){
			var userId = $('input[name=userId]');
			//소문자 시작, 소문자+숫자 포함하여 5 ~ 10글자
			if(!(/^[a-z][a-z0-9]{4,9}$/.test(userId.val()))){
				alert("ID를 다시 입력해주세요.");
				return false;
			}	
			
			var userPw = $('input[name=userPw]');
			//영어+숫자 섞어서 5글자~10글자
			if(!(/^[A-Za-z0-9_-]{5,10}$/.test(userPw.val()))){
				alert("비밀번호를 잘못 입력하였습니다.");
				return false;
			}
			
			var userBirth = $('input[name=userBirth]');
			//숫자만 8글자
			if(!/^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/.test(userBirth.val())){
				alert("생년월일을 잘못 입력하였습니다.");
				return false;
			}
			
			var userPhone = $('input[name=userPhone]');
			//숫자만 11글자
			if(!/(^02.{0})|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/g.test(userPhone.val())){
				alert("잘못된 휴대폰 번호입니다.");
				return false;
			}
			
			return true;
		});
		$('input[name]').focusin(function(){
			//입력창 클릭하면 lightgray
			$(this).css('background-color','lightgray');
			switch($(this).attr('name')){
			case "userId" : $(this).next().text("소문자+숫자 포함하여 5~10글자 가능");
			console.log($(this)); break;
			case "userPw" : $(this).next().text("영어+숫자 섞어서 5~10글자 가능");
			console.log($(this)); break;
			case "userPw_re" : $(this).next().text("비밀번호 재입력");
			console.log($(this)); break;
			case "userBirth" : $(this).next().text("생년월일 8자리 입력 ex)19990101");
			console.log($(this)); break;
			case "userPhone" : $(this).next().text("휴대폰번호 11자리 입력  ex)01012345678");
			console.log($(this)); break;
			}
		});
		$('input[name]').focusout(function(){
			//다른곳 클릭하면 하얀색(벗어나면)
			$(this).css('background-color','white');
			$(this).next().text("");
		});
	});
</script>
</body>
</html>