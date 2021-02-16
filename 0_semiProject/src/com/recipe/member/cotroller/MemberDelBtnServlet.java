package com.recipe.member.cotroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recipe.member.service.MemberService;
import com.recipe.member.vo.MemberVO;

/**
 * Servlet implementation class MemberDelBtnServlet
 */
@WebServlet("/MemberDelBtn.do")
public class MemberDelBtnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDelBtnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		String userId = mvo.getUserId();
		
		session.setAttribute("member", mvo);

		RequestDispatcher view = request.getRequestDispatcher("/member/memberDelForm.jsp");
		view.forward(request, response);
		
	}
}
