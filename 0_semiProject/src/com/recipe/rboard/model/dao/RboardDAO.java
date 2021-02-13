package com.recipe.rboard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.recipe.common.JDBCTemplate;
import com.recipe.rboard.model.vo.Rboard;

public class RboardDAO {

	public ArrayList<Rboard> selectAllBoardPageList(Connection conn, int category, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Rboard> list = new ArrayList<Rboard>();
		
		// 여기서 필요한 로직은 TOP-N 분석 ( 상위 5개씩 가져오는 것 )
		// 5개씩 가져오려면 BOARD_NUM을 바탕으로 내림차순을 한 뒤 가장 상위 5개를 가져와야 한다
		
		// SQL 예시
		// 1page라면 1-5 까지 row_num에 해당하는 데이터를 보여주어라.
		/* SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY BOARD_NUM DESC) AS ROW_NUM, R_BOARD.* FROM R_BOARD WHERE BOARD_CATEGORY=1)
		WHERE ROW_NUM BETWEEN 1 AND 5;*/
		
		// 2page라면 6~10까지 row_num에 해당하는 데이터를 보여주어라.
		/* SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY BOARD_NUM DESC) AS ROW_NUM, R_BOARD.* FROM R_BOARD WHERE BOARD_CATEGORY=1)
		WHERE ROW_NUM BETWEEN 6 AND 10;*/
		
		// 즉 페이지가 바뀌면 between 뒤의 숫자만 바꾸면 된다.
		
		// start와 end 값 구하는 공식 ( between start and end라고 하면 )
		// start = 현재페이지 * 보여줄 페이지 개수 - (보여줄 페이지 개수 -1)
		// end = 현재페이지 * 보여줄 페이지 개수
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage -1);
		int end = currentPage * recordCountPerPage;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY BOARD_NUM DESC)AS ROW_NUM, R_BOARD.* "
				+ "FROM R_BOARD WHERE BOARD_CATEGORY=?) WHERE ROW_NUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, category);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Rboard board = new Rboard();
				board.setBoardCategory(rset.getInt("BOARD_CATEGORY"));
				board.setBoardNum(rset.getInt("BOARD_NUM"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardContent(rset.getString("BOARD_CONTENT"));
				board.setBoardWriter(rset.getString("BOARD_WRITER"));
				board.setBoardHit(rset.getInt("BOARD_HIT"));
				board.setBoardDate(rset.getDate("BOARD_DATE"));
				board.setOriginName(rset.getString("ORIGIN_NAME"));
				board.setChangeName(rset.getString("CHANGE_NAME"));
				board.setFilePath(rset.getString("FILE_PATH"));
			
				list.add(board);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	
	public int getListCount(Connection conn, int category) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int postTotalCount =0 ;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM R_BOARD WHERE BOARD_CATEGORY=?";
		try {
			
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, category);
		rset = pstmt.executeQuery();
		
		rset.next();
		postTotalCount = rset.getInt("TOTALCOUNT");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return postTotalCount;
	}

	public int boardInsert(Connection conn, Rboard board) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO R_BOARD VALUES(?,R_BOARD_SEQ.NEXTVAL,?,?,?,NULL,DEFAULT,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getBoardCategory());
			pstmt.setString(2,board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setString(4, board.getBoardWriter());
			pstmt.setString(5, board.getOriginName());
			pstmt.setString(6, board.getChangeName());
			pstmt.setString(7, board.getFilePath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Rboard getPost(Connection conn, int boardNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Rboard board = new Rboard();
		
		String query = "SELECT * FROM R_BOARD WHERE BOARD_NUM = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				board.setBoardCategory(rset.getInt("BOARD_CATEGORY"));
				board.setBoardNum(rset.getInt("BOARD_NUM"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardContent(rset.getString("BOARD_CONTENT"));
				board.setBoardWriter(rset.getString("BOARD_WRITER"));
				board.setBoardHit(rset.getInt("BOARD_HIT"));
				board.setBoardDate(rset.getDate("BOARD_DATE"));
				board.setOriginName(rset.getString("ORIGIN_NAME"));
				board.setChangeName(rset.getString("CHANGE_NAME"));
				board.setFilePath(rset.getString("FILE_PATH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return board;
	
	}
	
	
	public int boardUpdate(Connection conn, Rboard board) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = 
					"UPDATE R_BOARD SET BOARD_CATEGORY=?, BOARD_TITLE=?, BOARD_CONTENT=? , "
					+ "BOARD_WRITER = ? , ORIGIN_NAME=?, CHANGE_NAME=? WHERE BOARD_NUM=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getBoardCategory());
			pstmt.setString(2,board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setString(4, board.getBoardWriter());
			pstmt.setString(5, board.getOriginName());
			pstmt.setString(6, board.getChangeName());
			pstmt.setInt(7, board.getBoardNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
	
	public int boardDelete(Connection conn, int boardNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM R_BOARD WHERE BOARD_NUM=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Rboard> selectSearchBoardPageList(Connection conn, String searchCategory, String keyword, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Rboard> list = new ArrayList<Rboard>();
		int start = currentPage * recordCountPerPage - (recordCountPerPage -1);
		int end = currentPage * recordCountPerPage;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY BOARD_NUM DESC)AS ROW_NUM, R_BOARD.* "
				+ "FROM R_BOARD WHERE "+searchCategory+" LIKE ?) WHERE ROW_NUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Rboard board = new Rboard();
				board.setBoardCategory(rset.getInt("BOARD_CATEGORY"));
				board.setBoardNum(rset.getInt("BOARD_NUM"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardContent(rset.getString("BOARD_CONTENT"));
				board.setBoardWriter(rset.getString("BOARD_WRITER"));
				board.setBoardHit(rset.getInt("BOARD_HIT"));
				board.setBoardDate(rset.getDate("BOARD_DATE"));
				board.setOriginName(rset.getString("ORIGIN_NAME"));
				board.setChangeName(rset.getString("CHANGE_NAME"));
				board.setFilePath(rset.getString("FILE_PATH"));
			
				list.add(board);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	
	public int getSearchListCount(Connection conn, String searchCategory, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int postTotalCount =0 ;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM R_BOARD WHERE "+searchCategory+" LIKE ?";
		try {
			
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, "%"+keyword+"%");
		rset = pstmt.executeQuery();
		
		rset.next();
		postTotalCount = rset.getInt("TOTALCOUNT");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return postTotalCount;
	}
}