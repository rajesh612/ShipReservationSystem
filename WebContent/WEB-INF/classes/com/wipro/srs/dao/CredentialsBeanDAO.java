/* 
 *
 * File Name         : CredentialsBeanDAO.java
 *
 * Short Description : This file is used to get/set Creditional Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
package com.wipro.srs.dao;

import java.util.List;

import com.wipro.srs.bean.CredentialsBean;

/**
 *
 * @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */
public interface CredentialsBeanDAO {
	/**
	 * This method is used to perform createCredentials functionality.
	 * 
	 * @param credentials
	 *            is used as the command object that would be bound with the HTTP request data.
	 * @return
	 *           String as "SUCCESS"/"INVALID".
	 */
	String createCredentials (CredentialsBean cred );
	/**
	 * This method is used to perform deleteCredentials functionality.
	 * 
	 * @param userID
	 *            to get the userID.
	 * @return 
	 *            a boolean value.
	 */
	boolean updateCredentials (CredentialsBean cred) ;
	/**
	 * This method is used to find the credentials details by userID.
	 * 
	 * @param usersID
	 *            to get the userID.
	 * @return 
	 *            an object of type credentialsBean class.
	 */
	CredentialsBean findByID (String userID);
	/**
	 * This method is used to find all the credentials details.
	 * 
	 * @return 
	 *           an list of type credentialsBean.
	 */
	List<CredentialsBean> findAll();
}
