<%@page import="beans.OrderList" %>
<%@page import="DAO.SignupDAO" %>
<%@page import="DAO.OrderPage" %>
<%@page import="java.util.*" %>
<%@page import="common.DataBaseConnect" %>
<%@page import="beans.Signup" %>
<%@page import="java.sql.Connection" %>



<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>CustomerOrder</title>
	
		<link rel="stylesheet" type="text/css" href="common/common.css">
		<%@include file="../common/cdn.jsp" %>
	</head>
<body>
					<%//System.out.println("This is customerOrder.jpg page"); %>
	  <!--  <header> -->
	<%@include file="../common/header.jsp" %>
	  <!--  </header> -->
	
	<div class="container-fluid">
	 	<div class="row">
	 	
	 		<div class="col-sm-3 sidebar-col">
	 			<%@include file="common/sidebar.jsp" %>
	 		</div>
	 		
	 		<div class="col-sm-9 main-col">
	 			
	 			
	 			<!-- For Printing product add Success message on Screen -->
	 			
	 			<div style="color: green; margin-left:45%; width:150px;">
				

				</div>
	 			
	 			
	 			
	 			<div class="col-sm-12 main-col">
	 			
	 		
	 			
					<h3 style="color:blue; margin:8px;"><center>Customer Order</center></h3>  <br>

		  <!-- For Searching  Start -->
		  <div class="row">
	   <div class="col-sm-6">
			<fieldset>
			   <%
			   String CusPhone="";
			   if(request.getAttribute("lastProductNameText")!=null){
				   CusPhone =(String)request.getAttribute("lastProductNameText");
			   }
			   %>
			   
			   <form action="searchproducts">
					Search by CusPhone<input  class="form-control" type="text" name="name_search_text"  value="<%=CusPhone%>" placeholder="enter CusPhone" required="required"> 
			        <input type="submit" value="search product">
				
				 </form>
			  </fieldset>
		   </div>
		   </div>
		   <!-- For Searching  End -->
		   		  <br>
		   <div class="row">
		   		  <!-- for delete Message Print Start-->

								
								   <div   class="col-sm-3 " style="color: green; margin-left:45%; width:150px;">
										   <%if(request.getParameter("isDeleted")!=null){ %>
														  is Deleted? : <%=request.getParameter("isDeleted") %><br>
											<%} %>
								   </div>
					
		  <!-- for delete Message Print End-->
		   <div class="col-sm-6">	
		   	<form action="deletecusphone">
					   			
										delete By CusPhone<input  class="form-control" type="text" name="delete_By_CusPhone"   placeholder="enter CusPhone" required="required"> 
								        <input type="submit" value="search product">
									
					 </form>	
			</div> 		 
			</div>		
						  
		

		  
		  
		  
		
		  

					<table class="table table-bordered">
						<tr>
							<th>pId</th>
							<th>pName</th>
							<th>pQuantity</th>
							<th>pBrand</th>
							<th>Cost</th>
							<th>CusName</th>
							<th>CusPhone</th>
							<th>CusLocation</th>
							
						</tr>
						<%
					
							List<OrderList> list=(List<OrderList>)request.getAttribute("list");
							 		ListIterator<OrderList> lit=list.listIterator();
							 			
							 		while(lit.hasNext()){
							 			OrderList orderList=(OrderList) lit.next();
						%>
						<tr>
							<!-- Why we use here(../)because our Rashan.jsp is inside admin/Rashan.jsp and url work on home page so we have to come out side admin and work on home page -->
							
							<td><%=orderList.getpId()%></td>
							<td><%=orderList.getpName()%></td>
							<td><%=orderList.getpQuantity()%></td>
							<td><%=orderList.getpBrand()%></td>
							<td><%=orderList.getCost()%></td>
							<td><%=orderList.getCusName()%></td>
							<td><%=orderList.getCusPhone()%></td>
							<td><%=orderList.getCusLocation()%></td>
							
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