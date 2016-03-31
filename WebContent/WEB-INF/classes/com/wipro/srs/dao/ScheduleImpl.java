/* 
 *
 * File Name         : ScheduleImpl.java
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

/**
*
* @author Rajesh Kumar
 * @version 1.0,May 8,2015
 * @since 1.0
*/
@Repository
public class ScheduleImpl implements ScheduleDAO {
	public static final Logger log = Logger.getLogger(MethodLogger.class);
	@Autowired
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ScheduleDAO#createSchedule(com.wipro.srs.bean.ScheduleBean)
	 */
	@Override
	public String createSchedule(ScheduleBean schedule) {
		/*
		 * Session session = sessionFactory.getCurrentSession(); String sched = schedule.getScheduleID();
		 * session.save(schedule); return sched;
		 */
		String result = "Failure";
		// try {
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

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ScheduleDAO#deleteSchedule(java.util.List)
	 */
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
			//System.out.println(scheduleID.get(1));
			//System.out.println(scheduleID.get(2));
			//schedule1=findByID(id);
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

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ScheduleDAO#updateSchedule(com.wipro.srs.bean.ScheduleBean)
	 */
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

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ScheduleDAO#findByID(java.lang.String)
	 */
	@Override
	@Transactional
	public BigDecimal findByID () {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select SRS_SEQ_SCHEDULE_ID.nextval from dual";
		Query query = session.createSQLQuery(sql);
		BigDecimal schedule = (BigDecimal) query.uniqueResult();
		return schedule;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ScheduleDAO#findAll()
	 */
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
