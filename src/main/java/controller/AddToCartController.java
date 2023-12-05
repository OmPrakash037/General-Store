package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/addtocartcontroller")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("This is AddToCartController");
		
		HttpSession session=request.getSession();
		List li;
		if(session.getAttribute("signup")!=null){
		String param=request.getParameter("id");
		
		System.out.println("5566");
		if(session.getAttribute("addToCart")==null){
			 li=new ArrayList();
			 li.add(param);
			 session.setAttribute("addToCart", li);
			 System.out.println("7788");
		}else{
			li=(List)session.getAttribute("addToCart");
			if(!li.contains(param))
				li.add(param);
			session.setAttribute("addToCart", li);
			System.out.println("3322");
		}
		
		
		
		response.getWriter().print(li.size());
		}else{
			response.getWriter().print(0);
			session.invalidate();
		}
	}

}
