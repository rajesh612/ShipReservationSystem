/* 
 *
 * File Name         : PassengerBean.java
 *
 * Short Description : This file is used to get/set passenger Details.
 *
 * Version Number    : 1.0 

 *
 */
package com.wipro.srs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


/**
 * This class is used to get/set login details.
 *
 * @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */
@Entity
@Table(name = "SRS_TBL_User_Passenger")
public class PassengerBean {
	@Id
	@Column(name = "ReservationID", length = 8, nullable = true)
	private String reservationID;
	@Column(name = "ScheduleID", length = 8, nullable = true)
	private String scheduleID;
	@Column(name = "Name", length = 20, nullable = false)
	private String name;
	@Column(name = "Age", length = 6, nullable = false)
	private int age;
	@Column(name = "Gender", length = 6, nullable = false)
	private String gender;
	/**
	 * @return the reservationID
	 */
	public String getReservationID() {
		return reservationID;
	}
	/**
	 * @param reservationID the reservationID to set
	 */
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	/**
	 * @return the scheduleID
	 */
	public String getScheduleID() {
		return scheduleID;
	}
	/**
	 * @param scheduleID the scheduleID to set
	 */
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
