<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="700" border="1">
		<tr height="40">
			<td colspan="5" align="right">
			<button onclick="location.href ='/aBoard/aBoardWriteForm.jsp'">글쓰기</button>
			</td>
		</tr>
		<tr height="40">
			<td width="50" align="center">번호</td>
			<td width="320" align="center">제목</td>
			<td width="150" align="center">작성일</td>
			<td width="80" align="center">조회수</td>
		</tr>
		<c:set var="number" value="${number}" />
		<c:forEach var="v" items="${v}">
			
			<tr height="40">
				<td width="50" align="center">${v.boardNum}</td>
				<td width="320" align="Left">
					<%-- <c:if test="${v.reStep>1}">
					<c:forEach var="j" begin="1" end="${(v.reStep-1)*2}">
						&nbsp;
					</c:forEach>
				</c:if>  --%> 
				<a href="/aBoardInfoServlet.do?num=${v.boardNum}">${v.boardTitle}</a>
				</td>
				<td width="150" align="Left">${v.boardDate}</td>
				<td width="80" align="Left">${v.readCount}</td>
			</tr>
			<c:set var="number" value="${number-1}" />
		</c:forEach>
	</table>
	
	<p>
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
			
			<!--이전 링크를 결지 파악 -->
			<c:if test="${startPage > 5}">
				<a href="/aBoardListSevlet.do?pageNum=${startPage-5}">[이전]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPage+1}" end="${endPage}">
				<a href="/aBoardListServlet.do?pageNum=${i}">[${i}]</a>
			</c:forEach>
			
			<!-- 다음  -->
			<c:if test="${endPage < pageCount}">
				<a href="/aBoardListServlet.do?pageNum=${startPage+5}">[다음]</a>
			</c:if>
		</c:if>
	</p>
</body>
</html>