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

@WebServlet(name = "MemberLogin", urlPatterns = { "/memberLogin.do" })
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("//views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		//1. 이전 페이지에서 보내준 값을 Servlet에서 받을 수 있도록 해야 함.
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		System.out.println("ID : "+userId);
		System.out.println("PW : "+userPw);

		//2. 비지니스 로직 처리
		MemberVO mvo = new MemberService().loginMember(userId,userPw);
		System.out.println(mvo);

		//3. 돌아온 결과에 따라서 성공/실패 로직 처리
		//성공했으면 m객체 안에 Member 데이터가 있을 것이고, 실패했으면 m객체 안에 null이 있는 상황

		//out객체를 통해서 한글을 정상적으로 전송하려면 인코딩 작업이 필요함
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		if(mvo!=null) {
			/* jsp에서는 session객체가 내장객체이기 때문에 바로 사용이 가능하지만 
			 * Servlet은 내장객체가 아니기 때문에 만들고 나서 사용해야 함	*/
			HttpSession session = request.getSession();
			session.setAttribute("member", mvo);

			System.out.println("login : "+mvo);
			
			request.getRequestDispatcher("/member/memberLoginSuccess.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/member/memberLoginFail.jsp").forward(request, response);
		}

	}
}
