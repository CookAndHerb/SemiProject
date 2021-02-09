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


@WebServlet("/aBoardInfoServlet.do")
public class aBoardInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num").trim());
		
		aBoardService se = new aBoardService();
		aBoardVO vo = se.getOneBoard(num);
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher dis = request.getRequestDispatcher("/aBoard/aBoardInfo.jsp");
		dis.forward(request ,response);
	}

}
