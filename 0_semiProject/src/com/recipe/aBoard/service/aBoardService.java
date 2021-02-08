package com.recipe.aBoard.service;

import java.sql.Connection;
import java.util.Vector;

import javax.swing.JButton;

import com.recipe.aBoard.dao.aBoardDAO;
import com.recipe.aBoard.vo.aBoardVO;
import com.recipe.common.JDBCTemplate;

public class aBoardService {
	aBoardDAO dao = new aBoardDAO();
	
	public int insertBoard(aBoardVO vo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertBoard(conn, vo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	public int getAllCount() {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.getAllCount(conn);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	public Vector<aBoardVO> getAllBoard(int startRow, int endRow){
		Connection conn = JDBCTemplate.getConnection();
		Vector<aBoardVO> v = dao.getAllBoard(conn, startRow, endRow);
		
		JDBCTemplate.close(conn);
		
		return v;
	}
}
