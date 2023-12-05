package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Random;

//import javax.mail.internet.*;
//import javax.mail.*;
//import sis.com.util.EmailPasswordUtil;



import java.util.*;


@WebServlet("/emailvalidate")

public class EmailValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String clientUserEmail = request.getParameter("user_email");
//create otp  4 digit

		System.out.println("clientUserEmail=" + clientUserEmail);

		Random rand = new Random();
		HttpSession session = request.getSession();
		int otpNum = (rand.nextInt(1001) + 1000); // 1000-2000
		String otp = otpNum + "";
		session.setAttribute("otp", otp);
//send otp to user email
		System.out.println("otp =" + otp + " user" + session.getId());
//************************************

//email code start
		// TODO
// final String userName = "anuj.mca.nitrr.2019@gmail.com";
// final String password = "@nuj1998***";
//
// // email server details
// Properties props = new Properties();
// //set key and value
// props.put("mail.smtp.auth", "true");
// props.put("mail.smtp.starttls.enable", "true");
// props.put("mail.smtp.host", "smtp.gmail.com");
// props.put("mail.smtp.port", "587");
//
//
// //create email session object
// System.out.println("login starting .....");
// Session email_session = Session.getInstance(props,
//  new javax.mail.Authenticator() {
// protected PasswordAuthentication getPasswordAuthentication() {
// return new PasswordAuthentication(userName, password);
// }
//  });
//  
//
// try {
// System.out.println("message sending");
//    //create message object
// Message message = new MimeMessage(email_session);
//
//
// message.setFrom(new InternetAddress(userName));
//
// //String receiverEmailList="x123@gmail.com,y123@gmail.com";
// String receiverEmailList=clientUserEmail;
//
// message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiverEmailList));
//
// String subject= "Sis Msg success is sure "+Math.random();
// message.setSubject(subject);
//
// String dataText="Message from \"AcademyOfMine\" \n Your OneTimePassword is "+otp+"";
// message.setText(dataText);
//
// //send email
// Transport.send(message);
//
// System.out.println("message sent ");
// }catch (MessagingException e) {
// //throw new RuntimeException(e);
// System.out.print(e.getMessage());
// e.printStackTrace();
// }
//  
//email code END

//************************************
		request.setAttribute("userEmail", clientUserEmail);

		session.setAttribute("userEmail", clientUserEmail);

		System.out.println("step1" + clientUserEmail);
		response.sendRedirect("emailvalidateotpcheck");
//request.getRequestDispatcher("otp_form.jsp").forward(request, response);
	}

}