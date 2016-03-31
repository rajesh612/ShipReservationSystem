/* 
 *
 * File Name         : CustomerImpl.java
 *
 * Short Description : This file is used to get/set Customer Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
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

/**
*
* @author Rajesh Kumar
* @version 1.0,May 5,2015
* @since 1.0
* */
@Repository
public class CustomerImpl implements Customer {

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
	
	
	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Customer#viewScheduleByRoute(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public List<ScheduleBean> viewScheduleByRoute(String source,
			String destination) {
		String rid = routeDAO.viewRouteDetails(source, destination);
		if (!rid.equalsIgnoreCase("Failure")) {
			List<ScheduleBean> list = new ArrayList<ScheduleBean>();
			list = scheduleDAO.viewRoute(rid);
			if (list != null) {
				return list;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Customer#reserveTicket(com.wipro.srs.bean.ReservationBean, java.util.List)
	 */
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
