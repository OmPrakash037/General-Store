package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.DataBaseConnect;
import DAO.SignupDAO;
import beans.Signup;

/**
 * Servlet implementation class Login_controller
 */
@WebServlet("/Signin")
public class Signin_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub

//Here we use our Signup class and make an object "s" for putting value which is come from signin.jsp page
		Signup s = new Signup();
// Here we write a SignupDAO.java class to write select Query and we pass MyConnection.connectTo() method to connect database  
		SignupDAO sd = new SignupDAO(DataBaseConnect.connect());
		String[] errors = new String[2];

		if (!request.getParameter("email").equals("") && !request.getParameter("email").equals(" ")) {
			s.setEmail(request.getParameter("email"));
			System.out.println(request.getParameter("email"));
		} else {
			errors[0] = "Email field is not valid";
		}
		if (!request.getParameter("password").equals("") && !request.getParameter("password").equals(" ")) {
			s.setPassword(request.getParameter("password"));
			System.out.println(request.getParameter("password"));
		} else {
			errors[1] = "Password field is not valid";
		}

// Here first we send value which is inside the s object and fetch value from Signup.java class and go signin()method which is inside SignupDAO.java & after checking that it is right or wrong information and  again put that value inside sb object.  

		Signup sb = sd.signin(s);
		if (sb != null) {
			HttpSession session = request.getSession();
			session.setAttribute("signup", sb);
			if (sb.getUserrole().equals("admin")) {
				response.sendRedirect("admin/index.jsp");
			} else if (sb.getUserrole().equals("user")) {
				response.sendRedirect("Index.jsp");
			}
		} else {
			response.sendRedirect("signin.jsp?info=failed");
		}

	}

}