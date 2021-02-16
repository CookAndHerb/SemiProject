package com.recipe.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.recipe.common.JDBCTemplate;
import com.recipe.member.vo.MemberVO;

public class MemberFindDAO {
	public MemberVO memberInfo(Connection conn, String userId) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		MemberVO mvo = null;
		
		//탈퇴 안 한 사람중에 id, pw가 일치하는 사람 찾기
		String query = "SELECT * FROM MEMBER WHERE USER_ID=? AND USER_DEL='N'";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mvo = new MemberVO();
				mvo.setUserNum(rset.getInt("USER_NUM"));
				mvo.setUserId(rset.getString("USER_ID"));
				mvo.setUserPw(rset.getString("USER_PW"));
				mvo.setUserName(rset.getString("USER_NAME"));
				mvo.setUserEmail(rset.getString("USER_EMAIL"));
				mvo.setUserGender(rset.getString("USER_GENDER").charAt(0));
				mvo.setUserNickname(rset.getString("USER_NICKNAME"));
				mvo.setUserBirth(rset.getString("USER_BIRTH"));
				mvo.setUserPhone(rset.getString("USER_PHONE"));
				mvo.setUserDate(rset.getDate("USER_DATE"));
				
				System.out.println("VO : "+mvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mvo;
	}
	
	public int updatePw(Connection conn, String userPw, String userId) {
		PreparedStatement pstmt = null;
		
		String query = "UPDATE MEMBER SET USER_PW=? WHERE USER_ID=?";
		
		int result = 0;
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userPw);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}
