package com.recipe.notice.model.dao;

import java.sql.*;
import java.util.ArrayList;

import com.recipe.common.JDBCTemplate;
import com.recipe.notice.model.vo.NoticeVO;

public class NoticeDAO {
	/*
	public ArrayList<NoticeVO> selectAllNoticeList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 게시판이 여러 개라 arrayList로 가져오기
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		
		// 여기서 필요한 로직이 바로 TOP-N분석 (상위 5개씩 가져오는 것)
		// 5개씩 가졍려면 NoticeNum을 바탕으로 내림차순을 한 뒤 가장 상위 10개를 가져와야 하기 때문에
		// TOP-N분석 필요
		
		// sql 예시
		// 1 page면 1~10까지 row-num에 해당하는 데이터 보여주기
		// select * from (select row_number() over(order by notice_num desc) 
		// as row_num, notice * from notice where del_yn='n') where row_num between 1 and 5;
		
		//int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		//int end = currentPage * recordCountPerPage;
		
//		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(order by NOTICE_NUM DESC) "
//				+ "AS row_num, NOTICE.* "
//				+ "FROM NOTICE WHERE row_num between ? and ?";
		String query = "SELECT * FROM NOTICE";
				
		try {
			pstmt = conn.prepareStatement(query);
			//pstmt.setInt(1, start);
			//pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeVO notice = new NoticeVO();
				notice.setNoticeNum(rset.getInt("noticeNum"));
				notice.setNoticeTitle(rset.getString("noticeTitle"));
				notice.setNoticeContent(rset.getString("noticeContent"));
				notice.setNoticeWriter(rset.getString("noticeWriter"));
				notice.setNoticeHit(rset.getInt("noticeHit"));
				notice.setNoticeDate(rset.getDate("noticeDate"));
				
				list.add(notice);
			}
			
		} catch (SQLException e) {
			// TODO 모든 테스트 후 e.printStackTrace(); 으로 변경
			// 오류 메세지 출력
			System.out.println(e.getMessage());
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	*/
	
	
	public int insertNotice(Connection conn, NoticeVO noticeVO) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into NOTICE values(notice_seq.nextval,?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, noticeVO.getNoticeTitle());
			pstmt.setString(2, noticeVO.getNoticeContent());
			pstmt.setString(3, noticeVO.getNoticeWriter());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
/*
	public ArrayList<NoticeVO> selectAllNoticeList(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		
		// 게시판이 여러 개라 arrayList로 가져오기
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(order by NOTICE DESC) "
				+ "AS notice_num, NOTICE.* "
				+ "FROM NOTICE) WEHRE notice_num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeVO notice = new NoticeVO();
				notice.setNoticeNum(rset.getInt("noticeNum"));
				notice.setNoticeTitle(rset.getString("noticeTitle"));
				notice.setNoticeContent(rset.getString("noticeContent"));
				notice.setNoticeWriter(rset.getString("noticeWriter"));
				notice.setNoticeDate(rset.getDate("noticeDate"));
				
				list.add(notice);
			}
			
		} catch (SQLException e) {
			// TODO 모든 테스트 후 e.printStackTrace(); 으로 변경
			// 오류 메세지 출력
			System.out.println(e.getMessage());
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	*/
	
	/* noticeAllList.jsp : 페이징을 위해 DB에 입력된 전체 글 수 구하기 */
	public int getTotalNum(Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int total = 0;
		
		try{
			pstmt = conn.prepareStatement("select count(*) from notice");
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				total = rset.getInt(1);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return total;
	} 
	
	/* NoticeAllList.jsp : 페이징. DB로부터 여러행을 결과로 받는다. */
	public ArrayList<NoticeVO> getNotices(Connection conn, int startRow, int endRow) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		try{
			String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(order by NOTICE_NUM DESC) AS row_num, NOTICE.* "
					+ "FROM NOTICE) WHERE row_num between ? and ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			
			while(rset.next()){
				NoticeVO noticeVO = new NoticeVO();
				noticeVO.setNoticeNum(rset.getInt("NOTICE_NUM"));
				noticeVO.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				noticeVO.setNoticeWriter(rset.getString("NOTICE_WRITER"));
				noticeVO.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				noticeVO.setNoticeDate(rset.getDate("NOTICE_DATE"));
					
				list.add(noticeVO);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	} 
	
	/* detailNotice.jsp : 공지사항 글 1개 정보 가져오기 */
	public NoticeVO getNotice(Connection conn, int noticeNum) {
		NoticeVO noticeVO = new NoticeVO();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM NOTICE WHERE NOTICE_NUM=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				noticeVO.setNoticeNum(rset.getInt("NOTICE_NUM"));
				noticeVO.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				noticeVO.setNoticeWriter(rset.getString("NOTICE_WRITER"));
				noticeVO.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				noticeVO.setNoticeDate(rset.getDate("NOTICE_DATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return noticeVO;
	}
	
	public int deleteNotice(Connection conn, int noticeNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM NOTICE WHERE NOTICE_NUM=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public NoticeVO getNoticeUpdateReady(Connection conn,int noticeNum) {
		NoticeVO noticeVO = new NoticeVO();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM NOTICE WHERE NOTICE_NUM=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				noticeVO.setNoticeNum(rset.getInt("NOTICE_NUM"));
				noticeVO.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				noticeVO.setNoticeWriter(rset.getString("NOTICE_WRITER"));
				noticeVO.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				noticeVO.setNoticeDate(rset.getDate("NOTICE_DATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return noticeVO;
		
	}
	
	public int updateNotice(Connection conn, NoticeVO noticeVO) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NOTICE SET NOTICE_TITLE=?,NOTICE_CONTENT=? WHERE NOTICE_NUM=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, noticeVO.getNoticeTitle());
			pstmt.setString(2, noticeVO.getNoticeContent());
			pstmt.setInt(3, noticeVO.getNoticeNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<NoticeVO> noticeSearchList(Connection conn, int currentPage, int recordCountPerPage, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		
		try{
			String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(order by NOTICE_NUM DESC) AS row_num, NOTICE.* "
					+ "FROM NOTICE WHERE subject like ?)row_num between ? and ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			
			while(rset.next()){
				NoticeVO noticeVO = new NoticeVO();
				noticeVO.setNoticeNum(rset.getInt("NOTICE_NUM"));
				noticeVO.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				noticeVO.setNoticeWriter(rset.getString("NOTICE_WRITER"));
				noticeVO.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				noticeVO.setNoticeDate(rset.getDate("NOTICE_DATE"));
					
				list.add(noticeVO);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	/* 
	public String getPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String keyword) {
		int postTotalCount = postSearchTotalCount(conn, keyword);
		
		
		
		StringBuilder sb = new StringBuilder(); //String은 한 번 만들어지면 바꾸지 못함.
		if(startNavi != 1) {
			sb.append("<a href='/noticeAllList.do?currentPage="+(startNavi-1)+"'><</a> ");
		}
		
		for (int i = startNavi; i<= endNavi; i++) {
			if(i==currentPage) {
				// 현재 선택된 페이지는 진하게 표시
				sb.append("<a href='/noticeAllList.do?currentPage="+i+"'><b>"+i+"</b><</a> ");
			}else {
				sb.append("<a href='/noticeAllList.do?currentPage="+i+"'>"+i+"<</a> ");
			}
		}
		
		if(endNavi != pageTotalCount) {
			sb.append("<a href='/noticeAllList.do?currentPage="+(endNavi+1)+"'>></a> ");
		}
		return sb.toString();
	}
	*/
	
	private int postSearchTotalCount(Connection conn, String keyword) {
		// 키워드를 통해 검색된 게시물의 총 갯수를 구하는 메서드
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int postTotalCount = 0;
		
		String query = "SELECT COUNT(*) as totalCount FROM NOTICE "
				+ "WHERE SUBJECT like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			rset.next();
			postTotalCount = rset.getInt("totalCount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return postTotalCount;
	}
	
	public ArrayList<NoticeVO> selectSearchNoticePageList(Connection conn, String keyword, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		int start = currentPage * recordCountPerPage - (recordCountPerPage -1);
		int end = currentPage * recordCountPerPage;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY BOARD_NUM DESC)AS ROW_NUM, NOTICE.* "
				+ "FROM NOTICE LIKE ?) WHERE ROW_NUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeVO noticeVO = new NoticeVO();
				noticeVO.setNoticeNum(rset.getInt("NOTICE_NUM"));
				noticeVO.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				noticeVO.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				noticeVO.setNoticeWriter(rset.getString("NOTICE_WRITER"));
				noticeVO.setNoticeDate(rset.getDate("NOTICE_DATE"));
			
				list.add(noticeVO);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	
	public int getSearchListCount(Connection conn , String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int postTotalCount =0 ;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE LIKE ?";
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


