package com.recipe.member.service;

import java.sql.Connection;

import com.recipe.common.JDBCTemplate;
import com.recipe.member.dao.MemberDAO;
import com.recipe.member.vo.MemberVO;


public class MemberService {
	//Service 역할
	//Connection 객체 생성 + DAO 연결
	//여기서는 템플릿을 사용함
	
	MemberDAO mDAO = new MemberDAO();
	
	public MemberVO loginMember(String userId, String userPw) {
		Connection conn = JDBCTemplate.getConnection();
		MemberVO mvo = mDAO.loginMember(conn, userId, userPw);
		
		System.out.println("DAO : "+mvo);
		
		JDBCTemplate.close(conn);
		return mvo;
	}
	
	public int insertMember(MemberVO mvo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.insertMember(conn, mvo);
		
		if(result>0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int deleteMember(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.deleteMember(conn,userId);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int updateMember(MemberVO mvo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.updateMember(conn, mvo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public String findId(String userName, String userPhone) {
		Connection conn = JDBCTemplate.getConnection();
		String userId = mDAO.findId(conn, userName, userPhone);
		JDBCTemplate.close(conn);
		return userId;
	}
	
	public String findPw(String userName, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		String userPw = mDAO.findPw(conn, userName, userId);
		JDBCTemplate.close(conn);
		return userPw;
	}

	public int JoinIdCheck(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.JoinIdCheck(conn, userId);
		JDBCTemplate.close(conn);
		return result;
	}
}
