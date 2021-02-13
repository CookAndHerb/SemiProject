<%@page import="com.recipe.rboard.model.vo.Rboard"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>template</title>
<style>
/* 본문 내부 간격 */
section#content_body {
	/* padding:20px 0; */
	/* 템플릿 적용시 전체 레이아웃 높이 조정 : 본문 가용화면 확보 : 
	     가용화면(viewport) - 상단메뉴 높이 - 하단 section 높이 - (padding(높이))  */
	min-height:calc(100vh - 50px - 70px);
}

.wrt{

	margin-top : 100px;
	margin-bottom : 100px;
	margin-left: 300px;
}

</style>
</head>
<body>

	<!-- 상단 공동 메뉴 -->
	<header id="top_section">
		<%@ include file="/template/top.jsp" %>
	</header>
	    <!-- ##### Hero Area Start ##### -->
<%
	Rboard rboard = (Rboard)request.getAttribute("rboard");
	int currentPage = (int)request.getAttribute("currentPage");
	
	String arr[] = new String[]{"","","","","","","","",""};
	String category =  Integer.valueOf(rboard.getBoardCategory()).toString();

	if(category.equals("1"))  arr[0] = "selected";
	else if(category.equals("2")) arr[1] = "selected";
	else if(category.equals("3")) arr[2] = "selected";
	else if(category.equals("4")) arr[3] = "selected";
	else if(category.equals("5")) arr[4] = "selected";
	else if(category.equals("6")) arr[5] = "selected";
	else if(category.equals("7")) arr[6] = "selected";
	else if(category.equals("8")) arr[7] = "selected";
	else if(category.equals("9")) arr[8] = "selected";
	
	

%>

<c:set var="rboard" value="<%=rboard %>"/>
<!-- 글쓰기 부분 -->
<div class="container wrt">
	<div class="row2">
		<form  action="/RboardUpt.do" method="POST" enctype="multipart/form-data">
			<table class="table table-striped style="text-align:center; border:1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2" style="background-color:#eeeeee; text-align :center;">Cook Cook Recipe</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" value="${rboard.boardTitle }" class="form-control"  name="boardTitle" maxlength="100" ></td>
						<td>
						<select class="custom-select" id="inputGroupSelect03" name="boardCategory">
                    <option value="">category</option>
                    <option value="1" <%=arr[0] %>>반찬</option>
                    <option value="2" <%=arr[1] %>>국 & 탕</option>
                    <option value="3" <%=arr[2] %>>찌개</option>
                    <option value="4" <%=arr[3] %>>밥 & 죽</option>
                    <option value="5" <%=arr[4] %>>면</option>
                    <option value="6" <%=arr[5] %>>디저트</option>
                    <option value="7" <%=arr[6] %>>비건</option>
                    <option value="8" <%=arr[7] %>>음료</option>
                    <option value="9" <%=arr[8] %>>기타</option>
                    
                 			 </select>  
						</td>
					</tr>
					<tr>
						<td colspan="2"><textarea class="form-control" name="boardContent" maxlength="3000" style="height:350px;">${rboard.boardContent}</textarea></td>
					</tr>
					<tr>
						<td colspan="2" > 기존 파일 : ${rboard.originName} 
						<input type ="hidden" name="boardNum" value="${rboard.boardNum}"/>
						<input type ="hidden" name="existing_file_origin" value="${rboard.originName}"/>
						<input type ="hidden" name="existing_file_change" value="${rboard.changeName}"/>
						<input type ="hidden" name="currentPage" value="${currentPage}"/>
						
						</td>
					</tr>
					<tr>
						<td colspan="2"> 첨부 파일 : <input type="file"  name="file"></td>
					</tr>
				</tbody>
			
			</table>
				<div class="row justify-content-md-center">
        <input type="submit" class="btn btn-outline-secondary" style="width: 10%; font-weight: bold" value="완료">

            &nbsp;&nbsp;&nbsp;&nbsp;
             <button type="reset" class="btn btn-outline-secondary"onclick="history.back()" style="width: 10%; font-weight: bold">
             취소    
            </button>
        </div>
							
			
		</form>
	</div>
</div>



	<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
	
</body>
</html>