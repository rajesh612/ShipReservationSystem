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
<form:form method="POST" id="form1" action="ARoute.htm" commandName="route">
						<div >${MSG_P}</div>
		
						<table align="center" width=200px height=70px cellpadding=15px>
							<tr>
								<td colspan="2"><h3>
										<center><font color="black"><B>ADD ROUTE DETAILS</B></font></center>
									</h3></td>
							</tr>
							<tr>
								<td>Source</td>
								<td><form:input path="source" id="source" required="true" /></td>
								<td><font color="red"><form:errors path="source"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td>Destination</td>
								<td><form:input path="destination" id="destination" required="true"/></td>
								<td><font color="red"><form:errors path="destination"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td>Travel Duration</td>
								<td><form:input path="travelDuration" type="number"  required="true" id="travelDuration"/></td>
								<td><font color="red"><form:errors path="travelDuration"
											cssclass="error" /></font></td>
							</tr>
							<tr>
							<td>Fare($)</td>
								<td><form:input path="fare" type="number" required="true" id="fare"/></td>
								<td><font color="red"><form:errors path="fare"
											cssclass="error" /></font></td>
											
											</tr>
									<tr>
								<td colspan="2"><center>
										<input type="submit" value="Add" class="btn btn-primary">
									</center></td>
							</tr>				
											
											</table>
											</form:form>
											</div>
											 <script src="jquery-1.11.1.min.js"></script>
		<script
			src="jquery.validate.min.js"></script>
		<script
			src="additional-methods.min.js"></script>
			 <script src="js/custom.js"></script>
			 <script>jQuery.validator.addMethod("notEqualTo", function(value, element, param) {
				 return this.optional(element) || value != $(param).val();
			 }, "This has to be different...");
</script>
			 <script>
			$("#form1").validate({
				rules : {
					source : {
						required:true,
						lettersonly: true,
						minlength:3,
						maxlength:20
						
					},
					destination: {
						required:true,
						lettersonly: true,
						minlength:3,
						maxlength:20,
						notEqualTo: "#source"
					},
					
					
				travelDuration : {
						required:true,
						number: true,
						min:1,
						max:50000
					},
					fare : {
						required:true,
						number: true,
						min:1,
						max:50000
					}
				}
			});
		</script>
											
											
</body>


</html>