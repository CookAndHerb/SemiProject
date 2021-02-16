package com.recipe.mboard.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.mboard.model.mBoardVO;
import com.recipe.mboard.service.mBoardService;

/**
 * Servlet implementation class aBoardWriteProc
 */
@WebServlet("/mBoardWrite.do")
public class mBoardWrite extends HttpServlet {

	//private int result;  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		/*
		 * mBoardVO vo = new mBoardVO();
		 * vo.setBoardTitle(request.getParameter("title"));
		 * vo.setBoardContent(request.getParameter("content"));
		 * 
		 * System.out.println(vo.getBoardTitle());
		 * System.out.println(vo.getBoardContent()); int result = new
		 * mBoardService().insertBoard(vo);
		 */
		
//		if(result>0) {
//			RequestDispatcher dis = request.getRequestDispatcher("/mBoardList.do");
//			dis.forward(request, response);
//		}else {
//			RequestDispatcher dis = request.getRequestDispatcher("/mBoard/mBoardWrite.jsp");
//			dis.forward(request, response);
		
		
		// 작성 시간
				
				mBoardVO boardVO = new mBoardVO();
				
				boardVO.setBoardTitle(request.getParameter("boardTitle"));
				boardVO.setBoardWriter(request.getParameter("boardWriter"));
				boardVO.setBoardContent(request.getParameter("boardContent"));
				
				mBoardService ms = new mBoardService();
				int result = ms.insertBoard(boardVO);
				
				if (result > 0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/mBoardList.do"); //서블릿 부분 리스트로 가게끔
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/mBoard/mBoard/boardWriteFail.jsp");//작성 실패할시 jsp페이지로
					dispatcher.forward(request, response);
		}

	}

}