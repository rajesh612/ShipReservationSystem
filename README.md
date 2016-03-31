# ShipReservationSystem
SRS is a Spring MVC based application, which is used to Reserve Tickets,Cancel Tickets and Make Payment by the passengers. This
application is developed using Spring 3.0.2, Hibernate3, JavaScript, CSS and JSP.
## How to use SRS
In SRS there are two Actors. One is Administrator and other is Customer. Administrator has many Activities like CRUD
(create,read,update and Delete) operations on Ship details, Schedule Details, Route Details and View Passenger Details. 
Customer has activities like View Schedule by Route, Reserve Tickets,Make Payment,Print Ticket, View Ticket and Cancel 
Ticket. New User should Register by providing his/her details. By default, the user type will be Customer. If a user 
want the role of Administrator than DBA should update 'user type' field in User Credentials DB table from customer to 
admin. Once, Registration is succesful than a unique User Id will be generated. User can login using his user Id and 
Password. User can Change his password and can also logout from his account.
##Required Tools and Softwares
###### Apache TomCat v8.0 Server
##### Oracle 11g Data Base
##### Eclipse IDE 
##### jdk 1.8
##Required Library files
######apache-commons jar
######spring-3.0.2.RELEASE jars
######tiles-2.2.2 jars
######commons-dbcp-1.4 jar
######catalina jars
######jstl jar
######jsp-api jar
######jta jar
######jdbc jar
######hibernate3 jars
######servlet-api jar
######validation-api-1.1.0.Final jar
## Required DB Tables and Sequences

      CREATE SEQUENCE SRS_SEQ_USER_ID
      MINVALUE 1000
      START WITH 1001
      INCREMENT BY 1
      CACHE 10;
      
      CREATE SEQUENCE SRS_SEQ_SHIP_ID
      MINVALUE 1000
      START WITH 1001
      INCREMENT BY 1
      CACHE 10;
      
      CREATE SEQUENCE SRS_SEQ_SCHEDULE_ID
      MINVALUE 1000
      START WITH 1001
      INCREMENT BY 1
      CACHE 10;
      
      CREATE SEQUENCE SRS_SEQ_RESERVATION_ID
      MINVALUE 1000
      START WITH 1001
      INCREMENT BY 1
      CACHE 10;
      
      create table SRS_TBL_USER_PROFILE1 
      (
      userID VARCHAR(12) PRIMARY KEY,
      firstName VARCHAR2(20) not null,
      lastName VARCHAR2(20) not null,
      DateOfBirth date not null,
      gender VARCHAR(7) not null,
      street VARCHAR2(30) not null, 
      location VARCHAR2(20) not null,
      city VARCHAR2(20) not null,
      state VARCHAR2(20) not null,
      pincode VARCHAR2(20) not null,
      mobileNo number(10) not null,
      emailID VARCHAR2(40) not null
      );
      
      create table SRS_TBL_USER_CREDENTIALS1
      (
      userID VARCHAR2(12),
      Password VARCHAR2(20) not null,
      Usertype VARCHAR2(15) not null,
      Loginstatus NUMBER(10) not null,
      FOREIGN KEY (userID) REFERENCES SRS_TBL_USER_PROFILE1(userID)
      );
      
      create table SRS_TBL_SHIP
      (
      shipID  VARCHAR2(255) PRIMARY KEY,
      ShipName VARCHAR2(30),
      SeatingCapacity NUMBER(10),
      ReservationCapacity NUMBER(10)
      );
      
      create table SRS_TBL_ROUTE
      (
      routeID VARCHAR2(255)  PRIMARY KEY,
      source VARCHAR2(30) NOT NULL,
      destination VARCHAR2(30) NOT NULL,
      travelDuration  VARCHAR2(20) NOT NULL,
      Fare FLOAT(126) NOT NULL
      );
      
      create table SRS_TBL_SCHEDULE1
      (
      scheduleID VARCHAR2(255) PRIMARY KEY,
      shipID VARCHAR2(30) NOT NULL,
      routeID VARCHAR2(30) NOT NULL,
      StartDate DATE,
      FOREIGN KEY (shipID) REFERENCES SRS_TBL_SHIP(shipID),
      FOREIGN KEY (routeID) REFERENCES SRS_TBL_ROUTE(routeID)
      );
      
      create table SRS_TBL_USER_RESERVATION
      (
      reservationID VARCHAR2(8) PRIMARY KEY,
      ScheduleID VARCHAR2(8) NOT NULL ,
      userID VARCHAR2(6) NOT NULL,
      Bookingdate DATE NOT NULL,
      Journeydate DATE NOT NULL,
      Noofseats NUMBER(10) NOT NULL,
      Totalfare FLOAT(126),
      Bookingstatus VARCHAR2(20),
      FOREIGN KEY (ScheduleID) REFERENCES SRS_TBL_USER_SCHEDULE1(ScheduleID),
      FOREIGN KEY (userID) REFERENCES SRS_TBL_USER_PROFILE1(userID)
      );
     
      create table SRS_TBL_USER_PASSENGER
      (
      reservationID VARCHAR2(8) PRIMARY KEY,
      scheduleID  VARCHAR2(8),
      Name VARCHAR2(20) NOT NULL,
      Age NUMBER(10) NOT NULL,
      Gender VARCHAR2(6) NOT NULL
      FOREIGN KEY (reservationID) REFERENCES SRS_TBL_USER_RESERVATION(reservationID)
      FOREIGN KEY (scheduleID) REFERENCES SRS_TBL_USER_SCHEDULE1(scheduleID)
      );
##Java Beans(POJO Classes) as Model
##### Following POJO classes are used as Java Beans
###### ProfileBean is used for  User Registration.
###### CredentialsBean is used for User Login.
###### ShipBean is Used to Add, Modify and Delete Ship Details.
###### RouteBean is Used to Add, Modify and Delete Route Details.
###### ScheduleBean is Used to Used to Add, Modify and Delete Schedule Details.
###### ReservationBean is used to Reserve Ticket and Cancel Ticket.
###### PassengerBean is Used to Book Ticket and Make Payment.
##DAO(Data Access Object) Classes (@Repository) 
###### DAO Classes use Session Factory Object's save(),update() and delete() methods to perform CRUD operations on Model Objects.
### DAO Classes Used
###### ProfileImpl class implements ProfileDAO interface to Create User Profile and to Find User by UserId.
###### CredentialsDAOImpl class implements CredentialsDAO interface to Create User Credentials.
###### ShipDAOImpl class implements ShipDAO interface to save,update,delete and find ship bean object.
###### RouteImpl class implements RouteDAO interface to use session factory object's save(),update(),delete() and get() methods to add,modify,delete and search Route details.
###### ScheduleImpl class implements ScheduleDAO interface to use session factory object's save(),update(),delete(),get() and getSQLQuery() methods on Route Bean Object.
###### ReservationImpl class implements ReservationDAO interface to save,delete and find ReservationBean objects using UserId and ResrvationId.
###### PassengerDAOImpl class implements PassengerDAO interface to use save() and createSQLQuery() methods of sessionFactory object.
#### Example Of DAO class
#### ScheduleImpl DAO Class

    package com.wipro.srs.dao;
    
    import java.math.BigDecimal;
    import java.util.List;
    
    import org.apache.log4j.Logger;
    import org.hibernate.HibernateException;
    import org.hibernate.Query;
    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Repository;
    import org.springframework.transaction.annotation.Transactional;
    
     import com.wipro.srs.bean.RouteBean;
    import com.wipro.srs.bean.ScheduleBean;
    import com.wipro.srs.service.MethodLogger;
    
    @Repository
    public class ScheduleImpl implements ScheduleDAO {
    	public static final Logger log = Logger.getLogger(MethodLogger.class);
    @Autowired
	    private SessionFactory sessionFactory;
     	@Override
    	public String createSchedule(ScheduleBean schedule) {
		String result = "Failure";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From ScheduleBean where shipID=? and routeID=?");
		query.setParameter(0, schedule.getShipID());
		query.setParameter(1, schedule.getRouteID());
		List<ScheduleBean> list = query.list();
		if (list.isEmpty()) {
			session.save(schedule);
			result = "Success";
		} else {
			result = "Schedule already exists";
		}
		return result;
    	}
    	@Override
    	public int deleteSchedule(List<String> scheduleID) {
		int result = 0;
		ScheduleBean schedule = new ScheduleBean();
		ScheduleBean schedule1 = new ScheduleBean();
		try {
			String id = scheduleID.get(0);
			System.out.println("uid========="+id);
			schedule.setScheduleID(id);
			schedule1=findByID(id);
			Session session = sessionFactory.getCurrentSession();
			session.delete(schedule1);
			result = 1;
		} catch (HibernateException e) {
			result = 0;
			log.error(e);
		}
		finally{
		return result;}
	    }
	    @Override
	    public boolean updateSchedule(ScheduleBean schedule) {
		boolean result = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			schedule.setShipID(schedule.getShipID());
			schedule.setRouteID(schedule.getRouteID());
			session.update(schedule);
			result = true;
		} catch (HibernateException e) {
			result = false;
			log.error(e);
		}
		finally{
		return result;}
	  }
  	@Override
	  @Transactional
	  public BigDecimal findByID () {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select SRS_SEQ_SCHEDULE_ID.nextval from dual";
		Query query = session.createSQLQuery(sql);
		BigDecimal schedule = (BigDecimal) query.uniqueResult();
		return schedule;
    	}
	  @Override
	  public List<ScheduleBean> findAll() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "From ScheduleBean";
		Query query = session.createQuery(sql);
		List<ScheduleBean> details = query.list();
		return details;
	  }
	  @Override
	  public ScheduleBean findByID(String ID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ScheduleBean route = null;
		if (ID instanceof String) {
			route = (ScheduleBean) session.get(ScheduleBean.class, ID);
		}
		return route;
	  }
	  @Override
	  public List<String> findAllIds () {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT scheduleID FROM ScheduleBean";
		Query query = session.createQuery(sql);
		List<String> details = query.list();
		return details;
	  }
	  @Override
	  public ScheduleBean findScheduleId (final String scheduleID) {
		ScheduleBean schedules = null;
		if (scheduleID instanceof String) {
			Session session = sessionFactory.getCurrentSession();
			String sql = "From ScheduleBean where scheduleID=:fid";
			Query query = session.createQuery(sql);
			query.setParameter("fid", scheduleID);
			schedules = (ScheduleBean) query.uniqueResult();
		}
		return schedules;
	  }
	  @Override
	  public List<ScheduleBean> viewRoute (final String routeID) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "From ScheduleBean where routeID=:rid";
		Query query = session.createQuery(sql);
		query.setParameter("rid", routeID);
		List<ScheduleBean> routes = query.list();
		System.out.println("in sheduleimpl"+routeID);
		return routes;
	  }
	  @Override
	  public String findRouteId (final String scheduleID) {
		String routeid = null;
		if (scheduleID instanceof String) {
			Session session = sessionFactory.getCurrentSession();
			String sql = "Select routeID from ScheduleBean where scheduleID=:fid";
			Query query = session.createQuery(sql);
			query.setParameter("fid", scheduleID);
			routeid = (String) query.uniqueResult();
		}
		return routeid;
	  }
  }
    
## Service Classes (@Service)
##### Service Classes use DAO interface object methods to implement Service Interface methods.
## Service Classes Used
###### AdministratorImpl Class implements Administrator Interface to add,modify,search and delete Ship Details, Schedule Details and Route Details.
###### CustomerImpl class implements Customer interface to View Schedule, Reserve Ticket and Cancel Ticket.
### Example of Service Class
#### CustomerImpl Service Class
    package com.wipro.srs.service;
    import java.math.BigDecimal;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;
    import java.util.Map;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Repository;
    import org.springframework.transaction.annotation.Propagation;
    import org.springframework.transaction.annotation.Transactional;
    
    import com.wipro.srs.bean.CredentialsBean;
    import com.wipro.srs.bean.PassengerBean;
    import com.wipro.srs.bean.ReservationBean;
    import com.wipro.srs.bean.RouteBean;
    import com.wipro.srs.bean.ScheduleBean;
    import com.wipro.srs.bean.ShipBean;
    import com.wipro.srs.dao.PassengerDAO;
    import com.wipro.srs.dao.ReservationDAO;
    import com.wipro.srs.dao.RouteDAO;
    import com.wipro.srs.dao.ScheduleDAO;
    import com.wipro.srs.dao.ShipDAO;
  
    @Repository
    public class CustomerImpl implements Customer 	
	{
  
			@Autowired
			private RouteDAO routeDAO;
			@Autowired
			private ScheduleDAO scheduleDAO;
			@Autowired
			private ReservationDAO resDAO;
			@Autowired
			private PassengerDAO passDAO;
			@Autowired
			private ShipDAO shipDAO;
	  
			@Override
			@Transactional
			public List<ScheduleBean> viewScheduleByRoute(String source,
			String destination) {
			String rid = routeDAO.viewRouteDetails(source, destination);
			if (!rid.equalsIgnoreCase("Failure")) {
			List<ScheduleBean> list = new ArrayList<ScheduleBean>();
			list = scheduleDAO.viewRoute(rid);
			if (list != null) 
				{
				return list;
				}
				}
			return null;
			}
  
			@Override
			@Transactional
			public String reserveTicket(ReservationBean reservation,
			List<PassengerBean> passengers) {
			String result = "Failure";
			if (reservation != null && passengers != null) {
			
			BigDecimal sequence = resDAO.findByID();
			PassengerBean passenger = passengers.get(0);
			
			String routeid = scheduleDAO.findRouteId(reservation.getScheduleID());
			RouteBean route = new RouteBean();
			route = routeDAO.findRouteId(routeid);
			String dist = route.getTravelDuration();
			System.out.println("duration is"+dist);
			String src = route.getSource().substring(0, 2).toUpperCase();
			String dest = route.getDestination().substring(0, 2).toUpperCase();
			String routeId = routeDAO.viewRouteDetails(route.getSource(), route.getDestination());
			
			String reservationID = src + dest + sequence;
			reservation.setReservationID(reservationID);
			String scheduleID = reservation.getScheduleID();
			String userID = reservation.getUserID();
			ScheduleBean schedule = scheduleDAO.findScheduleId(scheduleID);
			Date date = new Date();
			reservation.setBookingDate(date);
			String bookingStatus = "booked";
			reservation.setBookingStatus(bookingStatus);
			reservation.setJourneyDate(date);
			int noOfSeats = reservation.getNoOfSeats();
			reservation.setScheduleID(scheduleID);
			
			double fare = reservation.getTotalFare();
			double totalFare = noOfSeats * fare;
			reservation.setTotalFare(totalFare);
			reservation.setUserID(userID);
			passenger.setReservationID(reservationID);
			result = resDAO.createReservation(reservation);
			if (result.equalsIgnoreCase("Success")) {
				passenger.setName(passenger.getName());
				passenger.setAge(passenger.getAge());
				passenger.setGender(passenger.getGender());
				reservation.setNoOfSeats(noOfSeats);
				passenger.setReservationID(reservationID);
				passDAO.createPassenger(passenger);
				resDAO.createReservation(reservation);
			  }
		  }
			return result;
		}

			@Override
			@Transactional
			public List<RouteBean> viewByRoutes () {
			List<RouteBean> rlist = new ArrayList<RouteBean>();
			rlist = routeDAO.findAll();
			return rlist;
			}
	  
			@Override
			@Transactional
			public RouteBean getRouteDetails (final String routeID) {
			return routeDAO.findRouteId(routeID);
    	}
			@Override
			@Transactional
			public ShipBean getShipDetails (final String shipID) {
			return shipDAO.findShipId(shipID);
		}
	
			@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
			@Override
			public List<ReservationBean> viewByReservations(String userid) {
			List<ReservationBean> list = resDAO.findAll(userid);
			return list;
  	}
	  
			@Override
			@Transactional
			public ReservationBean getTicketDetails(final String reservationID)
		{
		
		
			return resDAO.findByResID(reservationID);
		}
  
				@Override
				@Transactional
				public String cancelTicket(final String reservationID)
			{
				String result="failure";
		
				ReservationBean rb=resDAO.findByResID(reservationID);
				result=resDAO.deleteReservation(rb);
		 
				return result;
			}
	}

## Controller Classes (@Controller)
##### Controller Classes use @Request Mapping Annotation to Redirect from a JSP view. Controller Classes use service methods and return Collection objects( like maps) and JSPs.
##Controller Classes Used
###### AdminController Class use Administrator(Service) Interface methods to Add, modify,search and delete Ship Details, Schedule Details and Route Details. 
###### CustomerController Class use Customer(Service) Interface methods to Reserve Ticket, Make Payment, View Schedule Details and Cancel Ticket.
###### Controller Class use User(util) Interface methods for User Registration, Login, Change Password and Log out Activities.
### Example of Controller Class
#### controller.java Class

      package com.wipro.srs.controller;
  
      import java.util.HashMap;
      import java.util.Map;

      import javax.servlet.http.HttpSession;
      import javax.validation.Valid;

      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.stereotype.Controller;
      import org.springframework.ui.Model;
      import org.springframework.validation.BindingResult;
      import org.springframework.web.bind.annotation.ModelAttribute;
      import org.springframework.web.bind.annotation.RequestMapping;
      import org.springframework.web.bind.annotation.RequestMethod;
      import org.springframework.web.servlet.ModelAndView;

      import com.wipro.srs.bean.CredentialsBean;
      import com.wipro.srs.bean.ProfileBean;
      import com.wipro.srs.util.User;

      @Controller
      public class controller {

	      @Autowired
	      private User user;
      	@RequestMapping(value = "index.htm", method = RequestMethod.GET)
      	public String viewfront(final Model model) {
	  	model.addAttribute("credentials", new CredentialsBean());
    	model.addAttribute("credentials1", new ProfileBean());

	  	return "index";
	    }

	    /**
	     * This method is used for login functionality.
	    * 
	    * @param credentials
	    *            is used as the command object that would be bound with the
	    *            HTTP request data.
	    * @param session
	    *            to maintain the session.
	    * @return the object of type ModelAndView.
	    */
    	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	     public ModelAndView login(
			@ModelAttribute("credentials") final CredentialsBean credentials,
			final HttpSession session) {
	  	System.out.println("in login");
		  ModelAndView result = new ModelAndView("InvalidUser", "MSG",
				"INVALID User Details");
		  String status = user.login(credentials);
		  if ("admin".equals(status)) {
			session.setAttribute("userID", credentials.getUserID());
			session.setAttribute("userType", status);
			System.out.println("status for admin "+status);
			result = new ModelAndView("AdminHome", "MSG", "Welcome Admin "
					+ credentials.getUserID());
		} else if ("customer".equals(status)) {
			session.setAttribute("userID", credentials.getUserID());
			session.setAttribute("userType", status);
			System.out.println("status for customer is"+status);
			result = new ModelAndView("CustomerHome", "MSG", "Logged In As "
					+ credentials.getUserID());
		}
		session.setAttribute("nameheader", credentials.getUserID());
		return result;
	  }

	  /**
	   * This method is used for logout functionality.
	    * 
	     * @param session
	     *            to maintain the session.
	     * @param credentials
	     *            is used as the command object that would be bound with the
	     *            HTTP request data.
	     * @param result
	     *            is used to bind with the bean variable.
	     * @return logout view name.
	     */
    	@RequestMapping(value = "logout.htm", method = RequestMethod.GET)
	    public String viewlogout(final HttpSession session,
			@ModelAttribute("credentials") final CredentialsBean credentials) {

		ModelAndView result1 = null;
		user.logout(session.getAttribute("userID").toString());

		session.invalidate();
		result1 = new ModelAndView("index", "MSG", "Logout successful!!");

		return "index";

  	}

	  /**
	 * This method is used for change password functionality.
	 * 
	 * @return password view.
	 */
	@RequestMapping(value = "password.htm")
	public String gotopassword() {
		return "password";
	}

  	/**
  	 * This method is used for change password functionality.
	   * 
	   * @param session
	  *            to maintain the session.
	   * @param credentials
	   *            is used as the command object that would be bound with the
	   *            HTTP request data.
	   * @return index view name.
	   */
	  @RequestMapping(value = "Change.htm", method = RequestMethod.GET)
	  public String changePassowrd(final HttpSession session,
			@ModelAttribute("credentials") final CredentialsBean credentials) {
		ModelAndView result = null;
		result = new ModelAndView("Change", "MSG", "FAILED");
		String newPassword = credentials.getNpassword();
		credentials.setUserID(session.getAttribute("userID").toString());
		user.changePassword(credentials, newPassword);
		return "index";
	  }

  	/**
  	 * This method is used for registration functionality.
  	 * 
	   * @param profile
	   *            variable used to bind with ProfileBean.
	   * @return res1 returns view of name RegSuccess.
	  * @param binding
	  *            returns the binding result
	  */
	  @RequestMapping(value = "register.htm", method = RequestMethod.POST)
	  System.out.println("register page");
	  public ModelAndView register(
			@Valid @ModelAttribute("credentials1") final ProfileBean profile,
			final BindingResult binding) {
		ModelAndView res1 = null;
		if (binding.hasErrors()) {
			return new ModelAndView("index");
		}

		else {
			final String res = user.register(profile);
			if (!res.equalsIgnoreCase("INVALID")) {
				res1 = new ModelAndView("RegSuccess", "MSG",
						"Registered successfully with ID="
								+ profile.getUserID());
			}
		}
		return res1;
  	}
  	
  }

## JSP's are used as Views
##### Java Server Pages are html and javascript based pages to display UI elements to the user. All JSP's are placed in WEB-INF/jsp folder.
#####Inorder to get images in JSP pages, include your images folder in your Tomcat file location like Tomcat 8.0\webapps\portal_content\images.
###Example of JSP  ModifyShip.jsp
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

## JDBC Configuration file(jdbc.properties)
		jdbc.driverClassName= oracle.jdbc.driver.OracleDriver
		jdbc.dialect=org.hibernate.dialect.OracleDialect
		jdbc.databaseurl=jdbc:oracle:thin:@localhost:1521:orcl
		jdbc.username=scott
		jdbc.password=scott
    
## Servlet Configuration File (dispatcher-Servlet.xml)
      <?xml  version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
	    xmlns:context="http://www.springframework.org/schema/context"
		xmlns:jee="http://www.springframework.org/schema/jee" xmlns:lang="http://www.springframework.org/schema/lang"
		xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:p="http://www.springframework.org/schema/p"
	    xmlns:tx="http://www.springframework.org/schema/tx" xmlns:util="http://www.springframework.org/schema/util"
	    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
		http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee.xsd
		http://www.springframework.org/schema/lang http://www.springframework.org/schema/lang/spring-lang.xsd
		http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
		http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd
		http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">

	   <context:annotation-config />
	   <context:component-scan base-package="com.wipro.srs" />
	
		<mvc:annotation-driven conversion-service="applicationConversionService" />
		<bean id="applicationConversionService" class="com.wipro.srs.controller.ApplicationConversionServiceFactoryBean" />


		<bean id="propertyConfigurer"
		class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer"
		p:location="classpath:jdbc.properties" />

		<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
		destroy-method="close" p:driverClassName="${jdbc.driverClassName}"
		p:url="${jdbc.databaseurl}" p:username="${jdbc.username}" p:password="${jdbc.password}" />

		<bean id="user" class="com.wipro.srs.util.UserImpl"></bean>

		<bean id="sessionFactory"
		class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
			<property name="dataSource" ref="dataSource" />
			<property name="configLocation">
				<value>classpath:hibernate.cfg.xml</value>
			</property>
			<property name="configurationClass">
			<value>org.hibernate.cfg.AnnotationConfiguration</value>
			</property>
			<property name="hibernateProperties">
				<props>
				<prop key="hibernate.dialect">${jdbc.dialect}</prop>
				<prop key="hibernate.show_sql">true</prop>
				<prop key="hibernate.hbm2ddl.auto">update</prop>
				</props>
			</property>
		</bean>

		<tx:annotation-driven transaction-manager="transactionManager" />

		<bean id="transactionManager"
	  	class="org.springframework.orm.hibernate3.HibernateTransactionManager">
			<property name="sessionFactory" ref="sessionFactory" />
		</bean>
  
  </beans>
  
##log4j.properties file

		# Define the root logger with console and file appender 
		log4j.rootLogger=INFO,CONSOLE,LOGFILE

		#Define the Console Appender 
		log4j.appender.CONSOLE=org.apache.log4j.ConsoleAppender

		#Define the Layout for ConsoleAppender
		log4j.appender.CONSOLE.layout=org.apache.log4j.PatternLayout
		log4j.appender.CONSOLE.layout.ConversionPattern=%-4r %d [%t] %-5p %c{1} %M:%L - %m%n
    
		#Define the File Appender 
		log4j.appender.LOGFILE=org.apache.log4j.FileAppender
		log4j.appender.LOGFILE.File=D://MyLogs/MyLog.log
		
		log4j.appender.FILE.ImmediateFlush=true
		log4j.appender.FILE.Threshold=error
		log4j.appender.FILE.Append=true
		
		# Define the layout for File appender
		log4j.appender.LOGFILE.layout=org.apache.log4j.PatternLayout
		log4j.appender.LOGFILE.layout.conversionPattern=%-4r %d [%t] %-5p %C{1} %M:%L %x - %m%n

## hibernate.cfg.xml file
#### hibernate configuration file provides ORM mapping to Beans and Data Base tables. It has all bean classes.
    <?xml version='1.0' encoding='utf-8'?>
		<!DOCTYPE hibernate-configuration PUBLIC
		"-//Hibernate/Hibernate Configuration DTD//EN"
		"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

		<hibernate-configuration>
	    <session-factory>
		<mapping class="com.wipro.srs.bean.CredentialsBean" />
		<mapping class="com.wipro.srs.bean.ProfileBean" />
		<mapping class="com.wipro.srs.bean.PassengerBean" />
		<mapping class="com.wipro.srs.bean.ReservationBean" />
		<mapping class="com.wipro.srs.bean.RouteBean" />
		<mapping class="com.wipro.srs.bean.ScheduleBean" />
		<mapping class="com.wipro.srs.bean.ShipBean" />
		
	    </session-factory>

    </hibernate-configuration>

##Deployment Descriptor (web.xml)
#### web.xml has welcome file list, servelet mapping class and url pattern. 
      <?xml version="1.0" encoding="UTF-8"?>
		<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee"                      xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
		<display-name>SRS</display-name>
		<welcome-file-list>
			<welcome-file>index1.jsp</welcome-file>
		</welcome-file-list>
		<servlet>
			<servlet-name>dispatcher</servlet-name>
			<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
			<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/dispatcher-servlet.xml, /WEB-INF/Dispatcher-tiles.xml</param-value>
			</init-param>
			<load-on-startup>1</load-on-startup>
		</servlet>
		<servlet-mapping>
			<servlet-name>dispatcher</servlet-name>
			<url-pattern>*.htm</url-pattern>
		</servlet-mapping>
		<error-page>
			<error-code>500</error-code>
			<location>/WEB-INF/jsp/SystemError.jsp</location>
		</error-page>
		<error-page>
			<error-code>404</error-code>
			<location>/WEB-INF/jsp/SystemError.jsp</location>
		</error-page>
		<error-page>
			<error-code>503</error-code>
			<location>/WEB-INF/jsp/SystemError.jsp</location>
		</error-page>
    </web-app>