<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body background="/portal_content/images/adm-home.jpg">
	<div
		style="background-color: grey; height =100%; width: 150px; border: 1px solid black;">
		<div class="btn-group">
			<button type="button" class="btn btn-primary dropdown-toggle"
				style="margin-top: 85px; width: 120px;">
				Ship Details <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="addShip1.htm">Add new Ship Details</a></li>
				<li><a href="ViewShips.htm">View Ship Details</a></li>
				<li><a href="DeleteShip.htm">Delete Ship</a></li>
				<li><a href="ModifyShip.htm">Modify Ship</a></li>
			</ul>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-primary dropdown-toggle"
				style="width: 120px;">
				Schedule Details <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="AddSchedule.htm">Add Schedule</a></li>
				<li><a href="ViewSchedule.htm">View Schedule Details</a></li>
				<li><a href="ModifySchedule.htm">Modify Schedule Details</a></li>
				<li><a href="DeleteSchedule.htm">Delete Schedule Details</a></li>
			</ul>
		</div>
		<div>
			<br>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-primary dropdown-toggle"
				style="width: 120px;">
				Route Details <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="AddRoute.htm">Add Route</a></li>
				<li><a href="ViewRoute.htm">View Route Details</a></li>
				<li><a href="ModifyRoute.htm">Modify Route Details</a></li>
				<li><a href="DeleteRoute.htm">Delete Route</a></li>
			</ul>
		</div>

		<div class="btn-group">
			<button type="button" class="btn btn-primary dropdown-toggle"
				style="margin-bottom: 20px; width: 120px;">
				Passenger Details <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="passenger.htm">View passengers</a></li>

			</ul>
		</div>
	</div>
</body>
</html>