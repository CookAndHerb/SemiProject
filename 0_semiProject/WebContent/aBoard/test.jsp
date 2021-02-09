<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
  <th>Value</th>
  <th>Square</th>
</tr>
<c:forEach var="x" begin="0" end="10" step="2">
<tr>
  <td><c:out value="${x}"/></td>
  <td><c:out value="${x * x}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>