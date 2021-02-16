package com.recipe.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.notice.model.service.NoticeService;
import com.recipe.notice.model.vo.NoticeVO;

@WebServlet("/noticeUpdate.do")
public class NoticeUpdateServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		NoticeVO noticeVO = new NoticeVO();
		NoticeService service = new NoticeService();
		
		int number = Integer.parseInt(request.getParameter("number"));
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		
		noticeVO = service.getNotice(noticeNum);
		noticeVO.setNoticeTitle(request.getParameter("noticeTitle"));
		noticeVO.setNoticeContent(request.getParameter("noticeContent"));
		
		
		int result = service.updateNotice(noticeVO);
		
		if(result > 0) {
			request.setAttribute("number", number);
			request.setAttribute("noticeVO", noticeVO);
			RequestDispatcher view = request.getRequestDispatcher("/detailNotice.do");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/notice/noticeUpdateFail.jsp");
			view.forward(request, response);
		}
		
		
	}
}
