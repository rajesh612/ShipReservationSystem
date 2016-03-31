<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<script src="../jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta charset="utf-8"> -->
<title>Insert title here</title>

<script type="text/javascript">
function check()
{
   var retVal = confirm("Do you want to continue ?");
   if( retVal == true ){
      alert("User wants to continue!");
	  return true;
   }else{
      alert("User does not want to continue!");
	  return false;
   }
}
   </script>
</head>
<body>
	<h1 align="center">${MSG}</h1>
	<div>

		<form:form method="POST" action="DeleteShip.htm" commandName="ship">
			<div style="color: #0000FF">${msg}</div>

			<table align="center" width=75px height=65px cellpadding=7px
				cellspacing=5px>
				<tr>
					<td colspan="2"><h3 align="center" style="color: 070101">
							<B>DELETE SHIP DETAILS</B>
						</h3></td>
				</tr>
				<tr>
					<td>Select ships ID</td>
					<td><form:select path="shipID">
							<option value="SELECT">--SELECT--</option>
							<c:forEach var="shipID" items="${map.Shiplist}">
								<option value="${shipID}">${shipID}</option>
							</c:forEach>
						</form:select></td>
				<tr>

					<td colspan="2"><center>
							<input type="submit" value="View" class="btn btn-primary">
						</center></td>
				</tr>
			</table>
		</form:form>
	</div>
	<c:if test="${not empty ship}">
		<form:form action="DeleteShip1.htm" commandName="ship">
			<div>

				<table align="center" width=200px height=80px cellpadding=15px>
					<tr>
						<td>Ship ID</td>
						<td>${map.Ship.shipID}</td>
					<tr>
						<td>Ship Name</td>
						<td>${map.Ship.shipName}</td>
					</tr>
					<tr>
						<td>Reservation Capacity</td>
						<td>${map.Ship.reservationCapacity}</td>
					</tr>
					<tr>
						<td>Seating Capacity</td>
						<td>${map.Ship.seatingCapacity}</td>
					</tr>

					<tr>
						<td colspan="2"><center>
								<input type="submit" value="Delete" onclick="return check();"
									class="btn btn-primary">
							</center></td>
					</tr>
				</table>
			</div>
		</form:form>

	</c:if>


</body>
</html>