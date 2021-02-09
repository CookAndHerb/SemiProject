<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<td width="50" align="center">${number}</td>
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
</body>
</html>