/* 
 *
 * File Name         : PassengerDAO.java
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



import com.wipro.srs.bean.PassengerBean;

/**
 *
* @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */
public interface PassengerDAO {
	/**
	 * This method is used to perform createPassenger functionality.
	 * @param pass
	 * 		is used as the command object that would be bound with the HTTP request data.
	 * @return
	 * 		String as "SUCCESS"/"INVALID".
	 */
	String createPassenger(PassengerBean pass) ;
	/**
	 * This method is used to perform deletePassenger functionality.
	 * @param reservationID
	 * 		to get the reservationID.
	 * @return 
	 * 		integer value.
	 */
	int deletePassenger(List<String> reservationID ); 
	/**
	 * This method is used to perform updatePassenger functionality.
	 * @param pass
	 * 			 is used as the command object that would be bound with the HTTP request data.
	 * @return
	 * 				boolean value.
	 */
	boolean updatePassenger(PassengerBean pass) ;
	/**
	 * This method is used to perform findbyID functionality
	 * @param reservationID
	 * 			to get the reservationID.
	 * @return
	 * 			an object of type PassengerBean.
	 */
	PassengerBean findByID(String reservationID);
     /**
      * This method is used to list all the PassengerBean objects.
     * @return
     * 			list.
     */
    List<PassengerBean> findAll();
    List<Object[]> viewPassengers();
	
	List<PassengerBean> viewPassengersByName(String id);
	
}
