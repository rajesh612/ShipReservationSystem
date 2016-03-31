/* 
 *
 * File Name         : Customer.java
 *
 * Short Description : This file is used to get/set Customer Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
package com.wipro.srs.service;

import java.util.List;
import java.util.Map;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;

/**
*
* @author Rajesh Kumar
* @version 1.0,May 5,2015
* @since 1.0
* */
public interface Customer {
	

	/**
	 * This method is used to view the schedule details.
	 * 
	 * @param source
	 *            used to get the source.
	 * @param destination
	 *            used to get the destination.
	 * @return List
	 */
	List<ScheduleBean> viewScheduleByRoute (String source, String destination);
	/**
	 * This method is used to reserve the tickets.
	 * 
	 * @param reservationBean
	 *            used as a object of ReservationBean.
	 * @param passengerBean
	 *            used as a object of PassengerBean.
	 * @return value must be either: "SUCCESS", "FAIL"
	 */
	String reserveTicket(ReservationBean reservationBean, List<PassengerBean> passengerBean) ;
 

/**
 * 
 * @return list
 */
List<RouteBean> viewByRoutes();

/**
 * This method returns a the route details.
 * 
 * @param routeID
 *            used to get the routeID.
 * @return RouteBean as a object.
 */
RouteBean getRouteDetails(String routeID);


/**
 * This method returns the ship details.
 * 
 * @param shipID
 *            used to get the shipID.
 * @return ShipBean as a object.
 */
ShipBean getShipDetails(String shipID);
ReservationBean getTicketDetails(String reservationID);

List<ReservationBean> viewByReservations(String string);
String cancelTicket(String reservationID);


}
