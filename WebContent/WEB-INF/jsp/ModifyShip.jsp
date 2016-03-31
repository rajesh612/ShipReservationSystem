<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<script src="../jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>


<title></title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h3 align="center">
		<font color="black"><B>MODIFY SHIP DETAILS </B></font>
	</h3>

	<div></div>
	<form:form method="POST" action="ModifyShip.htm" commandName="ship">


		<table align="center" width=70px height=60px cellpadding=10px>


			<tr>
				<td>ShipID</td>
				<td><form:select path="shipID">
						<option value="SELECT">--SELECT--</option>
						<c:forEach var="shipID" items="${map.Shiplist}">
							<form:option value="${shipID}">${shipID}</form:option>
						</c:forEach>
					</form:select></td>
				<td><font color="red"><form:errors path="shipID"
							cssclass="error" /></font></td>
			</tr>

			<tr>
				<td colspan="2"><center>
						<input type="submit" value="View" class="btn btn-primary">
					</center></td>
			</tr>
		</table>
	</form:form>
	<br>
	<br>
	<br>
	<c:if test="${not empty ship}">


		<form:form action="ModifyShip1.htm" commandName="ship" id="form1">

			<div>
				<table align="center" width=200px height=70px cellpadding=15px>
					<tr>
						<td>Ship ID</td>
						<td><form:input path="shipID" readonly="true"
								value="${map.Ship.shipID}" id="shipID" /></td>
						<td><font color="red"><form:errors path="shipID"
									cssclass="error" /></font></td>
					</tr>
					<tr>
						<td>Ship Name</td>

						<td><form:input path="shipName" value="${map.Ship.shipName}"
								required="true" id="shipName" /></td>

						<td><font color="red"><form:errors path="shipName"
									cssclass="error" /></font></td>
					</tr>
					<tr>
						<td>Seating Capacity</td>
						<td><form:input path="seatingCapacity"
								value="${map.Ship.seatingCapacity}" required="true"
								id="seatingCapacity" /></td>
						<td><font color="red"><form:errors
									path="seatingCapacity" cssclass="error" /></font></td>
					</tr>
					<tr>
						<td>Reservation Capacity</td>
						<td><form:input path="reservationCapacity"
								value="${map.Ship.reservationCapacity}" required="true"
								id="reservationCapacity" /></td>
						<td><font color="red"><form:errors path=""
									cssclass="error" /></font></td>
					</tr>

					<tr>
						<td colspan="2"><center>
								<input type="submit" value="Modify" class="btn btn-primary">
							</center></td>
					</tr>
				</table>
				<br> <br> <br> <br>

			</div>
		</form:form>
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

	</c:if>
</body>
</html>