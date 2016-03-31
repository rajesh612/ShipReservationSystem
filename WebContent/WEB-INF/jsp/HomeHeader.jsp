<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
    .black_overlay{
        display: none;
        position: absolute;
        top: 0%;
        left: 0%;
        width: 100%;
        height: 100%;
        background-color: black;
        z-index:1001;
        -moz-opacity: 0.8;
        opacity:.80;
        filter: alpha(opacity=80);
    }
    .white_content {
        display: none;
        position: absolute;
        top: 25%;
        left: 25%;
        width: 50%;
        height: 50%;
        padding: 16px;
        border: 16px solid orange;
        background-color: white;
        z-index:1002;
        overflow: auto;
    }
</style>
</head>
<body>
<div class="tnav">
<div class="navbar navbar-fixed-top" role="banner" style="background-color:#FF7519; height:30px;">
    <div class="navbar-inner-sm">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    </div>
    </div>
    
    <nav class="collapse navbar-collapse" role="navigation">
      <ul class="nav navbar-nav pull-right">
      
<body>
<div class="tnav">
<div class="navbar navbar-fixed-top" role="banner" style="background-color:#FF7519; height:30px;">
    <div class="navbar-inner-sm">
  <div class="container">
  
    
    
    <div class="navbar-header">
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    
    <nav class="collapse navbar-collapse" role="navigation">
      <ul class="nav navbar-nav pull-right">
     
        
                <li class="active">
          <a href="Aboutus.htm" style=" color:black;">About Us</a>
     
        </li>
        <li class="active">
          <a href="Contactus.htm" style=" color:black;">Contact Us</a>
        </li>
        </ul>
        <ul class="nav navbar-nav pull-left">
	<li><img src="/portal_content/images/logo.jpg" height="60px" width="80px" /></li>
	<li align="center"><h3><span class="label label-danger">Welcome To Ship Reservation System</span></h3>
	</ul>
    </nav>
  </div>
    </div>
</div>
</body>
          <a href=""  style=" color:black;"></a>
        </li>
        <li class="active">
          <a href="" style=" color:black;">Contact Us</a>
        </li>
        </ul>
    </nav>
  </div>
    </div>
</div>
</div>

<div id="light" class="white_content">This is the lightbox content. <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">Close</a></div>
    <div id="fade" class="black_overlay"></div>
</body>
</html>