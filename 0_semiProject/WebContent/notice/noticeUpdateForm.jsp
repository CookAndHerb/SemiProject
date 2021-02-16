<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>
<form method="post" action="/noticeUpdate.do?noticeNum=${noticeVO.noticeNum }&number=${number}">
	<table id="writeNotice" width="90%" height="70" style="text-align:center;border:1px solid #dddddd">
		<thead>
			<tr><th colspan="2" style="background-color:#eeeeee; text-align:center;">NOTICE</th>
		</thead>
		<tbody>
			<tr>
				<td size="15%">제목</td>
				<td><input type="text" class="form-control" width="90%" placeholder="글 제목"
					size="80%" maxlength="100" name="noticeTitle" /></td>
			</tr>
			<tr>
				<td size="15%">작성자</td>
				<td>${noticeVO.noticeWriter}</td>
			</tr>
			<tr>
				<td size="15%">글 내용</td>
				<td><input type="text" placeholder="글내용 " name="noticeContent" maxlength="2500" 
				size="80%"></input></td>
			</tr>
		</tbody>
	</table>
	<input type="submit" value="수정하기">
</form>
<footer>
		<%@ include file="/template/bottom.jsp" %>
</footer>
</body>
</html>