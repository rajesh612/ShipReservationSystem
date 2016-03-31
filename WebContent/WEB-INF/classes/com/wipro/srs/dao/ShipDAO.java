/* 
 *
 * File Name         : ShipDAO.java
 *
 * Short Description : This file is used to get/set Ship Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
package com.wipro.srs.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wipro.srs.bean.ShipBean;

/**
*
* @author Rajesh Kumar
 * @version 1.0,May 8,2015
 * @since 1.0*/
public interface ShipDAO {
	/**
	 * This is used to perform createShip functionality.
	 * 
	 * @param ship
	 *            to get the ship details.
	 * @return String as "SUCCESS"/"INVALID".
	 */
	String createShip(ShipBean ship);

	/**
	 * This is used to perform deleteShip functionality.
	 * 
	 * @param shipID
	 *            to get the ship id.
	 * @return an integer value.
	 */


	/**
	 * This is used to perform updateShip functionality.
	 * 
	 * @param ship
	 *            to get the ship details.
	 * @return a boolean value.
	 */
	boolean updateShip(ShipBean ship);

	/**
	 * This is used to perform findByID functionality.
	 * 
	 * @param shipID
	 *            to get the shipID.
	 * @return an object of type ShipBean.
	 */
	ShipBean findByID(String shipID);

	/**
	 * This is used to perform list shipbean functionality.
	 * 
	 * @return a list of type ShipBean.
	 */
	List<ShipBean> findAll();

	/**
	 * This method is used to generate the sequence.
	 * 
	 * @return a sequence of type BigDecimal.
	 */
	public BigDecimal findById();

	/**
	 * This method is used to perform findAllIds functionality.
	 * 
	 * @return a list of type String.
	 */
	List<String> findByAllIds();

	/**
	 * This method is used to perform findShipId functionality.
	 * 
	 * @param shipID
	 *            used to get the shipID.
	 * @return an object of type ShipBean.
	 */
	ShipBean findShipId(String shipID);

	int deleteShip(List<String> list);


}
