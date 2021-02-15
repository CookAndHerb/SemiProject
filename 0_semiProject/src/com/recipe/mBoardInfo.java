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


@WebServlet("/mBoardInfo.do")
public class mBoardInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num").trim());
		
		mBoardService ms = new mBoardService();
		mBoardVO vo = ms.getOneBoard(num);
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher dis = request.getRequestDispatcher("/mBoard/detailpage.jsp");
		dis.forward(request ,response);
	}

}