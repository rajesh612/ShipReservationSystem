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
<div>
<form:form method="POST" action="login.htm" commandName="credentials" id="form1">
						<div>${MSG_P}</div>
		
						<table align="center" width=500px height=320px cellpadding=500px>
							<tr>
								<td colspan="2"><h3>
										<center><font color="black"><b>SCHEDULE DETAILS</b></font></center>
									</h3></td>
							</tr>
							

							<tr>
								<td>ScheduleId</td>
								<td><form:input path="scheduleID" /></td>
								<td><font color="black"><form:errors path="scheduleID"
											cssclass="error" /></font></td>
											

							<tr>
								<td>RouteId</td>
								<td><form:input path="routeID" /></td>
								<td><font color="black"><form:errors path="routeID"
											cssclass="error" /></font></td>
											

							<tr>
								<td>ShipId</td>
								<td><form:input path="shipID" /></td>
								<td><font color="black"><form:errors path="shipID"
											cssclass="error" /></font></td>
							
							
								<tr>
								<td>StartDate</td>
								<td><form:input path="startDate"/></td>
								<td><font color="black"><form:errors path="startDate"
											cssclass="error" /></font></td>
											
						
							
						
						</table>
				</form:form>	
			</div>		

</body>
</html>