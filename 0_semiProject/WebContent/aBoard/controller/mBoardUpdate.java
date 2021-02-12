package com.recipe.mBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.mBoard.service.mBoardService;
import com.recipe.mBoard.model.mBoardVO;

@WebServlet("/mBoardUpdate.do")
public class mBoardUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request ,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request ,response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num").trim());
		String title = request.getParameter("title");
		String Content = request.getParameter("content");
		int result = new mBoardService().updateBoard(num, title, Content);
		
		mBoardService ms = new mBoardService();
		mBoardVO boardvo = ms.getOneUpdateBoard(num);
		request.setAttribute("boardvo", boardvo);
		
		RequestDispatcher dis = request.getRequestDispatcher("/mBoard/Update.jsp");
		dis.forward(request ,response);
	}

}
