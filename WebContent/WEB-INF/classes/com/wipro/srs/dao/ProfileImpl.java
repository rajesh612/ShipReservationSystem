/*
 *
 * File Name         : ProfileBeanDAO.java
 *
 * Short Description : This file is used to get/set Profile Details.
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.srs.bean.ProfileBean;
/**
*
* @author Rajesh Kumar
* @version 1.0,May 5,2015
* @since 1.0
*/
@Repository
public class ProfileImpl implements ProfileDAO {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.wipro.srs.dao.ProfileDAO#createProfile(java.util.List)
	 */
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public String createProfile(final ProfileBean profile) {
		sessionFactory.getCurrentSession().save(profile);
		return null;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see com.wipro.srs.dao.ProfileDAO#deleteProfile(java.util.List)
	 */
	@Override
	public int deleteProfile(final List<String> userID) {
		return 0;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see com.wipro.srs.dao.ProfileDAO#updateProfile(java.util.List)
	 */
	@Override
	public boolean updateProfile(final ProfileBean profile) {
		return false;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see com.wipro.srs.dao.ProfileDAO#findByID(java.util.List)
	 */
	@Override
	public ProfileBean findByID(final String userID) {
		return null;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see com.wipro.srs.dao.ProfileDAO#findAll()
	 */
	@Override
	public List<ProfileBean> findAll() {
		return null;
	}
	@Override
	@Transactional
	public BigDecimal findById() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select SRS_SEQ_USER_ID.nextval from dual";
		System.out.println("sequence for user id is"+sql);
		Query query = session.createSQLQuery(sql);
		// query.addEntity(ProfileBean.class);
		BigDecimal profile = (BigDecimal) query.uniqueResult();
		return profile;
	}
}
