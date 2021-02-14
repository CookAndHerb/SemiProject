package com.recipe.member.service;

import java.sql.Connection;

import com.recipe.common.JDBCTemplate;
import com.recipe.member.dao.MemberFindDAO;
import com.recipe.member.vo.MemberVO;

public class MemberFindService {
	MemberFindDAO mDAO = new MemberFindDAO();
	
	public MemberVO memberInfo(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		MemberVO mvo = mDAO.memberInfo(conn, userId);		
		JDBCTemplate.close(conn);
		return mvo;
	}
	
	public int updatePw(String userPw, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.updatePw(conn, userPw, userId);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
}
