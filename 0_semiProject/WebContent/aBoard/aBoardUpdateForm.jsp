<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/aBoardUpdate.do" method ="post">
		<table width = "600" border = "1">
			<tr height= "40">
				<td width="120" align="center">제목</td>
				<td width="480" colspan="3">
				<input type="text" name="title" value="${vo.boardTitle}" size="60"></td>
			</tr>
			
			<tr height= "40">
				<td width="120" align="center">패스워드</td>
				<td width="480" colspan="3">
				<input type="password" name="pass" size="60"></td>
			</tr>
			
			<tr height= "40">
				<td width="120" align="center">내용</td>
				<td width="480" colspan="3"><textarea rows="10" cols="60" name="content" align="left">${vo.boardContent}</textarea></td>
			</tr>
			
			<tr height= "40">
				<td colspan="4" align="center">
					<input type="hidden" name="num" value="${vo.boardNum}">
					<input type="hidden" name="password" value="${vo.password}">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>