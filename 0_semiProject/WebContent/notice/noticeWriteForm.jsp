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

.thead {
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
		<colgroup>
			<col style="width:20%;">
			<col>
		</colgroup>
		<tbody>
 			 <tr>
    			<td class="thead" colspan="2">공지사항 작성하기</td>
  			</tr>
  			<tr>
    			<td>제목</td>
    			<td><input type="text" placeholder="글 제목" name="noticeTitle" size="50"/></td>
  			</tr>
  			<tr> 
   	 			<td>내용</td>
    			<td><textarea name="noticeContent" cols="52" rows="20">내용을 입력하세요</textarea></td>
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