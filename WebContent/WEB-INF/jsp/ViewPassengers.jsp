<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="com.wipro.srs.service.Administrator"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
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

	<h2>Passengers Details</h2>
	<table class="table" border="1" cellpadding="12" bordercolor="black">
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Ship Name</th>
				<th>Date of Travelling</th>
			</tr>
		</thead>

		<tbody>

			<tr class="success">
				<td>${passenger.name}</td>
				<td>${passenger.age}</td>
				<td>${passenger.gender}</td>
				<td>${ship.shipName}</td>
				<td>${schedule.startDate}</td>
			</tr>

		</tbody>


	</table>



</body>
</html>