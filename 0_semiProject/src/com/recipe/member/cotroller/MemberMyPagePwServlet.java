package com.recipe.member.cotroller;

import java.io.IOException;

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
 * Servlet implementation class MemberMyPagePwServlet
 */
@WebServlet("/MemberMyPagePw.do")
public class MemberMyPagePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMyPagePwServlet() {
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
		// 비밀번호 입력받음 -> 기존 비밀번호와 일치하는지 확인 
		// 일치하면 수정폼으로 이동
		// 일치하지 않으면 <alert> 띄우고 history.back(-1)
		
		String input_userPw = request.getParameter("userPw");
		
		HttpSession session = request.getSession();
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		String userId = mvo.getUserId();
		String userPw = mvo.getUserPw(); // 원래 비밀번호 
		
		
		if(userPw.equals(input_userPw)) { // 입력한 비밀번호와 일치한다면
			session.setAttribute("member", mvo);
			//수정폼으로 보내기
			RequestDispatcher view = request.getRequestDispatcher("/member/memberMyPageForm.jsp");
			view.forward(request, response);
		}else { // 일치하지 않으면 다시 비밀번호 입력창으로 돌려보내기
			RequestDispatcher view = request.getRequestDispatcher("/member/memberMyPagePwFail.jsp");
			view.forward(request, response);
			
		}
		

		
	}
}
