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
	int num = (int)request.getAttribute("num");
%>

<script>
	alert("비밀번호가 맞지 않습니다.");
	location.replace("/aBoardUpdate.do?num=<%=num%>");
</script>
</body>
</html>