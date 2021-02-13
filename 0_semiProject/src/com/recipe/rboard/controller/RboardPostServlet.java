package com.recipe.rboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.rboard.model.dao.RboardDAO;
import com.recipe.rboard.model.service.RboardService;
import com.recipe.rboard.model.vo.Rboard;

/**
 * Servlet implementation class RboardPostServlet
 */
@WebServlet("/RboardPost.do")
public class RboardPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  /**
     * @see HttpServlet#HttpServlet()
     */
    public RboardPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		RboardService rService = new RboardService();
		Rboard board = rService.getPost(boardNum);
		
		RequestDispatcher view = request.getRequestDispatcher("/rBoard/RboardPost.jsp");
		request.setAttribute("post", board);
		request.setAttribute("currentPage",currentPage);
		view.forward(request, response);
	}
}
