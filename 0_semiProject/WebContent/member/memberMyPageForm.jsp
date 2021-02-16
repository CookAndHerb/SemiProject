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
	
	width: 150px;
	height:50px;
	color: white;
	font-weight: bold;
	font-size: 17px;
	background:#b0c364;
	
		}
	
	.btn2{
	display :inline-block;
	margin-left:250px;
	margin-top: 20px;
	}
	.btn3{
	display :inline-block;
	margin-left:250px;
	}
	.my_du{
	display :  inline-block;
	}
	
	.du_btn{
	width: 100px;
	height:38px;
	background-color : white;
	border : 1px solid #b0c364;
	color : #b0c364;
	font-size:17px;
	
	border-top-left-radius : 4px;
	border-bottom-left-radius:4px;
	border-top-right-radius : 4px;	
	border-bottom-right-radius: 4px;
	}
	
	
	
	#chkMsg{
	display:none;
	width:300px;
	margin-left: 110px;
	}
	
	.b_box{
	margin-left: 110px;
	display:none;
	color:red;
	font-weight:bold;
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
  <h2 style="color: #b0c364;">개인 정보 수정</h2>
  

<br>
<hr>
  <form id="upt_form" action="/memberUpdate.do" method="POST" >
    <div class="form-col container3">
      
       <div class="my_kr">아이디</div>
       <div class="my_in"><input type="text" class="form-control"  value="${member.userId}"  name="userId" readonly="readonly"></div>
      <br><br>
      <div class="my_kr">
     		   비밀번호</div>
        <div class="my_in"><input type="password" class="form-control" id="userPw" onkeyup="pwCheckFunction();" placeholder="비밀번호를 입력해 주세요" name="userPw" ></div>
      <br><br>
      <p class="b_box" id="pwCheckMessage" ></p>
      
      <div class="my_kr">
     		   비밀번호 확인</div>
        <div class="my_in"><input type="password" class="form-control" id="userPwRe" name="userPw_re" onkeyup="passwordCheckFunction();" placeholder="비밀번호를 한 번 더 입력해 주세요." required></div>
   	  	  <br><br>
   	  <p class="b_box" id="passwordCheckMessage" ></p>
   
   	  
   	 
    <div class="my_kr">
     		  이름</div>
        <div class="my_in"><input type="text" class="form-control" value="${member.userName}" name="userName"  readonly="readonly"></div>
   <br><br>
    <div class="my_kr">
     		  닉네임</div>
        <div class="my_in"><input type="text" class="form-control" value="${member.userNickname}" name="userNickname" id="userNickname" ></div>&nbsp;&nbsp;<div class="my_du"><button type="button" onclick="checkNick()"class="du_btn">중복확인</button></div>
   <br><br>
    <p id ="chkMsg"><br><br></p> 
    <div class="my_kr">
     		  생년월일</div>
        <div class="my_in"><input type="text" class="form-control" value="${member.userBirth}"  name="userBirth"  readonly="readonly"></div>
   
   <br><br>
   <div class="my_kr">
     		  이메일</div>
        <div class="my_in"><input type="email" class="form-control" id="userEmail" value="${member.userEmail}" name="userEmail" ></div>
   <br><br>
    <div class="my_kr">
     		  휴대폰</div>
        <div class="my_in"><input type="text" class="form-control" onkeyup="phoneCheckFunction();" value="${member.userPhone}" name="userPhone" ></div>
   
   <p class="b_box" id="phoneCheckMessage"><br><br></p>
 	</div>
    <hr>
    <br>
    

    
    <div class="btn3"><button type="submit" class="btn my_btn " id="submit" disabled>회원정보수정</button></div>
  	
  </form>
  <div class="btn2"><button class="btn my_btn" onclick="javascript:location.href='/MemberDelBtn.do'">탈퇴</button></div>

</div>
<script type="text/javascript">
	
	
function checkNick(){
	var userNickname = $('#userNickname').val();
	
	$.ajax({
	url : '/MemberNickCheck.do',
	type : 'post',
	data : {userNickname : userNickname},
	success:function(data){
	if(data == 1){
	$("#achkMsg").show();
	$('#chkMsg').html("사용 가능한 닉네임입니다.");
	$('#submit').removeAttr("disabled");
		} else{
	$("#chkMsg").show();
	$('#chkMsg').html("이미 존재하는 닉네임입니다.");
	$('#submit').attr("disabled", "disabled");
		}
	}, 
	error : function(){	
		alert("에러입니다.");
	}
	});
}

function pwCheckFunction(){
	var userPw = $('input[name=userPw]');
	// 영어+숫자 섞어서 5글자 ~ 10글자
	if (/^(?=.*[a-zA-Z])(?=.*[0-9]).{5,10}$/.test(userPw.val())) {
			$('#pwCheckMessage').html('');
			$("#submit").removeAttr("disabled");
		}else{
			$('#pwCheckMessage').show();
			$('#pwCheckMessage').html('소문자와 숫자를 포함하여 5~10글자 이내로 입력해주세요.');
			$("#submit").attr("disabled", "disabled");
		}
	
}

function passwordCheckFunction(){
    var userPw = $('#userPw').val();
    var userPwRe = $('#userPwRe').val();
    if(userPw!=userPwRe){
    	$('#passwordCheckMessage').show();
        $('#passwordCheckMessage').html("비밀번호가 일치하지 않습니다.");
        $("#submit").attr("disabled", "disabled");
    }
    else{
        $('#passwordCheckMessage').html('');
        $("#submit").removeAttr("disabled");
       
    }
}



function phoneCheckFunction(){
	var userPhone = $('input[name=userPhone]');
	if (/(^02.{0}|^01.{1}|[0-9]{4})([0-9]+)([0-9]{7})/g.test(userPhone.val())) {
		$('#phoneCheckMessage').html('');
		$("#submit").removeAttr("disabled");
	}else{
		$('#phoneCheckMessage').show();
		$('#phoneCheckMessage').html('휴대폰번호 11자리 입력  ex)01012345678');
		$("#submit").attr("disabled", "disabled");
	}
}


</script>
   
   <br><br><br><br><br><br>
    
    
    <!-- ##### Catagory Area End ##### -->
	<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
</body>
</html>