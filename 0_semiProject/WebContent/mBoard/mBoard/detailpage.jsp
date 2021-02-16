 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세</title>
</head>
<!-- 상단 공동 메뉴 -->
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>

<body>
	<table class="table table-hover">
		<tr>
			<th>조회수</th>
			<td>${vo.boardHit}</td>
		</tr>

		<tr>
			<th>작성일</th>
			<td>${vo.boardDate}</td>
		</tr>

		<tr>
			<th>제목</th>
			<td>${vo.boardTitle}</td>
		</tr>

		<tr>
			<th>글 내용</th>
			<td>${vo.boardContent}</td>
		</tr>

		<tr>
			<td align="center" colspan="4">
				<input type="button" value="수정하기" onclick="location.href='/mBoardUpdateNo.do?num=${vo.boardNUM}'">
				<input type="button" value="삭제하기" onclick="location.href='/mBoard/mBoard/checkDelete.jsp?num=${vo.boardNUM}'">
				
			</td>
		</tr>
	</table>
	
	<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
</body>

</html>

