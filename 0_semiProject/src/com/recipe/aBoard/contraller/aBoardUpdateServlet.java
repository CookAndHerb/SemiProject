package com.recipe.aBoard.contraller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.aBoard.service.aBoardService;
import com.recipe.aBoard.vo.aBoardVO;

/**
 * Servlet implementation class aBoardUpdate
 */
@WebServlet("/aBoardUpdate.do")
public class aBoardUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");

		int num = Integer.parseInt(request.getParameter("num"));
		String password = request.getParameter("password");
		String pass = request.getParameter("pass");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int result = new aBoardService().updateBoard(num, title, content);
		
		if(result < 0) {
			RequestDispatcher dis = request.getRequestDispatcher("/aBoard/updatePwFail.jsp");
			request.setAttribute("num", num);
			dis.forward(request ,response);
		}
		if(password.equals(pass)) {
			aBoardService se = new aBoardService();
			se.updateBoard(num,title,content);
			RequestDispatcher dis = request.getRequestDispatcher("/aBoard/updateSuccess.jsp");
			request.setAttribute("num", num);
			dis.forward(request ,response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("/aBoard/updatePwFail.jsp");
			request.setAttribute("num", num);
			dis.forward(request ,response);
		}
	}
}
