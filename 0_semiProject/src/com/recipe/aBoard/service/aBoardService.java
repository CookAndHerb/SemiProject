package com.recipe.aBoard.service;

import java.sql.Connection;

import com.recipe.aBoard.dao.aBoardDAO;
import com.recipe.aBoard.vo.aBoardVO;
import com.recipe.common.JDBCTemplate;

public class aBoardService {
	aBoardDAO dao = new aBoardDAO();
	
	public int insertBoard(aBoardVO vo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertBoard(conn, vo);
		
		if(result>0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
}
