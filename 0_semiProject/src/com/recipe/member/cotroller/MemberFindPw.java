package com.recipe.member.cotroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recipe.member.service.MemberService;

@WebServlet("/memberFindPw.do")
public class MemberFindPw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/memberFindPw.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String userEmail = request.getParameter("userEmail");
		
		String userPw = null;
		
		userPw = new MemberService().findPw(userId, userEmail);
		
		if(userPw!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("userPw", userPw);
			session.setAttribute("userId", userId);
			request.getRequestDispatcher("/views/memberFindPwSuccess.jsp").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호를 찾을 수 없습니다.');</script>");
			out.println("<script>location.replace('/index.jsp');</script>");
		}
	}
}
