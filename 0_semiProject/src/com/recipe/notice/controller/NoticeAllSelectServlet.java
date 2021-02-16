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

@WebServlet("/noticeAllList.do")
public class NoticeAllSelectServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;
		
		public NoticeAllSelectServlet() {
			super();
		}
		
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
			
			request.setCharacterEncoding("utf-8");
			
			int pageSize = 10;
			String pageNum = request.getParameter("pageNum");
			
			if(pageNum == null) {
				pageNum = "1";
			}
			// 연산용 현재 페이지
			int currentPage = Integer.parseInt(pageNum);
			
			// 해당 페이지에서 시작할 레코드
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = currentPage * pageSize;
			
			// 전체 게시글의 갯수
			int count = 0;
			// jsp페이지 내에서 보여질 넘버링 숫자값을 저장한는 변수
			int number = 0;
			
			NoticeService service = new NoticeService();
			
			try {
				count = service.getTotalNum();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ArrayList<NoticeVO> list = service.getNotices(startRow, endRow);
			
			number = count - (currentPage - 1) * pageSize;
			
			request.setAttribute("list", list);
			request.setAttribute("number", number);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("count", count);
			request.setAttribute("currentPage", currentPage);
			
			RequestDispatcher view = 
					request.getRequestDispatcher("notice/noticeAllList.jsp");
			view.forward(request, response);
		}
	
}
