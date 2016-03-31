/*
 *
 * File Name         : CredentialsDAOImpl.java
 *
 * Short Description : This file is used implement credential dao Details.
 *
 * Version Number    : 1.0
 *
 * Created Date      : May 4, 2015
 *
 */


package com.wipro.srs.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.srs.bean.CredentialsBean;


/**
*
* @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
*/
@Repository
public class CredentialsDAOImpl implements CredentialsBeanDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wipro.srs.dao.CredentialsBeanDAO#createCredentials(com.wipro.srs.
	 * bean.CredentialsBean)
	 */
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public String createCredentials (final CredentialsBean credentials) {
		Session session = sessionFactory.getCurrentSession();
		session.save(credentials);
		return credentials.getUserID();
	} 
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wipro.srs.dao.CredentialsBeanDAO#updateCredentials(com.wipro.srs.
	 * bean.CredentialsBean)
	 */
	@Override
	public boolean updateCredentials (final CredentialsBean cred) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cred);
		return true;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wipro.srs.dao.CredentialsBeanDAO#findByID(java.lang.String)
	 */
	@Override
	@Transactional
	public CredentialsBean findByID (final String userID) {
		Session session = sessionFactory.getCurrentSession();
		CredentialsBean credentials = null;
		if (userID instanceof String) {
			credentials = (CredentialsBean) session.get(CredentialsBean.class,
					userID);
		}
		return credentials;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wipro.srs.dao.CredentialsBeanDAO#findAll()
	 */
	@Override
	public List<CredentialsBean> findAll() {
		return null;
	}
}
