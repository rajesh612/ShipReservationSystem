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
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">${MSG}</h1>
	<div>
		<form:form method="POST" action="scheduleAdd.htm"
			commandName="schedule">
			<div>${msg}</div>

			<table align="center" width=200px height=70px cellpadding=15px>
				<tr>
					<td colspan="2"><h3 align="center">
							<font color="#87CEFA"><B>ADD SCHEDULE DETAILS</B></font>
						</h3></td>
				</tr>
				<tr>
					<td>Ship ID</td>
					<td><form:select path="shipID">
							<option value="SELECT">--SELECT--</option>
							<c:forEach var="shipID" items="${map.viewShip}">
								<option value="${shipID}">${shipID}</option>
							</c:forEach>
						</form:select></td>

				</tr>
				<tr>
					<td>Route ID</td>

					<td><form:select path="routeID">
							<option value="SELECT">--SELECT--</option>
							<c:forEach var="routeID" items="${map.viewRoute}">
								<option value="${routeID}">${routeID}</option>
							</c:forEach>
						</form:select></td>

				</tr>
				<tr>
					<td>Start Date</td>
					<td><form:input path="startDate" /></td>
					<td><font color="red"><form:errors path="startDate"
								cssclass="error" /></font></td>
				</tr>
				<tr>
					<td colspan="2"><center>
							<input type="submit" value="schedule" class="btn btn-primary">
						</center></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>