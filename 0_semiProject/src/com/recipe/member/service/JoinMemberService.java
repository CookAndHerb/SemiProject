package com.recipe.member.service;

import java.sql.Connection;

import com.recipe.common.JDBCTemplate;
import com.recipe.member.dao.JoinMemberDAO;

public class JoinMemberService {
	
	public int JoinIdCheck(String userId) {
		JoinMemberDAO mDAO = new JoinMemberDAO();
		System.out.println("userId2:"+userId);
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.JoinIdCheck(conn, userId);
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int JoinNicknameCheck(String userNickname) {
		JoinMemberDAO mDAO = new JoinMemberDAO();
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.JoinNicknameCheck(conn, userNickname);
		JDBCTemplate.close(conn);
		
		return result;
	}
}
