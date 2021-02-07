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


@WebServlet("/memberWithdraw.do")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		//입력한 PW값을 가지고 비교한 뒤, 맞으면 ID 값을 가지고 탈퇴

		//1.입력한 pw가져오기
		String userPw = request.getParameter("userPw");

		//입력한 값이 비밀번호가 맞는지 확인하는 방법 2가지(1.session / 2.DB -> 1번 사용할거임)
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("member");

		if(userPw.equals(mvo.getUserPw())) {
			//사용자가 입력한 값과 실제 session에 저장된 값이 일치한다면

			//userId값을 추출해서 탈퇴하는 비즈니스 로직 처리
			String userId = mvo.getUserId();

			int result = new MemberService().deleteMember(userId); 

			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			if(result>0) {
				out.println("<script> alert('탈퇴 완료'); </script>");
				session.invalidate(); //세션 파기
				out.println("<script> location.replace('/CookCookRecipe/index.jsp'); </script>");
			}else {
				out.println("<script> alert('탈퇴 실패'); </script>");
				out.println("<script> location.replace('/CookCookRecipe/index.jsp'); </script>");
			}
		}else {
			//사용자가 입력한 값과 실제 session에 저장된 값이 다르다면
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script> alert('비밀번호가 일치하지 않습니다.'); </script>");
			out.println("<script> location.replace('/CookCookRecipe/index.jsp'); </script>");
		}
	}
}
