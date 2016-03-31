<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div style="background-color: #00BFFF;">
		<form id="reservation" action="addreservation.htm" method="post"
			class="form-inline">
			<table align="center">
				<tr>
					<td colspan="2"><h3 align="center">
							<B>FILL DETAILS</B>
						</h3></td>
				</tr>
				<tr>
					<td>Enter name:</td>
					<td><spring:bind path="passenger.name">
							<input type="text" name="name" class="form-control" />
							<br>
						</spring:bind></td>
					<td><span id="result"></span></td>
				</tr>

				<tr>
					<td>Enter age:</td>
					<td><spring:bind path="passenger.age">
							<input type="text" name="age" class="form-control" />
							<br>
						</spring:bind></td>
					<td><span id="result"></span></td>
				</tr>

				<tr>
					<td>Gender:</td>
					<td><spring:bind path="passenger.gender">
							<input type="radio" name="gender" value="Male">Male
		<input type="radio" name="gender" value="Female">Female<br>
						</spring:bind></td>
					<td><span id="result"></span></td>
				</tr>
				<tr>
					<td colspan="2"><center>
							<input type="submit" value="Submit" class="btn btn-primary">
						</center></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>