package com.recipe.mboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.mboard.model.mBoardVO;
import com.recipe.mboard.service.mBoardService;

@WebServlet("/mBoardSearch.do")
public class mBoardSearch extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String pageNum = request.getParameter("pageNum");
		String keyword = request.getParameter("keyword");

		int pageSize = 10;
		

		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);

		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		

		int count = 0;
		int number = 0;
		
		count = new mBoardService().getSearchBoardCount(keyword);
		ArrayList<mBoardVO> list = new mBoardService().getSearchBoard(keyword,startRow, endRow);
		number = count - (currentPage - 1) * pageSize;
		
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);

		request.getRequestDispatcher("/mBoard/boardAllList.jsp").forward(request, response);
		
	}

}