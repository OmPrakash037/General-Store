<%@page import="DAO.ProductDAO" %>
<%@page import="beans.Product_bean" %>
<%@page import="common.DataBaseConnect" %>

<!DOCTYPE html >
<html>
<head>
	
	<title> ADD TO CART </title>
	<%@include file="common/cdn.jsp" %>
	  <link rel="stylesheet" href="css/common.css"type="text/css">
	
</head>
<body>
<%@include file="common/header.jsp" %>

					<%//System.out.println("This is cart-Items.jsp "); %>
					
		<div class="container-fluid" >
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>ID</th>
					<th>Name</th>
					<th>Image</th>
					<th>Quantity</th>
					<th>Brand</th>
					<th>Available</th>
					<th>Cost</th>
					
				</tr>
			</thead>
			<%
			if(session.getAttribute("addToCart")!=null){
				ListIterator lit=((List)session.getAttribute("addToCart")).listIterator();
				ProductDAO pd=new ProductDAO(DataBaseConnect.connect());
				int a=0;
				float totalAmount=0;
				while(lit.hasNext()){
					a++;
	//Special Case care about this point
					int id=Integer.parseInt((String)lit.next());
					Product_bean pb=pd.getOne(id);
					totalAmount+=pb.getCost();
					
					
			%> 
				<tr>
					<td><%=a %></td>
					<td><%=pb.getId() %></td>
					<td><%=pb.getName() %></td>
					<td><img src="img/Products/<%=pb.getFileName() %>" height="50" width="50"></td>
					<td><%=pb.getQuantity() %></td>
					<td><%=pb.getBrand() %></td>
					<td><%=pb.getAvailable() %></td>
					<td><%=pb.getCost() %></td>					
				</tr>
			
			<% 		
					}//while
			%>
			<tr>
				
				<td colspan="7"><strong><center>totalAmount</center></strong></td>
				<td ><%=totalAmount %></td>
			
			</tr>
			<tr>
				<td style="text-align: center" colspan="8"><a href="itemordercontroller" class="btn btn-outline-success btn-lg">PlaceOrder</a></td>
			
			</tr>
			
			<%	
				}	
			%>
		</table>		
	</div>

<%@include file="common/footer.jsp" %>


	
	
</body>
</html>