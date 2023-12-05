<!DOCTYPE html >
<html>
<head>

<title>SignUpForm</title>
<%@include file="common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css" type="text/css">
</head>
<body>
	<%@include file="common/header.jsp"%>

	<div class="container signup">
		<h1>Sign Up Form</h1>

		<%
		String userEmail = "";
		if (session.getAttribute("userEmail") != null) {
			userEmail = (String) session.getAttribute("userEmail");
		}
		//System.out.println("Step2=" + userEmail);
		%>


		<form action="<%=request.getContextPath()%>/Signup" method="post">
			<div class="row">
				<div class="col-sm-6">
					<label>Name</label> <input class="form-control" type="text"
						name="name">
				</div>
				<div class="col-sm-6">
					<label>Contact</label> <input class="form-control" type="text"
						name="contact">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<label>Email</label> <input class="form-control" type="email"
						name="email" readonly="readonly" value="<%=userEmail%>"
						required="required">
				</div>
				<div class="col-sm-6">
					<label>Password</label> <input class="form-control" type="password"
						name="password">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<label>Role</label> <input class="form-control" type="text"
						name="userrole">
				</div>
				<div class="col-sm-6">
					<br>
					<button type="submit" class="btn btn-success">Submit</button>
					<button margin:10px; class="btn btn-dark">
						<a href="signin.jsp">Sign In</a>
					</button>
				</div>
			</div>
		</form>
	</div>





	<%@include file="common/footer.jsp"%>
</body>
</html>