/* 
 *
 * File Name         : ShipBean
 *
 * Short Description : This file is used to get/set Ship Details.
 *
 * Version Number    : 1.0 
 *
 */

package com.wipro.srs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



/**
 *This class is used to get/set ship details.
 * @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */
@Entity
@Table(name="SRS_TBL_Ship")
public class ShipBean {
	@Id
	private String shipID;
	@Column(name="shipName",length=30)
	private String shipName;
	@Column(name="seatingCapacity",length=10)
	private int seatingCapacity;
	@Column(name="reservationCapacity",length=10)
	private int reservationCapacity;
	


	/**
	 * 
	 * @return shipID
	 */
	public String getShipID() {
		return shipID;
	}

	
	/**
	 * 
	 * @param shipID is set
	 */
	public void setShipID(String shipID) {
		this.shipID = shipID;
	}

	/**
	 * 
	 * @return shipName
	 */
	
	public String getShipName() {
		return shipName;
	}

	/**
	 * 
	 * @param shipName is set
	 */
	
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	
	/**
	 * 
	 * @return seatingCapacity
	 */
	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	
	/**
	 * 
	 * @param seatingCapacity is set
	 */
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	/**
	 * 
	 * @return reservationCapacity
	 */
	
	public int getReservationCapacity() {
		return reservationCapacity;
	}
	
	

	/**
	 * 
	 * @param reservationCapacity is set
	 */
	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}
	
	
	
}
