<%@page import="com.recipe.member.vo.MemberVO"%>
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

	#del_btn{
	background:#b0c364;
	}
	
	.info_box{
	font-size: 15px;
	}
	
	.info_box2{
	display : inline-block;
	width :75px;
	color: gray;
	}
	
	.info_img{
	display : inline-block;
	width: 43px;
	}
	
	.category_box{
	display: inline-block;
	font-size: 17px;
	font-weight: bold;
	
	margin-top:30px;
	margin-left:300px;
	color : gray;
	}
	

</style>
</head>
<body>

	<!-- 상단 공동 메뉴 -->
	<header id="top_section">
		<%@ include file="/template/top.jsp" %>
	</header>
	    <!-- ##### Hero Area Start ##### -->



	
	<!-- 글 상세 페이지 -->
	<%
	Rboard rboard = (Rboard)request.getAttribute("post"); // 글 정보 꺼내기
	int currentPage = (int)(request.getAttribute("currentPage"));
	MemberVO mvo = (MemberVO)session.getAttribute("member"); // 로그인 정보 꺼내기
	
	String arr[] = new String[]{"반찬","국 & 탕","찌개","밥 & 죽","면","디저트","비건","음료","기타"};
	String category =  Integer.valueOf(rboard.getBoardCategory()).toString();

		if(category.equals("1")) category = arr[0];
		else if(category.equals("2")) category = arr[1];
		else if(category.equals("3")) category = arr[2];
		else if(category.equals("4")) category = arr[3];
		else if(category.equals("5")) category = arr[4];
		else if(category.equals("6")) category = arr[5];
		else if(category.equals("7")) category = arr[6];
		else if(category.equals("8")) category = arr[7];
		else if(category.equals("9")) category = arr[8];
		
	

	%>
	
	<c:set var="mvo" value="<%=mvo%>"/>
	<c:set var="rboard" value="<%=rboard %>"/>
	
	
<!-- ##### Post Details Area Start ##### -->
<br>
<hr>

	<!-- 카테고리 -->
	<div class="category_box">
	 	  <a href="/rBoard/RboardCategoryPage.jsp">
          <span class="glyphicon glyphicon-home" style="color:gray;">Category Home</span>
        </a>&nbsp;<i class="fa fa-angle-right"></i> &nbsp;<%=category %>
	 </div>
	 
	 
    <section class="post-news-area section-padding-100-0 mb-100">
        <div class="container">
            <div class="row justify-content-center">
                <!-- Post Details Content Area -->
                <div class="col-12 col-lg-4 col-xl-5">
                    <div class="post-details-content mb-100">
                        <div class="blog-thumbnail mb-50">
                            <img src="<%=rboard.getFilePath()%>//<%=rboard.getChangeName() %>">
                        </div>
                        
                    </div>
                </div>

                <div class="col-12 col-lg-4 col-xl-4">
                    <!-- Info -->
                    <div class="recipe-info2 info">
                        <h4 style="color:#b0c364;">Info</h4>
                        
                        <hr>
                        
                        <ul class="info-data2">
                            <li><div class="info_img"><img src="/resources/img/core-img/sandwich.png" ></div><span class="info_box"><b><div class="info_box2">카테고리</div><%=category %></b></span></li>
                            <hr>
                            <li><div class="info_img"><img src="/resources/img/core-img/alarm-clock.png"></div><span class="info_box"><b><div class="info_box2">제목</div><%=rboard.getBoardTitle() %></b></span></li>
                            <hr>
                            <li><div class="info_img"><img src="/resources/img/core-img/tray.png"></div><span class="info_box"><b><div class="info_box2">작성자</div><%=rboard.getBoardWriter() %></b></span></li>
                            <hr>
                            <li><div class="info_img"><img src="/resources/img/core-img/eye.png"></div><span class="info_box"><b><div class="info_box2">작성일</div><%=rboard.getBoardDate() %></b></span></li>
                            
                        </ul>
                    </div>

                 
                </div>
                
               		 <div class="blog-content col-10">
                            
                            <h5 class="mb-30">레시피</h5>
                            <p class="mb-30"><pre><%=rboard.getBoardContent() %></pre></p>

                            
                        </div>
                </div>
           </div>     
           <br>
           <br>
               <c:choose>		
					<c:when test="${mvo.userNickname eq rboard.boardWriter}">
						<div class="row float-right col-4">
							<a href="/RboardDel.do?boardNum=${rboard.boardNum}&category=${rboard.boardCategory}" type="button" onclick="return confirm('글을 삭제하시겠습니까?')"id ="del_btn" type="button" class="btn text-white" >삭제</a>&nbsp;
							<a href="/RboardGoUpt.do?boardNum=${rboard.boardNum}&currentPage=${currentPage}" type="button" class="btn btn-dark text-white" >수정</a>&nbsp;
							<a href="/RboardAllList.do?category=${rboard.boardCategory}&currentPage=${currentPage}" type="button" class="btn btn-secondary text-white" >목록</a>
						</div>
					</c:when>
				     <c:otherwise>
				      <div class="row float-right col-3">
						 	<a href="/RboardAllList.do?category=${rboard.boardCategory}&currentPage=${currentPage}" type="button" class="btn btn-secondary text-white" >목록</a>
				     
					  </div>
					</c:otherwise>	
         	  </c:choose>
</section>
  <hr>
  <br>
  <br>
  <br>
	<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
	
</body>
</html>