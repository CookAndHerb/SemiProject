package com.recipe.mBoard.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.mBoard.dao.mBoardDAO;
import com.recipe.mBoard.service.mBoardService;
import com.recipe.mBoard.model.mBoardVO;


@WebServlet("/mBoardList.do")
public class mBoardList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		int pageSize=5;
				

		String pageNum = request.getParameter("pageNum");
				

		if(pageNum==null){
			pageNum="1";
		}
				
//전체
		int count = 0;
					
		int number = 0;
					
		int currentPage = Integer.parseInt(pageNum); //현재
				
		mBoardService se = new mBoardService();
		count = se.getAllCount();


		int startRow = (currentPage - 1) * pageSize + 1; //현제페이지시작
		int endRow = currentPage * pageSize;

	
		Vector<mBoardVO> v = se.getAllBoard(startRow, endRow);
		number = count - (currentPage - 1) * pageSize;
		request.setAttribute("v", v);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		
		request.getRequestDispatcher("/mBoard/listView.jsp").forward(request, response);
		
	}

}