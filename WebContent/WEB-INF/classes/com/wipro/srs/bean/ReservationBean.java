/* 
 *
 * File Name         : ReservationBean
 *
 * Short Description : This file is used to get/set Reservation Details.
 *
 * Version Number    : 1.0 
 *
 
 *
 */

package com.wipro.srs.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;



/**
 *This class is used to get/set reservation details.
 * @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */
@Entity
@Table(name = "SRS_TBL_User_Reservation")
public class ReservationBean {
	@Id
	@Column(name = "reservationID", length = 8)
	private String reservationID;
	@Column(name = "Scheduleid", length = 8, nullable = false)
	private String scheduleID;
	@Column(name = "Userid", length = 6, nullable = false)
	private String userID;
	@Column(name = "Bookingdate", length = 20, nullable = false)
	private Date bookingDate;
	@Column(name = "Journeydate", length = 20, nullable = false)
	private Date journeyDate;
	@Column(name = "Noofseats", length = 20, nullable = false)
	private int noOfSeats;
	@Column(name = "Totalfare", length = 20, nullable = true)
	private double totalFare;
	@Column(name = "Bookingstatus", length = 20, nullable = true)
	private String bookingStatus;
	

	
	/**
	 * 
	 * @return reservationID
	 */
	public String getReservationID() {
		return reservationID;
	}


	/**
	 * 
	 * @param reservationID is set
	 */
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
   
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
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}

	
	/**
	 * 
	 * @param userID is set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * 
	 * @return bookingDate
	 */
	
	public Date getBookingDate() {
		return bookingDate;
	}

	
	/**
	 * 
	 * @param bookingDate is set
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	
	/**
	 * 
	 * @return journeyDate
	 */
	public Date getJourneyDate() {
		return journeyDate;
	}


	/**
	 * 
	 * @param journeyDate is set
	 */
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	/**
	 * 
	 * @return noOfSeats
	 */
	
	public int getNoOfSeats() {
		return noOfSeats;
	}

	
	/**
	 * 
	 * @param noOfSeats is set
	 */
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	
	/**
	 * 
	 * @return totalFare
	 */
	public double getTotalFare() {
		return totalFare;
	}

	
	/**
	 * 
	 * @param totalFare is set
	 */
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	
	/**
	 * 
	 * @return bookingStatus
	 */
	public String getBookingStatus() {
		return bookingStatus;
	}

	
	/**
	 * 
	 * @param bookingStatus is set
	 */
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


}
