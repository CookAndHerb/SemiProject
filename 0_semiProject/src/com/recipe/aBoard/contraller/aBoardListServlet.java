package com.recipe.aBoard.contraller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.aBoard.dao.aBoardDAO;
import com.recipe.aBoard.service.aBoardService;
import com.recipe.aBoard.vo.aBoardVO;


@WebServlet("/aBoardListServlet.do")
public class aBoardListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//화면에 보여질 게시글의 개수를 지정 
		int pageSize=10;
				
		//현재 보여지고 있는 페이지의 넘버 값을 읽음 
		String pageNum = request.getParameter("pageNum");
				
		//null 처리
		if(pageNum==null){
			pageNum="1";
		}
				
		//전체 게시글의 갯수 
		int count = 0;
				
		//jsp페이지 내에서 보여질 넘버링 숫자값을 저장하는 변수
		int number = 0;
				
		//현재 보여지고 있는 페이지 문자를 숫자로 변환 
		int currentPage = Integer.parseInt(pageNum);
				
		aBoardService se = new aBoardService();
		count = se.getAllCount();

		// 현재 보여질 페이지 시작 번호를 설정
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;

		// 최신글 10개를 기준으로 게시글 리턴 받아주는 메소드 호출
		Vector<aBoardVO> v = se.getAllBoard(startRow, endRow);
		number = count - (currentPage - 1) * pageSize;

		request.setAttribute("v", v);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		
		request.getRequestDispatcher("/aBoard/aBoardList.jsp").forward(request, response);
		
	}

}
