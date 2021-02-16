package com.recipe.notice.model.service;

import java.sql.*;
import java.util.ArrayList;

import com.recipe.common.JDBCTemplate;
import com.recipe.notice.model.dao.NoticeDAO;
import com.recipe.notice.model.vo.NoticeVO;

public class NoticeService {

	
	NoticeDAO noticeDAO = new NoticeDAO();
	
	
	public ArrayList<NoticeVO> getNotices(int startRow, int endRow) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<NoticeVO> list = noticeDAO.getNotices(conn,startRow,endRow);
		System.out.println("service list : "+list.size());
		JDBCTemplate.close(conn);
		return list;
	}
	
	public int getTotalNum() throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		int result = noticeDAO.getTotalNum(conn);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
	
	public int insertNotice(NoticeVO noticeVO) {
		Connection conn = JDBCTemplate.getConnection();
		int result = noticeDAO.insertNotice(conn, noticeVO);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public NoticeVO getNotice(int noticeNum) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeVO noticeVO = noticeDAO.getNotice(conn, noticeNum);
		JDBCTemplate.close(conn);
		
		return noticeVO;
	}
	
	public int deleteNotice(int noticeNum) {
		Connection conn = JDBCTemplate.getConnection();
		int result = noticeDAO.deleteNotice(conn, noticeNum);
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public NoticeVO getNoticeUpdateReady(int noticeNum) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeVO noticeVO = noticeDAO.getNoticeUpdateReady(conn, noticeNum);
		JDBCTemplate.close(conn);
		
		return noticeVO;
	}
	
	public int updateNotice(NoticeVO noticeVO) {
		Connection conn = JDBCTemplate.getConnection();
		int result = noticeDAO.updateNotice(conn, noticeVO);
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public ArrayList<NoticeVO> selectSearchBoardPage(String searchCategory, String keyword, int currentPage, int recordCountPerPage){
		Connection conn = JDBCTemplate.getConnection();
		
		
		NoticeDAO noticeDAO = new NoticeDAO();
		ArrayList<NoticeVO> list = 
				noticeDAO.selectSearchNoticePageList(conn, searchCategory, keyword, currentPage, recordCountPerPage);
		
		// 아래 코드는 데이터가 잘 넘어 왔는지 확인용도의 임시코드, 확인 후 삭제 예정
		for(NoticeVO noticeVO : list) {
			System.out.println(noticeVO.getNoticeNum()+"/"+noticeVO.getNoticeTitle());
			
		}
		JDBCTemplate.close(conn);
		return list;
	}
	
	public int getSearchListCount(String searchCategory, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		
		NoticeDAO rboardDAO = new NoticeDAO();
		int postTotalCount = rboardDAO.getSearchListCount(conn, searchCategory, keyword);
		
		// 아래 코드는 데이터가 잘 넘어왔는지 확인 용도 임시코드
		// System.out.println("postTotalCount"+postTotalCount);
		return postTotalCount;
		
	}
	 
	public ArrayList<NoticeVO> selectSearchNoticePage(String searchCategory, String keyword, int currentPage, int recordCountPerPage){
		Connection conn = JDBCTemplate.getConnection();
		
		
		NoticeDAO rboardDAO = new NoticeDAO();
		ArrayList<NoticeVO> list = 
				rboardDAO.selectSearchNoticePageList(conn, searchCategory, keyword, currentPage, recordCountPerPage);
		
		// 아래 코드는 데이터가 잘 넘어 왔는지 확인용도의 임시코드, 확인 후 삭제 예정
		for(NoticeVO board : list) {
			System.out.println(board.getNoticeNum()+"/"+board.getNoticeTitle());
			
		}
		JDBCTemplate.close(conn);
		return list;
	}
	
}
