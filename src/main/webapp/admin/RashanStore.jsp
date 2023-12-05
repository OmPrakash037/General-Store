
<%@page import="beans.Product_bean" %>
<%@page import="DAO.SignupDAO" %>
<%@page import="DAO.ProductDAO" %>
<%@page import="java.util.*" %>
<%@page import="common.DataBaseConnect" %>
<%@page import="beans.Signup" %>
<%@page import="java.sql.Connection" %>



<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>AdminRashanStore</title>
	
		<link rel="stylesheet" type="text/css" href="common/common.css">
		<%@include file="../common/cdn.jsp" %>
	</head>
<body>
					<%//System.out.println("This is RashanStore.jpg page"); %>

	  <!--  <header> -->
	<%@include file="common/header.jsp" %>
	  <!--  </header> -->


	<div class="container-fluid">
	 	<div class="row">
	 		<div class="col-sm-3 sidebar-col">
	 			<%@include file="common/sidebar.jsp" %>
	 		</div>
	 		<div class="col-sm-9 main-col">
	 				
	 			
	 			<!-- For Printing product add Success message on Screen -->
	 			
	 			
	 			
	 			
	 			
	 			<div class="col-sm-9 main-col">
					<h3 style="color:blue; margin:8px;"><center>Product Store List</center></h3>



					<table class="table table-bordered">
						<tr>
							<th>ToDo</th>
							<th>ToDo</th>
							<th>ID</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Cost</th>
							<th>Brand</th>
							<th>Available</th>
						</tr>
						<%
							List<Product_bean> li=new ProductDAO(DataBaseConnect.connect()).getAll();
							 			
							 		ListIterator<Product_bean> lit=li.listIterator();
							 		while(lit.hasNext()){
							 			Product_bean pb=(Product_bean) lit.next();
						%>
						<tr>
							<!-- Why we use here(../)because our Rashan.jsp is inside admin/Rashan.jsp and url work on home page so we have to come out side admin and work on home page -->
							<td><a href="../updateproductcontroller?id=<%=pb.getId()%>" class="btn btn-dark">Update</a></td>
							<td><a href="../productdelete?id=<%=pb.getId()%>"
								class="btn btn-dark">Delete</a></td>
							<td><%=pb.getId()%></td>
							<td><%=pb.getName()%></td>
							<td><%=pb.getQuantity()%></td>
							<td><%=pb.getCost()%></td>
							<td><%=pb.getBrand()%></td>
							<td><%=pb.getAvailable()%></td>
						</tr>

						<%
							}//while
						%>

					</table>
				</div>
	 			
	 			
	 			
	 		</div>		
	 			
	 	</div>
	</div>
	 
	

</body>
	
</html>