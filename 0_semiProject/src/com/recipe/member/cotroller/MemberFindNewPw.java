package com.recipe.member.cotroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recipe.member.service.MemberFindService;
import com.recipe.member.service.MemberService;
import com.recipe.member.vo.MemberVO;

@WebServlet("/findNewPw.do")
public class MemberFindNewPw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {

		//사용자가 수정할 수 있는 값만 가져옴
		String userId=request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		//비즈니스 로직 처리
		int result = new MemberFindService().updatePw(userPw, userId);
		if(result>0) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호 변경 완료. 새로운 비밀번호로 로그인 해주세요');</script>");
			out.println("<script>location.replace('/index.jsp');</script>");
		}
		
		
	}
}
