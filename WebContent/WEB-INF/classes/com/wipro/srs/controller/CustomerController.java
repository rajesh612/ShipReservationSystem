/*
 *
 * File Name         : CredentialsBean
 *
 * Short Description : This file is used to get/set Credential Details.
 *
 * Version Number    : 1.0
 *
 * Created Date      : May 6, 2015
 *
 */

package com.wipro.srs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.dao.ShipDAO;
import com.wipro.srs.service.Customer;

/**
 * This class is used to get/set login details.
 *
 * @author Rajesh Kumar
 * @version 1.0,May 6,2015
 * @since 1.0
 */
@Controller
public class CustomerController {

	@Autowired
	private Customer cust;

	/**
	 * This method is used to perform the view schedule functionality.
	 * 
	 * @param route
	 *            is an object of class RouteBean.
	 * @return a value of type ModelAndView.
	 */

	@RequestMapping(value = "CustscheduleView")
	public ModelAndView viewScheduleDeatils(
			@ModelAttribute("schedule") final RouteBean route,
			final HttpSession session) {
		ModelAndView value = null;
		String source = route.getSource();
		String destination = route.getDestination();
		List<ScheduleBean> slist = (List<ScheduleBean>) cust
				.viewScheduleByRoute(source, destination);
		System.out.println("slist===" + slist);
		value = new ModelAndView("ViewScheduleByRoute", "slist", slist);
		return value;
	}

	/**
	 * This method is used to perform view schedule functionality.
	 * 
	 * @param model
	 *            represents the data that will be passed to and from an
	 *            operation and the view.
	 * @param route
	 *            represents an object of RouteBean class.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return an object of type ModelAndView.
	 */
	@RequestMapping(value = "CustScheduleView1")
	public ModelAndView viewSchedulejsp(final Model model,
			final RouteBean route, final HttpSession session) {
		model.addAttribute("schedule", new RouteBean());
		List<RouteBean> routedetails = cust.viewByRoutes();
		session.setAttribute("routedetails", routedetails);
		return new ModelAndView("ViewScheduleByRoute", "routedetails",
				routedetails);
	}

	/**
	 * This method is used to perform ViewDetails functionality.
	 * 
	 * @param shipID
	 *            is a request parameter used for mapping the details from
	 *            controller to jsp file.
	 * @param routeID
	 *            is a request parameter used for mapping the details from
	 *            controller to jsp file.
	 * @param scheduleID
	 *            is a request parameter used for mapping the details from
	 *            controller to jsp file.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return ModelAndView object.
	 * */
	@RequestMapping(value = "CustScheduleBook.htm", method = RequestMethod.GET)
	public ModelAndView viewDetailsForBooking(
			@RequestParam("shipID") final String shipID,
			@RequestParam("routeID") final String routeID,
			@RequestParam("scheduleID") final String scheduleID,
			final HttpSession session) {
		System.out.println("in schedule");
		RouteBean route = cust.getRouteDetails(routeID);
		ShipBean ship = cust.getShipDetails(shipID);
		session.setAttribute("scheduleID", scheduleID);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("routedetails", route);
		model.put("shipdetails", ship);
		System.out.println("in schedule");
		return new ModelAndView("CustShipDetails", model);
	}

	/**
	 * This method is used to perform reservation functionality.
	 * 
	 * @param fare
	 *            is a request parameter used for mapping the details from
	 *            controller to jsp file.
	 * @param travelDuration
	 *            is a request parameter used for mapping the details from
	 *            controller to jsp file.
	 * @param seats
	 *            is a request parameter used for mapping the details from
	 *            controller to jsp file.
	 * @param reservation
	 *            is a request parameter used for mapping the details from
	 *            controller to jsp file.
	 * @param passenger
	 *            is a request parameter used for mapping the details from
	 *            controller to jsp file.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return ModelAndView .
	 */
	@RequestMapping(value = "Reserve.htm", method = RequestMethod.GET)
	public ModelAndView viewFillDetails(
			@RequestParam("fare") final double fare,
			@RequestParam("travelDuration") final int travelDuration,
			@RequestParam("seats") final String seats,
			@ModelAttribute("reservation") final ReservationBean reservation,
			@ModelAttribute("passenger") final PassengerBean passenger,
			final HttpSession session) {
		session.setAttribute("fare", fare);
		return new ModelAndView("FillDetails");
	}

	/**
	 * This method is used to perform add reservation functionality.
	 * 
	 * @param reservation
	 *            is a request parameter used for mapping the details from
	 *            controller to jsp file.
	 * @param passenger
	 *            is a request parameter used for mapping the details from
	 *            controller to jsp file.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "addReservation", method = RequestMethod.POST)
	public ModelAndView addReservation(
			@ModelAttribute("reservation") final ReservationBean reservation,
			@ModelAttribute("passenger") final PassengerBean passenger,
			final HttpSession session) {
		String scheduleID = (String) session.getAttribute("scheduleID");
		reservation.setScheduleID(scheduleID);
		passenger.setScheduleID(scheduleID);
		String userID = (String) session.getAttribute("userID");
		reservation.setUserID(userID);
		double fare = (Double) session.getAttribute("fare");
		reservation.setTotalFare(fare);
		Date bookdate = new Date();
		reservation.setBookingDate(bookdate);
		List<PassengerBean> passbean = new ArrayList<PassengerBean>();
		passbean.add(passenger);
		String value = cust.reserveTicket(reservation, passbean);
		String reservationID = reservation.getReservationID();
		if ("Success".equals(value)) {
			return new ModelAndView("CustomerSuccess", "MSG",
					"Reservation Done with ID as " + reservationID);
		} else {
			return new ModelAndView("CustomerFail", "MSG",
					"Reservation Failed!");
		}
	}
	
	
	
	
	@RequestMapping(value = "v.htm",method = RequestMethod.GET)
	public ModelAndView viewTicket(@ModelAttribute("credentials") final CredentialsBean credentials,HttpSession session) {
		final Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(session.getAttribute("userID").toString());
		map.put("ViewTicket", cust.viewByReservations(session.getAttribute("userID").toString()));
		return new ModelAndView("ViewTicket", map);
	}

	

	@RequestMapping(value = "pay.htm", method = RequestMethod.GET)
	public ModelAndView doPayment(HttpSession session){
	
		return new ModelAndView("Payment");
	}


	
	
	@RequestMapping(value = "c.htm",method = RequestMethod.GET)
	public ModelAndView cancelTicket(HttpSession session,HttpServletRequest req) {
		System.out.println("Entered");
		String id1=req.getParameter("id");
		System.out.println(id1);
		String result=cust.cancelTicket(id1);
		System.out.println(result);
		if ("Success".equals(result)) {
			return new ModelAndView("CustomerFail", "MSG",
					"Ticket Cancelled Successfully" );
		} else {
			return new ModelAndView("CustomerFail", "MSG",
					"Cancellation not successful!");
		}
	}
	
	@RequestMapping(value = "p.htm",method = RequestMethod.GET)
	public ModelAndView paymentSuccess(HttpSession session,HttpServletRequest req) {
		
			return new ModelAndView("CustomerFail", "MSG",
					"Payment successful!");
	
	}
	

	
}
