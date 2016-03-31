<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<!-- <body>
<img src="images/front1.jpg" height="550px" width="600px" />
</body> -->
<body>
<!--  <img src="images/t4.jpg" class="img-responsive" alt="Responsive image" height="550px" width="650px">-->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="2000" data-wrap="true">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>
 
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="images/f1.jpg" alt="" height="550" width="600">
      <div class="carousel-caption">
          <h3></h3>
      </div>
    </div>
    <div class="item">
      <img src="images/f2.jpg" alt="" height="550" width="600">
      <div class="carousel-caption">
          <h3></h3>
      </div>
    </div>
    <div class="item">
      <img src="images/f4.jpg" alt="" height="550" width="600">
      <div class="carousel-caption">
          <h3></h3>
      </div>
    </div>
  </div>
 
  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div> <!-- Carousel -->
<p></p>
</body>
</html>