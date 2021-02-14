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
import com.recipe.member.vo.MemberVO;

@WebServlet("/memberFindId.do")
public class MemberFindId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/memberFindId.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		
		String userId = null;
		
		userId = new MemberService().findId(userName, userPhone);
		
		if(userId!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			request.getRequestDispatcher("/views/memberFindIdSuccess.jsp").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('ID를 찾을 수 없습니다.');</script>");
			out.println("<script>location.replace('/index.jsp');</script>");
		}
		
	}
}
