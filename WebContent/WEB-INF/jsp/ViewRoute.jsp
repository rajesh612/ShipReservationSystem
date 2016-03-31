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
<h2>Route Details</h2>
<table class="table" border="1" cellpadding="12" bordercolor="black">
<thead>
<tr>
<th>Route ID</th>
<th>Destination</th>
<th>Travel Duration</th>
<th>Fare</th>
<th>Source</th>
</tr>
   </thead>

<c:forEach items="${ViewRoute}" var="route">
<tbody>
<tr class="success">
<td>${route.routeID}</td>
<td>${route.destination}</td>
<td>${route.travelDuration }</td>
<td>${route.fare}</td>
<td>${route.source}</td>
</tr>
</tbody>
</c:forEach>
</table>

</body>
</html>