 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세</title>
</head>
<body>
	<table width = "800" border = "1">
		<tr height="40">
			
			<td width="120" align="center">조회수</td>
			<td width="180" align="center">${vo.boardHit}</td>
		</tr>

		<tr height="40">
			<td width="120" align="center">작성일</td>
			<td width="180" align="center">${vo.boardDate}</td>
		</tr>

		<tr height="40">
			<td width="120" align="center">제목</td>
			<td colspan="3" align="center">${vo.boardTitle}</td>
		</tr>

		<tr height="400">
			<td width="120" align="center">글 내용</td>
			<td colspan="3" align="center">${vo.boardContent}</td>
		</tr>

		<tr height="40">
			<td align="center" colspan="4">
				<input type="button" value="수정하기" onclick="location.href='/mBoardUpdateNo.do?num=${vo.boardNum}'">
				<input type="button" value="삭제하기" onclick="location.href='/mBoard/checkDelete.jsp?num=${vo.boardNum}'">
				
			</td>
		</tr>
	</table>
</body>

</html>

