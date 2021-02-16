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

@WebServlet("/noticeUpdateReady.do")
public class NoticeUpdateReadyServlet extends HttpServlet{
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
		 
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		int number = Integer.parseInt(request.getParameter("number"));
		
		NoticeVO noticeVO = new NoticeVO();
		NoticeService service = new NoticeService();
		noticeVO = service.getNoticeUpdateReady(noticeNum);
		
		request.setAttribute("number", number);
		request.setAttribute("noticeVO", noticeVO);
		RequestDispatcher view = request.getRequestDispatcher("notice/noticeUpdateForm.jsp");
		view.forward(request, response);
		
	}
}