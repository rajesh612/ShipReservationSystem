<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="tnav">
<div class="navbar navbar-fixed-top" style="background-color:#FA5858; height:70px;">
    <div class="navbar-inner-sm">
  <div class="container">
  
    
    
    <div class="navbar-header">
      <button class="navbar-toggle" type="button">
        <span class="sr-only">User Settings</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    
    <nav class="collapse navbar-collapse" role="navigation">
      <ul class="nav navbar-nav pull-right">
      
                <li>
          <a href="password.htm"  style=" color:black;"><b>CHANGE PASSWORD</b></a>
        </li>
        <li class="active">
          <a href="logout.htm" style=" color:black;"><b>SIGN OUT</b></a>
        </li>
        </ul>

        <ul class="nav navbar-nav pull-left">
	<li><img src="/portal_content/images/header.jpg" height="68px" width="103px" align="bottom" /></li>
	<h3 align="center"><span class="label label-danger">Welcome ${nameheader}</span></h3>
	</ul>
    </nav>
  </div>
    </div>
</div>
</div>
</body>
</html>