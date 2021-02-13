package com.recipe.rboard.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.recipe.common.JDBCTemplate;
import com.recipe.rboard.model.dao.RboardDAO;
import com.recipe.rboard.model.vo.Rboard;

public class RboardService {

	public ArrayList<Rboard> selectAllBoardPage(int category, int currentPage, int recordCountPerPage){
		Connection conn = JDBCTemplate.getConnection();
		
		
		RboardDAO rboardDAO = new RboardDAO();
		ArrayList<Rboard> list = 
				rboardDAO.selectAllBoardPageList(conn, category, currentPage, recordCountPerPage);
		
		// 아래 코드는 데이터가 잘 넘어 왔는지 확인용도의 임시코드, 확인 후 삭제 예정
		for(Rboard board : list) {
			System.out.println(board.getBoardNum()+"/"+board.getBoardTitle());
			
		}
		
		JDBCTemplate.close(conn);
		return list;
	}

	
	public int getListCount(int category) {
		Connection conn = JDBCTemplate.getConnection();
		
		RboardDAO rboardDAO = new RboardDAO();
		int postTotalCount = rboardDAO.getListCount(conn, category);
		
		// 아래 코드는 데이터가 잘 넘어왔는지 확인 용도 임시코드
		// System.out.println("postTotalCount"+postTotalCount);
		return postTotalCount;
		
	}
	
	public int boardInsert(Rboard board) {
		Connection conn = JDBCTemplate.getConnection();
		
		RboardDAO rboardDAO = new RboardDAO();
		int result = rboardDAO.boardInsert(conn, board);
		
		if(result>0) {
			JDBCTemplate.close(conn);
		}else{
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
	public Rboard getPost(int boardNum) {
		Connection conn = JDBCTemplate.getConnection();
		
		RboardDAO rboardDAO = new RboardDAO();
		Rboard board = rboardDAO.getPost(conn, boardNum);
		
		return board;
		
	}
	
	public int boardUpdate(Rboard board) {
		Connection conn = JDBCTemplate.getConnection();
		
		RboardDAO rboardDAO = new RboardDAO();
		int result = rboardDAO.boardUpdate(conn, board);
		
		if(result>0) {
			JDBCTemplate.close(conn);
		}else{
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
	public int boardDelete(int boardNum) {
		Connection conn = JDBCTemplate.getConnection();
		
		RboardDAO rboardDAO = new RboardDAO();
		int result = rboardDAO.boardDelete(conn, boardNum);
		if(result>0) {
			JDBCTemplate.close(conn);
		}else{
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
	public ArrayList<Rboard> selectSearchBoardPage(String searchCategory, String keyword, int currentPage, int recordCountPerPage){
		Connection conn = JDBCTemplate.getConnection();
		
		
		RboardDAO rboardDAO = new RboardDAO();
		ArrayList<Rboard> list = 
				rboardDAO.selectSearchBoardPageList(conn, searchCategory, keyword, currentPage, recordCountPerPage);
		
		// 아래 코드는 데이터가 잘 넘어 왔는지 확인용도의 임시코드, 확인 후 삭제 예정
		for(Rboard board : list) {
			System.out.println(board.getBoardNum()+"/"+board.getBoardTitle());
			
		}
		JDBCTemplate.close(conn);
		return list;
	}
	
	public int getSearchListCount(String searchCategory, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		
		RboardDAO rboardDAO = new RboardDAO();
		int postTotalCount = rboardDAO.getSearchListCount(conn, searchCategory, keyword);
		
		// 아래 코드는 데이터가 잘 넘어왔는지 확인 용도 임시코드
		// System.out.println("postTotalCount"+postTotalCount);
		return postTotalCount;
		
	}
}
