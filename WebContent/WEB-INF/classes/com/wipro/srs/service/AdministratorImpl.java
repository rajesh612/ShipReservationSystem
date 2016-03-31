/* 
 *
 * File Name         : AdministratorImpl.java
 *
 * Short Description : This file is used to get/set Administrator Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
package com.wipro.srs.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.dao.PassengerDAO;
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
public class AdministratorImpl implements Administrator {

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#addShip(com.wipro.srs.bean.ShipBean)
	 */
	@Autowired
	ShipDAO shipDAO;
	@Autowired
	private ScheduleDAO scheduleDAO;
	@Autowired
	RouteDAO routeDAO;
	@Autowired
	PassengerDAO pDAO;
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public String addShip(ShipBean ship) {
		String result = "INVALID";
		if (ship instanceof ShipBean && ship.getShipName() instanceof String) {
			BigDecimal sequence = shipDAO.findById();
			String name = ship.getShipName().substring(0, 2).toUpperCase();
			String shipID = name + sequence;
			ship.setShipID(shipID);
			boolean flag = false;
			if (!flag) {
				result = shipDAO.createShip(ship);
			}
			return "SUCCESS";
		}
		return result;
		
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#modifyShip(com.wipro.srs.bean.ShipBean)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public boolean modifyShip(ShipBean shipbean) {
		return shipDAO.updateShip(shipbean);
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#removeShip(java.util.List)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public int removeShip (final List<String> ShipId) {
		int result = 0;
		// if (shipID instanceof String) {
		List<String> rlist = new ArrayList<String>();
		rlist.addAll(ShipId);
		System.out.println(rlist);
		result = shipDAO.deleteShip(rlist);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#addSchedule(com.wipro.srs.bean.ScheduleBean)
	 */

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public String addSchedule(ScheduleBean schedule) {
		String result = "INVALID";
		if (schedule instanceof ScheduleBean && schedule.getShipID() instanceof String
				&& schedule.getRouteID() instanceof String) {
			BigDecimal sequence = scheduleDAO.findByID();
			String nameF = schedule.getShipID().substring(0, 2);
			String nameR = schedule.getRouteID().substring(0, 2);
			String scheduleID = nameF + nameR + sequence;
			schedule.setScheduleID(scheduleID);
			scheduleDAO.createSchedule(schedule);
			boolean flag = false;
			if (!flag) {
				result = scheduleDAO.createSchedule(schedule);
			}
			return "SUCCESS";
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#modifySchedule(com.wipro.srs.bean.ScheduleBean)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public boolean modifySchedule(ScheduleBean schedule) {
		boolean result = false;
		result = scheduleDAO.updateSchedule(schedule);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#removeSchedule(java.util.List)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public int removeSchedule(List<String> scheduleid) {
		int result = 0;
		List<String> rlist = new ArrayList<String>();
		rlist.addAll(scheduleid);
		result = scheduleDAO.deleteSchedule(rlist);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#addRoute(com.wipro.srs.bean.RouteBean)
	 */
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public String addRoute(RouteBean route) {
		String result = "INVALID";
		if (route instanceof RouteBean && route.getSource() instanceof String) {
			BigDecimal sequence = shipDAO.findById();
			String name = route.getSource().substring(0, 2).toUpperCase();
			String routeID = name + sequence;
			route.setRouteID(routeID);
			routeDAO.createRoute(route);
			boolean flag = false;
			if (!flag) {
				result = routeDAO.createRoute(route);
			}
			return "SUCCESS";
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#modifyRoute(com.wipro.srs.bean.RouteBean)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public boolean modifyRoute(RouteBean route) {
		boolean result = false;
		result = routeDAO.updateRoute(route);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#removeRoute(java.lang.String)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public int removeRoute(final List<String> routeid) {
		int result = 0;
		List<String> rlist = new ArrayList<String>();
		rlist.addAll(routeid);
		result = routeDAO.deleteRoute(rlist);
		System.out.println(result);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#viewByShipId(java.lang.String)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public ShipBean viewByShipId(String ShipId) {
		return shipDAO.findShipId(ShipId);
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#viewByRouteId(java.lang.String)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public RouteBean viewByRouteId(String routeid) {
		return routeDAO.findRouteId(routeid);
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#viewByAllShips()
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public List<ShipBean> viewByAllShips() {
		List<ShipBean> list = shipDAO.findAll();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#viewByAllRoute()
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public List<RouteBean> viewByAllRoute() {
		List<RouteBean> list = routeDAO.findAll();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#viewByAllSchedule()
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public List<ScheduleBean> viewByAllSchedule() {
		List<ScheduleBean> list = scheduleDAO.findAll();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#viewByScheduleId(java.lang.String)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public ScheduleBean viewByScheduleId(String scheduleid) {
		return scheduleDAO.findScheduleId(scheduleid);
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.service.Administrator#viewPasengersByShip(java.lang.String)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public List viewPasengers() {
		List l=pDAO.viewPassengers();
		return l;
	}
	@Override
	@Transactional
	public List<String> findByAllRouteId () {
		List<String> list = routeDAO.findAllIds();
		return list;
	}
	
	@Override
	@Transactional
	public List<String> findByAllShipId () {
		List<String> list = shipDAO.findByAllIds();
		return list;}
	
	@Override
	@Transactional
	public List<String> findByAllScheduleId () {
		List<String> list = scheduleDAO.findAllIds();
		return list;
	}

	@Override
	public List<PassengerBean> viewPasengersByShip(String scheduleid) {
		// TODO Auto-generated method stub
		List<PassengerBean> l=pDAO.viewPassengersByName(scheduleid);
		return l;
	}

	@Override
	public List<PassengerBean> viewByShipName() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

