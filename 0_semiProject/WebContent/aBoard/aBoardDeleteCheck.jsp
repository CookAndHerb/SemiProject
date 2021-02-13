<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cook Q&A 게시글 삭제</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num").trim());

%>
<script>
		result = window.confirm("글을 삭제하시겠습니까?");
		if (result == true) {
			location.replace("/aBoardDeleteNum.do?num=<%=num%>");
		}else{
			location.replace("/aBoardListServlet.do");
		}
</script>
</body>
</html>