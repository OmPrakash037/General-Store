<%@page import="DAO.ProductDAO" %>
<%@page import="beans.Product_bean" %>
<!DOCTYPE html >
<html>
<head>

	<title>INDEX</title>
	<%@include file="common/cdn.jsp"%>
	<link rel="stylesheet" href="css/common.css" type="text/css">

</head>
<body>
	<%@include file="common/header.jsp"%>

	<%
		//System.out.println("This is Index.jsp ");
	%>


	<!---------------banner  Section-->


		<section class="banner-section">
				<div class="row">
					<div class="col-sm-12">
						 <!--  <img src="img/Products/a.jpg">-->
						
						<h1 style="color:yellow;">
								<marquee direction="right"behavior="alternate">OM PRAKASH MISHRA</marquee>
						</h1>
						
					</div>
				</div>
			</section>
		
	<!---------------Product  Section-->


	<div class="container-fluid" style="background-color: green;"></div>



	<div class="container-fluid" style="background-color: black;">



		<div class="recentproduct">
			<center>
				<h1>PRODUCT</h1>
			</center>
		</div>

		<section class="products">

			<div class="row">

<!--  
				<div class="col-sm-1">

					

				<div class="product_wrapper">
				  <img src="C:/eclipse/workSpace/GeneralStore/src/main/webapp/img/Products/MixPic.jpg" class="pimg">
				<a class="btn btn-success" href="rashan.jsp">click here</a>
				</div>

				</div>
-->				

				
				<div class="col-sm-5">
					<div class="product_wrapper">
						<img src="img/Products/MixPic.jpg" class="pimg"><br>
						<br> <a class="btn btn-success" href="rashan.jsp">click
							here</a>
					</div>
				</div>
				<div class="col-sm-2">

					<!-- For Middle Space -->
					
 				

				</div>
				<div class="col-sm-5">



					<div class="product_wrapper">
						<img src="img/Products/MixPicColdDrink.jpg" class="pimg"><br>
						<br> <a class="btn btn-success" href="rashan.jsp">click
							here</a>
					</div>



				</div>


			</div>
		</section>
	</div>
	



 
	<div id="about-id">
		<div class="container">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4" style="margin-top: 20px; margin-botton: 20px">

				</div>

			</div>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8" style="background-color: #408080;">
					<h1>
						<center>About</center>
					</h1>
					<h2>Phone &nbsp; 9661565075</h2>
					<h2>Email &nbsp; ompm0001@gmail.com</h2>
					<h1 style="color: black; margin-top: 30px;">It's no longer
						clothes or books or makeup items that people want to buy online.
						Even when it comes to buying the everyday groceries,peoples are
						increasingly turning online, amid the pandemic.</h1>



				</div>
			</div>
		</div>
	</div>




	<%@include file="common/footer.jsp"%>




</body>
</html>