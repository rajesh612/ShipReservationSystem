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

<title>View Ship Details</title>
</head>
<body>
	<h2>Ship Details</h2>
	<table class="table" border="1" cellpadding="12" bordercolor="black">
		<thead>
			<tr>
				<th>Ship ID</th>
				<th>Ship Name</th>
				<th>Reservation Capacity</th>
				<th>Seating Capacity</th>
			</tr>
		</thead>

		<c:forEach items="${ViewShip}" var="ship">
			<tbody>
				<tr class="success">
					<td>${ship.shipID}</td>
					<td>${ship.shipName}</td>
					<td>${ship.reservationCapacity }</td>
					<td>${ship.seatingCapacity }</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>


</body>
</html>