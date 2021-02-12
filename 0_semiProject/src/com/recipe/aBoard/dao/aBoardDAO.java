package com.recipe.aBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.recipe.aBoard.vo.aBoardVO;
import com.recipe.common.JDBCTemplate;

public class aBoardDAO {	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int insertBoard(Connection conn, aBoardVO vo) {
		int ref = 1;
		int reStep = 1;
		int reLevel = 1;
		int result = 0;
		System.out.println(vo.getBoardTitle());
		System.out.println(vo.getPassword());
		System.out.println(vo.getBoardContent());
		
		try {
			
			String reSql = "SELECT MAX(REF) FROM A_BOARD";
			pstmt = conn.prepareStatement(reSql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ref = rs.getInt(1)+1;
			}
			String sql = "INSERT INTO A_BOARD VALUES(A_BOARD_SEQ.NEXTVAL,?,?,?,sysdate,?,?,?,0)";
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
	
	public ArrayList<aBoardVO> getAllBoard(Connection conn, int startRow, int endRow){
		ArrayList<aBoardVO> list = new ArrayList<>();
		
		try {
			String sql = "select * from (select A.* ,Rownum Rnum from" + 
					"(select *from a_board order by ref desc ,re_step asc)A)" + 
					"where Rnum >= ? and Rnum <= ?";
			
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
				vo.setBoardDate(rs.getDate(5).toString());
				vo.setRef(rs.getInt(6));
				vo.setReStep(rs.getInt(7));
				vo.setReLevel(rs.getInt(8));
				vo.setReadCount(rs.getInt(9));
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
//		System.out.println("dao: "+list.size());
		return list;
	}
	
	public aBoardVO getOneBoard(Connection conn, int num) {
		aBoardVO vo = new aBoardVO();
		
		try {
			String rsql = "UPDATE A_BOARD SET READCOUNT = READCOUNT+1 WHERE BOARD_NUM=?";
			pstmt = conn.prepareStatement(rsql);
			pstmt.setInt(1,num);
			pstmt.executeUpdate();	
				
			String sql = "SELECT * FROM A_BOARD WHERE BOARD_NUM=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs= pstmt.executeQuery();
				
			if(rs.next()) {
				vo.setBoardNum(rs.getInt(1));
				vo.setBoardTitle(rs.getString(2));
				vo.setPassword(rs.getString(3));
				vo.setBoardContent(rs.getString(4));
				vo.setBoardDate(rs.getDate(5).toString());
				vo.setRef(rs.getInt(6));
				vo.setReStep(rs.getInt(7));
				vo.setReLevel(rs.getInt(8));
				vo.setReadCount(rs.getInt(9));
			}

			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
			}
			return vo;	
	}
	//update, Delete시 하나의 게시글을 리턴
	public aBoardVO getOneUpdateBoard(Connection conn, int num){	
		aBoardVO vo = new aBoardVO();

		try {
			String sql = "SELECT * FROM A_BOARD WHERE BOARD_NUM=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setBoardNum(rs.getInt(1));
				vo.setBoardTitle(rs.getString(2));
				vo.setPassword(rs.getString(3));
				vo.setBoardContent(rs.getString(4));
				vo.setBoardDate(rs.getDate(5).toString());
				vo.setRef(rs.getInt(6));
				vo.setReStep(rs.getInt(7));
				vo.setReLevel(rs.getInt(8));
				vo.setReadCount(rs.getInt(9));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return vo;
	}
	public int updateBoard(Connection conn,int num ,String title ,String content){
		int result = 0;
		try {		
			String sql = "UPDATE A_BOARD SET BOARD_TITLE=?,BOARD_CONTENT=? WHERE BOARD_NUM=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setInt(3,num);
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}  
	public int deleteBoard(Connection conn, int num){
		int result = 0;
		try {		
			String sql = "DELETE FROM A_BOARD WHERE BOARD_NUM=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			result = pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public ArrayList<aBoardVO> getSearchBoard(Connection conn, String keyword, int startRow, int endRow){
		ArrayList<aBoardVO> list = new ArrayList<>();
		System.out.println("keyword: "+keyword);
		
		try {
			String sql = "Select * FROM (SELECT ROW_NUMBER() OVER(order by BOARD_NUM DESC) AS row_num, A_BOARD.* " + 
					"FROM A_BOARD where BOARD_TITLE like ?) WHERE row_num between ? and ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				aBoardVO vo = new aBoardVO();
				vo.setBoardNum(rs.getInt(2));
				vo.setBoardTitle(rs.getString(3));
				vo.setPassword(rs.getString(4));
				vo.setBoardContent(rs.getString(5));
				vo.setBoardDate(rs.getDate(6).toString());
				vo.setRef(rs.getInt(7));
				vo.setReStep(rs.getInt(8));
				vo.setReLevel(rs.getInt(9));
				vo.setReadCount(rs.getInt(10));
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
//		System.out.println("dao: "+list.size());
		return list;
	}
	public int getSearchBoardCount(Connection conn, String keyword) {
		int postCount = 0;
		
		String sql = "SELECT COUNT(*) as count FROM A_BOARD WHERE board_title like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			rs.next();
			postCount = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return postCount;
	}
	public int reWriteBoard(Connection conn, aBoardVO vo){
		
		int result = 0;
		int ref =vo.getRef();
		int reStep = vo.getReStep();
		int reLevel = vo.getReLevel();

		try {
				String resql = "UPDATE A_BOARD SET RE_LEVEL=RE_LEVEL+1 WHERE REF= ? AND RE_LEVEL > ?";
				pstmt = conn.prepareStatement(resql);
				pstmt.setInt(1 , ref);
				pstmt.setInt(2 , reLevel);
				pstmt.executeUpdate();
				
				String sql = "INSERT INTO A_BOARD VALUES(A_BOARD_SEQ.NEXTVAL,?,?,?,sysdate,?,?,?,0)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getBoardTitle());
				pstmt.setString(2, vo.getPassword());
				pstmt.setString(3, vo.getBoardContent());
				pstmt.setInt(4, ref); 
				pstmt.setInt(5, reStep+1);
				pstmt.setInt(6, reLevel+1);
				result = pstmt.executeUpdate();
				
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
}
