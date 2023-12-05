
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
					<%System.out.println("This is updateProductForm.jpg page"); %>
	<%@include file="common/header.jsp" %>
	<div class="container-fluid">
	  <!--  <header> -->
	  <!--  </header> -->
	 	<div class="row">
	 		<div class="col-sm-3 sidebar-col">
	 			<%@include file="common/sidebar.jsp" %>
	 		</div>
	 		<div class="col-sm-9 main-col">
	 			
	 			
	 			<!-- For Printing product add Success message on Screen -->
	 			
	 			
	 			
	 			
	 			
	 			<div class="col-sm-9 main-col">
	 		
	 		
	 		<%
  
					  Product_bean pb  = null;
					  if(request.getAttribute("pb")!=null){
					   pb = (Product_bean)request.getAttribute("pb");
					  }
			  %>
	 		
	 			<h3>Create Products List</h3>
	 			
	 			<!-- For Printing product add Success message on Screen -->
	 			
	 			
	 			
	 			
	 			<form method="post" action="updateproductcontroller">
	 			
		 			<div class="row">
		 				<div class="col-sm-4">
		 					<label>ID</label>
		 					<input value="<%=pb.getId() %>" name="id"  class="form-control" readonly="readonly" style="background-color:grey;">
		 				</div>
		 				<div class="col-sm-4">
		 					<label>Name</label>
		 					<input value="<%=pb.getName() %>" name="name"  class="form-control"  autofocus="autofocus" required="required">
		 				</div>
		 				<div class="col-sm-4">
		 					<label>Quantity</label>
		 					<input value="<%=pb.getQuantity()%>" name="quantity"  class="form-control"  autofocus="autofocus" required="required">
		 				</div>
		 				
		 			</div>
		 			<div class="row">
		 				<div class="col-sm-4">
		 					<label>Cost</label>
		 					<input value="<%=pb.getCost()%>" type="text" name="cost" class="form-control" autofocus="autofocus" required="required" >
		 				</div>
		 				<div class="col-sm-4">
		 					<label>Brand</label>
		 					<input value="<%=pb.getBrand()%>" type="text" name="brand" class="form-control" autofocus="autofocus" required="required">
		 				</div> 
		 				<div class="col-sm-4">
		 					<label>Available</label>
		 					<input value="<%=pb.getAvailable()%>" type="text" name="available" class="form-control" autofocus="autofocus" required="required">
		 				</div> 
		 				
		 			</div>
		 			
		 			
		 			<div class="row">
		 			<div class="col-sm-4">
		 						<label>Available</label>
		 					<input value="<%=pb.getFileName()%>" type="text" name="fileName" class="form-control" autofocus="autofocus" required="required">
		 				 				
		 				</div>
		 			<div class="col-sm-2">
		 						 				
		 				</div>
		 				<div class="col-sm-6">
		 					<br>
		 					<button type="submit" style="margin-left:45%; width:150px;" class="btn btn-success">Save</button>
		 					
		 				
		 				</div>		 			
		 			</div>
	 			</form>
	 			
	 			
	 			
	 			
	 			
	 		</div>
	 			
	 			
	 			
	 		</div>		
	 			
	 	</div>
	</div>
	 
	

</body>
	
</html>