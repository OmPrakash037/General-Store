package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.DataBaseConnect;
import DAO.SignupDAO;

@WebServlet("/signupDelete")


public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		SignupDAO sb=new SignupDAO(DataBaseConnect.connect());
		if(sb.delete(Integer.parseInt(request.getParameter("id")))) {
			response.sendRedirect("admin/index.jsp?status=Deleted");
		}else {
			response.sendRedirect("admin/index.jsp?status=Not Deleted");
		}
	}

}
