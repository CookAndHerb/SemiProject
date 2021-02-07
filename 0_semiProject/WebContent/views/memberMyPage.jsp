<%@page import="com.recipe.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>
	fieldset{
		width : 300px;
		height : 400px;
		margin : 0 auto;
	}
	legend{
		text-align : center;
	}
</style>
<!-- jquery cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
</head>
<body>
	
	<!-- form안에서 버튼태그 만들고, 클릭하면 버튼태그는 기본적으로 submit 동작한다. 그때에는 버튼 태그의 type에 button이라 주면 submit 동작 안 함 -->
	
	<form action="/memberUpdate.do" method="post">
		<fieldset>
			<legend>나의 정보</legend>
			회원 ID : ${member.getUserId()}<br>
			<%-- <input type="text" name="userId" value="${m.getUserId()}" readOnly="true" /><br> --%>
			<!-- 회원ID는 수정하면 안 되니 보여주기만 해야함. readOnly="true" 로!!! -->
			비밀번호 : <input type="password" name="userPw" value="${member.getUserPw()}" /><br>
			비밀번호(re) : <input type="password" name="userPw_re" value="${member.getUserPw()}" /> <br>
			이름 : ${member.getUserName()}<br> <!-- 값 변경X -->
			이메일 : <input type="email" name="userEmail" value="${member.getUserEmail()}" /> <br>
			성별 : ${member.getUserGender()}
			닉네임 : <input type="text" name="userNickname" value="${member.getUserNickname()}" /> <br>
			생년월일 : ${member.getUserBirth()}<br>
			휴대폰 : <input type="text" name="userPhone" value="${member.getUserPhone()}" /> <br>
			<input type="submit" value="정보수정" />
				<input type="reset" value="취소" />
				<a href="/CookCookRecipe/index.jsp">메인 페이지로 돌아가기</a>
		</fieldset>
	</form>
</body>
</html>