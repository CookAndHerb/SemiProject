package com.recipe.rboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.rboard.model.service.RboardService;
import com.recipe.rboard.model.vo.Rboard;

/**
 * Servlet implementation class RboardGoUptServlet
 */
@WebServlet("/RboardGoUpt.do")
public class RboardGoUptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RboardGoUptServlet() {
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
		
		// 잘 넘어왔는지 확인
		System.out.println(boardNum);
		RboardService rService = new RboardService();
		
		Rboard rboard = rService.getPost(boardNum);
		request.setAttribute("rboard", rboard);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("/rBoard/RboardUptPage.jsp").forward(request, response);
	}

}
