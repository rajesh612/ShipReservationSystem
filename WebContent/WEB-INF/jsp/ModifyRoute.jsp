<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<script src="../jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>  

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Route</title>
</head>

<body>
<div>
					<form:form  method="POST" action="ModifyRoute.htm" commandName="route">
						<div style="color: #0000FF" align="center"><h2>${msg}</h2></div>
		
						<table align="center" width=70px height=65px cellpadding=10px cellspacing=7px>
							<tr>
								<td colspan="2" ><h3 style="color:#0000FF">
								<B>Modify Route</B>
									</h3></td>
							</tr>

							<tr>
								<td>Route ID</td>
								
								<td>
						<form:select path="routeID">
									<option value="SELECT">--SELECT--</option>
									<c:forEach var="routeID" items="${map.routelist}">
								    <option value="${routeID}">${routeID}</option>
									</c:forEach>
                    				</form:select>
                    </td>	
                    <td><font color="red"><form:errors path="routeID"
											cssclass="error" /></font></td></tr>
											
					<tr><td colspan="2"><center>
					<input type="submit" value="View" class="btn btn-primary"></center></td>
							</tr>
							</table>
                       </form:form>
                       </div>
                       <br>
                       <br>
                      
                        <c:if test="${not empty route}">
                    <form:form action="ModifyRoute1.htm" commandName="route" id="form1">	
						<div>
						<table align="center" width=200px height=70px cellpadding=15px>
							 <tr>
								<td>Route ID</td>
								<td><form:input path="routeID" readonly="true" value="${map.route.routeID}" id="routeID"/></td>
								<td><font color="red"><form:errors path="routeID"
											cssclass="error" /></font></td>
						</tr>
						<tr>
								<td>Source</td>
								<td><form:input path="source" value="${map.route.source}"  id="source" required="true"/></td>
								<td><font color="red"><form:errors path="source"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td>Destination</td>
								
								<td><form:input path="destination" value="${map.route.destination}" id="destination" required="true"/></td>
								<td><font color="red"><form:errors path="destination"
											cssclass="error" /></font></td>
							</tr>
							
							<tr>
								<td>Travel Duration</td>
								<td><form:input path="travelDuration" value="${map.route.travelDuration}" required="true" id="travelDuration"/></td>
								<td><font color="red"><form:errors path="travelDuration"
											cssclass="error" /></font></td>
							</tr>
							<tr>
								<td>Fare($)</td>
								<td><form:input path="fare" value="${map.route.fare}" required="true" id="fare"/></td>
								<td><font color="red"><form:errors path="fare"
											cssclass="error" /></font></td>
							</tr>
							
							<tr>
								<td colspan="2"><center>
										<input type="submit" value="Modify" class="btn btn-primary">
									</center></td>
							</tr>
						</table>
						<br>
						<br>
						<br>
						<br>
						
</div>
					</form:form>
	 <script src="jquery-1.11.1.min.js"></script>
		<script
			src="jquery.validate.min.js"></script>
		<script
			src="additional-methods.min.js"></script>
			 <script src="js/custom.js"></script>
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
						minlength:3,
						maxlength:20 
					},
					destination: {
						required:true,
						minlength:3,
						maxlength:20 ,
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
				</c:if>
				<br />
</body>
</html>