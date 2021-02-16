<%-- <%@page import="com.recipe.mBoard.model.BoardList" %>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.recipe.mBoard.model.mBoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loos.dtd">

<html>
<head>
<meta http-equiv="Context-Type" content="text/html; charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td{
border : 1px solid #ccc;
border-collapse: collapse;
padding: 6px;
margin: auto;
text-align:center;
}
</style>

</head>
<body>
<%ArrayList<mBoardVO> list=(ArrayList<mBoardVO>)request.getAttribute("list"); 
	BoardList plist = (BoardList)request.getAttribute("plist");
	
	int currentPage = plist.getCurrentPage();
	int startPage = plist.getStartPage();
	int endPage = plist.getEndPage();
	int totalPage = plist.getTotalPage();
	%> 
  <h2>COOK&TALK</h2>
  <p>COOK&TALK 자유게시판 입니다</p>   
<div style="text-align: right; width:700px; margin:auto;">
  총<%=plist.getTotalCount() %>개 글 /
 현재<%=plist.getCurrentPage() %>페이지/
 총<%=plist.getTotalPage() %> 페이지
 </div>

  <table>
    <thead>
      <tr>
        <th>글번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
    </thead>
   <%
   for(mBoardVO boardvo : list){
	   %> 
   <tr>
   <td><%=boardvo.getBoardNo() %></td>
   <td style="text-align: left;">
   <a href="selectOne.jsp?boardNo=<%=boardvo.getBoardNo() %>&page=<%=currentPage %>">
  <%=boardvo.getBoardTitle() %>
   </a>     

<td><%=boardvo.getBoardHit() %></td>
</tr>
<%
   }
%>
  </table>
  <div style="text-align: right; width:700px; margin:auto;">
  <br>
  <input type="button" value="글작성" onclick="location.href='WriteForm.jsp;">
  </div>
  <div style="text-align: center;">
  <%
  if(currentPage > 10){
	  
  %>
  <input type="button" value="&lt;&lt;" onclick="location.href='?page=<%=currentPage-10%>'">
  
  <%
  }
  if(currentPage ==1){
	  out.print("<input type='button' value='&lt;' disabled>");
  }else{
%>
<input type="button" value="&lt;"
onclick="location.href='?page=<%=currentPage-1 %>'">
<% 
  }
  for(int i=startPage; i<=endPage; i++){
	  if(i == currentPage){
%>
<input type="button" value="<%=i%>" style="color: green;" disabled>
<% 		  
	  }else{
%>
<input type="button" value="<%=i %>"
onclick="location.href='?page=<%=i %>'">
<% }
  }
  if(currentPage== totalPage){
	  out.print("<input type='button' value=&gt;' disabled>");
  }else{
%>
	  <input type='button' value=&gt;"
	  onclick="location.href='?page=<%=currentPage+1 %>'">
<%
  }
  if(endPage < totalPage){
%>
<input type="button" value="&gt;&gt;"
onclick="location.href='?page=<%=endPage+1 %>'">
<%
} 
%>
 </div>
 </body>
</html>
--%>


<%@page import="com.recipe.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!--  <script type="text/javascript"> //글쓰기 버튼 클릭시 글쓰기 화면으로 이동
function WriteForm(){
	location.href="WriteForm.jsp";
}
</script>
-->

<style>
	.container {
    	margin: 0;
    	padding: 0;
    }
    #btnSearch{
    	background-color:  #b0c364;
    	border-color:  #b0c364;
    }
    #write_btn{
    	background-color:  #b0c364;
    	border-color:  #b0c364;
    }
    .subject{
    	text-align: center;
    }
    .text{
		color:  #b0c364;
		text-align: center;
    }
    table{
    	margin-right : 300px;
    }
}
</style>

</head>
<body>
<!-- 상단 공동 메뉴 -->
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>

<% MemberVO mvo = (MemberVO)session.getAttribute("member"); 
	System.out.println(mvo);  %>
<br>
  <h2 class="subject">COOK&TALK</h2>
  <p class="text">COOK&TALK 자유게시판 입니다</p> 
  
 
	
	<div class="form-row">

         <c:if test="${not empty member}"> <!-- 로그인 했을 경우 글쓰기 버튼 보여줌 -->
 <button onclick="location.href ='/mBoard/mBoard/WriteForm.jsp'">글작성</button> 
	</c:if>  		
          
  
    </div>
    
    
	<table class="table table-hover col-sm-10" >
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:set var="number" value="${number}" />
		<c:forEach var="v" items="${list}">
			
			<tr>
				<td>${v.boardNUM}</td>
				<td>
				<a href="/mBoardInfo.do?num=${v.boardNUM}">${v.boardTitle}</a>
				</td>
				<td>${v.boardWriter}</td>
				<td>${v.boardDate}</td>
				<td>${v.boardHit}</td>
			</tr>
			<c:set var="number" value="${number-1}" />
		</c:forEach>
	</table>
	
	<%-- <p>
	<c:if test="${count>0}">
			<c:set var="pageCount" value="${count /pageSize + (count%pageSize == 0 ? 0 : 1 )}" />
			<c:set var="startPage" value="${1}" />
			
			<c:if test="${currentPage % 5 != 0}">
				<fmt:parseNumber var="result" value="${currentPage%5}" integerOnly="true"/>
				<c:set var="startPage" value="${result*5+1}" />
			</c:if>
			
			<c:if test="${currentPage%5 == 0}">
				<c:set var="startPage" value="${(result-1)*5+1}" />
			</c:if>
			
			<c:set var="pageBlock" value="${5}" />
			<c:set var="endPage" value="${startPage+pageBlock-1}" />
			
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			
			<!--이전-->
			<c:if test="${startPage > 5}">
				<a href="/mBoardList.do?pageNum=${startPage-5}">[[◀]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPage+1}" end="${endPage}">
				<a href="/mBoardList.do?pageNum=${i}">[${i}]</a>
			</c:forEach>
			
			<!-- next -->
			<c:if test="${endPage < pageCount}">
				<a href="/mBoardList.do?pageNum=${startPage+5}">[▶]</a>
			</c:if>
		</c:if>
	</p> --%>
	
	<div class="container">
	<c:if test="${count>0}">
			<!-- 카운터링 숫자를 얼마까지 보여줄건지 결정 -->
			<c:set var="pageCount" value="${count /pageSize + (count%pageSize == 0 ? 0 : 1 )}" />
			<c:set var="startPage" value="${1}" />
			
			<c:if test="${currentPage%5 != 0}">
				<!--결과를 정수형으로 리턴 받아야 하기에 fmt  -->
				<fmt:parseNumber var="result" value="${(currentPage-1)/5}" integerOnly="true"/>
				<c:set var="startPage" value="${result*5+1}" />
			</c:if>
			
			<c:if test="${currentPage%5 == 0}">
				<!--결과를 정수형으로 리턴 받아야 하기에 fmt  -->
				<c:set var="startPage" value="${result*5+1}" />
			</c:if>
			
			<!-- 화면에 보여질 페이지 처리 숫자를 표현 -->
			<c:set var="pageBlock" value="${5}" />
			<c:set var="endPage" value="${startPage+pageBlock-1}" />
			
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			
			<!-- 게시판 페이징 -->
			<c:set var="keyword" value="${param.keyword}" />
			<c:if test="${keyword == null}">
			 <ul class="pagination justify-content-center" style="margin:20px 0">
			 	<!-- 이전 -->
				<c:if test="${startPage > pageBlock}">
					<li class="page-item"><a class="page-link" href="/boardAllList.do?pageNum=${startPage-5}">◀</a></li>
				</c:if>
				<!-- 페이지 숫자 -->
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i==currentPage}">
						<li class="page-item active"><a class="page-link" href="/boardAllList.do?pageNum=${i}">${i}</a></li>
					</c:if>
					<c:if test="${i!=currentPage}">
						<li class="page-item"><a class="page-link" href="/boardAllList.do?pageNum=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				<!-- 다음  -->
				<c:if test="${endPage < pageCount}">
					<li class="page-item"><a class="page-link" href="/boardAllList.do?pageNum=${startPage+5}">▶</a></li>
				</c:if>
			</ul>
			</c:if>
			
			<!-- 검색 시 페이징 -->
			<c:if test="${keyword != null}">
			 <ul class="pagination justify-content-center" style="margin:60px 0">
			 	<!-- 이전 -->
				<c:if test="${startPage > pageBlock}">
					<li class="page-item"><a class="page-link" href="/aBoardSearch.do?keyword=${keyword}&pageNum=${startPage-5}">◀</a></li>
				</c:if>
				<!-- 페이지 숫자 -->
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i==currentPage}">
						<li class="page-item active"><a class="page-link" href="/aBoardSearch.do?keyword=${keyword}&pageNum=${i}">${i}</a></li>
					</c:if>
					<c:if test="${i!=currentPage}">
						<li class="page-item "><a class="page-link" href="/aBoardSearch.do?keyword=${keyword}&pageNum=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				
				<!-- 다음  -->
				<c:if test="${endPage < pageCount}">
					<li class="page-item"><a class="page-link" href="/aBoardSearch.do?keyword=${keyword}&pageNum=${startPage+5}">▶</a></li>
				</c:if>
			</ul>
			</c:if>
		</c:if>
	</div>
	
	<form name="searchForm" id="searchForm" method="get">
					<input type="hidden" name="page" id="page" value="1">
					<input type="hidden" name="codeSeq" id="codeSeq" value="48">
					<fieldset class="search_area" style="text-align:center">
						<select name="searchKey" id="searchKey" style="padding:1px">
							<option value="Title">제목</option>
							<option value="writerNick">닉네임</option>							<option value="bContent">내용</option>
						</select>
<input type="text" name="searchVal" id="searchVal" style="width:150px; padding:2px; border:1px solid #abadb3" value="">
<button type="button" class="btn btn-outline-success" value="검색" style="border:none; 
vertical-align:middle" onclick="searchChk();">검색</button> <!-- 마우스 올리면 색생 나타남 -->

<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
</body>
</html>




