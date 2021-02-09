<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/aBoardWriteServlet.do" method="post">
		<table width="600" border="1">
			<tr height="40">
				<td align="center" width="150">제목</td>
				<td width="450"><input type="text" name="title"></td>
			</tr>
			<tr height="40">
				<td align="center" width="150">비밀번호</td>
				<td width="450"><input type="password" name="password"></td>
			</tr>
			<tr height="40">
				<td align="center" width="150">글 내용</td>
				<td width="450"><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
			<tr height="40">
				<td align="center" colspan="2">
					<input type="submit" value="글쓰기">&nbsp;
					<button onclick="location.href='/aBoard/aBoardList.jsp'">취소</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>