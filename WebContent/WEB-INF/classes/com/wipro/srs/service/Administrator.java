/* 
 *
 * File Name         : Administrator.java
 *
 * Short Description : This file is used to get/set Administrator Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
package com.wipro.srs.service;

import java.util.List;


import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;

/**
* @author Rajesh Kumar
 * @version 1.0,May 8,2015
 * @since 1.0
*/
public interface Administrator {

	/**
	 * This method is used to add the ship details.
	 * 
	 * @param shipbean
	 *            to get the details of ship.
	 * @return value must be either: "SUCCESS", "FAIL", ERROR”
	 */
	String addShip(ShipBean shipbean);

	/**
	 * This method is used to modify the ship details.
	 * 
	 * @param Shipbean
	 *            to get the details of ship.
	 * @return returns a boolean value.
	 */
	boolean modifyShip(ShipBean Shipbean);

	/**
	 * This method is used to remove the ship details
	 * 
	 * @param fid
	 *            used to get the list id.
	 * @return an integer value.
	 */
	int removeShip(final List<String> fid);

	/**
	 * This method is used to add the schedule details.
	 * 
	 * @param schedulebean
	 *            used to get the schedule details.
	 * @return value must be either: "SUCCESS", "FAIL", “ERROR”
	 */
	String addSchedule(ScheduleBean schedulebean);

	/**
	 * This method is used to modify the schedule details.
	 * 
	 * @param schedulebean
	 *            used to get the schedule details.
	 * @return a boolean value.
	 */
	boolean modifySchedule(ScheduleBean schedulebean);

	/**
	 * This method is used to remove the schedule details.
	 * 
	 * @param scheduleid
	 *            used to get the scheduleid.
	 * @return an integer value.
	 */
	int removeSchedule(List<String> scheduleid);

	/**
	 * This method is used to add the route details.
	 * 
	 * @param routebean
	 *            used to get the route details.
	 * @return value must be either: "SUCCESS", "FAIL", “ERROR”
	 */
	String addRoute(RouteBean routebean);

	/**
	 * This method is used to modify the route details.
	 * 
	 * @param routebean
	 *            used to get the route details.
	 * @return a boolean value.
	 */
	boolean modifyRoute(RouteBean routebean);

	/**
	 * This method is used to remove the route details.
	 * 
	 * @param routeid
	 *            used to get the routeid.
	 * @return a integer value.
	 */
	int removeRoute(final List<String> routeid);

	/**
	 * This method is used to view the route details.
	 * 
	 * @param ShipId
	 *            to get the shipid.
	 * @return object of type shipbean.
	 */
	ShipBean viewByShipId(String ShipId);

	/**
	 * This method is used to view the route details by routeid.
	 * 
	 * @param routeid
	 *            used to get the routeid.
	 * @return an object of type route bean.
	 */
	RouteBean viewByRouteId(String routeid);

	/**
	 * This method is used to list the ship details.
	 * 
	 * @return list of type ShipBean.
	 */
	List<ShipBean> viewByAllShips();

	/**
	 * This method is used to view all the route details.
	 * 
	 * @return a list of type RouteBean.
	 */
	List<RouteBean> viewByAllRoute();

	/**
	 * This method is used to list all the schedule details.
	 * 
	 * @return a list of type ScheduleBean.
	 */
	List<ScheduleBean> viewByAllSchedule();

	/**
	 * This method is used to view the schedule details by scheduleid.
	 * 
	 * @param scheduleid
	 *            to get the scheduleid.
	 * @return an object of type ScheduleBean.
	 */
	ScheduleBean viewByScheduleId(String scheduleid);

	/**
	 * This method is used to list the passenger details by scheduleid.
	 * 
	 * @param scheduleid
	 *            to get the scheduleid.
	 * @return a list of type PassengerBean.
	 */

	List<PassengerBean> viewPasengersByShip(String scheduleid);

	/**
	 * This method is used to list the route details..
	 * 
	 * @return a list of type string.
	 */
	List<String> findByAllRouteId();

	/**
	 * This method is used to list the ship details.
	 * 
	 * @return a list of type string.
	 */
	List<String> findByAllShipId();

	/**
	 * This method is used to list the schedule details.
	 * 
	 * @return a list of type string.
	 */
	List<String> findByAllScheduleId();

	List<Object[]> viewPasengers();

	List<PassengerBean> viewByShipName();

}
