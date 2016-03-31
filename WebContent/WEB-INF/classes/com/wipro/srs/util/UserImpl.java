/*
 *
 * File Name         : UserImpl.java
 *
 * Short Description : This file is used to get/set User Details.
 *
 * Version Number    : 1.0
 *
 * Created Date      : May 4, 2015
 *
 */


package com.wipro.srs.util;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.dao.CredentialsBeanDAO;
import com.wipro.srs.dao.ProfileDAO;

/**
*
* @author Rajesh Kumar
* @version 1.0,May 10,2015
* @since 1.0
*/


@Service
public class UserImpl implements User {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.wipro.srs.util.User#login(com.wipro.srs.bean.CredentialsBean)
	 */
	@Autowired
	private CredentialsBeanDAO credentialsDAO;
	@Override
	@Transactional
	public String login(final CredentialsBean credentials) {
		String result = "INVALID";
		if (credentials instanceof CredentialsBean) {
			CredentialsBean credentialsDB = credentialsDAO.findByID(credentials
					.getUserID());
			if ((credentialsDB instanceof CredentialsBean)
					&& credentialsDB.getPassword().equals(
							credentials.getPassword())) {
				credentialsDB.setLoginStatus(1);
				result = credentialsDB.getUserType();
				System.out.println("user Type is"+result);
			}
		}
		return result;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see com.wipro.srs.util.User#logout(java.lang.String)
	 */
	@Override
	@Transactional
	public boolean logout(final String userId) {
		boolean result=false;
		try{
		CredentialsBean credentialsDB = null;
		credentialsDB = credentialsDAO.findByID(userId);
		credentialsDB.setLoginStatus(0);
		credentialsDAO.updateCredentials(credentialsDB);
		result=true;
		}
		catch(Exception e){
			result=false;
		}
		finally{
		return result;}
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wipro.srs.util.User#changePassword(com.wipro.srs.bean.CredentialsBean
	 * , java.lang.String)
	 */
	@Override
	@Transactional
	public String changePassword(CredentialsBean credentials,
			final String newPassword) {
		credentials = credentialsDAO.findByID(credentials
				.getUserID());
		credentials.setPassword(newPassword);
		credentialsDAO.updateCredentials(credentials);
		System.out.println("password changed");
		return "success";
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see com.wipro.srs.util.User#register(com.wipro.srs.bean.ProfileBean)
	 */
	@Autowired
	private ProfileDAO profileDAO;
	@Override
	@Transactional
	public String register(final ProfileBean profile) {
		if (profile instanceof ProfileBean) {
			BigDecimal sequence = profileDAO.findById();
			String name = profile.getFirstName().substring(0, 2).toUpperCase();
			String userID = name + sequence;
			System.out.println("user id is"+userID);
			CredentialsBean credentials = new CredentialsBean();
			credentials.setUserID(userID);
			credentials.setPassword(profile.getPassword());
			credentials.setUserType("customer");
			credentials.setLoginStatus(0);
			System.out.println("userID"+userID);
			credentialsDAO.createCredentials(credentials);
			boolean flag = false;
			if (!flag) {
				profile.setUserID(userID);
				String result = profileDAO.createProfile(profile);
			}
			return "SUCCESS";
		}
		return "Faliure";
	}
}
