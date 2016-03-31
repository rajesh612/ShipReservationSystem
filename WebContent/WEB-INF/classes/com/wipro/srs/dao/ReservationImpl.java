/* 
 *
 * File Name         : ReservationImpl.java
 *
 * Short Description : This file is used to get/set Reservation Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
package com.wipro.srs.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.ShipBean;

/**
*
* @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
*/
@Repository
public class ReservationImpl implements ReservationDAO {
	@Autowired
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ReservationDAO#createReservation(com.wipro.srs.bean.ReservationBean)
	 */
	@Override
	public String createReservation(ReservationBean reservation) {
		String result = "Failure";
		Session session = sessionFactory.getCurrentSession();
		if (reservation instanceof ReservationBean) {
			session.save(reservation);
			result = "Success";
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ReservationDAO#deleteReservation(java.util.List)
	 */
	@Override
	public String deleteReservation(ReservationBean reservation) {
		
		String result = "Failure";
		Session session = sessionFactory.getCurrentSession();
		if (reservation instanceof ReservationBean) {
			session.delete(reservation);
			result = "Success";
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ReservationDAO#updateReservation(com.wipro.srs.bean.ReservationBean)
	 */
	@Override
	public boolean updateReservation(ReservationBean reservation) {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ReservationDAO#findByID(java.lang.String)
	 */
	

	/* (non-Javadoc)
	 * @see com.wipro.srs.dao.ReservationDAO#findAll()
	 */
	@Override
	@Transactional
	public List<ReservationBean> findAll(String userid) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "From ReservationBean where userID=:uid";
		Query query = session.createQuery(sql);
		query.setParameter("uid", userid);
		List<ReservationBean> details = query.list();
		return details;
	}
		
	
	@Override
	public BigDecimal findByID () {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select SRS_SEQ_RESERVATION_ID.nextval from dual ";
		SQLQuery query = session.createSQLQuery(sql);
		BigDecimal res = (BigDecimal) query.uniqueResult();
		return res;
	}
	
	@Override
	public ReservationBean findByResID (String reservationID) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "From ReservationBean where reservationID=:rid ";
		Query query = session.createQuery(sql);
		query.setParameter("rid", reservationID);
		ReservationBean value = (ReservationBean) query.uniqueResult();
		return value;
	}

	
}
