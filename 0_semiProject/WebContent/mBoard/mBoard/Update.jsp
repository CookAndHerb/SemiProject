<%@ page import="com.recipe.mBoard.dao.mBoardDAO" %>
<%@ page import="com.recipe.mBoard.model.mBoardVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	// 쿠키 
	Cookie[] cookieFromRequest = request.getCookies();
	String cookieValue = null;
	for(int i = 0 ; i<cookieFromRequest.length; i++) {
		// 요청정보로부터 쿠키를 가져온다.
		cookieValue = cookieFromRequest[0].getValue();	// 테스트라서 추가 데이터나 보안사항은 고려하지 않으므로 1번째 쿠키만 가져옴	
	}
	
	// 글 목록 -> 글 상세 : 글번호
 	String seq = request.getParameter("boardNum");
 	
 	// 쿠키 세션 입력
	if (session.getAttribute(seq+":cookie") == null) {
	 	session.setAttribute(seq+":cookie", seq + ":" + cookieValue);
	} else {
		session.setAttribute(seq+":cookie ex", session.getAttribute(seq+":cookie"));
		if (!session.getAttribute(seq+":cookie").equals(seq + ":" + cookieValue)) {
		 	session.setAttribute(seq+":cookie", seq + ":" + cookieValue);
		}
	}
 
 //	mBoardVO vo = new mBoardVO();
 //	vo.getBoardNUM()(Integer.parseInt(num));
 	
 	mBoardDAO boardDAO = new mBoardDAO();
 	// 글 상세 조회
 	mBoardVO  mboardvo    = boardDAO.getOneBoard(conn, num);

 	// 조회수 카운트
 	if (!session.getAttribute(seq+":cookie").equals(session.getAttribute(seq+":cookie ex"))) {
 		boardDAO.getAllCount(conn);
	 	// 가시적으로  조회수 1 추가해줌
	 	board.setboardHit(board.getboardHit() + 1);//
 	}
 	
 	//System.out.println("중복방지 111 = " + session.getAttribute(seq+":cookie") );
 	//System.out.println("중복방지 222 = " + session.getAttribute(seq+":cookie ex") );
 	//System.out.println("중복방지 333 = " + session.toString() );
 	//for(int i = 0; i < session.getValueNames().length; i++){
 	//	System.out.println("중복방지 444 = " + session.getValueNames()[i].toString() );
 	//}
 	
 --%> 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
		<a href="logout_proc.jsp">log out</a>  <!--  -->
		<hr>
		<form action="updateBoard_proc.jsp" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left">
						<input name="title" type="text" value="<%= board.getboardTitle() %>">
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><%= board.getboardWriter() %></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left">
						<textarea name="content" cols="40" rows="10"><%= board.getContent() %></textarea>
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left"><%= board.getboardDate() %></td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left"><%= board.getboardHit %></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글 수정" />
					</td>
				</tr>
			</table>
			<input name="seq" type="hidden" value="<%= board.getboardNum %>" />
		</form>
		<hr>
		<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
		<%--<a href="deleteBoard_proc.jsp?num=<%= board() %>">글 삭제</a>&nbsp;&nbsp;&nbsp; --%>
		<a href="getBoardList.jsp">글 목록</a>
	</center>
</body>
</html>