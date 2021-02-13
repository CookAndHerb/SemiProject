<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cook Q&A 글 수정 완료</title>
</head>
<body>
<%
	int num = (int)request.getAttribute("num");
%>

<script>
	alert("글 수정 완료");
	location.replace("/aBoardListServlet.do");
</script>
</body>
</html>