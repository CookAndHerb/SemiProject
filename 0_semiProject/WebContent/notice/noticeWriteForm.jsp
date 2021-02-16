<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글 작성하기</title>
<style>
table {
	border-collapse: collapse;
 	text-align: center;
  	line-height: 1.5;
  	align : center;
  	line-height: 1.5;
  	margin: 20px 10px;
  	font-size : 20px;
  	width: 100%;
  	table-layout: fixed;
}

table thead {
	text-align : center;
	font-size : 35px;
	border-bottom: 3px solid #b0c364;
	width : 100%;
}

table th {
	padding: 10px;
  	font-weight: bold;
  	vertical-align: top;
  	border-bottom: 1px solid #ccc;
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
#inputSubmit {
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

<form method="post" action="/writeNotice.do">
	<table>
  		<thead>
 			 <tr>
    			<th colspan="2" scope="cols">공지사항 작성하기</th>
  			</tr>
 		 </thead>
 		 <tbody>
  			<tr>
    			<th width="20%" scope="row">제목</th>
    			<td><input type="text" placeholder="글 제목" name="noticeTitle" size="50"/></td>
  			</tr>
  			<tr>
   	 		<th width="20%" scope="row">내용</th>
    			<td><textarea name="noticeContent" cols="40" rows="20">내용을 입력하세요</textarea></td>
  			</tr>
  		</tbody>
	</table>
	<div id="inputDiv">
		<input id="inputSubmit" type="submit" value="글쓰기">
	</div>
</form>

<footer>
		<%@ include file="/template/bottom.jsp" %>
</footer>
</body>
</html>