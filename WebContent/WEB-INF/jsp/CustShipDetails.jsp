<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"><b>SHIP DETAILS</b></h1>
<div>
<table class="table table-striped" cellpadding="10"  cellspacing ="5" align="center" >
<tr>
	<th>Ship Name</th>
    <th>Seating Capacity</th>
    <th> Source</th>
    <th>Destination</th>
    <th>Travel Duration</th>
    <th>Fare</th>
   <th>Reserve Tickets</th>
    
</tr>

    <tr>
    <td>${shipdetails.shipName}</td>
    <td>${shipdetails.seatingCapacity}</td>
     <td>${routedetails.source}</td>
        <td>${routedetails.destination}</td>
        <td>${routedetails.travelDuration}</td>
       <td>${routedetails.fare}</td>
       <td><b><a href="Reserve.htm?fare=${routedetails.fare}&seats=${shipdetails.seatingCapacity}&travelDuration=${routedetails.travelDuration}">Reserve</a></b></td>
        
    </tr>

</table>

</div>
</body>
</html>