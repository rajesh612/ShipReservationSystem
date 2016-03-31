/* 
 *
 * File Name         : ScheduleBean
 *
 * Short Description : This file is used to get/set Schedule Details.
 *
 * Version Number    : 1.0 
 */

package com.wipro.srs.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



/**
 *This class is used to get/set schedule details.
 * @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */
@Entity
@Table(name = "SRS_TBL_Schedule1")
public class ScheduleBean {
	@Id
	@OneToMany
	@JoinColumn(name = "scheduleID")
	private  String scheduleID;
	@Column(name = "shipID", length = 30, nullable = false)
	private String shipID;
	@Column(name = "routeID", length = 30, nullable = false)
	private  String routeID;
	@Column(name = "startDate", length = 30)
	private Date startDate;
	
	/**
	 * 
	 * @return scheduleID
	 */

	public String getScheduleID() {
		return scheduleID;
	}
	

	/**
	 * 
	 * @param scheduleID is set
	 */

	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}

	
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
	 * @return routeID
	 */
	public String getRouteID() {
		return routeID;
	}

	
	/**
	 * 
	 * @param routeID is set
	 */
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	
	/**
	 * 
	 * @return startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	
	/**
	 * 
	 * @param startDate is set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
}
