<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width = "700" border = "1">
		<tr height="40">
			<td align="right" colspan="5">
			<input type="button" value="글쓰기" onclick="location.href='aBoardWriteForm.jsp'">
			</td>
		</tr>
		<tr height="40">
			<td width="50" align="center">번호</td>
			<td width="320" align="center">제목</td>
			<td width="150" align="center">작성일</td>
			<td width="80" align="center">조회수</td>
		</tr>

		<% 
			for(int i=0;i < vec.size();i++){
				BoardBean bean = vec.get(i);// 벡터에 저장되어있는 빈 클래스 하나씩 추출 
		%>
		<tr height="40">
			<td width="50" align="center"><%=number--%></td>
			<td width="320" align="left"><a
				href="BoardInfo.jsp?num=<%=bean.getNum()%>"
				style="text-decoration: none;"> <% 
							if(bean.getRe_stop() > 1){
								for(int j = 0 ;j<(bean.getRe_stop()-1)*5;j++){		
						%> &nbsp; <% 		}
							}
						%> <%=bean.getSubject()%>
			</a></td>
			<td width="100" align="center"><%=bean.getWrite()%></td>
			<td width="150" align="center"><%=bean.getReg_date()%></td>
			<td width="80" align="center"><%=bean.getReadcount()%></td>
		</tr>
		<%}%>
	</table>
</body>
</html>