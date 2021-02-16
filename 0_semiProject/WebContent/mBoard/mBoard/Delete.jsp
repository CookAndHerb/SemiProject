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
	
	alert('삭제하였습니다');
	location.replace('/mBoardList.do');
<%}else{ %>
	
	alert('삭제 실패 하였습니다.');
	history.back(-1); //

<%   } %>
</script>
</body>
</html>
