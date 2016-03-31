<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div style="background-color: 909098;">
		<form id="pay1" action="p.htm" method="get">
			<table align="center">
				<tr>
					<td colspan="2"><h3 align="center">
							<B>FILL DETAILS</B>
						</h3></td>
				</tr>

				<tr>
					<td>Enter Card Number:</td>
					<td><input type="text" name="cardNo" class="form-control" /><br>
					</td>
					<td><span id="result"></span></td>
				</tr>

				<tr>
					<td>Expiry:</td>
					<td><input type="text" name="Expiry" class="form-control" /><br>
					</td>
					<td><span id="result"></span></td>
				</tr>

				<tr>
					<td>CVV No:</td>
					<td><input type="text" name="cvvNo" class="form-control" /><br>
					</td>
					<td><span id="result"></span></td>
				</tr>

				<tr>
					<td>Card Password:</td>
					<td><input type="password" name="3DPassword"
						class="form-control" /><br></td>
					<td><span id="result"></span></td>
				</tr>
				<tr>
					<td colspan="2"><center>
							<input type="submit" value="Submit" class="btn btn-primary">
						</center></td>

				</tr>

			</table>

		</form>
	</div>
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script
		src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
	<script
		src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
	<script>
		// just for the demos, avoids form submit
		$("#pay1").validate({
			rules : {
				cvvNo : "required",
				cardNo : {
					required : true,
					minlength : 3
				},
				expiry : {
					required : true,
					minlength : 1,
					maxlength : 2
				}

			}
		});
	</script>

</body>
</html>