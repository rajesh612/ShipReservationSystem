/* 
 *
 * File Name         : RouteImpl.java
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

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.service.MethodLogger;

/**
*
* @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
*/
@Repository
public class RouteImpl implements RouteDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wipro.srs.dao.RouteDAO#createRoute(com.wipro.srs.bean.RouteBean)
	 */
	public static final Logger log = Logger.getLogger(MethodLogger.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String createRoute(RouteBean route) {
		String result = "Failure";
		try {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from RouteBean where source=? and destination=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, route.getSource());
			query.setParameter(1, route.getDestination());
			List<RouteBean> list = query.list();
			if (list.isEmpty()) {
				session.save(route);
				result = "Success";

			} else {
				result = "Route already exists";
			}
		} catch (Exception e) {
			result = "Failure";
		}

		finally {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wipro.srs.dao.RouteDAO#deleteRoute(java.util.List)
	 */
	@Override
	public int deleteRoute(List<String> routeID) {
		int result = 0;
		RouteBean route = new RouteBean();
		RouteBean routebean = new RouteBean();
		try {
			String id = routeID.get(0);
			route.setRouteID(id);
			routebean = findByID(id);
			Session session = sessionFactory.getCurrentSession();
			session.delete(routebean);
			result = 1;
		} catch (HibernateException e) {
			result = 0;
			log.error(e);
		} finally {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wipro.srs.dao.RouteDAO#updateRoute(com.wipro.srs.bean.RouteBean)
	 */
	@Override
	public boolean updateRoute(RouteBean route) {
		boolean result = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			route.setSource(route.getSource().toUpperCase());
			session.update(route);
			result = true;
		} catch (HibernateException e) {
			result = false;
			log.error(e);
		} finally {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wipro.srs.dao.RouteDAO#findByID(java.lang.String)
	 */
	@Override
	public RouteBean findByID(String ID) {
		Session session = sessionFactory.getCurrentSession();
		RouteBean route = null;
		if (ID instanceof String) {
			route = (RouteBean) session.get(RouteBean.class, ID);
		}
		return route;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wipro.srs.dao.RouteDAO#findAll()
	 */
	@Override
	public List<RouteBean> findAll() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "From RouteBean";
		Query query = session.createQuery(sql);
		List<RouteBean> details = query.list();
		return details;
	}

	@Override
	public List<String> findAllIds() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT routeID FROM RouteBean";
		Query query = session.createQuery(sql);
		List<String> details = query.list();
		return details;
	}

	@Override
	public RouteBean findRouteId(final String routeID) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "From RouteBean where routeID=:rid";
		Query query = session.createQuery(sql);
		query.setParameter("rid", routeID);
		RouteBean routes = (RouteBean) query.uniqueResult();
		return routes;
	}

	@Override
	public String viewRouteDetails(final String source, final String destination) {
		String result = "Failure";
		try {
			Session session = sessionFactory.getCurrentSession();
			System.out.println(source);
			System.out.println(destination);
			String sql = "Select routeID from RouteBean where source=:s and destination=:d";
			Query query = session.createQuery(sql);
			query.setParameter("s", source);
			query.setParameter("d", destination);
			String route = (String) query.uniqueResult();
			result = route;
			System.out.println("in rout impl===" + result);
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}
}
