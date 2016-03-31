<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-gb">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="">
    <meta name="author" content="WebThemez">
 
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/isotope.css" media="screen" />
    <link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/da-slider.css" />
    <!-- Owl Carousel Assets -->
    <link href="js/owl-carousel/owl.carousel.css" rel="stylesheet">
    <link rel="stylesheet" href="css/styles.css" />
    <!-- Font Awesome -->
    <link href="font/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/ChangePassword.css">

		<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
	
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
  <script>
  $(function() {
    $( "#datepicker1" ).datepicker();
    $( "#datepicker2" ).datepicker();
  });
  </script>
  <script  type="text/javascript">
 
function validatePassword(fld) {
    var error = "";

    var illegalChars = /[\W_]/; // allow only letters and numbers
 
    if (fld.value == "") {
        fld.style.background = 'Yellow';
        document.getElementById('errorMsg').innerHTML = "You didn't enter a password.\n";
        return false;
 
    } else if ((fld.value.length < 7) || (fld.value.length > 15)) {
        fld.style.background = 'Yellow';
       // Document.write(error);
        document.getElementById('errorMsg').innerHTML = "The password is the wrong length. \n";
        return false;
 
    } else if (illegalChars.test(fld.value)) {
        fld.style.background = 'Yellow';
        document.getElementById('errorMsg').innerHTML = "The password contains illegal characters.\n";
        return false;
 
    } else if ( (fld.value.search(/[a-zA-Z]+/)==-1) || (fld.value.search(/[0-9]+/)==-1) ) {
        fld.style.background = 'Yellow';
        document.getElementById('errorMsg').innerHTML = "The password must contain at least one numeral.\n";
        return false;
 
    } else {
        fld.style.background = 'White';
        document.getElementById('errorMsg').innerHTML = " ";
    }
   return true;
}


</script>
</head>

<body>
    <header class="header">
        <div class="container">
            <nav class="navbar navbar-inverse" role="navigation">
                <div class="navbar-header">
                    <button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
               
               <!--/.navbar-header-->
                <!--change made for images-->
                <div align=center>
                <a href="#" class="navbar-brand scroll-top logo"><img src="/portal_content/images/logo.jpg" alt="banner" width="150" height="34"/></a>&nbsp;&nbsp;&nbsp;
                <a href="#home" class="navbar-brand scroll-top logo"><b>Home</b></a>&nbsp;&nbsp;&nbsp;
                <a href="#aboutUs" class="navbar-brand scroll-top logo"><b>About Us</b></a>&nbsp;&nbsp;&nbsp;
                <a href="#services" class="navbar-brand scroll-top logo"><b>Login</b></a>&nbsp;&nbsp;&nbsp;
                <a href="#portfolio" class="navbar-brand scroll-top logo"><b>Portfolio</b></a>&nbsp;&nbsp;&nbsp;
                <a href="#team" class="navbar-brand scroll-top logo"><b>Team</b></a>&nbsp;&nbsp;&nbsp;
                <a href="#contactUs" class="navbar-brand scroll-top logo"><b>Contact Us</b></a>&nbsp;&nbsp;&nbsp;
                </div>   
                </div>
            </nav>
        </div>
    </header>
    
    <div id="#top"></div>
    <section id="home">
        <div class="banner-container">
            <img src="/portal_content/images/banner-bg.jpg" alt="banner2" align="right" width="100%" height="240px" />
            <div class="container banner-content">
                <div id="da-slider" class="da-slider">
                    <div class="da-slide">
                        <h2>Maverick Ship services</h2>
                        <p>Welcomes you !</p>
                        <div class="da-img"></div>
                    </div>
                  
                    <nav class="da-arrows">
                        <span class="da-arrows-prev"></span>
                        <span class="da-arrows-next"></span>
                    </nav>
                </div>
            </div>
        </div>
    </section>
<h2>${MSG}</h2>
    <section id="aboutUs" class="page-section darkBg pDark pdingBtm30">
        <div class="container">
            <div class="heading text-center">
                <!-- Heading -->
                <h2>About Us</h2>
                <p>Best Ship services with best deals !!</p>
            </div>
            <div>
                <h3>Our Company</h3>
                <p>Maverick Ship Services is a private sector Ship company.</p>
            </div>
            <div class="row">
                <div class="col-md-4 col-sm-4">
                    <h3><i class="fa fa-desktop color"></i>&nbsp; What services do we offer?</h3>
                    <!-- Paragraph -->
                    <p>It's the Online platform to Check the voyage prices, Book Tickets,Choose Routes and many more!!! </p>
                </div>
                <div class="col-md-4 col-sm-4">
                    <!-- Heading -->
                    <h3><i class="fa fa-cloud color"></i>&nbsp;Why choose us?</h3>
                    <!-- Paragraph -->
                    <p>We Provide best Ship services at Low prices.</p>
                </div>
                <div class="col-md-4 col-sm-4">
                    <!-- Heading -->
                    <h3><i class="fa fa-home color"></i>&nbsp;What is our vision?</h3>
                    <!-- Paragraph -->
                    <p>Our vision is to expand our services to Europe and North America.</p>
                </div>
            </div>
        </div>
    </section>

    <section id="services" class="page-section">
        <div class="container">
            <div class="heading text-center">
                <!-- Heading -->
                <h2>LOGIN</h2>
                
            </div>
            <center>
         
            
            <form:form name="f1" method="POST" commandName="credentials" action="login.htm">
<B>USERNAME</B>:<input type="text" class="form-control"  name="userID" placeholder="Username" autofocus="" required >
		
<B>PASSWORD</B><input type="password" class="form-control"  name="password" placeholder="password" autofocus="" required >
		
		<input type="submit" value="submit" name="action"  class="btn btn-primary">
		</form:form>
			<br>
		
	<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Sign Up</button> 
		</center>
	
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Register Page</h4>
        </div>
        <div class="modal-body">

	<form:form name="tstest" commandName="credentials1" action="register.htm" method="POST">
<table>
<tr>
<td>FIRST NAME</td><td><input type="text"  name="firstName" required/><form:errors path="firstName"></form:errors></td></tr>
<tr><td>LAST NAME</td><td><input type="text"  name="lastName" required/><form:errors path="lastName" ></form:errors></td></tr>
<tr><td>DATE OF BIRTH</td><td><input type="text"  name="DateOfBirth" /><form:errors path="DateOfBirth" id="datepicker1"></form:errors></td></tr>
<tr><td>GENDER </td><td><input type="radio" name="gender" value="Male">Male
		<input type="radio" name="gender" value="Female">Female<br><form:errors path="gender"></form:errors></td></tr>
<tr><td>STREET</td><td><input type="text"  name="street" required/><form:errors path="street"></form:errors></td></tr>
<tr><td>LOCATION</td><td><input type="text"  name="location" required/><form:errors path="location"></form:errors></td></tr>
<tr><td>CITY</td><td><input type="text" name="city" required/><form:errors path="city"></form:errors></td></tr>
<tr><td>STATE</td><td><input type="text"  name="state" required/><form:errors path="state"></form:errors></td></tr>
<tr><td>PINCODE</td><td><input type="text"  name="pincode" required/><form:errors path="pincode"></form:errors></td></tr>
<tr><td>MOBILE NO</td><td><input type="text"  name="mobileNo" required/><form:errors path="mobileNo"></form:errors></td></tr>
<tr><td>EMAIL</td><td><input type="text"  name="emailID" required/><form:errors path="emailID"></form:errors></td></tr>
<tr><td>PASSWORD</td><td><input type="password"  name="Password" value="Password" onmouseout="validatePassword(Password)"/><form:errors path="Password"></form:errors></td></tr>
<div id="errorMsg"></div>
<tr><td><input type="submit"  name="action" value="SIGNUP"/></td></tr>
</table>
</form:form>
  </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>

</div>
      

        <div id="demo" class="clients">
            <div class="container">
                <div class="heading text-center">
                    <!-- Heading -->
                    <h2><br><br><br><br>Our Clients</h2>
                    <p></p>
                </div>

                <div class="row">
                    <div class="span12">

                        <div class="customNavigation">
                            <a class="prev"><i class="fa fa-chevron-circle-left"></i></a>
                            <a class="next"><i class="fa fa-chevron-circle-right"></i></a>
                        </div>
                        <div id="owl-demo" class="owl-carousel">
                            <div class="item">
                                <span class="helper">
                         <img src="/portal_content/images/clients/client-1.jpg" alt="client1" width="200" height="150"/></span>
                            </div>
                            <div class="item">
                                <span class="helper">
                                    <img src="/portal_content/images/clients/client-2.png" alt="client2" width="200" height="150"/></span>
                            </div>
                            <div class="item">
                                <span class="helper">
                                    <img src="/portal_content/images/clients/client-3.jpg" alt="client3" width="200" height="150"/></span>
                            </div>
                            <div class="item">
                                <span class="helper">
                                    <img src="/portal_content/images/clients/client-4.png" alt="client4" width="200" height="150"/></span>
                            </div>
                            <div class="item">
                                <span class="helper">
                                    <img src="/portal_content/images/clients/client-5.jpg" alt="client5" width="200" height="150"/></span>
                            </div>
                            <div class="item">
                                <span class="helper">
                                    <img src="/portal_content/images/clients/client-6.png" alt="client6" width="200" height="150"/></span>
                            </div>
                            <div class="item">
                                <span class="helper">
                                    <img src="/portal_content/images/clients/client-7.jpg" alt="client7" width="200" height="150"/></span>
                            </div>
                            <div class="item">
                                <span class="helper">
                                    <img src="/portal_content/images/clients/client-8.jpg" alt="client8" width="200" height="150"/></span>
                            </div>
                            <div class="item">
                                <span class="helper">
                                    <img src="/portal_content/images/clients/client-9.png" alt="client9" width="200" height="150"/></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section id="portfolio" class="page-section section appear clearfix">
        <div class="container">

            <div class="heading text-center">
                <!-- Heading -->
                <h2>Portfolio</h2>
                <p>Feel the sea, let your soul and spirit float..</p>
            </div>

            <div class="row">
                <nav id="filter" class="col-md-12 text-center">
                    <ul>
                        <li><a href="#" class="current btn-theme btn-small" data-filter="*">All</a></li>
                        <li><a href="#" class="btn-theme btn-small" data-filter=".webdesign">Web Design</a></li>
                        <li><a href="#" class="btn-theme btn-small" data-filter=".photography">Photography</a></li>
                        <li><a href="#" class="btn-theme btn-small" data-filter=".print">Print</a></li>
                    </ul>
                </nav>
                <div class="col-md-12">
                    <div class="row">
                        <div class="portfolio-items isotopeWrapper clearfix" id="3">

                            <article class="col-sm-4 isotopeItem webdesign">
                                <div class="portfolio-item">
                                    <img src="/portal_content/images/portfolio/img1.jpg" alt="portfolio" width="720" height="550" />
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="/portal_content/images/portfolio/img1.jpg" class="fancybox">
                                                Click to View Image
                                                <i class="fa fa-plus-circle fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem photography">
                                <div class="portfolio-item">
                                    <img src="/portal_content/images/portfolio/img2.png" alt="" width="720" height="550"/>
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="/portal_content/images/portfolio/img2.png" class="fancybox">
                                                Click to View Image
                                                <i class="fa fa-plus-circle fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>


                            <article class="col-sm-4 isotopeItem photography">
                                <div class="portfolio-item">
                                    <img src="/portal_content/images/portfolio/img3.jpg" alt="" width="720" height="550"/>
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="/portal_content/images/portfolio/img3.jpg" class="fancybox">
                                                Click to View Image
                                                <i class="fa fa-plus-circle fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem print">
                                <div class="portfolio-item">
                                    <img src="/portal_content/images/portfolio/img4.jpg" alt="" width="720" height="550"/>
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="/portal_content/images/portfolio/img4.jpg" class="fancybox">
                                                Click to View Image
                                                <i class="fa fa-plus-circle fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem photography">
                                <div class="portfolio-item">
                                    <img src="/portal_content/images/portfolio/img5.jpg" alt="" width="720" height="550"/>
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="/portal_content/images/portfolio/img5.jpg" class="fancybox">
                                                Click to View Image
                                                <i class="fa fa-plus-circle fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem webdesign">
                                <div class="portfolio-item">
                                    <img src="/portal_content/images/portfolio/img6.jpg" alt="" width="720" height="550"/>
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="/portal_content/images/portfolio/img6.jpg" class="fancybox">
                                                Click to View Image
                                                <i class="fa fa-plus-circle fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem print">
                                <div class="portfolio-item">
                                    <img src="/portal_content/images/portfolio/img7.jpg" alt="" width="720" height="550"/>
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="/portal_content/images/portfolio/img7.jpg" class="fancybox">
                                                Click to View Image
                                                <i class="fa fa-plus-circle fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem photography">
                                <div class="portfolio-item">
                                    <img src="/portal_content/images/portfolio/img8.jpg" alt="" width="720" height="550"/>
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="/portal_content/images/portfolio/img8.jpg" class="fancybox">
                                                Click to View Image
                                                <i class="fa fa-plus-circle fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem print">
                                <div class="portfolio-item">
                                    <img src="/portal_content/images/portfolio/img9.jpg" alt="" width="720" height="550"/>
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="/portal_content/images/portfolio/img9.jpg" class="fancybox">
                                               Click to View Image
                                                <i class="fa fa-plus-circle fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>
                        </div>

                    </div>


                </div>
            </div>

        </div>
    </section>

    <section id="team" class="page-section">
        <div class="container">
            <div class="heading text-center">
                <!-- Heading -->
                <h2>Our Team</h2>
            </div>
            <!-- Team Member's Details -->
            <div class="team-content">
                <div class="row">
                    <div class="col-md-3 col-sm-6 col-xs-6">
                        <!-- Team Member -->
                        <div class="team-member pDark">
                            <!-- Image Hover Block -->
                            <div class="member-img">
                                <!-- Image  -->
                                <img src="/portal_content/images/photo-1.jpg" alt="MY PIC" width="260" height="285">
                            </div>
                            <!-- Member Details -->
                            <h4>Rajesh Kumar</h4>
                            <!-- Designation -->
                            <span class="pos">CEO</span>
                            <div class="team-socials">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-6">
                        <!-- Team Member -->
                        <div class="team-member pDark">
                            <!-- Image Hover Block -->
                            <div class="member-img">
                                <!-- Image  -->
                                <img  src="/portal_content/images/photo-2.jpg" alt="" width="260" height="285">
                            </div>
                            <!-- Member Details -->
                            <h4>Akash</h4>
                            <!-- Designation -->
                            <span class="pos">Sales Manager</span>
                            <div class="team-socials">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-6">
                        <!-- Team Member -->
                        <div class="team-member pDark">
                            <!-- Image Hover Block -->
                            <div class="member-img">
                                <!-- Image  -->
                                <img src="/portal_content/images/photo-3.jpg" alt="" width="260" height="285">
                            </div>
                            <!-- Member Details -->
                            <h4>Raj</h4>
                            <!-- Designation -->
                            <span class="pos">Executive Manager</span>
                            <div class="team-socials">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-6">
                        <!-- Team Member -->
                        <div class="team-member pDark">
                            <!-- Image Hover Block -->
                            <div class="member-img">
                                <!-- Image  -->
                                <img src="/portal_content/images/photo-4.jpg" alt="" width="260" height="285">
                            </div>
                            <!-- Member Details -->
                            <h4>Krishna</h4>
                            <!-- Designation -->
                            <span class="pos">Web Designer</span>
                            <div class="team-socials">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section id="contactUs" class="page-section">
        <div class="container">

            <div class="row">
                <div class="heading text-center">
                    <!-- Heading -->
                    <h2>Contact Us</h2>
              
                </div>
            </div>

            <div class="row mrgn30">

                <form action="contactus.htm" id="contactfrm">

                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" name="name" id="name" placeholder="Enter name" title="Please enter your name (at least 2 characters)">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" id="email" placeholder="Enter email" title="Please enter a valid email address">
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="comments">Comments</label>
                            <textarea name="comment" class="form-control" id="comments" cols="3" rows="5" placeholder="Enter your message" title="Please enter your message (at least 10 characters)"></textarea>
                        </div>
                        <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">Submit</button>
                        <div class="result"></div>
                    </div>
                </form>
                <div class="col-sm-4">
                    <h4>Address:</h4>
                    <address>
                        Software Innovaters Company<br>
                        Universal Avenue, 91972<br>
                        San Diego, CA 91942 USA
                        <br>
                    </address>
                    <h4>Phone:</h4>
                    <address>
                        119-123-4567<br>
                    </address>
                </div>
            </div>
        </div>
        <!--/.container-->
    </section>
    <section class="maps">
        <iframe src="http://maps.google.com/maps?f=q&t=m&z=10&ll=32.9078683,-116.4209253&output=embed" width="100%" height="250" frameborder="0"></iframe>
    </section>
    <footer>
        <div class="container">
            <div class="social text-center">
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-dribbble"></i></a>
                <a href="#"><i class="fa fa-flickr"></i></a>
                <a href="#"><i class="fa fa-github"></i></a>
            </div>

            <div class="clear"></div>
            <!--CLEAR FLOATS-->
        </div>
    </footer>
    <!--/.page-section-->
    <section class="copyright">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center">
                    Copyright 2015 | All Rights Reserved <a href="http://www.linkedin.com/pub/rajesh-bommakuri/23/8aa/573" target="_blank"> Rajesh Kumar</a>
                </div>
            </div>
            <!-- / .row -->
        </div>
    </section>
    <a href="#top" class="topHome"><i class="fa fa-chevron-up fa-2x"></i></a>

    <script src="js/modernizr-latest.js"></script>
    <script src="js/jquery-1.8.2.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/jquery.isotope.min.js" type="text/javascript"></script>
    <script src="js/fancybox/jquery.fancybox.pack.js" type="text/javascript"></script>
    <script src="js/jquery.nav.js" type="text/javascript"></script>
    <script src="js/jquery.cslider.js" type="text/javascript"></script>
    <script src="js/custom.js" type="text/javascript"></script>
    <script src="js/owl-carousel/owl.carousel.js"></script>
</body>
</html>
