

package com.recipe.mBoard.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;

import com.recipe.mBoard.service.mBoardService;
import com.recipe.mBoard.dao.mBoardDAO;
import com.recipe.mBoard.model.mBoardVO;
import com.recipe.common.JDBCTemplate;

public class mBoardService {
	mBoardDAO dao = new mBoardDAO();
	mBoardVO vo = new mBoardVO();
	
	
	
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
	public Vector<mBoardVO> getAllBoard(int startRow, int endRow){
		Connection conn = JDBCTemplate.getConnection();
		Vector<mBoardVO> v = dao.getAllBoard(conn, startRow, endRow);
		
		JDBCTemplate.close(conn);
		
		return v;
	}
	public mBoardVO getOneBoard(int num){
		Connection conn = JDBCTemplate.getConnection();
		mBoardVO vo = dao.getOneBoard(conn, num);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}
	public mBoardVO getOneUpdateBoard(int num) {
		Connection conn = JDBCTemplate.getConnection();
		mBoardVO vo = dao.getOneUpdateBoard(conn, num);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}
	public int updateBoard(int no ,String title ,String content) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateBoard(conn,no,title,content);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	

	public int deleteBoard(int num) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteBoard(conn, num);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	public ArrayList<mBoardVO> getSearchBoard(String keyword, int startRow, int endRow){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<mBoardVO> list = dao.getSearchBoard(conn, keyword, startRow, endRow);

		
		JDBCTemplate.close(conn);
		
		return list;
	}
	public int getSearchBoardCount(String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.getSearchBoardCount(conn, keyword);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
}

