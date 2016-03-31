/* 
 *
 * File Name         : ReservationDAO.java
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

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.ShipBean;

/**
*
* @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
*/
public interface ReservationDAO {
	/**
	 * This is used to perform createReservation functionality.
	 * @param reservation
	 *    			Is used to get the reservation details.
	 * @return
	 * 		String value.
	 */
	String createReservation(ReservationBean reservation) ;
	/**
	 * This is used to perform deleteReservation functionality.
	 * @param reservationID
	 * 			Is used to get the reservationID.
	 * @return
	 * 			integer value.
	 */
	
	/**
	 * This is used to perform updateReservation functionality.
	 * @param reservation
	 * 			Is used to get the reservation details.
	 * @return
	 * 			Boolean value.
	 */
	boolean updateReservation(ReservationBean reservation);
	/**
	 * This is used to perform findbyID functionality.
	 * @param reservationID
	 * 			Is used to find the details by reservationID.
	 * @return
	 * 		object of type ReservationBean.
	 */
	
	/**
	 * This is used to perform findAll functionality.
	 * @return
	 * 		ReservationBean list.	
	 */
	
	BigDecimal findByID();
	ReservationBean findByResID(String reservationID);
	
	
	List<ReservationBean> findAll(String userid);
	String deleteReservation(ReservationBean reservation);
	
	

}
