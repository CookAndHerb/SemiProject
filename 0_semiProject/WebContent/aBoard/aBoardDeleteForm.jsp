<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>cook Q&A 게시글 삭제</title>
<style>
	#pwFont{
		font-weight: bold;
		font-size: 20px;
		font-weight: normal;
	}
	.form-group{
		display: flex;
  		justify-content: center;
  		height: 400px;
	}
	#pw_btn{
		background-color:  #b0c364;
    	border-color:  #b0c364;
	}
	
</style>
</head>
<body>
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>

<form action = "/aBoardDelete.do" method="post" class="form-inline" role="form">
	<div class="container"  style='width:1000px; height:500px;'>
		<div class="form-group">
	    	<label for="pwd" id="pwFont" class="px-4">Password: </label>
	    	<input type="password" class="form-control col-5" name="pass" placeholder="비밀번호를 입력하세요" id="pwd">
			<div class="btn pl-8">
				<input type ="submit" id="pw_btn" value="확인" class="btn btn-success">
			</div>
	  	</div>
	</div>
		<input type ="hidden" name ="num" value="${vo.boardNum}">
		<input type ="hidden" name ="password" value="${vo.password}">
	</form>

<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
</body>
</html>