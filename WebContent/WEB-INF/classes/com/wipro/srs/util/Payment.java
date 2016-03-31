/* 
 *
 * File Name         : Payment.java
 *
 * Short Description : This file is used to get/set Payment Details.
 *
 * Version Number    : 1.0 
 *
 * Created Date      : May 4, 2015
 *
 */
package com.wipro.srs.util;

/**
*
* @author Rajesh Kumar
* @version 1.0,May 10,2015
* @since 1.0
*/

public interface Payment {
	String creditCardNumber=null, validFrom=null, validTo=null;
	int balance=0;
	/**
	 * @param userid
	 * @param cardnumber
	 * @return
	 */
	Boolean findByCardNumber(String userid, String cardnumber) ;
	/**
	 * @param payment
	 * @return
	 */
	String process(Payment payment);
}
