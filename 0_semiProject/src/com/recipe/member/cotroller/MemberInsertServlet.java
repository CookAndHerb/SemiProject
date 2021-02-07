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

@WebServlet("/memberJoin.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		//1. 한글 값이 있을 경우를 위해 인코딩 처리
		request.setCharacterEncoding("UTF-8");

		//2. 이전 페이지에서 보낸 전송값을 꺼내서 자바에서 저장
		MemberVO mvo = new MemberVO();
		try { //try-catch는 정상 경로를 통해 회원가입을 한게 아니라 url만 복사해서 가입된 페이지로 가는 등의 에러 발생시 예외처리를 위해
			String userId = request.getParameter("userId");
			String userPw = request.getParameter("userPw");
			String userName = request.getParameter("userName");
			String userEmail = request.getParameter("userEmail");
			char userGender = request.getParameter("userGender").charAt(0);
			String userNickname = request.getParameter("userNickname");
			String userBirth = request.getParameter("userBirth");
			String userPhone = request.getParameter("userPhone");

			mvo.setUserId(userId);
			mvo.setUserPw(userPw);
			mvo.setUserName(userName);
			mvo.setUserEmail(userEmail);
			mvo.setUserGender(userGender);
			mvo.setUserNickname(userNickname);
			mvo.setUserBirth(userBirth);
			mvo.setUserPhone(userPhone);

			//3.비즈니스 로직 처리
			int result = new MemberService().insertMember(mvo);
			if(result>0) {
				//회원 가입 성공 시 성공 페이지로 이동
				HttpSession session = request.getSession();
				session.setAttribute("member", mvo);
				
				RequestDispatcher view = request.getRequestDispatcher("/member/memberJoinSuccess.jsp"); //url 감춤
				view.forward(request, response);			
			}else {
				//회원 가입 실패 시 실패 페이지로 이동
				RequestDispatcher view = request.getRequestDispatcher("/member/memberJoinFail.jsp");
				view.forward(request, response);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
