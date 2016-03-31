/* 
 *
 * File Name         : PaymentImpl.java
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

public class PaymentImpl implements Payment {

	/* (non-Javadoc)
	 * @see com.wipro.srs.util.Payment#findByCardNumber(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean findByCardNumber(String userid, String cardnumber) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wipro.srs.util.Payment#process(com.wipro.srs.util.Payment)
	 */
	@Override
	public String process(Payment payment) {
		return null;
	}

}
