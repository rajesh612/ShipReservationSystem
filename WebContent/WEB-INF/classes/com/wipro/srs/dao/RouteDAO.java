/* 
 * File Name         : RouteDAO.java
 *
 * Short Description : This file is used to get/set Route Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
package com.wipro.srs.dao;

import java.util.List;

import com.wipro.srs.bean.RouteBean;

/**
*
* @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 * */
public interface RouteDAO {
	/**
	 * This is used to perform createRoute functionality.
	 * 
	 * @param route
	 *            Used to get route details.
	 * @return String value.
	 */
	String createRoute(RouteBean route);

	/**
	 * This is used to perform deleteRoute functionality.
	 * 
	 * @param routeID
	 *            Used to get route details as list.
	 * @return a list of type integer.
	 */
	int deleteRoute(List<String> routeID);

	/**
	 * This is used to perform updateRoute functionality.
	 * 
	 * @param route
	 *            to get route.
	 * @return boolean value.
	 */
	boolean updateRoute(RouteBean route);

	/**
	 * This is used to perform findbyID functionality.
	 * 
	 * @param routeID
	 *            to get the routeID.
	 * @return an object of type RouteBean.
	 */
	RouteBean findByID(String routeID);

	/**
	 * This is used to perform findAll functionality.
	 * 
	 * @return RouteBean list.
	 */
	List<RouteBean> findAll();

	/**
	 * This is used to perform findAllIds functionality.
	 * 
	 * @return list.
	 */
	List<String> findAllIds();

	/**
	 * This is used to perform findRouteId functionality.
	 * 
	 * @param routeID
	 *            to get the RouteID.
	 * @return an object of RouteBean.
	 */
	RouteBean findRouteId(String routeID);

	/**
	 * This method is used to perform viewRouteDetalis.
	 * 
	 * @param source
	 *            to get the source.
	 * @param destination
	 *            to get the destination.
	 * @return string value.
	 */
	String viewRouteDetails(String source, String destination);

}
