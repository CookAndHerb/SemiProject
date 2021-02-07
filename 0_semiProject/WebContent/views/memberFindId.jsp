<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>
	form{
		width: 300px;
		height: 500px;
	}
</style>
</head>
<body>
	<!-- 상단 공동 메뉴 -->
	<header id="top_section">
			<%@ include file="/template/top.jsp" %>
	</header>

	<form action="/memberFindId.do" method="post">
		<fieldset>
			<legend>ID 찾기</legend>
			<label for="userName">이름 : </label>
			<input type="text" name="userName" /><br>
			<label for="userPhone">휴대폰 : </label>
			<input type="text" name="userPhone" placeholder="하이픈(-)제외"/><br><br>
			<input type="submit" value="ID 찾기" /><br>
			<a href="/index.jsp">메인 페이지</a>
		</fieldset>
	</form>
	
<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
</body>
</html>