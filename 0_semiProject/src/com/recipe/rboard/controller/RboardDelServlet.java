package com.recipe.rboard.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.recipe.member.vo.MemberVO;
import com.recipe.rboard.model.service.RboardService;
import com.recipe.rboard.model.vo.Rboard;

/**
 * Servlet implementation class RboardDelServlet
 */
@WebServlet("/RboardDel.do")
public class RboardDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RboardDelServlet() {
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
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		int category = Integer.parseInt(request.getParameter("category"));
		// 삭제 로직 수행
		RboardService rService = new RboardService();
		int result = rService.boardDelete(boardNum);
		if(result > 0 ) { // 삭제 성공했을 시
			
			response.sendRedirect("/RboardAllList.do?category="+category);
			
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/rBoard/RboardDelFail.jsp");
			view.forward(request, response);
		}
	}

}
