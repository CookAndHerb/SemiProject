package com.recipe.aBoard.contraller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.aBoard.dao.aBoardDAO;
import com.recipe.aBoard.service.aBoardService;
import com.recipe.aBoard.vo.aBoardVO;

/**
 * Servlet implementation class aBoardWriteProc
 */
@WebServlet("/aBoardWriteServlet.do")
public class aBoardWriteServlet extends HttpServlet {

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
		
		aBoardVO vo = new aBoardVO();
		vo.setBoardTitle(request.getParameter("title"));
		vo.setPassword(request.getParameter("password"));
		vo.setBoardContent(request.getParameter("content"));
		
		System.out.println("title"+vo.getBoardTitle()+"password"+vo.getPassword()+"content"+vo.getBoardContent());
		aBoardService se = new aBoardService();
		se.insertBoard(vo);
		RequestDispatcher dis = request.getRequestDispatcher("/aBoardList.do");
		dis.forward(request, response);
	}

}
