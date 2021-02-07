package com.recipe.aBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.recipe.aBoard.vo.aBoardVO;
import com.recipe.common.JDBCTemplate;

public class aBoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public int insertBoard(Connection conn, aBoardVO vo) {
		
		int ref = 0;
		int re_step = 1;
		int re_level = 1;
		int result = 0;
		
		try {
			String reSql = "SELECT MAX(REF) FROM A_BOARD";
			pstmt = conn.prepareStatement("reSql");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ref = rs.getInt(1)+1;
			}
			
			String sql = "INSERT INTO BOARD VALUES(A_BOARD.SEQ.NEXTVAL,?,?,?,?,?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBoardTitle());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getBoardContent());
			pstmt.setInt(4, ref);
			pstmt.setInt(5, re_step);
			pstmt.setInt(6, re_level);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
