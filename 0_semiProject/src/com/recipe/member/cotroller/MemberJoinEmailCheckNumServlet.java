package com.recipe.member.cotroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.member.service.JoinMemberService;

/**
 * Servlet implementation class MemberJoinEmailCheckNumServlet
 */
@WebServlet("/MemberJoinEmailCheckNum.do")
public class MemberJoinEmailCheckNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		
		String AuthenticationKey = (String) request.getSession().getAttribute("authenticationKey");
		String userEmailNum = request.getParameter("userEmailNum");
		System.out.println("authenticationKey : "+AuthenticationKey);
        System.out.println("userEmailNum : "+userEmailNum);
        
		if (!AuthenticationKey.equals(userEmailNum)) {
			result = 1;
			System.out.println("인증번호ㄴㄴ "+result);
			request.setAttribute("result", result);
			response.getWriter().write(result+"");
		}else {
			System.out.println("인증번호ㅇㅇ");
			request.setAttribute("result", result);
			response.getWriter().write(result+"");
		}

	}
}
