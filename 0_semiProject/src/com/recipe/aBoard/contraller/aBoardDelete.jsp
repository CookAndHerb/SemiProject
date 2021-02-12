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
	boolean result = (boolean)request.getAttribute("result");

%>
<script>
<%if(result==true){ %>
	alert('글 삭제를 완료 하였습니다.');
	location.replace('/aBoardListServlet.do');
<%}else{ %>
	alert('글 삭제를 실패 하였습니다.');
	history.back(-1);
<%} %>
</script>
</body>
</html>