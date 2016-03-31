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

import com.wipro.srs.bean.ProfileBean;


/**
*
* @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
*/
public interface ProfileDAO {

	/**
	 * This is used to perform createProfile functionality.
	 * @param profile
	 * 			 to get the user details.
	 * @return
	 * 			String as "SUCCESS"/"INVALID".
	 */
	String createProfile(ProfileBean profile);
	/**
	 * This is used to perform deleteProfile functionality.
	 * @param userID
	 * 			To get the userID.
	 * @return
	 * 			integer value.
	 */
	int deleteProfile(List<String> userID);
	/**
	 * This is used to perform updateProfile functionality.
	 * @param profile
	 * 			This is used to find all the profile details for all users.
	 * @return
	 * 			Boolean value.
	 */
	boolean updateProfile(ProfileBean profile);
	/**
	 * This is used to perform findbyID functionality.
	 * @param userID
	 * 		To get the userID.
	 * @return
	 *      an object of type ProfileBean.
	 */
	ProfileBean findByID(String userID);
	/**
	 * This is used to perform findAll functionality.
	 * @return
	 * 			List of type ProfileBean.
	 */
	List<ProfileBean> findAll();
	/**
	 * This is used to perform findbyID functionality.
	 * @return
	 * 		sequence of type BigDecimal.
	 */
	BigDecimal findById();
}
