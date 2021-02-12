<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num").trim());
%>

<script>
	alert("비밀번호가 맞지 않습니다.");
	history.back(-1);
</script>
</body>
</html>