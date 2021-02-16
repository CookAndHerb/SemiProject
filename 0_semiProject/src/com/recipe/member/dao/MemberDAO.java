package com.recipe.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.recipe.common.JDBCTemplate;
import com.recipe.member.vo.MemberVO;

public class MemberDAO {
	public MemberVO loginMember(Connection conn, String userId, String userPw) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		MemberVO mvo = null;
		
		//탈퇴 안 한 사람중에 id, pw가 일치하는 사람 찾기
		String query = "SELECT * FROM MEMBER WHERE USER_ID=? AND USER_PW=? AND USER_DEL='N'";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
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
	
	public int insertMember(Connection conn, MemberVO mvo) {
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO MEMBER VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT, DEFAULT)";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mvo.getUserId());
			pstmt.setString(2, mvo.getUserPw());
			pstmt.setString(3, mvo.getUserName());
			pstmt.setString(4, mvo.getUserEmail());
			pstmt.setString(5, Character.toString(mvo.getUserGender()));
			pstmt.setString(6, mvo.getUserNickname());
			pstmt.setString(7, mvo.getUserBirth());
			pstmt.setString(8, mvo.getUserPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int deleteMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		//실제 탈퇴하는 회원은 그 정보를 삭제하는게 아니라 member테이블에서 END_YN을 Y로 바꿈
		String query = "UPDATE MEMBER SET USER_DEL='Y' WHERE USER_ID=?";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int updateMember(Connection conn, MemberVO mvo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET USER_PW=?, USER_EMAIL=?, USER_NICKNAME=?, "
				+ "USER_PHONE=? WHERE USER_ID=?";
		
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, mvo.getUserPw());
			pstmt.setString(2, mvo.getUserEmail());
			pstmt.setString(3, mvo.getUserNickname());
			pstmt.setString(4, mvo.getUserPhone());
			pstmt.setString(5, mvo.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public String findId(Connection conn, String userName, String userPhone) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		
		String query = "SELECT * FROM MEMBER WHERE USER_NAME=? AND USER_PHONE=? AND USER_DEL='N'";
		String userId = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPhone);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				userId = rset.getString("USER_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return userId;
	}
	
	public String findPw(Connection conn, String userId, String userEmail) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		
		String query = "SELECT * FROM MEMBER WHERE USER_ID=? AND USER_EMAIL=? AND USER_DEL='N'";
		String userPw = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userEmail);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				userPw = rset.getString("USER_PW");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return userPw;
	}
	
	public int checkNick(Connection conn, String userNickname) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE USER_NICKNAME=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userNickname);
				rset = pstmt.executeQuery();
				if(rset.next() || userNickname.equals("")) { // 결과가 있으면
					return 0; // 이미 존재하는 닉네임
				}else {
					return 1; // 사용 가능한 닉네임
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return -1; // 데이터베이스 오류
	}
}
