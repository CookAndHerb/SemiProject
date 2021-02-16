package com.recipe.mboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipe.mboard.service.mBoardService;


@WebServlet("/mBoardUpdate.do")
public class mBoardUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");

		int num = Integer.parseInt(request.getParameter("num"));
//		String password = request.getParameter("password");
//		String pass = request.getParameter("pass");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int result = new mBoardService().updateBoard(num, title, content);
		
		if(result > 0) {
			mBoardService ms = new mBoardService();
			ms.updateBoard(num, title, content);
		
			RequestDispatcher dis = request.getRequestDispatcher("/mBoard/updateSuccess.jsp");
			request.setAttribute("num", num);
			dis.forward(request ,response);
		}
		
	}		
	}
