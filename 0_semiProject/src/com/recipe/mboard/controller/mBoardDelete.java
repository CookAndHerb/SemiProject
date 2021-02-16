package com.recipe.mboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.mboard.service.mBoardService;


/**
 * Servlet implementation class mBoardDelete
 */
//@WebServlet("/mBoardDelete.do")
//public class mBoardDelete extends HttpServlet {
//	
//		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			execute(request ,response);
//		}
//
//		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			execute(request ,response);
//		}
//		
//		protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
//			request.setCharacterEncoding("UTF-8");
//
//			int num = Integer.parseInt(request.getParameter("num"));
//			String password =  request.getParameter("password");
//			String pass =  request.getParameter("pass");
//
//			
//			if(pass.equals(password)){  ///////////
//				int result = new mBoardService().boardDelete(num);
//				RequestDispatcher dis = request.getRequestDispatcher("/mBoard/Delete.jsp");
//				if(result>0) {
//					request.setAttribute("result", true);
//				}else {
//					request.setAttribute("result", false);
//				}
//				dis.forward(request, response);
////			}else {
////				RequestDispatcher dis = request.getRequestDispatcher("/mBoard/updatePwFail.jsp");
////				dis.forward(request ,response);
////			}

@WebServlet("/mBoardDelete.do")
public class mBoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mBoardDelete() {
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
		
		// 페이지에서 보내온 글번호 저장
		int boardNum = Integer.parseInt(request.getParameter("num"));
	//	int category = Integer.parseInt(request.getParameter("category"));
		
		// 삭제 로직 수행
		mBoardService ms = new mBoardService();
		int result = ms.deleteBoard(boardNum);
		if(result > 0 ) { // 삭제 성공했을 시
			
			response.sendRedirect("/mBoardList.do");
			
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/mBoard/mBoard/DelFail.jsp");
			view.forward(request, response);
		}

		}
}