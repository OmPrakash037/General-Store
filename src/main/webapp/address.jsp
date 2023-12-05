

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
		<title>Address</title>
	
		<link rel="stylesheet" type="text/css" href="css/common.css">
		<%@include file="../common/cdn.jsp" %>
	</head>
<body>
					<%//System.out.println("This is address.jsp page"); %>
	<%@include file="common/header.jsp" %>
	<div class="container-fluid">
	  <!--  <header> -->
	  <!--  </header> -->
	 	<div class="row">
	 		
	 		<div class="col-sm-12 main-col">
	 			<h3>Address</h3>
	 			
	 			<!-- For Printing product add Success message on Screen -->
	 			
	 			
	 			<form method="post" action="itemordercontroller">
	 			
		 			<div class="row">
			 			<div class="col-sm-2">
			 			</div>
		 				<div class="col-sm-8">
		 					<label>cusName</label>
		 					<input type="text" name="cusName"  class="form-control"  placeholder="Name">
		 				</div>
		 				
		 				
		 			</div>
		 			<div class="row">
		 				<div class="col-sm-2">
		 				</div>
		 				<div class="col-sm-8">
		 					<label>cusPhone</label>
		 					<input type="text" name="cusPhone" class="form-control" placeholder="Phone" >
		 				</div>
		 				
		 				
		 			</div>
		 			<div class="row">
		 			<div class="col-sm-2">
		 			</div>
		 				<div class="col-sm-8">
		 					<label>cusLocation</label>
		 					<input type="text" name="cusLocation" class="form-control" placeholder="Location" >
		 				</div>
		 				
		 				
		 			</div>
		 			<div class="row">
		 				<div class="col-sm-12">
		 				<h1 style="color:green;margin-top:5px;"><center> Cash On Delivery</center></h1>
		 				</div>
		 				
		 			</div>
		 			
		 			<div class="row">
		 			<div class="col-sm-3">
		 			</div>
		 			
		 				<div class="col-sm-3">
		 					<br>
		 					<button type="submit" style="margin-left:45%;margin-bottom:6px; width:150px;" class="btn btn-outline-success">Buy</button>
		 					
		 				
		 				</div>		 			
		 			</div>
	 			</form>
	 			
	 			
	 			
	 			
	 			
	 		</div>		
	 			
	 	</div>
	</div>
	 
	<%@include file="common/footer.jsp" %>
	

</body>
	
</html>