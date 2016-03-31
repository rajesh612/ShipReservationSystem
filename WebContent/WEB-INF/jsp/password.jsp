<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="js/bootstrap.min.js"></script>
</head>

</head>
<body background="/portal_content/images/pwd-bg.jpg">
<center>
<form:form action="Change.htm" method="GET" id="loginForm" name="loginForm">
<label>old password:</label><input type="password"  name="password" id="password" ><br><br>
<label>new password:</label><input type="password" name="npassword" id="npassword"><br><br>
<label>confirm password:</label><input type="password" name="confirmpassword" id="confirmpassword"><br><br>
<input type="submit" value="submit" name="submit"  >
<span id='message'></span>
</form:form>
</center>
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
			$("#loginForm").validate({
				rules : {
					password : {
						required:true,
						minlength:3
						
					},
					npassword: {
						required:true,
						minlength:6,
						notEqualTo: "#password"
					},
					
					
					confirmpassword : {
						required:true,
						minlength:6,
						EqualTo: "#npassword"
						
					}
					
				}
			});
		</script>
</body>
</html>