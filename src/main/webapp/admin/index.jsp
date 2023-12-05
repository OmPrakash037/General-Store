



<%@page import="DAO.SignupDAO" %>
<%@page import="java.util.*" %>
<%@page import="common.DataBaseConnect" %>
<%@page import="beans.Signup" %>
<%@page import="java.sql.Connection" %>

<!-- -->



<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>AdminIndex</title>
	
		<link rel="stylesheet" type="text/css" href="common/common.css">
		<%@include file="../common/cdn.jsp" %>
	</head>
<body>
					<!--  <% //System.out.println("This is admin/index.jsp page"); %> -->
					
		
	<%
      		if(session.getAttribute("signup")!=null){
      			Signup sb=(Signup) session.getAttribute("signup");
      			
      			if(sb.getUserrole().equals("admin")){
      				
      			}else{
      				
	      			response.sendRedirect("../signin.jsp");
      			}
      			
      		}else{
      			response.sendRedirect("../signin.jsp");
      		}


%>	
		
					
					
	<%@include file="common/header.jsp" %>
	<div class="container-fluid">
	  <!--  <header> -->
	  <!--  </header> -->
	 	<div class="row">
	 		<div class="col-sm-3 sidebar-col">
	 			<%@include file="common/sidebar.jsp" %>
	 		</div>	
	 		<div class="col-sm-9 main-col">
	 			<h3> User List</h3>
			
			<div style="color:red;">
				<%
	 				if(request.getParameter("status")!=null){
	 					out.println("    "+request.getParameter("status").toUpperCase());
	 				}
	 			%>
			
			</div>
			
			
			 <table class="table table-bordered">
				<tr>
					<th></th>
					<th></th>
					<th>Id</th>
					<th>Name</th>
					<th>Contact</th>
					<th>Email</th>
					<th>UserRole</th>
				</tr>
	 	<%
	 		List<Signup> li=new SignupDAO(DataBaseConnect.connect()).getAll();
	 			
	 		ListIterator<Signup> lit=li.listIterator();
	 		while(lit.hasNext()){
	 			Signup sb=(Signup) lit.next();
	 			
	 	%>
	 		<tr>
	 			<!-- Why we use here(../)because our index.jsp is inside admin/index.jsp and url work on home page so we have to come out side admin and work on home page -->
	 			<td><button class="btn btn-dark">Update</button></td>
	 			<td><a href="../signupDelete?id=<%= sb.getId() %>" class="btn btn-dark">Delete</a></td>
	 			<td><%= sb.getId() %></td>
	 			<td><%= sb.getName() %></td>
	 			<td><%= sb.getContact() %></td>
	 			<td><%= sb.getEmail() %></td>
	 			<td><%= sb.getUserrole() %></td>
	 		</tr>
		 			
		 	<% 
		 			
 		   }//while
	 			
		 	
		 	%>	
		 		
	 	       </table>		
	 		</div>	
	 	</div>
	</div>
	 
	

</body>
</html>