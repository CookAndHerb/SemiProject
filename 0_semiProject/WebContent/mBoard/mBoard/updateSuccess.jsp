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
	alert(" 수정 성공");
	location.replace("/mBoardList.do");
</script>
</body>
</html>