package com.recipe.aBoard.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;

import com.recipe.aBoard.dao.aBoardDAO;
import com.recipe.aBoard.vo.aBoardVO;
import com.recipe.common.JDBCTemplate;

public class aBoardService {
	aBoardDAO dao = new aBoardDAO();
	aBoardVO vo = new aBoardVO();
	
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
	public ArrayList<aBoardVO> getAllBoard(int startRow, int endRow){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<aBoardVO> list = dao.getAllBoard(conn, startRow, endRow);
//		System.out.println("service list: "+list.size());
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	public aBoardVO getOneBoard(int num){
		Connection conn = JDBCTemplate.getConnection();
		aBoardVO vo = dao.getOneBoard(conn, num);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}
	public aBoardVO getOneUpdateBoard(int num) {
		Connection conn = JDBCTemplate.getConnection();
		aBoardVO vo = dao.getOneUpdateBoard(conn, num);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}
	public int updateBoard(int num ,String title ,String content) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateBoard(conn,num,title,content);
		
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
	public ArrayList<aBoardVO> getSearchBoard(String keyword, int startRow, int endRow){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<aBoardVO> list = dao.getSearchBoard(conn, keyword, startRow, endRow);
//		System.out.println("service list: "+list.size());
		
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
