package com.recipe.member.cotroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.recipe.member.service.MemberFindService;
import com.recipe.member.vo.MemberVO;

@WebServlet("/memberFindPwEmail.do")
public class MemberFindPwEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userEmail = request.getParameter("userEmail");
		
		JSONObject object = new JSONObject();
		
		//회원 아이디로 정보를 받아오고 가져온 데이터에서 email 값을 비교하여 다르면 알림창 뜨기
		MemberVO mvo = new MemberFindService().memberInfo(userId);
		
//		System.out.println("가져온 ID : "+mvo.getUserId());
//		System.out.println("가져온 Email : "+mvo.getUserEmail());
		
		if(mvo==null || !mvo.getUserEmail().equals(userEmail)) {
			//입력값 비일치
			object.put("ok", "");
			System.out.println("비일치 : "+mvo.getUserEmail().equals(userEmail));

		} else {
			//입력 값 일치
			System.out.println("일치 : "+mvo.getUserEmail().equals(userEmail));
				
		//mail server 설정
		String host = "smtp.naver.com";
		final String user = "sujung9404";
		final String password = "Crystal_";
		
		//메일 받을 주소
		String toEmail = mvo.getUserEmail();
		
		//SMTP 서버 정보를 설정한다.
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");  
		
		//인증번호 생성기
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for(int i=0; i<10; i++) {
			int rIndex = rnd.nextInt(3);
			switch(rIndex) {
			case 0:
				//a-z
				temp.append((char)((int)(rnd.nextInt(26))+97));
				break;
			case 1:
				//A-Z
				temp.append((char)((int)(rnd.nextInt(26))+65));
				break;
			case 2:
				//0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		String authenticationKey = temp.toString();
		System.out.println("인증번호 : "+authenticationKey);
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });
		//email 전송
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("sujung9404@naver.com","CookCookRecipe")); //보내는 이메일 주소, 보내는 이름
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail)); //받는 이메일 주소
            
            //메일 제목
            msg.setSubject("안녕하세요 CookCookRecipe 인증 메일입니다.");
            //메일 내용
            msg.setText("인증 번호 : "+temp);
            
            Transport.send(msg);
            System.out.println("이메일 전송");
            
            //out.println("<script>alert('이메일 전송 완료. 인증번호를 입력해주세요.');</script>");
        }catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
        HttpSession saveKey = request.getSession();
        saveKey.setAttribute("authenticationKey", authenticationKey);
        //패스워드 바꿀때 뭘 바꿀지 조건에 들어가는 id
        request.setAttribute("userId", userId);
        request.getRequestDispatcher("/memberFindPw.do").forward(request, response);
		}
		
		response.setContentType("application/json");
		
		response.setCharacterEncoding("utf-8");		
		PrintWriter out = response.getWriter();
		out.print(object);
	}
}
