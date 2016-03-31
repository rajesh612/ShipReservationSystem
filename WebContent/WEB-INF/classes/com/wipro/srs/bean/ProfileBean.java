/*
 *
 * File Name         : ProfileBean
 *
 * Short Description : This file is used to get/set Profile Details.
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * This class is used to get/set registration details.
 *
 * @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */
@Entity
@Table(name = "SRS_TBL_User_Profile1")
public class ProfileBean {
	@Id
	@Size(min=4, max=12)
	@Column(name = "userID", length = 12, nullable = false)
	private String userID;
	@NotEmpty(message="enter the first name")
	@Column(name = "firstName", length = 20, nullable = false)
	private String firstName;
	@NotEmpty(message="enter the last name")
	@Column(name = "lastName", length = 20, nullable = false)
	private String lastName;
	@Column(name = "DateOfBirth", nullable = false)
	private Date DateOfBirth;
	@NotEmpty(message="enter the gender")
	@Column(name = "gender", length = 7, nullable = false)
	private String gender;
	@NotEmpty(message="enter the street name")
	@Column(name = "street", length = 30, nullable = false)
	private String street;
	@NotEmpty(message="enter the location")
	@Column(name = "location", length = 20, nullable = false)
	private String location;
	@NotEmpty(message="enter the city name")
	@Column(name = "city", length = 20, nullable = false)
	private String city;
	@NotEmpty(message="enter the state")
	@Column(name = "state", length = 20, nullable = false)
	private String state;
	@Pattern(regexp="(^$|[0-9]{6})",message="invalid")
	@NotNull(message = "cannot be null")
	@Size(min=1, max=100000)
	@Column(name = "pincode", length = 20)
	private String pincode;
	@Pattern(regexp="(^$|[0-9]{10})",message="invalid")
	@NotEmpty(message="enter the mobile number")
	@Column(name = "mobileNo", length = 10, nullable = false)
	private String mobileNo;
	@Email
	@Column(name = "emailID", length = 40, nullable = false)
	private String emailID;
	@Transient
	 @Size(min=6, max=12)
	private String Password;
	@Transient
	 @Size(min=6, max=12)
	private String ConfirmPassword;
	
	
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
	public void setUserID(final String userID) {
		this.userID = userID;
	}
	
	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * 
	 * @param firstName is set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * 
	 * @param lastName is set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * 
	 * @return dateOfBirth
	 */
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	
	/**
	 * 
	 * @param dateOfBirth is set
	 */
	public void setDateOfBirth(final Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	/**
	 * 
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * 
	 * @param gender is set
	 */
	public void setGender(final String gender) {
		this.gender = gender;
	}
	

	/**
	 * 
	 * @return street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * 
	 * @param street is set
	 */
	public void setStreet(final String street) {
		this.street = street;
	}
	
	/**
	 * 
	 * @return location
	 */
	public String getLocation() {
		return location;
	}
	

	/**
	 * 
	 * @param location is set
	 */
	public void setLocation(final String location) {
		this.location = location;
	}
	
	/**
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * 
	 * @param city is set
	 */
	public void setCity(final String city) {
		this.city = city;
	}
	
	/**
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * 
	 * @param state is set
	 */
	public void setState(final String state) {
		this.state = state;
	}
	
	/**
	 * 
	 * @return pincode
	 */
	public String getPincode() {
		return pincode;
	}
	

	/**
	 * 
	 * @param pincode is set
	 */
	public void setPincode(final String pincode) {
		this.pincode = pincode;
	}
	
	/**
	 * 
	 * @return mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	
	/**
	 * 
	 * @param mobileNo is set
	 */
	public void setMobileNo(final String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	/**
	 * 
	 * @return emailID
	 */
	public String getEmailID() {
		return emailID;
	}
	
	/**
	 * 
	 * @param emailID is set
	 */
	public void setEmailID(final String emailID) {
		this.emailID = emailID;
	}
	/**
	 * @return password
	 */
	
	public String getPassword() {
		return Password;
	}
	
	/**
	 * @param password 
	 */
	public void setPassword(final String password) {
		Password = password;
	}
}
