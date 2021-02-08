package com.recipe.aBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.recipe.aBoard.vo.aBoardVO;
import com.recipe.common.JDBCTemplate;

public class aBoardDAO {	
	
	public int insertBoard(Connection conn, aBoardVO vo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ref = 0;
		int reStep = 1;
		int reLevel = 1;
		int result = 0;
		
		try {
			String reSql = "SELECT MAX(REF) FROM A_BOARD";
			pstmt = conn.prepareStatement(reSql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ref = rs.getInt(1)+1;
			}
			String sql = "INSERT INTO A_BOARD VALUES(A_BOARD_SEQ.NEXTVAL,?,?,?,0,sysdate,?,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBoardTitle());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getBoardContent());
			pstmt.setInt(4, ref);
			pstmt.setInt(5, reStep);
			pstmt.setInt(6, reLevel);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int getAllCount(Connection conn) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//쿼리 준비 
			String sql ="SELECT COUNT(*) FROM A_BOARD";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}
	
	public Vector<aBoardVO> getAllBoard(Connection conn, int startRow, int endRow){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<aBoardVO> v = new Vector<>();
		
		try {
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM rnum FROM(SELECT * FROM A_BOARD ORDER BY REF DESC, RE_STEP ASC)A)"
					+ "WHERE rnum >= ? AND rnum <= ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				aBoardVO vo = new aBoardVO();
				vo.setBoardNum(rs.getInt(1));
				vo.setBoardTitle(rs.getString(2));
				vo.setPassword(rs.getString(3));
				vo.setBoardContent(rs.getString(4));
				vo.setBoardHit(rs.getString(5));
				vo.setBoardDate(rs.getDate(6).toString());
				vo.setRef(rs.getInt(7));
				vo.setReStep(rs.getInt(8));
				vo.setReLevel(rs.getInt(9));
				vo.setReadCount(rs.getInt(10));
				
				v.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return v;
	}
	
}
