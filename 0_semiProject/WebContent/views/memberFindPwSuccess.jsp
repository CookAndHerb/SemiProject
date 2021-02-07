<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 상단 공동 메뉴 -->
	<header id="top_section">
			<%@ include file="/template/top.jsp" %>
	</header>

	비밀번호 찾기 결과 : ${userPw}
	
	<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
</body>
</html>