<%@page import="DAO.ProductDAO" %>
<%@page import="beans.Product_bean" %>

<!DOCTYPE html>
<html>
<head>
		<title>RashanShop</title>
		<%@include file="common/cdn.jsp" %>
	 	 <link rel="stylesheet" href="css/common.css"type="text/css">
</head>
<body>
			<%@include file="common/header.jsp" %>

					<% //System.out.println("This is rashan.jsp "); %>
					
		<div class="container-fluid" >
		<table class="table table-bordered">
			<thead>
				<tr>
					
					<th>ID</th>
					<th>Name</th>
					<th>Image</th>
					<th>Quantity</th>
					<th>Cost</th>
					<th>Brand</th>
					<th>Available</th>
					<th></th>
					
				</tr>
			</thead>
				<%
				
					List<Product_bean> li1=new ProductDAO(DataBaseConnect.connect()).getAll();
			 		ListIterator<Product_bean> lit=li1.listIterator();
			 		while(lit.hasNext()){
			 			Product_bean pb=(Product_bean) lit.next();
						
				%> 
				<tr>
					<td><%=pb.getId() %></td>
					<td><%=pb.getName() %></td>
					<td><img src="img/Products/<%=pb.getFileName() %>" height="50" width="50"></td>
					<td><%=pb.getQuantity() %></td>
					<td><%=pb.getCost() %></td>					
					<td><%=pb.getBrand() %></td>					
					<td><%=pb.getAvailable() %></td>					
					<td><button type="button" class="btn btn-primary" onclick="addToCart('<%= pb.getId()%>')">AddToCart</button></td>					
				</tr>
			
			<% 		
					}//while
			%>
			
		</table>		
	</div>

<%@include file="common/footer.jsp" %>


<script>
		<!-- This is AJAX  the working of AJAX is without refreshing the page go an another page and come with a data  -->
		function addToCart(id){
			
			$.post("addtocartcontroller",{
				id:id
			},function(data,status){
				alert(data);
				$(".stickyItemList").text(data+" Items");
			});
		}
	</script>
	<div class="stickyItemList" onclick="window.location.href='cart-Items.jsp'">
		<%if(session.getAttribute("addToCart")!=null){
			out.print(((List)session.getAttribute("addToCart")).size()+"Items");
		}
			%>	
		
	</div>
	
	
</body>
</html>