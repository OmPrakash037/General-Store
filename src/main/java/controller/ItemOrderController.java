package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import common.DataBaseConnect;

import DAO.OrderPage;
import DAO.ProductDAO;
import DAO.SignupDAO;
import beans.OrderList;
import beans.Product_bean;

/**
 * Servlet implementation class ItemOrderController
 */


@WebServlet("/itemordercontroller")
public class ItemOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("This is ItemOrderController.java  page doGet()"); 
		RequestDispatcher rd = request.getRequestDispatcher("address.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("*** ");
		System.out.println("This is ItemOrderController.java  page doPost()"); 
		
		OrderPage order=new OrderPage(DataBaseConnect.connect());
		OrderList orderList=new OrderList();
		String []errors=new String[4];
		boolean bool = false;
		
		System.out.println(request.getParameter("cusName"));
		System.out.println(request.getParameter("cusPhone"));
		System.out.println(request.getParameter("cusLocation"));
		
		
		if(!request.getParameter("cusName").equals("") && !request.getParameter("cusName").equals(" ")){
			orderList.setCusName(request.getParameter("cusName"));
			System.out.println(request.getParameter("cusName"));
		}else{
			errors[0]="Name field is not valid";
		}
		if(!request.getParameter("cusPhone").equals("") && !request.getParameter("cusPhone").equals(" ")){
			orderList.setCusPhone(request.getParameter("cusPhone"));
			System.out.println(request.getParameter("cusPhone"));
		}else{
			errors[1]="Name field is not valid";
		}
		if(!request.getParameter("cusLocation").equals("") && !request.getParameter("cusLocation").equals(" ")){
			orderList.setCusLocation(request.getParameter("cusLocation"));
			System.out.println(request.getParameter("cusLocation"));
		}else{
			errors[2]="Name field is not valid";
		}
		
		
		
		
		
		HttpSession session =request.getSession();
		
		if(session.getAttribute("addToCart")!=null){
			ListIterator lit=((List)session.getAttribute("addToCart")).listIterator();
			ProductDAO pd=new ProductDAO(DataBaseConnect.connect());
			
			
			while(lit.hasNext()){
				
//Special Case care about this point
				int id=Integer.parseInt((String)lit.next());
				Product_bean pb=pd.getOne(id);
				
				int pId=pb.getId();
				String pName=pb.getName();
				String pQuantity=pb.getQuantity();
				String pBrand=pb.getBrand();
				float cost=pb.getCost();
				
				orderList.setpId(pId);
				orderList.setpName(pName);
				orderList.setpQuantity(pQuantity);
				orderList.setpBrand(pBrand);
				orderList.setCost(cost);
				
				System.out.println(pId);
				System.out.println(pName);
				System.out.println(pQuantity);
				System.out.println(pBrand);
				System.out.println(cost);
				
				
				
				
				try {
					bool = order.insert(orderList);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				
				
				
				
			}//while
		}//if
		
		if(bool){
			System.out.println("remove addToCart");
			session.removeAttribute("addToCart");
			System.out.println("addToCart   removed");
			//session.invalidate();
			response.sendRedirect("success.jsp");
		}else{
			System.out.println("I am Here");
			response.sendRedirect("signUp.jsp?=info=failed");
			
		}
	}

}
