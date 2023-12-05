<%@page import="beans.Signup"%>

<% 
		if(session.getAttribute("signup")!=null){
			Signup sb = (Signup)session.getAttribute("signup");
			
			if(sb.getUserrole().equals("admin")){
				
			}else{
				response.sendRedirect("../signin.jsp");
			}
				
		}else{
			response.sendRedirect("../signin.jsp");
		}
%>