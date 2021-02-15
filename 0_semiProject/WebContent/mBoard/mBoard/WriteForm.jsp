<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판 테스트</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>게시판 테스트</title>

    <meta charset="UTF-8">

    <meta name="description" content="">

    <meta name="keywords" content="">

    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>

    <script language = "javascript">

  
   </script>

    <style>

      .body{

        width:1100px;

        margin:50px auto 0;

        text-align: center;

      }

      .body, .body td, .body th{ border-collapse: collapse; border:1px solid black; box-sizing: border-box;}

      .body th{width:242px; padding:10px 0;}

      .body td{padding:10px 0;}

      #board_title{width:730px; height:30px;}

      #board_content{width:730px; height:300px;}

      .Btn{margin:30px auto 0; width:100px;}

    </style>
</head>
<body>
<div class="container">
  <h2>COOK&TALK</h2>
  <p>COOK&TALK 자유게시판 입니다</p>  
  
<form action="/mBoardWrite.do" method="post">

    <table class="body">

      <tr>

        <th>글제목</th>

        <td><input type="text" id="board_title" name="board_title"></td>

      </tr>

      <tr>

        <th>글내용</th>

        <td><textarea id="board_content" name="board_content"></textarea></td>

      </tr>
      
      <tr>

        <th>작성자</th>

        <td><input type="text" id="board_title" name="board_title"></td>

      </tr>
      
      <tr>

        <th>등록일</th>

        <td><input type="text" id="board_title" name="board_title"></td>

      </tr>
      
      <tr>

        <th>조회수</th>

        <td><input type="text" id="board_title" name="board_title"></td>

      </tr>
      

    </table>
</form>
  
<script type="text/javascript">

function WriteForm() {

	if ($("#boardTitle").val() == "") {
		alert("제목을 입력해주세요");
		return;
	}

    $("#boardContent").val();
    if ($("#baordContent").val() == "") {
        alert("내용을 입력해주세요");
        return;
    }
    
</script>

<div class="Btn">

<button onclick="location.href='/mBoard/boardAllList.jsp'" >등록</button> 
<!--  <input type="submit" value="등록" id="confirm" class="btn btnsuccess" >-->
<button onclick="location.href='/mBoard/boardAllList.jsp'" >작성취소</button>  

 </div>
</body>
</html>
