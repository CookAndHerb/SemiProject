package com.recipe.aBoard.contraller;

import java.io.IOException;
import java.util.ArrayList;
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
				
		//페이지 링크를 클릭한 번호 --> 현재 페이지 
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum==null){
			pageNum="1";
		}
		// 연산용 현재 페이지
		int currentPage = Integer.parseInt(pageNum);
		
		// 해당 페이지에서 시작할 레코드
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		
		//전체 게시글의 갯수 
		int count = 0;
		//jsp페이지 내에서 보여질 넘버링 숫자값을 저장하는 변수
		int number = 0;
		
		aBoardService se = new aBoardService();
		count = se.getAllCount();

		ArrayList<aBoardVO> list = se.getAllBoard(startRow, endRow);
		number = count - (currentPage - 1) * pageSize;
		
//		System.out.println("startRow: "+startRow);
//		System.out.println("endRow: "+endRow);
//		System.out.println("number: "+number);
//		System.out.println("list : "+list.size());
//		System.out.println("---------------------------");
		
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		
		request.getRequestDispatcher("/aBoard/aBoardList.jsp").forward(request, response);
		
	}

}
