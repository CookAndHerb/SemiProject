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

@WebServlet("/detailNotice.do")
public class NoticeDetailServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		int number = Integer.parseInt(request.getParameter("number"));
		
		NoticeService service = new NoticeService();
		NoticeVO noticeVO = service.getNotice(noticeNum);
		
		request.setAttribute("noticeVO", noticeVO);
		request.setAttribute("number", number);
		
		RequestDispatcher view = request.getRequestDispatcher("notice/detailNotice.jsp");
		view.forward(request, response);
	}
	
}
