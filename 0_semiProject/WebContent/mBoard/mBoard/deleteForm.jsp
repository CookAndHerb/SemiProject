<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	* {
	    margin: 0;
	    padding: 0;
	    float:none;
	}
	#pw_btn{
		background-color:  #b0c364;
	 	border-color:  #b0c364;	
	}
</style>
<body>
<form action = "/mBoardDelete.do" method="post" class="form-inline" role="form">
	<div class="container"  style='width:1000px; height:500px;'>
	<h2 class="board_title" align="center" style="margin-top:40px;">Cook</h2>
		<div class="form-group">
	    	
				<input type ="submit" id="pw_btn" value="확인" class="btn btn-success">
			</div>
	  	</div>
	</div>
		<input type ="hidden" name ="num" value="${vo.boardNUM}">

	</form>
</body>
</html>