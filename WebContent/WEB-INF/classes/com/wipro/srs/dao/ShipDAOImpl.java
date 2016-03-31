/* 
 *
 * File Name         : ShipDAOImpl.java
 *
 * Short Description : This file is used to get/set Ship Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
package com.wipro.srs.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;
import com.wipro.srs.service.MethodLogger;


import com.wipro.srs.bean.ShipBean;

/**
*
* @author Rajesh Kumar
 * @version 1.0,May 8,2015
 * @since 1.0
 * */
@Repository
public class ShipDAOImpl implements ShipDAO {
	public static final Logger log = Logger.getLogger(MethodLogger.class);
	@Autowired
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ShipDAO#createShip(com.wipro.srs.bean.ShipBean)
	 */
	@Override
	@Transactional
	public String createShip(ShipBean ship) {
		String result = "Failure";
		// try {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from ShipBean where shipName=?";
		Query query = session.createQuery(sql);
		query.setParameter(0, ship.getShipName());
		List<ShipBean> list = query.list();
		if (list.isEmpty()) {
			session.save(ship);
			result = "Success";
			return result;
		} else {
			result = "Ship already exists";
		}
		return result;
	
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ShipDAO#deleteShip(java.util.List)
	 */
	@Override
	@Transactional
	public int deleteShip(List<String> list) {
		int result = 0;
		ShipBean ship = new ShipBean();
		ShipBean shipbean = new ShipBean();
		try {
			String id = list.get(0);
			// String id = ship.getShipID();
			System.out.println("ship isd in delete ship======" + id);
			ship.setShipID(id);
			shipbean = findByID(id);
			Session session = sessionFactory.getCurrentSession();
			session.delete(shipbean);
			result = 1;
			System.out.println("result=====" + result);
		} catch (HibernateException e) {
			result=0;
		}
		finally{
		return result;}
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ShipDAO#updateShip(com.wipro.srs.bean.ShipBean)
	 */
	@Override
	@Transactional
	public boolean updateShip(ShipBean ship) {
		boolean result = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			ship.setShipName(ship.getShipName().toUpperCase());
			session.update(ship);
			result = true;
		} catch (HibernateException e) {
			result=false;
			log.error(e);
		}
		finally{
		return result;}
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ShipDAO#findByID(java.lang.String)
	 */
	@Override
	@Transactional
	public ShipBean findByID(String ID) {
		System.out.println(ID);
		Session session = sessionFactory.getCurrentSession();
		ShipBean ship = null;
		if (ID instanceof String) {
			ship = (ShipBean) session.get(ShipBean.class, ID);
		}
		return ship;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ShipDAO#findAll()
	 */
	@Override
	@Transactional
	public List<ShipBean> findAll() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "From ShipBean";
		Query query = session.createQuery(sql);
		List<ShipBean> details = query.list();
		return details;
	}
	@Override
	@Transactional
	public BigDecimal findById() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select SRS_SEQ_SHIP_ID.nextval from dual";
		Query query = session.createSQLQuery(sql);
		BigDecimal profile = (BigDecimal) query.uniqueResult();
		return profile;
	}
	@Override
	@Transactional
	public List<String> findByAllIds () {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT shipID FROM ShipBean";
		Query query = session.createQuery(sql);
		List<String> details = query.list();
		return details;
	}
	@Override
	@Transactional
	public ShipBean findShipId (final String shipID) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "From ShipBean where shipID=:sid";
		Query query = session.createQuery(sql);
		query.setParameter("sid", shipID);
		ShipBean ships = (ShipBean) query.uniqueResult();
		return ships;
	}

}
