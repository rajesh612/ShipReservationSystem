<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<h3>Schedule Details</h3>
<table class="table" border="1" cellpadding="12" bordercolor="black">
<thead>
<tr>
<th>Schedule ID</th>
<th>Route ID</th>
<th>Ship ID</th>
<th>Start Date</th>
</tr>
</thead>

<c:forEach items="${ViewSchedule}" var="schedule">
<tbody>
<tr>

<td>${schedule.scheduleID}</td>
<td>${schedule.routeID}</td>
<td>${schedule.shipID}</td>
<td>${schedule.startDate}</td>

</tr>
</tbody>

</c:forEach>
</table>

</body>
</html>