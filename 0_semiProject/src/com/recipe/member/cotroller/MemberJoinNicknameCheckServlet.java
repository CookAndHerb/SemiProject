package com.recipe.member.cotroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.member.service.JoinMemberService;

/**
 * Servlet implementation class MemberJoinNicknameCheckServlet
 */
@WebServlet("/MemberJoinNicknameCheck.do")
public class MemberJoinNicknameCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String userNickname = request.getParameter("userNickname");
		response.getWriter().write(new JoinMemberService().JoinNicknameCheck(userNickname)+"");
	}

}
