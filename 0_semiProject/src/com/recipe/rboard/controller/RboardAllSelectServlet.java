package com.recipe.rboard.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recipe.rboard.model.service.RboardService;
import com.recipe.rboard.model.vo.PageInfo;
import com.recipe.rboard.model.vo.Rboard;



/**
 * Servlet implementation class RboardAllSelectServlet
 */
@WebServlet("/RboardAllList.do")
public class RboardAllSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RboardAllSelectServlet() {
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
		
		// 넘겨받은 카테고리 번호
		request.setCharacterEncoding("utf-8");
		int category = Integer.parseInt(request.getParameter("category"));
		
		// 게시판을 처음 접근하게 되면 1page임
		int currentPage;
		// 현재 페이지 값을 가지고 있는 변수, 이 변수는 페이지가 변경되면 변경된 페이지 값을 가지고 있어야 한다.
		
		int recordCountPerPage = 9; // 한 페이지당 몇 개의 게시물이 보이게 될 것인지
		
		// 게시판
		if(request.getParameter("currentPage") == null) { 
			// 처음 currentPage는 자동으로 1이기 때문에 보내주는 값이 없어서 null이면 1이란 소리 (1페이지라는 소리)
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			// 1페이지 이후부터는 특정 페이지를 이동할 때 값을 보내주게 되므로 그 값을 page처리 하겠다.
		}
		
		
		
		// 페이지를 가져올 수 있는 비즈니스 로직 처리
		ArrayList<Rboard> list = new RboardService().selectAllBoardPage(category, currentPage, recordCountPerPage);
		
		// 페이징 처리를 위해서 생성된 페이지 개수를 구하기
		int postTotalCount = new RboardService().getListCount(category); // 총 게시물 개수 알아오기
		
		int pageTotalCount = 0 ; // 전체 페이지를 저장하는 변수		
		
		if(postTotalCount % recordCountPerPage >0) {
					pageTotalCount = postTotalCount / recordCountPerPage +1; // 몫 개수
		}else {
			pageTotalCount = postTotalCount / recordCountPerPage + 0; // 몫 개수
		}
		
		// <startNavi 구하는 공식>
		// startNavi = ((현재페이지-1)/보여질 navi 개수) * 보여질 navi 개수 +1;
		int naviCountPerPage = 5;
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;
		
		// <endNavi 구하는 공식>
		// endNavi = 시작 navi번호 + 보여질 navi 개수 -1;
		int endNavi = startNavi + naviCountPerPage -1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		PageInfo pageinfo = new PageInfo(currentPage, pageTotalCount, startNavi, endNavi, recordCountPerPage); 

		
		RequestDispatcher view = request.getRequestDispatcher("/rBoard/RboardAllListPage.jsp");
		request.setAttribute("pageinfo", pageinfo);                                                        
		request.setAttribute("boardList", list);  
		request.setAttribute("category",category);
		view.forward(request, response);
		
	
	}
}
