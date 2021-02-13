package com.recipe.rboard.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.recipe.member.vo.MemberVO;
import com.recipe.rboard.model.service.RboardService;
import com.recipe.rboard.model.vo.Rboard;

/**
 * Servlet implementation class RboardUptServlet
 */
@WebServlet("/RboardUpt.do")
public class RboardUptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RboardUptServlet() {
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
				String uploadPath = "/upload/";
				
				// 현재 프로젝트에 대한 정보를 가지고 있는 객체
				ServletContext context = request.getServletContext();
				
				// ServletContext를 이용하여 실제 경로를 가져와야 함
				String realUploadPath = context.getRealPath(uploadPath);
				
				
				// 경로 확인
				System.out.println(realUploadPath);
				
				// 파일 사이즈 (숫자는 byte 단위)
				int uploadFileSizeLimit = 50 * 1024 * 1024; 
				
				// 인코딩값
				String encType = "UTF-8";
				
				// MultipartRequest 객체 생성 (생성하면서 마지막 5번째 정책 설정 객체 만들기)
				MultipartRequest multi = new MultipartRequest(request, realUploadPath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
				
				int currentPage = Integer.parseInt(multi.getParameter("currentPage"));
				int boardCategory = Integer.parseInt(multi.getParameter("boardCategory"));
				int boardNum = Integer.parseInt(multi.getParameter("boardNum")); // 수정할 게시물 번호 알아오기
				String boardTitle = multi.getParameter("boardTitle");
				String boardContent = multi.getParameter("boardContent");
				
				String ch_originName = multi.getOriginalFileName("file"); // 파일 수정을 할 경우 
				String ch_changeName = multi.getFilesystemName("file"); // 파일 수정을 할 경우
				if(ch_originName == null) { // 파일 수정을 하지 않을 경우
					ch_originName = multi.getParameter("existing_file_origin");
					ch_changeName = multi.getParameter("existing_file_change");
				}
				String changeName = multi.getParameter("existing_file_change");
				
				String filePath = "/upload";
				
				HttpSession session = request.getSession();
				MemberVO mvo = (MemberVO)session.getAttribute("member");
				String boardWriter = mvo.getUserNickname();
				
				Rboard board = new Rboard();
				
				board.setBoardCategory(boardCategory);
				board.setBoardNum(boardNum);
				board.setBoardTitle(boardTitle);
				board.setBoardContent(boardContent);
				board.setBoardWriter(boardWriter);
				board.setOriginName(ch_originName);
				board.setChangeName(ch_changeName);
				board.setFilePath(filePath);
				

				RboardService rService = new RboardService();
				
				int result = rService.boardUpdate(board);
				
				if(result > 0 ) {
					
					response.sendRedirect("/RboardPost.do?boardNum="+boardNum+"&currentPage="+currentPage);
					
				}else {
					RequestDispatcher view = request.getRequestDispatcher("/rBoard/RboardUptFail.jsp");
					view.forward(request, response);
				}
		
	}
}
