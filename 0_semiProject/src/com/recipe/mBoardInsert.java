package com.recipe.mBoard.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.recipe.mBoard.model.mBoardVO;
import com.recipe.mBoard.service.mBoardService;
import com.recipe.member.vo.MemberVO;

/**
 * Servlet implementation class mBoardInsert
 */
@WebServlet("/mBoardInsert.do")
public class mBoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mBoardInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	
	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		
		// 최상위 디렉토리 (WebContent)로부터의 파일이 업로드 되는 경로
	//	String uploadPath = "/upload/";
		
		// 현재 프로젝트에 대한 정보를 가지고 있는 객체
	//	ServletContext context = request.getServletContext();
		
		// ServletContext를 이용하여 실제 경로를 가져와야 함
	//	String realUploadPath = context.getRealPath(uploadPath);
		
		
		// 경로 확인
	//	System.out.println(realUploadPath);
		
		// 파일 사이즈 (숫자는 byte 단위)
	//	int uploadFileSizeLimit = 50 * 1024 * 1024; 
		
		// 인코딩값
		String encType = "UTF-8";
		
		// MultipartRequest 객체 생성 (생성하면서 마지막 5번째 정책 설정 객체 만들기)
		//MultipartRequest multi = new MultipartRequest(request, encType, 0, new DefaultFileRenamePolicy());
		
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		String boardWriter = request.getParameter("boardWriter"); 
		String boardDate= request.getParameter("boardDate");
		String boardHit = request.getParameter("boardHit");
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("member");
		String BoardWriter = vo.getUserNickname();
		
		mBoardVO boardvo = new mBoardVO();
		
		boardvo.setBoardNUM(boardNum);
		boardvo.setBoardTitle(boardTitle);
		boardvo.setBoardContent(boardContent);
		boardvo.setBoardWriter(boardWriter);
//		boardvo.setBoardDate(boardDate);
//		boardvo.setChangeName(changeName);
//		boardvo.setFilePath(filePath);
		

		mBoardService Service = new mBoardService();
		
		int result = Service.insertBoard(boardvo);
		
		if(result > 0 ) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('글이 등록되었습니다.')");
			script.println("</script>");
			response.sendRedirect("/mboardList.do?boardNum="+boardNum+"&currentPage=1");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/mBoard/InsertFail.jsp");
			view.forward(request, response);

}
	}
}
