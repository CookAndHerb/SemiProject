


package com.recipe.mBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.recipe.mBoard.model.mBoardVO;
import com.recipe.common.JDBCTemplate;

public class mBoardDAO {	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

public int getAllCount(Connection conn) {
		int count = 0;
				try {
//		
			String sql ="SELECT COUNT(*) FROM M_BOARD";
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
	
	public Vector<mBoardVO> getAllBoard(Connection conn, int startRow, int endRow){ //모든게시글리턴
		Vector<mBoardVO> v = new Vector<>();
		
		try {
			String sql = "SELECT * FROM (SELECT M.*, ROWNUM rnum FROM(SELECT * FROM M_BOARD ORDER BY DESC, ASC)A)"
					+ "WHERE rnum >= ? AND rnum <= ?";   //
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mBoardVO vo = new mBoardVO();
				vo.setBoardNUM(rs.getInt(1));
				vo.setBoardTitle(rs.getString(2));				
				vo.setBoardContent(rs.getString(3));
				vo.setBoardWriter(rs.getString(4));
				vo.setBoardDate(rs.getDate(5));  //.toString());
				vo.setBoardHit(rs.getInt(6));
				
				
				
				v.add(vo);
			}
		} catch (Exception e) {	
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return v;
	}
	
	public mBoardVO getOneBoard(Connection conn, int num) {
		mBoardVO vo = new mBoardVO();
		
		try {
			String rsql = "UPDATE M_BOARD SET BOARD_HIT = BOARD_HIT+1 WHERE BOARD_NUM=?";
			pstmt = conn.prepareStatement(rsql);
			pstmt.setInt(1,num);
			pstmt.executeUpdate();	
				
			String sql = "SELECT * FROM M_BOARD WHERE BOARD_NUM=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs= pstmt.executeQuery();
				
			if(rs.next()) {
				vo.setBoardNUM(rs.getInt(1));
				vo.setBoardTitle(rs.getString(2));				
				vo.setBoardContent(rs.getString(3));
				vo.setBoardWriter(rs.getString(4));
				vo.setBoardDate(rs.getDate(5));
				vo.setBoardHit(rs.getInt(6));
			
				
			}

			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
			}
			return vo;	
	}

	public mBoardVO getOneUpdateBoard(Connection conn, int num){	
		mBoardVO vo = new mBoardVO();

		try {
			String sql = "SELECT * FROM M_BOARD WHERE BOARD_NUM=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setBoardNUM(rs.getInt(1));
				vo.setBoardTitle(rs.getString(2));				
				vo.setBoardContent(rs.getString(3));
				vo.setBoardWriter(rs.getString(4));
				vo.setBoardDate(rs.getDate(5));
				vo.setBoardHit(rs.getInt(6));
				
			}
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return vo;
	}
	public int updateBoard(Connection conn, int num ,String title ,String content){
		
		int result = 0;
		try {		
			String sql = "UPDATE M_BOARD SET BOARD_TITLE=? WHERE BOARD_NUM=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setInt(3, num);
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
			String sql = "DELETE FROM M_BOARD WHERE BOARD_NUM=?";
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
	public ArrayList<mBoardVO> getSearchBoard(Connection conn, String keyword, int startRow, int endRow){
		ArrayList<mBoardVO> list = new ArrayList<>();
		System.out.println("keyword: "+keyword);
		
		try {
			String sql = "Select * FROM (SELECT ROW_NUMBER() OVER(order by BOARD_NUM DESC) AS row_num, M_BOARD.* " + 
					"FROM M_BOARD where BOARD_TITLE like ?) WHERE row_num between ? and ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mBoardVO vo = new mBoardVO();
				vo.setBoardNUM(rs.getInt(1));  //
				vo.setBoardTitle(rs.getString(2));				
				vo.setBoardContent(rs.getString(3));
				vo.setBoardDate(rs.getDate(4));
				vo.setBoardHit(rs.getInt(5));
							
				list.add(vo);
			}
		} catch (Exception e) {
	
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public int getSearchBoardCount(Connection conn, String keyword) {
		//키워드를 통해 검색된 게시물의 총 개수를 구하는 메소드
		int postCount = 0;
		
		String sql = "SELECT COUNT(*) as count FROM M_BOARD WHERE board_title like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			rs.next();
			postCount = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}return postCount;
	}
	
	public static int insertBoard(Connection conn, mBoardVO vo) {  // 서비스와 관련 static 변경
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into M_BOARD values(m_board_seq.nextval,?,?,?,sysdate,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getBoardTitle());
			pstmt.setString(2, vo.getBoardContent());
			pstmt.setString(3, vo.getBoardWriter());
			//pstmt.setDate(4, vo.getBoardDate());
			pstmt.setInt(4, vo.getBoardHit());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
	
