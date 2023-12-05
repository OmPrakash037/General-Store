




<!DOCTYPE html >
<html>
<head>

<title>INDEX</title>
<%@include file="common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css" type="text/css">

</head>
<body>
	<%@include file="common/header.jsp"%>





	<!-- ***************************CONTAINER************************************** -->
	<div class="container-fluid">
		<center>

			<fieldset style="width: 30%">
				<legend>
					<b><i>Verify Email</i></i></b>
				</legend>

				<form action='emailvalidate' method="post">
					<table>
						<tr>
							<td>Email</td>
							<td><input name="user_email" type="email"
								required="required"></b><br></td>
						</tr>
						<tr>
						</tr>
						<tr>
							<td colspan="3" align="right"><input class="btn"
								type="submit" value="verify email"></td>
						</tr>
					</table>
				</form>
			</fieldset>

		</center>

	</div>
	<!-- ***************************************************************** -->

	<%@include file="common/footer.jsp"%>
</body>
</html>