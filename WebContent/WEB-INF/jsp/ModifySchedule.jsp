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
<title>Modify Schedule</title>
</head>
<body>
	<div>
		<form:form method="POST" action="ModifySchedule.htm"
			commandName="schedule">
			<div align="center">
				<h2>${msg}</h2>
			</div>
			<br>
			<br>
			<br>
			<h3 align="center">
				<font color="070101"><B>MODIFY SCHEDULE DETAILS</B> </font>
			</h3>
			<table align="center" width=75px height=65px cellpadding=10px
				cellspacing=5px>

				<tr>
					<td>Schedule ID</td>

					<td><form:select path="scheduleID">
							<option value="SELECT">--SELECT--</option>
							<c:forEach var="scheduleID" items="${map.schedulelist}">
								<option value="${scheduleID}">${scheduleID}</option>
							</c:forEach>
						</form:select></td>
					<td><font color="red"><form:errors path="scheduleID"
								cssclass="error" /></font></td>
					<td><hr>
						<hr></td>
				</tr>
				<tr>
					<td colspan="2"><center>
							<input type="submit" value="View" class="btn btn-primary">
						</center></td>
				</tr>
			</table>
		</form:form>
	</div>
	<c:if test="${not empty schedule}">
		<br>
		<br>
		<br>
		<form:form action="ModifySchedule1.htm" commandName="schedule"
			id="reservation">
			<div>
				<table align="center" width=200px height=70px cellpadding=15px>


					<tr>
						<td>Schedule ID</td>
						<td><form:input path="scheduleID" readonly="true"
								value="${schedule.scheduleID}" id="scheduleID" /></td>
						<td><font color="red"><form:errors path="scheduleID"
									cssclass="error" /></font></td>
					</tr>


					<tr>
						<td>Ship ID</td>

						<td><form:select path="shipID">
								<option value="${map.schedule.shipID}">${map.schedule.shipID}</option>
								<c:forEach var="shipID" items="${shiplist.shipID}">
									<option value="${shipID}">${shipID}</option>
								</c:forEach>
							</form:select>
					</tr>
					<tr>
						<td>Route ID</td>

						<td><form:select path="routeID">
								<option value="${map.schedule.routeID}">${map.schedule.routeID}</option>
								<c:forEach var="routeID" items="${map.routelist}">
									<option value="${routeID}">${routeID}</option>
								</c:forEach>
							</form:select></td>
					</tr>


					<tr>
						<td>Start Date</td>

						<td><form:input path="startDate"
								value="${map.schedule.startDate}" required="true" /></td>
						<td><font color="red"><form:errors path="startDate"
									cssclass="error" /></font></td>
					</tr>

					<tr>
						<td colspan="2"><center>
								<input type="submit" value="Modify" class="btn btn-primary">
							</center></td>
					</tr>

				</table>
			</div>
		</form:form>
		<script src="jquery-1.11.1.min.js"></script>
		<script src="jquery.validate.min.js"></script>
		<script src="additional-methods.min.js"></script>
		<script src="js/custom.js"></script>
		<script>
			$("#reservation").validate({
				rules : {
					scheduleID : {
						required : true,
						minlength : 2

					}

				}
			});
		</script>
	</c:if>
	<br />
</body>
</html>