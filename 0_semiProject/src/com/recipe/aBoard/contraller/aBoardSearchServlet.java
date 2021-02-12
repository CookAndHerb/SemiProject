package com.recipe.aBoard.contraller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.aBoard.service.aBoardService;
import com.recipe.aBoard.vo.aBoardVO;

/**
 * Servlet implementation class aBoardSearchServlet
 */
@WebServlet("/aBoardSearch.do")
public class aBoardSearchServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String keyword = request.getParameter("keyword");
		String pageNum = request.getParameter("pageNum");

		int pageSize = 10;
		

		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);

		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		

		int count = 0;
		int number = 0;
		
		count = new aBoardService().getSearchBoardCount(keyword);
		ArrayList<aBoardVO> list = new aBoardService().getSearchBoard(keyword,startRow, endRow);
		number = count - (currentPage - 1) * pageSize;
		
//		System.out.println("number: " + number);
//		System.out.println("list : " + list.size());
//		System.out.println("startRow: " + startRow);
//		System.out.println("endRow: " + endRow);
//		System.out.println("---------------------------");
		
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);

		request.getRequestDispatcher("/aBoard/aBoardList.jsp").forward(request, response);
		
	}

}
