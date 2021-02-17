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
 * Servlet implementation class aBoardReWriteRef
 */
@WebServlet("/aBoardReWriteRef.do")
public class aBoardReWriteRef extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int ref = Integer.parseInt(request.getParameter("ref"));
		int reStep = Integer.parseInt(request.getParameter("reStep"));
		int reLevel = Integer.parseInt(request.getParameter("reLevel"));
		
		request.setAttribute("ref", ref);
		request.setAttribute("reStep", reStep);
		request.setAttribute("reLevel", reLevel);
		
		RequestDispatcher dis = request.getRequestDispatcher("/aBoard/aBoardReWriteForm.jsp");
		dis.forward(request ,response);
		
	}

}
