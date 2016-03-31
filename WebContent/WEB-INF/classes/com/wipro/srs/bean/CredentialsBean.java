/*
 *
 * File Name         : CredentialsBean
 *
 * Short Description : This file is used to get/set Credential Details.
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
import javax.persistence.Transient;


/**
 * This class is used to get/set login details.
 *
 * @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */
@Entity
@Table(name = "SRS_TBL_User_Credentials1")
public class CredentialsBean {

	@Id
	@OneToMany
	@JoinColumn(name = "userID")
	private String userID;
	@Column(name = "Password", length = 20, nullable = false)
	private String password;
	@Column(name = "Usertype", length = 15, nullable = false)
	private String userType;
	@Column(name = "Loginstatus", length = 1, nullable = false)
	private int loginStatus;
	
	/**
	 * 
	 * @return npassword returns a new password.
	 */
	@Transient
	private String npassword;
	public String getNpassword() {
		return npassword;
	}
	/**
	 * 
	 * @param npassword value is set
	 */
	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}
	
	/**
	 * 
	 * @return userID returns the userID.
	 */
	public String getUserID() {
		return userID;
	}
	
	/**
	 * 
	 * @param userID value is set
	 */
	public void setUserID(final String userID) {
		this.userID = userID;
	}
	
	/**
	 * 
	 * @return password returns password.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @param password value is set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @return userType returns the user type.
	 */
	public String getUserType() {
		return userType;
	}
	
	/**
	 * 
	 * @param userType value is set
	 */
	public void setUserType(final String userType) {
		this.userType = userType;
	}
	
	/**
	 * 
	 * @return loginStatus returns login status.
	 */
	public int getLoginStatus() {
		return loginStatus;
	}
	
	/**
	 * 
	 * @param loginStatus value is set
	 */
	
	public void setLoginStatus(final int loginStatus) {
		this.loginStatus = loginStatus;
	}
	public CredentialsBean findByID(final String userID2) {
		return null;
	}
}
