package com.recipe.aBoard.contraller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.aBoard.service.aBoardService;

@WebServlet("/aBoardDelete.do")
public class aBoardDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request ,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request ,response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");

		int num = Integer.parseInt(request.getParameter("num"));
		String password =  request.getParameter("password");
		String pass =  request.getParameter("pass");

		
		if(pass.equals(password)){
			int result = new aBoardService().deleteBoard(num);
			
			RequestDispatcher dis = request.getRequestDispatcher("/aBoardListServlet.do");
			if(result>0) {
				request.setAttribute("result", true);
			}else {
				request.setAttribute("result", false);
			}
			dis.forward(request, response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("/aBoard/updatePwFail.jsp");
			dis.forward(request ,response);
		}
	}
}
