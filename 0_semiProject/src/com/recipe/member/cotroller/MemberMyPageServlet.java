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

@WebServlet("/myPageLoad.do")
public class MemberMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		//해당 서블릿의 로직은 나의 정보를 가져와서 jsp 페이지를 통해서 보여주는 역할
		//정보를 가져오는 방법 : 1.session 2.DB -> 2번 사용
		//DB에서 처리한다고 해도 DB에서 ID+PW 값을 추출해서 가져온 DB데이터로 session을 갱신

		HttpSession session = request.getSession();
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		String userId = mvo.getUserId();
		String userPw = mvo.getUserPw();
		
		session.setAttribute("member", mvo);

		//갱신하기 위한 비즈니스 로직 처리
		mvo = new MemberService().loginMember(userId, userPw);
		session.setAttribute("member", mvo);

		RequestDispatcher view = request.getRequestDispatcher("/member/memberMyPage.jsp");
		view.forward(request, response);
	}

}
