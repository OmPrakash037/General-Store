package products;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.ProductDAO;
import common.DataBaseConnect;

/**
 * Servlet implementation class ProductDeleteController
 */


@WebServlet("/productdelete")
public class ProductDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("This is ProductDeleteController.java");
		ProductDAO pd=new ProductDAO(DataBaseConnect.connect());
		if(pd.delete(Integer.parseInt(request.getParameter("id")))){
			response.sendRedirect("admin/RashanStore.jsp?status=Deleted");
		}else{
			response.sendRedirect("admin/RashanStore.jsp?status=Not deleted");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
