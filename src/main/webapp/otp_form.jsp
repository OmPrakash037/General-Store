
<!DOCTYPE html>
<html>
<head>

	<title>INDEX</title>
	<%@include file="common/cdn.jsp" %>
	<link rel="stylesheet"href="css/common.css"type="test/css">
	
</head>
<body>
	
	<%@include file="common/header.jsp" %>
	
	<%//System.out.println("This is otp_form.jsp"); %>
	
<div class="container-fluid">

	<!-- *********************End Header************************ -->
	<fieldset id="otpform"><legend><b><i>VERIFY EMAIL</i></b></legend>
	<%
		String userEmail="";
		if(session.getAttribute("userEmail")!=null){
			userEmail =(String)session.getAttribute("userEmail");
		}
		//System.out.println("Step2="+userEmail);
	%>
	<%
		if(request.getAttribute("otpError")!=null){%>
		<h1 style="color:red;"><%= request.getAttribute("otpError") %></h1>
		<%} %>
		
		<form action="emailvalidateotpcheck"method="post">
		
			<table>
				
				<tr>
				
					<td>Email</td>
					<td><input name="user_email"readonly="readonly"type="email"value="<%=userEmail %>"required="required"></td>
					
				</tr>
				<tr>
					<td>OTP</td>
					<td><input name="user_otp" value=""required="required"></td>
				</tr>
				<tr>
				
				<td colspan="3" align="right">
					<button class="btn btn-primary"type="submit">check OTP</button>
				</td>
				
				</tr>
				
			</table>
		</form>
		
	</fieldset>
	
</div>
	<%@include file="common/footer.jsp" %>
</body>
</html>