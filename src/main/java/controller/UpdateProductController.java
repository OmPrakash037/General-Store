package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.Product_bean;
import DAO.ProductDAO;

import DAO.SignupDAO;

import common.DataBaseConnect;
/**
 * Servlet implementation class UpdateProductController
 */
@WebServlet("/updateproductcontroller")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("This is UpdateProductController.java servler class:-");
	    
	    String idStr=request.getParameter("id");
	    int id=Integer.parseInt(idStr);
	    ProductDAO pd= new ProductDAO(DataBaseConnect.connect());
	    Product_bean pb = pd.updateProductForm(id);
	    System.out.println("id="+pb.getId());
	    System.out.println("name="+pb.getName());
	    System.out.println("cost="+pb.getCost());
	    System.out.println("Brand="+pb.getBrand());
	    System.out.println("available="+pb.getAvailable());
	    System.out.println("before here");
	    
	    if(pb!=null) {
	    	System.out.println("I am here");
	    	request.setAttribute("pb",pb);
	    	
	    	request.getRequestDispatcher("admin/updateProductForm.jsp").forward(request, response);
	    }else {
	    	
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("This is UpdateProductController.java doPost()method ");
		
		StringBuilder errorCode = new StringBuilder();
		
		Product_bean pb = new Product_bean();
		String idStr=request.getParameter("id");
		String name =request.getParameter("name");
		String costStr=request.getParameter("cost");
		String brand=request.getParameter("brand");
		String available=request.getParameter("available");
		String quantity=request.getParameter("quantity");
		String fileName=request.getParameter("fileName");
		
		Float cost=null;
        try {
        	cost=Float.parseFloat(costStr);
		} catch (NumberFormatException e) {
			errorCode.append(" price is Not number "+ e.getMessage()+"<BR>");

		}
		int id=Integer.parseInt(idStr);
		pb.setId(id);
		pb.setName(name);
		pb.setQuantity(quantity);
		pb.setCost(cost);
		pb.setBrand(brand);
		pb.setAvailable(available);
        pb.setFileName(fileName);
        
        
		System.out.println("id="+pb.getId());
		System.out.println("name="+pb.getName());
		System.out.println("Quantity="+pb.getQuantity());
		System.out.println("cost="+pb.getCost());
		System.out.println("Brand="+pb.getBrand());
		System.out.println("Available="+pb.getAvailable());
		System.out.println("FileName="+pb.getFileName());
		
		
		
		try{
			 boolean b=new ProductDAO(DataBaseConnect.connect()).updateProductInDB(pb);
			 System.out.println("After update = "+pb.getAvailable());
			 if(b){
				 response.sendRedirect("admin/RashanStore.jsp?status=success");
			 }else{
				 response.sendRedirect("admin/RashanStore.jsp?status=failed");
				 
			 }
			 
		 }catch(Exception e){
			 
		 }
		
		response.getWriter().print("Here  ");
		
	}

}
