package com.recipe.aBoard.contraller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.aBoard.service.aBoardService;
import com.recipe.aBoard.vo.aBoardVO;

/**
 * Servlet implementation class aBoardUpdateNumServlet
 */
@WebServlet("/aBoardUpdateNum.do")
public class aBoardUpdateNumServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request ,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request ,response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num").trim());
		
		aBoardService se = new aBoardService();
		aBoardVO vo = se.getOneUpdateBoard(num);
		request.setAttribute("vo", vo);
		
		RequestDispatcher dis = request.getRequestDispatcher("/aBoard/aBoardUpdateForm.jsp");
		dis.forward(request ,response);
	}

}
