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


@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		//1. 보내온 값에 대한 인코딩 처리
		request.setCharacterEncoding("UTF-8");

		//2. View Page에서 보낸 데이터를 자바 변수에 저장
		//회원정보 수정 로직을 진행하기 위하여 이전 페이지에서 보내온 정보를 저장
		//누구의 정보를 바꿀지에 대한 회원 구분 데이터가 필요함 - 유니크 속성을 가진 데이터(userNo 또는 userId)
		//userId를 받아와야하는데 마이페이지에서 <input type="hidden">으로 해서 넘기면 해킹 위험있음!!
		//따라서 세션에서 꺼내와야 함

		//Member m = (Member)session.getAttribute("member");
		//String userId = m.getUserId();
		//위 코드를 한 줄로
		HttpSession session = request.getSession();
		
		String userId = ((MemberVO)session.getAttribute("member")).getUserId();

		//사용자가 수정할 수 있는 값만 가져옴
		String userPw = request.getParameter("userPw");
		String userEmail = request.getParameter("userEmail");
		String userNickname = request.getParameter("userNickname");
		String userPhone = request.getParameter("userPhone");

		MemberVO mvo = new MemberVO();
		mvo.setUserId(userId); //아이디는 담아야함
		mvo.setUserPw(userPw);
		mvo.setUserEmail(userEmail);
		mvo.setUserNickname(userNickname);
		mvo.setUserPhone(userPhone);
		
		session.setAttribute("member", mvo);

		//3. 비즈니스 로직 처리
		int result = new MemberService().updateMember(mvo);
		if(result>0) {
			response.sendRedirect("/CookCookRecipe/myPageLoad.do"); //서블릿통해서 이동
		}else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원정보실패');</script>");
			out.println("<script>location.replace('/myPageLoad.do');</script>");
		}
	}
}
