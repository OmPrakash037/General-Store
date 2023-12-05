<!DOCTYPE html >
<html>
<head>

<title>SignInForm</title>
<%@include file="common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css" type="text/css">
</head>
<body>
	<%@include file="common/header.jsp"%>

	<div class="container signup">
		<h1>Sign In Form</h1>
		<%
		if (request.getParameter("info") != null) {
			out.print("<h1>Login Failed.</h1>");
		}
		%>
		<form action="<%=request.getContextPath()%>/Signin" method="post">

			<div class="row">
				<div class="col-sm-6">
					<label>Email</label> <input class="form-control" type="text"
						name="email">
				</div>
				<div class="col-sm-6">
					<label>Password</label> <input class="form-control" type="password"
						name="password">
				</div>
			</div>
			<div class="row">

				<div class="col-sm-12">
					<br>
					<button type="submit" class="btn btn-success">Submit</button>
					<button margin:10px; class="btn btn-dark">
						<a href="signUp.jsp">Sign Up</a>
					</button>
				</div>
			</div>
		</form>
	</div>





	<%@include file="common/footer.jsp"%>
</body>
</html>