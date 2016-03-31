/* 
 *
 * File Name         : PassengerDAOImpl.java
 *
 * Short Description : This file is used to get/set Passenger Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
package com.wipro.srs.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.service.MethodLogger;

/**
 *
 * @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */
@Repository
public class PassengerDAOImpl implements PassengerDAO {
	public static final Logger log = Logger.getLogger(MethodLogger.class);
	@Autowired
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.PassengerDAO#createPassenger(com.wipro.srs.bean.PassengerBean)
	 */
	@Override
	public String createPassenger (PassengerBean pass) {
		String result = "FAIL";
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(pass);
			result = "SUCCESS";
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.PassengerDAO#deletePassenger(java.util.List)
	 */
	@Override
	public int deletePassenger (List<String> reservationID) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.PassengerDAO#updatePassenger(com.wipro.srs.bean.PassengerBean)
	 */
	@Override
	public boolean updatePassenger (PassengerBean pass) {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.PassengerDAO#findByID(java.lang.String)
	 */
	@Override
	public PassengerBean findByID (String reservationID) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.PassengerDAO#findAll()
	 */
	@Override
	public List<PassengerBean> findAll() {
		return null;
	}
	

	public List viewPassengers(){
		Session session = sessionFactory.getCurrentSession();
		String sql ="select  * FROM SRS_TBL_User_Passenger NATURAL JOIN SRS_TBL_Schedule1 NATURAL JOIN SRS_TBL_Ship";
		Query query = session.createSQLQuery(sql);
		System.out.println(query);
		List<Object[]> list = query.list();
		System.out.println(list);
		return list;
	}

	@Override
	public  List<PassengerBean> viewPassengersByName(String id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		String sql = "from PassengerBean where scheduleID=:fid";
		Query query = session.createQuery(sql);
		query.setParameter("fid", id);
		List<PassengerBean> list = query.list();
		String sql1 = "select startdate from ScheduleBean where scheduleID=:fid";
		Query query1=session.createSQLQuery(sql);
		List<ScheduleBean> list1 = query1.list();
		
		return list;
		
	}

}
