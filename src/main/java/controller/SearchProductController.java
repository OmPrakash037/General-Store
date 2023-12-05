package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.OrderPage;
import beans.OrderList;

import common.DataBaseConnect;


/**
 * Servlet implementation class SearchProductController
 */

@WebServlet("/searchproducts")
public class SearchProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		System.out.println("This is SearchProductController.java");
		
		String searchNameText=request.getParameter("name_search_text");
		System.out.println(searchNameText);
		if(searchNameText==null){
			searchNameText="";
		}
		List<OrderList> list=new OrderPage(DataBaseConnect.connect()).getAllByName(searchNameText);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/customerOrder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
