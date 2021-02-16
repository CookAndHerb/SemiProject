package com.recipe.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.recipe.common.JDBCTemplate;

public class JoinMemberDAO {
	public int JoinIdCheck(Connection conn, String userId) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		int result = 0;
		
		String query = "SELECT USER_ID FROM MEMBER WHERE USER_ID=? AND USER_DEL='N'";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = 1;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int JoinNicknameCheck(Connection conn, String userNickname) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		int result = 0;
		
		String query = "SELECT USER_Nickname FROM MEMBER WHERE USER_Nickname=? AND USER_DEL='N'";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNickname);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = 1;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
