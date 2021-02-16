package com.recipe.member.cotroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/emailKey.do")
public class MemberEmailKeyConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	@SuppressWarnings("unchecked")
	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		String authenticationKey = (String)request.getSession().getAttribute("authenticationKey");
        String authenticationUser = request.getParameter("authenticationUser");
        
        System.out.println("authenticationKey : "+authenticationKey);
        System.out.println("authenticationUser : "+authenticationUser);
        
        JSONObject object = new JSONObject();
        if(authenticationKey.equals(authenticationUser)){
        	object.put("ok", "ok");
        }else {
        	object.put("ok", "");
        }
        
        response.setContentType("application/json");
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(object);
	}
}
