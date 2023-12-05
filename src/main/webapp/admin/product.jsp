

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
		<title>AdminIndex</title>
	
		<link rel="stylesheet" type="text/css" href="common/common.css">
		<%@include file="../common/cdn.jsp" %>
	</head>
<body>
					<%//System.out.println("This is Products.jpg page"); %>
	<%@include file="common/header.jsp" %>
	<div class="container-fluid">
	  <!--  <header> -->
	  <!--  </header> -->
	 	<div class="row">
	 		<div class="col-sm-3 sidebar-col">
	 			<%@include file="common/sidebar.jsp" %>
	 		</div>
	 		<div class="col-sm-9 main-col">
	 			<h3>Create Products List</h3>
	 			
	 			<!-- For Printing product add Success message on Screen -->
	 			
	 			<div style="color: green; margin-left:45%; width:150px;">
					<%/*status is a key which is come from productInsertController.java page to print Either Success or Failed Message*/
						if(request.getParameter("status")!=null){
						 					out.println("    "+request.getParameter("status").toUpperCase());
						 				}
					%>

				</div>
	 			
	 			
	 			<form method="post" action="../product_insert_controller" enctype="multipart/form-data">
	 			
		 			<div class="row">
		 				<div class="col-sm-4">
		 					<label>ID</label>
		 					<input type="text" name="id"  class="form-control"  placeholder="product-Id">
		 				</div>
		 				<div class="col-sm-4">
		 					<label>Name</label>
		 					<input type="text" name="name"  class="form-control"  placeholder="product-Name">
		 				</div>
		 				<div class="col-sm-4">
		 					<label>Quantity</label>
		 					<input type="text" name="quantity"  class="form-control"  placeholder="Either in kg or lit">
		 				</div>
		 				
		 			</div>
		 			<div class="row">
		 				<div class="col-sm-4">
		 					<label>Cost</label>
		 					<input type="text" name="cost" class="form-control" placeholder="cost" >
		 				</div>
		 				<div class="col-sm-4">
		 					<label>Brand</label>
		 					<input type="text" name="brand" class="form-control" placeholder="Brand">
		 				</div> 
		 				<div class="col-sm-4">
		 					<label>Available</label>
		 					<input type="text" name="status" class="form-control" placeholder="avl,outOfStaock,fewLeft">
		 				</div> 
		 				
		 			</div>
		 			
		 			
		 			<div class="row">
		 			<div class="col-sm-6">
		 					<br>
								<input type="file" name="img" class="form-control">		 				
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
	 
	

</body>
	
</html>