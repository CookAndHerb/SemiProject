package com.recipe.aBoard.contraller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.aBoard.service.aBoardService;
import com.recipe.aBoard.vo.aBoardVO;


@WebServlet("/aBoardReWrite.do")
public class aBoardReWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		aBoardVO vo = new aBoardVO();
		
		vo.setBoardTitle(request.getParameter("title"));
		vo.setPassword(request.getParameter("password"));
		vo.setBoardContent(request.getParameter("content"));
		
		vo.setRef(Integer.parseInt(request.getParameter("ref")));
		vo.setReStep(Integer.parseInt(request.getParameter("reStep")));
		vo.setReLevel(Integer.parseInt(request.getParameter("reLevel")));
		
		int result = new aBoardService().reWriteBoard(vo);
		
		if(result > 0) {
			RequestDispatcher dis = request.getRequestDispatcher("/aBoardListServlet.do");
			dis.forward(request ,response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("/aBoard/aBordReWriteFail.jsp");
			dis.forward(request ,response);
		}
		
		
	}

}
