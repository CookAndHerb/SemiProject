
//package com.recipe.member.cotroller;
//
//import java.io.IOException;
//import java.util.Properties;
//import java.util.Random;
//
//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet implementation class MemberJoinEmailCheckServlet
// */
//@WebServlet("/MemberJoinEmailCheck.do")
//public class MemberJoinEmailCheckServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//   
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		execute(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		execute(request, response);
//	}
//
//	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String email = request.getParameter("userEmail");
//		System.out.println(email);
//		// mail server 설정
//		String host = "smtp.naver.com";
//		final String user = "jjii320"; // 자신의 네이버 계정
//		final String password = "j@269852";// 자신의 네이버 패스워드
//
//		// SMTP 서버 정보를 설정한다.
//		Properties props = new Properties();
//		props.put("mail.smtp.host", host);
//		props.put("mail.smtp.port", 465);
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.ssl.enable", "true");
//
//		// 인증 번호 생성기
//		StringBuffer temp = new StringBuffer();
//		Random rnd = new Random();
//		for (int i = 0; i < 10; i++) {
//			int rIndex = rnd.nextInt(3);
//			switch (rIndex) {
//			case 0:
//				// a-z
//				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
//				break;
//			case 1:
//				// A-Z
//				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
//				break;
//			case 2:
//				// 0-9
//				temp.append((rnd.nextInt(10)));
//				break;
//			}
//		}
//		String AuthenticationKey = temp.toString();
//		System.out.println(AuthenticationKey);
//
//		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(user, password);
//			}
//		});
//
//		// email 전송
//		try {
//			MimeMessage msg = new MimeMessage(session);
//			msg.setFrom(new InternetAddress(email, "CookCookRecipe"));
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("jjii320@naver.com"));
//
//			// 메일 제목
//			msg.setSubject("안녕하세요 CookCookRecipe 인증 메일입니다.");
//			// 메일 내용
//			msg.setText("인증 번호는 '" + temp +"' 입니다.");
//
//			Transport.send(msg);
//			System.out.println("이메일 전송");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		HttpSession saveKey = request.getSession();
//		saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
//		request.getRequestDispatcher("/views/memberJoin.jsp").forward(request, response);
//	}
//
//}