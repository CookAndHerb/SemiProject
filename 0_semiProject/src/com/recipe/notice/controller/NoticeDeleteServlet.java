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

@WebServlet("/noticeDelete.do")
public class NoticeDeleteServlet extends HttpServlet{
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
		
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		
		NoticeService service = new NoticeService();
		int result = service.deleteNotice(noticeNum);
		
		if(result > 0) {
			request.setAttribute("result", 1);
		} else {
			request.setAttribute("result", 0);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("notice/deleteNotice.jsp");
		view.forward(request, response);
		
	}
	
}