<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">${MSG}</h1>



	<!-- <div style="border: 1px solid; background-color: #B7B3B3;"> -->
	<div>
		<form:form method="POST" action="addShip.htm" commandName="ship"
			id="form1" name="loginForm">
			<div>${msg}</div>

			<table align="center" width=200px height=70px cellpadding=15px>
				<tr>
					<td colspan="2"><h3 align="center">
							<font color="FCF9F9"><b>ADD SHIP DETAILS</b></font>
						</h3></td>
				</tr>

				<tr>
					<td>Ship Name</td>
					<td><form:input path="shipName" required="true" /> <form:errors
							path="shipName"></form:errors></td>
					<td><font color="red"><form:errors path="shipName"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td>Seating Capacity</td>
					<td><form:input path="seatingCapacity" required="true"
							id="seatingCapacity" />
					<td><font color="red"><form:errors
								path="seatingCapacity" cssclass="error" /></font></td>

				</tr>
				<tr>
					<td>Reservation Capacity</td>
					<td><form:input path="reservationCapacity" required="true"
							id="reservationCapacity" /></td>
					<td><font color="red"><form:errors
								path="reservationCapacity" cssclass="error" /></font></td>

				</tr>
				<tr>
					<td colspan="2"><center>
							<input type="submit" value="Add" class="btn btn-primary">
						</center></td>
				</tr>
			</table>
		</form:form>
	</div>

	<script src="jquery-1.11.1.min.js"></script>
	<script src="jquery.validate.min.js"></script>
	<script src="additional-methods.min.js"></script>
	<script src="js/custom.js"></script>
	<script>
		$("#form1").validate({
			rules : {
				shipName : {
					required : true,
					lettersonly : true,
					minlength : 2,
					maxlength : 20

				},
				seatingCapacity : {
					required : true,
					number : true,
					min : 1,
					max : 50000
				},

				reservationCapacity : {
					required : true,
					number : true,
					min : 1,
					max : 50000
				}
			}
		});
	</script>
</body>
</html>