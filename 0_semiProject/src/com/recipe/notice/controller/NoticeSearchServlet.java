package com.recipe.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.notice.model.service.NoticeService;
import com.recipe.notice.model.vo.NoticeVO;
import com.recipe.notice.model.vo.PageInfo;

@WebServlet("/searchNotice.do")
public class NoticeSearchServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword");
		
		
		int currentPage;
		if(request.getParameter("currentPage")==null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int recordCountPerPage = 10;
		
		ArrayList<NoticeVO> list = new NoticeService().selectSearchNoticePage(keyword, currentPage, recordCountPerPage);
		
		int postTotalCount = new NoticeService().getSearchListCount(keyword);
		int pageTotalCount = 0;
		
		if(postTotalCount % recordCountPerPage > 0) {
			pageTotalCount = postTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = postTotalCount / recordCountPerPage + 0;
		}
		
		int naviCountPerPage = 5;
		int startNavi= ((currentPage-1)/naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		PageInfo pageinfo = new PageInfo(currentPage, pageTotalCount, startNavi, endNavi, recordCountPerPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/notice/noticeSearchList.jsp");
		request.setAttribute("pageinfo", pageinfo);                                                        
		request.setAttribute("list", list);  
		request.setAttribute("keyword",keyword);
		view.forward(request, response);
		
	}
}
