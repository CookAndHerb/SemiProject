<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<title>회원가입</title>
<style>
	* {
    	margin: 0;
    	padding: 0;
    	float:none;
	}
	td{
		padding: 10px; 
	}
	.form-group{
		width:100%;
		padding: 60px;
		padding-bottom: 160px;
	}
	#join_btn{
		background-color:  #b0c364;
    	border-color:  #b0c364;
		width: 240px;
		
	}
	#idCheck{
    	border-color:  #b0c364;
    	color: #b0c364;
	}
	#idCheck:hover{
		background-color:  #b0c364;
		color: white;
	}
	#NicknameCheck{
    	border-color:  #b0c364;
    	color: #b0c364;
	}
	#NicknameCheck:hover{
		background-color:  #b0c364;
		color: white;
	}
	#emailCheck{
    	border-color: #b0c364;
    	color: #b0c364;
	}
	#emailCheck:hover{
		background-color:  #b0c364;
		color: white;
	}
	#emailCheckNum{
		border-color: #b0c364;
    	color: #b0c364;
	}
	#emailCheckNum:hover{
		background-color:  #b0c364;
		color: white;
	}
	.table-borderless td{
		font-size: 16px;
		font-weight: bold;
	}
	h1{
		text-align: center; 
		padding-bottom: 30px;
	}
	.border1{
		border: 1px solid #d3d3d3;
		width: 900px;
		margin-bottom: 40px;
		box-shadow: 0 0 0 1px #d3d3d3 inset; 
	}
	.border2{
		border: 1px solid #d3d3d3;
		width: 900px;
		box-shadow: 0 0 0 1px #d3d3d3 inset;
		margin-bottom: 30px;
	}

</style>

</head>
<body>
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>
<div class="form-group row justify-content-center">
	<form action="/memberJoin.do" method="post" class="needs-validation" onsubmit="return check()" novalidate>
		<h1>회원가입</h1>
		<div class="border1"></div>
		<table class="table-borderless" style="margin: 0 250px 0 50px; ">
			<tr class="d-flex">
				<td class="col-4"><label for="userId">아이디</label></td>
				<td class="col-sm-12">
					<input type="text" name="userId" id="userId" class="form-control col-xs-10" 
					placeholder="아이디를 입력해 주세요" onkeyup="idCheckFunction();"required>
				</td>
				<td>
					<input type="button" name="idCheck" value="중복확인" id="idCheck" class="btn btn-outline-success px-4">
				</td>
			</tr>
			<tr>
				<td><span id="idCheckMessage" style="color:red;font-weight:bold"></span></td>
			</tr>
			<tr class="d-flex">
				<td class="col-4"><label for="userPW">비밀번호</label></td>
				<td class="col-sm-12">
					<input type="password" name="userPw" class="form-control" id="userPw" 
					placeholder="비밀번호를 입력해 주세요" onkeyup="pwCheckFunction();" required>
				</td>
			</tr>
			<tr>
				<td><span id="pwCheckMessage" style="color:red;font-weight:bold"></span></td>
			</tr>
			<tr class="d-flex">
				<td class="col-4"><label for="userPwRe">비밀번호 확인</label></td>
				<td class="col-sm-12"><input type="password" name="userPwRe" id="userPwRe" 
				class="form-control" onkeyup="passwordCheckFunction();" placeholder="비밀번호를 한 번 더 입력해 주세요" required>
				</td>
			</tr>
			<tr>
				<td><span id="passwordCheckMessage" style="color:red; font-weight:bold"></span></td>
			</tr>
			<tr class="d-flex">
				<td class="col-4"><label for="userName">이름</label></td>
				<td class="col-sm-12">
					<input type="text" name="userName" class="form-control" placeholder="이름을 입력해 주세요" required>
				</td>
			</tr>
			<tr class="d-flex">
				<td class="col-4"><label for="userEmail">이메일</label></td>
				<td class="col-sm-12">
					<input type="email" name="userEmail" id="userEmail" class="form-control" 
					placeholder="ex)cook@cook.com" required>
				</td>
				<td>
					<input type="button" name="emailCheck" id="emailCheck" value="인증번호" 
					class="btn btn-outline-success px-4">
				</td>
			</tr>
			<tr>
				<td><span id="emailCheckMessage" style="color:red;font-weight:bold"></span></td>
			</tr>
			<tr class="d-flex">
				<td class="col-4"><label for="userEmailNum">인증번호</label></td>
				<td class="col-sm-12">
					<input type="text" name="userEmailNum" id="userEmailNum" class="form-control"
					 placeholder="인증번호를 입력해 주세요" required>
				</td>
				<td>
					<input type="button" name="emailCheckNum" id="emailCheckNum" value="인증하기" 
					class="btn btn-outline-success px-4">
				</td>
			</tr>
			<tr>
				<td><span id="emailNumCheckMessage" style="color:red; font-weight:bold"></span></td>
			</tr>
			<tr class="d-flex">
				<td class="col-4">성별</td>
				<td class="col-3" style="padding-left:40px;">
					<input type="radio" name="userGender" value="남" class="form-check-input">남
				 </td>
				 <td class="col-2">
			 		<input type="radio" name="userGender" value="여" class="form-check-input" checked>여
			 	</td>
			 <tr class="d-flex">
			 	<td class="col-4"><label for="userNickname">닉네임</label></td>
				<td class="col-sm-12">
					<input type="text" name="userNickname" id="userNickname" class="form-control" required>
				</td>
				<td>
					<input type="button" name="NicknameCheck" id="NicknameCheck" value="중복확인" class="btn btn-outline-success px-4">
				</td>
			</tr>
			<tr>
				<td><span id="NicknameCheckMessage" style="color:red; font-weight:bold"></span></td>
			</tr>
			<tr class="d-flex" >
				<td class="col-4"><label for="userBirth">생년월일</label></td>
				<td class="col-sm-12">
					<input type="text" name="userBirth" placeholder="숫자만 입력해 주세요"
					onkeyup="birthCheckFunction();" class="form-control" required>
				</td>
			</tr>
			<tr>
				<td><span id="birthCheckMessage" style="color:red;font-weight:bold"></span></td>
			</tr>
			<tr class="d-flex">
				<td class="col-4"><label for="userPhone">전화번호</label></td>
				<td class="col-sm-12">
					<input type="text" name="userPhone" placeholder="숫자만 입력해 주세요" 
					onkeyup="phoneCheckFunction();" class="form-control" required>
				</td>
			</tr>
			<tr>
				<td><span id="phoneCheckMessage" style="color:red; font-weight:bold; padding:10px;"></span></td>
			</tr>
		</table>
		<div class="border2"></div>
		<div class="btn d-flex justify-content-center" style=" padding-top: 40px;">
			<input type="submit" id="join_btn" value="가입하기" class="btn btn-primary btn-lg" disabled="disabled">
		</div>
		<input type="hidden" name="checkedId" value="">
		<input type="hidden" name="checkedEmail" value="">
		<input type="hidden" name="checkedEmailNum" value="">
		<input type="hidden" name="checkedNickname" value="">
	</form>
</div>
<script>
	// 폼 전송 전 버튼 체크
	function check() {
		  if($("input[name='checkedId']").val()==''){
			    alert('아이디 중복확인을 해주세요.');
			    $("input[name='checkedId']").eq(0).focus();
			    return false;
			}else if($("input[name='checkedNickname']").val()==''){
			    alert('닉네임 중복확인을 해주세요.');
			    $("input[name='checkedNickname']").eq(0).focus();
			    return false;
			}else if($("input[name='checkedEmail']").val()==''){
			    alert('인증번호 버튼을 눌러주세요 ');
			    $("input[name='checkedEmail']").eq(0).focus();
			    return false;
			}else if($("input[name='checkedEmailNum']").val()==''){
			    alert('인증하기 버튼을 눌러주세요 ');
			    $("input[name='checkedEmailNum']").eq(0).focus();
			    return false;
			}
		  	else return true;
	}
	// 회원가입 버튼 누르기 전 입력 체크
	(function() {
		  'use strict';
		  window.addEventListener('load', function() {
		    // Get the forms we want to add validation styles to
		    var forms = document.getElementsByClassName('needs-validation');
		    // Loop over them and prevent submission
		    var validation = Array.prototype.filter.call(forms, function(form) {
		      form.addEventListener('submit', function(event) {
		        if (form.checkValidity() === false) {
		          event.preventDefault();
		          event.stopPropagation();
		        }
		        form.classList.add('was-validated');
		      }, false);
		    });
		  }, false);
		})();
	// 아이디 중복체크
	$('#idCheck').on("click", function(){
		$("input[name=checkedId]").val('y');
		var userId = $("#userId").val();
		if(userId == ''){
			$('#idCheckMessage').html('아이디를 입력해 주세요');
			return false;
		}
		$.ajax({
			type: 'POST',
			url: '/MemberJoinIdCheck.do', 
			data: {userId: userId},
			success: function(result){
				if(result == 1){ 
					$('#idCheckMessage').html('사용할 수 없는 아이디입니다.');
					 $("#join_btn").attr("disabled", "disabled");
				} else {
					$('#idCheckMessage').html('사용할 수 있는 아이디입니다.');
					$("#join_btn").removeAttr("disabled");
				}
			}
		})
	});
	// 닉네임 중복체크
	$('#NicknameCheck').on("click", function(){
		$("input[name=checkedNickname]").val('y');
		var userNickname = $("#userNickname").val();
		if(userNickname == ''){
			$('#NicknameCheckMessage').html('닉네임을 입력해 주세요');
			return false;
		}
		$.ajax({
			type: 'POST', 
			url: '/MemberJoinNicknameCheck.do',
			async : false,
			data: {userNickname: userNickname},
			success: function(result){ 
				if(result == 1){ 
					$('#NicknameCheckMessage').html('사용할 수 없는 닉네임입니다.');
					 $("#join_btn").attr("disabled", "disabled");
				} else{
					$('#NicknameCheckMessage').html('사용할 수 있는 닉네임입니다.');
					$("#join_btn").removeAttr("disabled");
				}
			}
		})
	});
	// 이메일 인증번호 전송
	$('#emailCheck').on("click", function(){
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var userEmail = $("#userEmail").val();
		
		$("input[name=checkedEmail]").val('y');
		
		if(userEmail == ''){
			$('#emailCheckMessage').html('이메일을 입력해 주세요');
			return false;
		}else if(!regExp.test(userEmail)){
			$('#emailCheckMessage').html('올바르지 않은 이메일 주소입니다.');
			return false;
		}
		$.ajax({
			type: 'get', 
			url: '/MemberJoinEmailCheck.do',
			async : false,
			data: {userEmail: userEmail},
			success: function(data){ 
				$('#emailCheckMessage').html('인증번호가 발송되었습니다.');
			}
		})
	});
	$('#emailCheckNum').on("click", function(){
		$("input[name=checkedEmailNum]").val('y');
		var userEmailNum = $("#userEmailNum").val();
		if(userEmailNum == ''){
			$('#emailNumCheckMessage').html('인증번호를 입력해 주세요');
			return false;
		}
		$.ajax({
			type: 'get', 
			url: '/MemberJoinEmailCheckNum.do',
			data: {userEmailNum: userEmailNum},
			success: function(result){
				if(result == 1){ 
					alert("인증번호가 맞지 않습니다");
					$("#join_btn").attr("disabled", "disabled");
				}else{
					alert("인증번호가 확인되었습니다.");
					$("#join_btn").removeAttr("disabled");
				}
			}
		})
	});
	function idCheckFunction(){
		var userId = $('input[name=userId]');
		//소문자 시작, 소문자+숫자 포함하여 5 ~ 10글자
		if (/^[a-z][a-z0-9]{4,9}$/.test(userId.val())) {
			$('#idCheckMessage').html('');
			$("#join_btn").attr("disabled", "disabled");
		}else{
			$('#idCheckMessage').html('소문자와 숫자를 포함하여 5~10글자 이내로 입력해주세요.');
			$("#join_btn").removeAttr("disabled");
		}
	}
	function pwCheckFunction(){
		var userPw = $('input[name=userPw]');
		//영어+숫자 섞어서 5글자~10글자
		if (/^(?=.*[a-zA-Z])(?=.*[0-9]).{5,10}$/.test(userPw.val())) {
			$('#pwCheckMessage').html('');
			$("#join_btn").removeAttr("disabled");
		}else{
			$('#pwCheckMessage').html('소문자와 숫자를 포함하여 5~10글자 이내로 입력해주세요.');
			$("#join_btn").attr("disabled", "disabled");
		}
	}
	function birthCheckFunction(){
		var userBirth = $('input[name=userBirth]');
		//숫자만 8글자
		if (/^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/
				.test(userBirth.val())) {
			$('#birthCheckMessage').html('');
			$("#join_btn").removeAttr("disabled");
		}else{
			$('#birthCheckMessage').html('생년월일 8자리 입력 ex)19990101');
			$("#join_btn").attr("disabled", "disabled");
		}
	}
	function phoneCheckFunction(){
		var userPhone = $('input[name=userPhone]');
		if (/(^02.{0}|^01.{1}|[0-9]{4})([0-9]+)([0-9]{7})/g.test(userPhone.val())) {
			$('#phoneCheckMessage').html('');
			$("#join_btn").removeAttr("disabled");
		}else{
			$('#phoneCheckMessage').html('휴대폰번호 11자리 입력  ex)01012345678');
			$("#join_btn").attr("disabled", "disabled");
		}
	}
	function passwordCheckFunction(){
        var userPw = $('#userPw').val();
        var userPwRe = $('#userPwRe').val();
        if(userPw!=userPwRe){
            $('#passwordCheckMessage').html("비밀번호가 일치하지 않습니다");
            $("#join_btn").attr("disabled", "disabled");
        }
        else{
            $('#passwordCheckMessage').html("");
            $("#join_btn").removeAttr("disabled");
        }
    }
	
</script>

	<footer>
		<%@ include file="/template/bottom.jsp"%>
	</footer>
</body>
</html>