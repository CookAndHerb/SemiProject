package com.recipe.notice.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recipe.member.vo.MemberVO;
import com.recipe.notice.model.service.NoticeService;
import com.recipe.notice.model.vo.NoticeVO;

@WebServlet("/writeNotice.do")
public class NoticeInsertServlet extends HttpServlet{
	
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
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		String noticeWriter = mvo.getUserNickname();
		
		// 작성 시간
		java.sql.Date regDate = new java.sql.Date(new java.util.Date().getTime());
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setNoticeTitle(request.getParameter("noticeTitle"));
		noticeVO.setNoticeWriter(noticeWriter);
		noticeVO.setNoticeContent(request.getParameter("noticeContent"));
		noticeVO.setNoticeDate(regDate);
		
		NoticeService service = new NoticeService();
		int result = service.insertNotice(noticeVO);
		
		if (result > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/noticeAllList.do");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/notice/noticeWriteFail.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}
