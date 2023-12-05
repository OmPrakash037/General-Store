package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SignupDAO;
import beans.Signup;
import common.DataBaseConnect;

/**
 * Servlet implementation class Signup_controller
 */
@WebServlet("/Signup")
public class Signup_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("signUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String[] errors = new String[5];
		Signup s = new Signup();
		PrintWriter out = response.getWriter();
		
		if(!request.getParameter("name").equals("") && !request.getParameter("name").equals(" ")) {
			s.setName(request.getParameter("name"));
		}else {
			errors[0] = "Name field is not valid";
		}
		if(!request.getParameter("contact").equals("") && !request.getParameter("contact").equals(" ")) {
			s.setContact(request.getParameter("contact"));
		}else {
			errors[1] = "contact field is not valid";
		}
		if(!request.getParameter("email").equals("") && !request.getParameter("email").equals(" ")) {
			s.setEmail(request.getParameter("email"));
		}else {
			errors[2] = "email field is not valid";
		}
		if(!request.getParameter("password").equals("") && !request.getParameter("password").equals(" ")) {
			s.setPassword(request.getParameter("password"));
		}else {
			errors[3] = "password field is not valid";
		}
		if(!request.getParameter("userrole").equals("") && !request.getParameter("userrole").equals(" ")) {
			s.setUserrole(request.getParameter("userrole"));
		}else {
			errors[4] = "userrole field is not valid";
		}
		
		System.out.println("Name :: "+ request.getParameter("name")+ " contact :: "+request.getParameter("contact")+ " email :: "+request.getParameter("email")+" password :: "+request.getParameter("password")+" :: userrole"+request.getParameter("userrole"));
		SignupDAO sd = new SignupDAO(DataBaseConnect.connect());
		boolean bool;
		try {
			bool = sd.insert(s);
			if(bool) {
				response.sendRedirect("Signin");
			}else {
				response.sendRedirect("signUp.jsp");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
