<%@page import="com.recipe.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberVO m = (MemberVO)session.getAttribute("member");
%>
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>
<form method="post" action="/detailNotice.do">
	<table id="writeNotice" width="90%" height="70" style="text-align:center;border:1px solid #dddddd">
		<tbody>
			<tr>
				<td>제목</td>
				<td>${noticeVO.noticeTitle}</td>
			</tr>
			<tr>
				<td width="10%">글번호</td>
				<td width="40%">${number}</td>
				<td width="10%">작성자</td>
				<td width="40%">${noticeVO.noticeWriter}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${noticeVO.noticeDate}</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>${noticeVO.noticeContent}</td>
			</tr>
		</tbody>
	</table>
	<div>
		<c:if test="${m.getUserNum() < 1000 }">
			<input type="button" value="글수정" onclick="location.href='/noticeUpdateReady.do?noticeNum=${ noticeVO.noticeNum }&number=${number }'" />
			<input type="button" value="글삭제" onclick="location.href='/noticeDelete.do?noticeNum=${ noticeVO.noticeNum }'" />
		</c:if>
		<input type="button" value="글목록" onclick="location.href='/noticeAllList.do'" />
	</div>
</form>
<footer>
		<%@ include file="/template/bottom.jsp" %>
</footer>
</body>
</html>