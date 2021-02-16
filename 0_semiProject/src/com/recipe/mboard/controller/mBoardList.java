package com.recipe.mboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.mboard.model.mBoardVO;
import com.recipe.mboard.service.mBoardService;


@WebServlet("/mBoardList.do")
public class mBoardList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("리스트 서블릿 시작");
		int pageSize=5;
				

		String pageNum = request.getParameter("pageNum");
				

		if(pageNum==null){
			pageNum="1";
		}
				
//전체
		int count = 0;
					
		int number = 0;
					
		int currentPage = Integer.parseInt(pageNum); //현재
				
		mBoardService ms = new mBoardService();
		count = ms.getAllCount();


		int startRow = (currentPage - 1) * pageSize + 1; //현제페이지시작
		int endRow = currentPage * pageSize;
		
		System.out.println("startRow : " + startRow);
		System.out.println("endRow : " + endRow);
	
		ArrayList<mBoardVO> v = ms.getAllBoard(startRow, endRow);
		System.out.println("arrayList : "+v);
		
		number = count - (currentPage - 1) * pageSize;
		System.out.println("number : "+number);
		
		request.setAttribute("v", v);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		
		request.getRequestDispatcher("/mBoard/mBoard/boardAllList.jsp").forward(request, response);
		
	}

}