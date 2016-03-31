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

<title>Insert title here</title>
</head>
<body>
	<h3>Ticket Details</h3>
	<table class="table">
		<thead>
			<tr>
				<th>Reservation ID</th>
				<th>Booking Date</th>
				<th>No of Seats</th>
				<th>Booking Status</th>
				<th>Journey Date</th>
				<th>Total Fare</th>
			</tr>
		</thead>


		<c:forEach items="${ViewTicket}" var="ticket">
			<tbody>
				<tr class="success">
					<td><a href="pdf.htm?reservationID=${ticket.reservationID}">${ticket.reservationID}</a></td>
					<td>${ticket.bookingDate}</td>
					<td>${ticket.noOfSeats}</td>
					<td>${ticket.bookingStatus}</td>
					<td>${ticket.journeyDate}</td>
					<td>${ticket.totalFare}</td>
				</tr>
			</tbody>
		</c:forEach>

	</table>
	<center>Cancel Ticket</center>
	<form action="c.htm" method="get">
		Enter Reservation ID:<input type="text" name="id" /> <input
			type="submit" value="Submit" class="btn btn-primary" />
	</form>


</body>
</html>