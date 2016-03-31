/* 
 *
 * File Name         : ScheduleDAO.java
 *
 * Short Description : This file is used to get/set Schedule Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 5, 2015
 *
 */
package com.wipro.srs.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wipro.srs.bean.ScheduleBean;

/**
*
* @author Rajesh Kumar
* @version 1.0,May 8,2015
* @since 1.0
*/
public interface ScheduleDAO {

	/**
	 * This is used to perform createSchedule functionality.
	 * 
	 * @param schedule
	 *            to get the schedule for the ships.
	 * @return String as "SUCCESS"/"INVALID".
	 */
	String createSchedule(ScheduleBean schedule);

	/**
	 * This is used to perform deleteSchedule functionality.
	 * 
	 * @param scheduleID
	 *            to get the scheduleID.
	 * @return an integer value.
	 */
	int deleteSchedule(List<String> scheduleID);

	/**
	 * This is used to perform updateSchedule functionality.
	 * 
	 * @param schedule
	 *            to get the schedule
	 * @return a boolean value.
	 */
	boolean updateSchedule(ScheduleBean schedule);

	/**
	 * This is used to perform findbyID functionality.
	 * 
	 * @param scheduleID
	 *            used to get the scheduleID.
	 * @return an object as a ScheduleBean.
	 */
	ScheduleBean findByID(String scheduleID);

	/**
	 * This is used to perform createReservation functionality.
	 * 
	 * @return a list of type ScheduleBean.
	 */
	List<ScheduleBean> findAll();

	/**
	 * This is used to perform createReservation functionality.
	 * 
	 * @return sequence of ID.
	 * 
	 */
	BigDecimal findByID();

	/**
	 * This is used to perform createReservation functionality.
	 * 
	 * @return a list of type String.
	 */
	List<String> findAllIds();

	/**
	 * This is used to perform createReservation functionality.
	 * 
	 * @param scheduleID
	 *            used to get the scheduleID.
	 * @return an object of type ScheduleBean.
	 */
	ScheduleBean findScheduleId(String scheduleID);

	/**
	 * This is used to perform viewRoute functionality.
	 * 
	 * @param routeID
	 *            to get routeID.
	 * @return list of type ScheduleBean.
	 */
	List<ScheduleBean> viewRoute(String routeID);

	/**
	 * This is used to perform findRouteId functionality.
	 * 
	 * @param scheduleID
	 *            to get the scheduleID.
	 * @return string value.
	 */
	String findRouteId(String scheduleID);
}
