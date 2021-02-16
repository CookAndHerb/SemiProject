<%@page import="com.recipe.member.vo.MemberVO"%>
<%@page import="com.recipe.notice.model.vo.NoticeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글 목록</title>
<style>
table {
	font-size: 20px;
	text-align: center;
	padding : 20px;
	border-collapse: collapse;
  text-align: left;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  margin: 20px 10px;
}


table td {
	width: 350px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
}

.header {
	width: 150px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #deeda1;
}

#searchDiv {
	font-size : 20px;
	text-align : center;
	padding : 20px;
}

#searchInput {
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
<%
	MemberVO m = (MemberVO)session.getAttribute("member");
	ArrayList<NoticeVO> list = (ArrayList<NoticeVO>)request.getAttribute("list");
%>
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>
<section>
 	<% MemberVO mvo = (MemberVO)session.getAttribute("member"); // 로그인 돼있는 경우만 글쓰기 버튼 보이도록
	
	if(mvo != null && mvo.getUserNum() < 1000){
	%>0
 
	<div class="float-right write">
  <input type="button"  id="writeBtn" onclick="location.href='notice/noticeWriteForm'" value="글쓰기">
  </div>
  <%} %>
  

	<c:if test="${ count == 0 }">
		<table class="table text-center">
			<tr>
				<td><h4>게시판에 저장된 글이 없습니다.</h4></td>
			</tr>
		</table>
	</c:if>
-->	
		<h1 align="center">공지사항</h1>
		<table id="noticeList">
			<tr height="45">
				<td class="header" style="width:8.33%">글번호</td>
				<td class="header" style="width:65%">제목</td>
				<td class="header" style="width:11.67%">작성자</td>
				<td class="header" style="width:15%">작성일</td>
			</tr>
			<c:set var="number" value="${number }" />
			<c:forEach var="noticeVO" items="${ list }">
			<tr>
				<td width="10%">${number }</td>
				<td width="52%"><a href="/detailNotice.do?noticeNum=${noticeVO.noticeNum}&number=${number}">${noticeVO.noticeTitle }</a></td>
				<td width="16%">${ noticeVO.noticeWriter }</td>
				<td width="19%">${ noticeVO.noticeDate }</td>
				<c:set var="number" value="${number-1 }" />
			</tr>
			</c:forEach>
		</table>
		
	<div id="searchDiv">
		<form action="/searchNotice.do" method="get">
			<input type="text" name="keyword"/>
			<input type="submit" value="검색" id="searchInput"/>
		</form>
	</div>
	
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
					<li class="page-item"><a class="page-link" href="//noticeAllList.do?pageNum=${startPage-5}">◀</a></li>
				</c:if>
				<!-- 페이지 숫자 -->
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i==currentPage}">
						<li class="page-item active"><a class="page-link" href="/noticeAllList.do?pageNum=${i}">${i}</a></li>
					</c:if>
					<c:if test="${i!=currentPage}">
						<li class="page-item"><a class="page-link" href="/noticeAllList.do?pageNum=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				<!-- 다음  -->
				<c:if test="${endPage < pageCount}">
					<li class="page-item"><a class="page-link" href="/noticeAllList.do?pageNum=${startPage+5}">▶</a></li>
				</c:if>
			</ul>
			</c:if>
			
			<!-- 검색 시 페이징 -->
			<c:if test="${keyword != null}">
			 <ul class="pagination justify-content-center" style="margin:60px 0">
			 	<!-- 이전 -->
				<c:if test="${startPage > pageBlock}">
					<li class="page-item"><a class="page-link" href="/aBoardSearch.do?keyword=${keyword}&&pageNum=${startPage-5}">◀</a></li>
				</c:if>
				<!-- 페이지 숫자 -->
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i==currentPage}">
						<li class="page-item active"><a class="page-link" href="/aBoardSearch.do?keyword=${keyword}&&pageNum=${i}">${i}</a></li>
					</c:if>
					<c:if test="${i!=currentPage}">
						<li class="page-item "><a class="page-link" href="/aBoardSearch.do?keyword=${keyword}&&pageNum=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				
				<!-- 다음  -->
				<c:if test="${endPage < pageCount}">
					<li class="page-item"><a class="page-link" href="/aBoardSearch.do?keyword=${keyword}&&pageNum=${startPage+5}">▶</a></li>
				</c:if>
			</ul>
			</c:if>
		</c:if>
	</div>
	
	
</section>
<footer>
		<%@ include file="/template/bottom.jsp" %>
</footer>
</body>
</html>