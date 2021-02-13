<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="${path}/ckeditor/ckeditor.js"></script>


<title>cook Q&A 글 작성 페이지</title>
<style>
	.btn_group{
		display: flex;
  		justify-content: center;
	}
	.form-group{
		display: flex;
  		justify-content: center;
	}
	#Confirm_btn{
		background-color:  #b0c364;
    	border-color:  #b0c364;
	}
	#cancel_btn{
		background-color:  #b0c364;
    	border-color:  #b0c364;
	}
	
</style>
</head>
<body>
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>
<h2 class="board_title" align="center" style="margin: 20px 0px 30px 0;">Cook Q&A</h2>
	<form action="/aBoardWriteServlet.do" method="post" class="justify-content-center">
		<div class="row justify-content-md-center">
            <div class="col-sm-6">
            <div class="input-group mb-2">
                <div class="input-group-prepend">
                    <label class="input-group-text px-4">제목</label>
                </div>            
                  <input type="text" name="title" class="form-control">              
                </div>
            </div>
        </div>
  		
  		<div class="row justify-content-md-center">
            <div class="col-sm-6">
            <div class="input-group mb-2">
                <div class="input-group-prepend">
                    <label class="input-group-text px-2">비밀번호</label>
                </div>            
                  <input type="password" name="password" class="form-control">              
                </div>
            </div>
        </div>
 		
		<div class="form-group">
			<textarea id="editor1" name="content" rows="15" cols="80"></textarea>
			<script> // Replace the <textarea id="editor1"> 
    		// 옵션을 부여하고, editor1 이라는 녀석의 아이디를 에디터로 변환합니다.
    		CKEDITOR.config.width = 1000; // 넓이 
    		CKEDITOR.config.height = 600; // 높이 // 퍼센트로 가능합니다. 
    		CKEDITOR.replace( 'editor1' , {
    		}); 
    		</script>
		</div>
   		 
		<div class="btn_group mb-5">
			<input type="submit" value="확인" id="Confirm_btn" class="btn btn-success">&nbsp;&nbsp;&nbsp;&nbsp;
			<button onclick="location.href='/aBoard/aBoardList.jsp'" id="cancel_btn"class="btn btn-success">취소</button>
		</div>
	</form>
</body>
</html>