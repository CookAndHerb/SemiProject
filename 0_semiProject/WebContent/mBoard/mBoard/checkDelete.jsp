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
		result = window.confirm("게시글을 삭제하시겠습니까?");
		if (result == true) {
			location.replace("/mBoardDeleteNo.do?num=<%=num%>");
		
		
		}else{
			location.replace("/mBoardList.do");
		}
</script>

</body>
</html>