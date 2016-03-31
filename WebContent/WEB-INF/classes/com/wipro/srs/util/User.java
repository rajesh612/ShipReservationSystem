/* 
 *
 * File Name         : User.java
 *
 * Short Description : This file is used to get/set User Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
package com.wipro.srs.util;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;

/**
*
* @author Rajesh Kumar
* @version 1.0,May 10,2015
* @since 1.0
*/


public interface User {
	/**
	 * This method is used for login details.
	 * 
	 * @param credentialsBean
	 *            as an object of CredentialsBean class.
	 * @return value "A", "C", "FAIL", "INVALID"
	 */
	String login(CredentialsBean credentialsBean);
	/**
	 * This method is used for logout.
	 * 
	 * @param userId
	 *            used to get the userId.
	 * @return boolean value.
	 */
	boolean logout(String userId);
	
	/**
	 * This method is used to change the password.
	 * 
	 * @param credentialsBean
	 *            as an object of CredentialsBean class.
	 * @param newPassword
	 *            to get the newPassword from user.
	 * @return value "SUCCESS", "FAIL", “INVALID”
	 */
	String changePassword(CredentialsBean credentialsBean, String newPassword);
	/**
	 * This method is used for registration.
	 * 
	 * @param profileBean
	 *            used as an object of ProfileBean.
	 * @return value must be either: "<userId of lenght 6>", "FAIL"
	 */
	String register(ProfileBean profileBean);

}
