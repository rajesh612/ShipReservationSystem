<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="jquery.js"></script>

<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="border: 1px solid; background-color: #B7B3B3;">
		<form:form method="POST" action="CustscheduleView.htm"
			commandName="schedule">
			<div style="color: #0000FF">${msg}</div>

			<table align="center" width=300px height=160px>
				<tr>
					<td colspan="2">
						<h3 align="center">View Schedule Details</h3>
					</td>
				</tr>

				<tr>
					<td>Source</td>

					<td><form:select path="source">
							<option value="SELECT">--SELECT--</option>
							<c:forEach var="details" items="${routedetails}">
								<option value="${details.source}">${details.source}</option>
							</c:forEach>
						</form:select></td>
					<td><font color="black"><form:errors path="source"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td>Destination</td>

					<td><form:select path="destination">
							<option value="SELECT">--SELECT--</option>
							<c:forEach var="details" items="${routedetails}">
								<option value="${details.destination}">${details.destination}</option>
							</c:forEach>
						</form:select></td>
					<td><font color="black"><form:errors path="destination"
								cssclass="error" /></font></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="View" class="btn btn-primary"></td>
				</tr>
			</table>
		</form:form>
	</div>

	<div>
		<c:if test="${not empty slist}">

			<c:forEach items="${slist}" var="slist">

				<table class="table table-striped" border="1px"
					bordercolor="solid-black" cellpadding="2px" cellspacing="2px">
					<tr>
						<th>Ship ID</th>
						<th>Route ID</th>
					</tr>
					<tr>
						<td>${slist.shipID}</td>
						<td>${slist.routeID}</td>

						<td><a
							href="CustScheduleBook.htm?shipID=${slist.shipID}&routeID=${slist.routeID}
				&scheduleID=${slist.scheduleID}"><b
								style="color: black">View Details</b></a></td>
					</tr>
				</table>
			</c:forEach>
		</c:if>

	</div>
</body>
</html>