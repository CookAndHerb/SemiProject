package com.recipe.mBoard.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.mBoard.dao.mBoardDAO;
import com.recipe.mBoard.service.mBoardService;
import com.recipe.mBoard.model.mBoardVO;

/**
 * Servlet implementation class aBoardWriteProc
 */
@WebServlet("/mBoardWrite.do")
public class mBoardWrite extends HttpServlet {

	private int result;  //
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		mBoardVO vo = new mBoardVO();
		vo.setBoardTitle(request.getParameter("title"));
		vo.setBoardContent(request.getParameter("content"));
		

		
		if(result>0) {
			RequestDispatcher dis = request.getRequestDispatcher("/mBoardList.do");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("/mBoard/mBoardWrite.jsp");
			dis.forward(request, response);
		}

	}

}