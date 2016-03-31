/* 
 *
 * File Name         : RouteBean.java
 *
 * Short Description : This file is used to get/set route Details.
 *
 * Version Number    : 1.0 
 *
 
 *
 */
package com.wipro.srs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *This class is used to get/set route details.
 * @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */
@Entity
@Table(name = "SRS_TBL_Route")
public class RouteBean {
	@Id
	@OneToMany
	@JoinColumn(name = "routeID")
private String routeID;
	@Column(name = "source", length = 30, nullable = false)
private String source;
	@Column(name = "destination", length = 30, nullable = false)
	private String destination;
	@Column(name = "travelDuration", length = 20, nullable = false)
	private String travelDuration;
	@Column(name = "fare", length = 20, nullable = false)
	private double fare;

	/**
	 * @return the routeID
	 */
	public String getRouteID() {
		return routeID;
	}

	/**
	 * @param routeID the routeID to set
	 */
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the travelDuration
	 */
	public String getTravelDuration() {
		return travelDuration;
	}

	/**
	 * @param travelDuration the travelDuration to set
	 */
	public void setTravelDuration(String travelDuration) {
		this.travelDuration = travelDuration;
	}

	/**
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	
	
}
