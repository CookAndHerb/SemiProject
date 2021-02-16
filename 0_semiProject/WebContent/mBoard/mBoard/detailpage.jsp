 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cook & Talk 상세 페이지</title>
</head>
<!-- 상단 공동 메뉴 -->
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>
<style>
* {
	margin: 0;
	padding: 0;
	float: none;
}

.board_view_subject {
	border-top: 1px solid #222;
	border-bottom: 1px solid #dae0e9;
	height: 70px;
	padding: 0 20px;
	line-height: 70px;
}

.board_view_subject_left {
	padding: 20px 0 20px 0;
	font-size: 15px;
	float: left;
	color: #222;
	font-size: 15px;
}

.board_view_subject_right {
	padding: 20px 0 20px 0;
	float: right;
	color: #222;
}

.board_view_content {
	text-align: left;
	width: 100%;
	padding: 40px 0 40px 0;
	border-bottom: 1px solid #dae0e9;
}

.board_title {
	padding: 40px 0 40px 0;
}

.btnGroup {
	padding: 20px 0 40px 0;
	margin-left: 80%;
}

#btn1 {
	background-color: #b0c364;
	border-color: #b0c364;
}

#btn2 {
	background-color: #b0c364;
	border-color: #b0c364;
}
.text{
		color:  #b0c364;
		text-align: center;
}
</style>
<body>
<div class="container">
<h2 class="board_title" align="center" style="margin: 30px 0 0 0; padding-bottom: 0;">Cook & Talk</h2>
  <p class="text" style="margin-bottom: 30px">Cook&Talk 자유게시판 입니다</p> 
	<div id="board_View" style="width:100%">
		<div class="board_view_subject" style="border-top: 1px solid #222;">
			<p class="board_view_subject_left">${vo.boardTitle}</p>
			<p class="board_view_subject_right">${vo.boardDate}</p>
			<p class="board_view_subject_right">조회수 ${vo.boardHit}&nbsp;&nbsp;|&nbsp;&nbsp;</p>
		</div>
	</div>
	
	<div class="board_view_content pl-3">
		${vo.boardContent}
	</div>
	
	<div class="btnGroup">
		<input type="button" value="수정하기" id="btn1" class="btn btn-success" onclick="location.href='/mBoardUpdateNo.do?num=${vo.boardNUM}'">
		<input type="button" value="삭제하기" id="btn2" class="btn btn-success" onclick="location.href='/mBoard/mBoard/checkDelete.jsp?num=${vo.boardNUM}'">	
	</div>
</div>
	<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
</body>

</html>

