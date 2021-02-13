<%@page import="com.recipe.member.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.recipe.rboard.model.vo.Rboard"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
<title>전체목록페이지</title>
<style>
/* 본문 내부 간격 */
section#content_body {
	/* padding:20px 0; */
	/* 템플릿 적용시 전체 레이아웃 높이 조정 : 본문 가용화면 확보 : 
	     가용화면(viewport) - 상단메뉴 높이 - 하단 section 높이 - (padding(높이))  */
	min-height:calc(100vh - 50px - 70px);
}


	.write{
	margin-right : 250px;
	margin-top : 20px;
	
	}

	#wrtbtn{
	background : #b0c364;
	}
	
	.noRecipe{
	text-align: center;
	border:2px solid #b0c364;
	padding : 100px;
	
	}
	
	.noRecipe_cont{
	font-size: 30px;
	font-weight: bold;
	color : gray;
	}
	
	.noRecipe_goCategory{
	font-size: 20px;
	font-weight: bold;
	color : #404040;
	}
	
	.category_box{
	display: inline-block;
	font-size: 17px;
	font-weight: bold;
	
	margin-top:30px;
	margin-left:300px;
	color : gray;
	}
	
	.post_content{
	margin-left:250px;
	margin-bottom: 30px;
	margin-top:50px;
	}
	
	.post_box{
	
	display : inline-block;
	width : 350px;
	height: 350px;
	}
	
	.img_box{
	width : 300px;
	height : 250px;
	
	}
	
	.post-title{
	font-size: 15px;
	font-weight: bold;
	color: dark-gray;
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
	List<Rboard> list = (ArrayList<Rboard>)request.getAttribute("boardList");	
	int category = (int)request.getAttribute("category");
	String category2 =  Integer.valueOf(category).toString();

	if(category2.equals("1"))  category2 = "반찬";
	else if(category2.equals("2")) category2 = "국  & 탕";
	else if(category2.equals("3")) category2 = "찌개";
	else if(category2.equals("4")) category2 = "밥 & 죽";
	else if(category2.equals("5")) category2 = "면";
	else if(category2.equals("6")) category2 = "디저트";
	else if(category2.equals("7")) category2 = "비건";
	else if(category2.equals("8")) category2 = "음료";
	else if(category2.equals("9")) category2 = "기타";
	
	%>	    
	<hr>
<!-- 카테고리  --> 
	   <div class="category_box">
	 	  <a href="/rBoard/RboardCategoryPage.jsp">
          <span class="glyphicon glyphicon-home" style="color:gray;">Category Home</span>
        </a>&nbsp;<i class="fa fa-angle-right"></i> &nbsp;<%=category2 %>
	   </div>
	   
 <!-- 글쓰기 버튼 -->
 	<% MemberVO mvo = (MemberVO)session.getAttribute("member"); // 로그인 돼있는 경우만 글쓰기 버튼 보이도록
	
	if(mvo != null){
	%>
 
	<div class="float-right write">
  <a type="button " class="btn text-white bold " id="wrtbtn" href="/rBoard/RboardInsertPage.jsp"><b>글쓰기</b></a>
  </div>
  <%} %>
  
  
	<!-- content -->
	 <% if(list.size() == 0) { // 등록된 레시피가 없는 경우 %>  
    <!-- ##### Catagory Post Area Start ##### -->
    <div class="catagory-post-area section-padding-100">
        <div class="container">
            <div class="row justify-content-center">
                <!-- Post Area -->
                <div class="col-12 col-lg-8 col-xl-9">
                    <!-- Single Blog Post -->
                  
                 
                 
                  <div class = "noRecipe">
                  
                  	<div class="noRecipe_cont">등록된 레시피가 없습니다<br>
                  	레시피를 등록해주세요 ! </div>
                  	<br>
                  	<br>
                  	<a href="/rBoard/RboardCategoryPage.jsp"class= "noRecipe_goCategory">
                  		Go Category Home &nbsp;<i class="fa fa-mouse-pointer" style="font-size:24px;color:#b0c364"></i>
                  	</a>
                  	
                  </div>
                 </div>
                </div>
               </div>
            </div>
                   
                   
                  <%} else{%>
                   
                   <div class="post_content col-10">
                   		<ul>
                   		<!-- 수정 반복 끝 -->
                   		 <% for (int i=0 ; i<list.size() ; i++) {
                    	Rboard rboard = list.get(i);
                        %>
                   			<li class="post_box">
                   				<table>
                   					<tr><td colspan=2><img class="img_box" onclick="location.href='/RboardPost.do?boardNum=<%=rboard.getBoardNum()%>&currentPage=${pageinfo.currentPage}';" src="<%=rboard.getFilePath()%>//<%=rboard.getChangeName() %>"></td></tr>
                   					<tr><td colspan=2 style="height:40px"><a href="/RboardPost.do?boardNum=<%=rboard.getBoardNum()%>&currentPage=${pageinfo.currentPage}" class="post-title"><%=rboard.getBoardTitle() %></a></td></tr>
                   					<tr><td class="sm-box"><%=rboard.getBoardDate()%> By <%=rboard.getBoardWriter()%></td></tr>
                   				</table>
                   			</li>
                   			
            	    			 <%} %>
                  
                    <!--  수정반복끝 -->
                    
                   		</ul>		
                   </div>
                 <%} %>
                    <!--원래 반복끝 -->
                   
            
 <% if(list.size() != 0) {%>
<ul class="pagination pagination-sm justify-content-center">

<c:choose>
	<c:when test="${pageinfo.currentPage == 1}">
            <li class="page-item disabled"><a class="page-link" href="#">◀</a></li>
	</c:when>
	<c:otherwise>
 	<li class="page-item"><a class="page-link" href="/RboardAllList.do?category=${category}&currentPage=${pageinfo.currentPage-1}">◀</a></li>
	</c:otherwise>
</c:choose>

<c:forEach var="page" begin="${pageinfo.startNavi}" end="${pageinfo.endNavi}">
	<c:choose>
	<c:when test="${pageinfo.currentPage == page}">
            <li class="page-item active"><a class="page-link" href="#">${page }</a></li>
	</c:when>
	
	<c:otherwise>
            <li class="page-item "><a class="page-link" href="/RboardAllList.do?category=${category}&currentPage=${page}">${page}</a></li>
	</c:otherwise>
	</c:choose>
</c:forEach>


<c:choose>
	<c:when test="${endNavi == pageTotalCount}">
            <li class="page-item"><a class="page-link" href="#">▶</a></li>
  	</c:when>
	<c:otherwise>
	 <li class="page-item"><a class="page-link" href="/RboardAllList.do?category=${category}&currentPage=${pageinfo.currentPage+1}">▶</a></li>
	</c:otherwise>
</c:choose>    
</ul>
<%} %>
<br>

     <div  id="search" align="center" >
                  <form action="/RboardSearch.do" method="post">
                         <select name="searchCategory">
               				 <option value="boardTitle">제목</option>
               				 <option value="boardWriter">작성자</option>
						</select>
                          <input type="search" name="keyword"  placeholder="Search">
                          <button type="submit" class="btn"><i class="fa fa-search"></i></button>
                   </form>
              </div>  
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