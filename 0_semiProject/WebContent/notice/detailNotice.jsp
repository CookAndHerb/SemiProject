<%@page import="com.recipe.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: separate;
  	border-spacing: 1px;
  	text-align: left;
  	line-height: 1.5;
  	border: 1px solid #ccc;
  	margin: 20px 10px;

}
.theader {
	width: 150px;
  	padding: 10px;
  	font-weight: bold;
  	vertical-align: top;
  	border-bottom: 1px solid #ccc;
  	background: #deeda1;
}
table td {
  width: 350px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
}
#inputDiv {
	font-size : 20px;
	text-align : center;
	padding : 20px;
}

.inputBtn {
	background : #b0c364;
	border : none;
	border-right : 0px;
	border-left : 0px;
	border-top : 0px;
	border-botton : 0px;
}
</style>
</head>
<body>
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>
<form method="post" action="/detailNotice.do">
	<table id="writeNotice" width="90%" style="text-align:center;border:1px solid #dddddd">
		<tbody>
			<tr>
				<td class="theader">제목</td>
				<td colspan="3">${noticeVO.noticeTitle}</td>
			</tr>
			<tr>
				<td class="theader">글번호</td>
				<td>${number}</td>
				<td class="theader">작성자</td>
				<td>${noticeVO.noticeWriter}</td>
			</tr>
			<tr>
				<td class="theader">작성일</td>
				<td colspan="3">${noticeVO.noticeDate}</td>
			</tr>
			<tr>
				<td class="theader">글 내용</td>
				<td>${noticeVO.noticeContent}</td>
			</tr>
		</tbody>
	</table>
	<div>
	<div id="inputDiv">
	<% MemberVO mvo = (MemberVO)session.getAttribute("member"); // 로그인 돼있는 경우만 글쓰기 버튼 보이도록
	
	if(mvo != null && mvo.getUserNum() < 1000){
	%>
			<input type="button" value="글수정" class="inputBtn" onclick="location.href='/noticeUpdateReady.do?noticeNum=${ noticeVO.noticeNum }&number=${number }'" />
			<input type="button" value="글삭제" class="inputBtn" onclick="location.href='/noticeDelete.do?noticeNum=${ noticeVO.noticeNum }'" />
	<%} %>	
			<input type="button" value="글목록" class="inputBtn" onclick="location.href='/noticeAllList.do'" />
	</div>
	</div>
</form>
<footer>
		<%@ include file="/template/bottom.jsp" %>
</footer>
</body>
</html>