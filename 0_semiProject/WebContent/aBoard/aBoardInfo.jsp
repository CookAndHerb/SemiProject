<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width = "600" border = "1">
		<tr height="40">
			<td width="100" align="center">글번호</td>
			<td width="180" align="left">${vo.boardNum}</td>
			<td width="120" align="center">조회수</td>
			<td width="180" align="center">${vo.readCount}</td>
		</tr>

		<tr height="40">
			<td width="120" align="center">작성일</td>
			<td width="180" align="center">${vo.boardDate}</td>
		</tr>

		<tr height="40">
			<td width="120" align="center">제목</td>
			<td colspan="3" align="center">${vo.boardTitle}</td>
		</tr>

		<tr height="80">
			<td width="120" align="center">글 내용</td>
			<td colspan="3" align="center">${vo.boardContent}</td>
		</tr>

		<tr height="40">
			<td align="center" colspan="4"><input type="button" value="답글쓰기"
				onclick="location.href='/aBoardReWrite.do?num=${vo.boardNum}&ref=${vo.ref}&re_stop=${vo.reStep}&re_level=${vo.reLevel}'">
				<input type="button" value="수정" onclick="location.href='/aBoardUpdateNum.do?num=${vo.boardNum}'">
				<input type="button" value="삭제" onclick="location.href='/aBoardPwCheckServlet.do?num=${vo.boardNum}'">
				<input type="button" value="목록" onclick="location.href='aBoardListServlet.do'">
			</td>
		</tr>
	</table>
</body>
</html>