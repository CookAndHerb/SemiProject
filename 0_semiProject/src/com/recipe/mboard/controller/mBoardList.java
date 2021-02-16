package com.recipe.mboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.mboard.model.mBoardVO;
import com.recipe.mboard.service.mBoardService;
import com.recipe.member.vo.MemberVO;
import com.recipe.notice.model.service.NoticeService;
import com.recipe.notice.model.vo.NoticeVO;


@WebServlet("/mBoardList.do")
public class mBoardList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		int pageSize=5;
//				
//
//		String pageNum = request.getParameter("pageNum");
//				
//
//		if(pageNum==null){
//			pageNum="1";
//		}
//				
////전체
//		int count = 0;
//					
//		int number = 0;
//					
//		int currentPage = Integer.parseInt(pageNum); //현재
//				
//		mBoardService ms = new mBoardService();
//		count = ms.getAllCount();
//
//
//		int startRow = (currentPage - 1) * pageSize + 1; //현제페이지시작
//		int endRow = currentPage * pageSize;
//	
//		ArrayList<mBoardVO> v = ms.getAllBoard(startRow, endRow);
//		
//		number = count - (currentPage - 1) * pageSize;		System.out.println("number : "+number);
//		
//		request.setAttribute("v", v);
//		request.setAttribute("number", number);
//		request.setAttribute("pageSize", pageSize);
//		request.setAttribute("count", count);
//		request.setAttribute("currentPage", currentPage);
		
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
		
		mBoardService ms = new mBoardService();
		
		try {
			count = ms.getAllCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<mBoardVO> list = ms.getAllBoard(startRow, endRow);
		
		number = count - (currentPage - 1) * pageSize;
		
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		
		
		request.getRequestDispatcher("/mBoard/mBoard/boardAllList.jsp").forward(request, response);
		
	}

}