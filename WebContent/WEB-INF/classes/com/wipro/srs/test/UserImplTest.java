/*
 *
 * File Name         : UserImplTest.java
 *
 * Short Description : This file is used to get/set Creditional Details.
 *
 * Version Number    : 1.0
 *
 * Created Date      : May 8, 2015
 *
 */


package com.wipro.srs.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;





import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.util.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/dispatcher-servlet.xml" })
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
/**
*
* @author Rajesh Kumar
* @version 1.0,May 10,2015
* @since 1.0
*/

public class UserImplTest {

	@Autowired
	private User user;
	/**
	 * Test method for
	 * {@link com.wipro.srs.util.UserImpl#login(com.wipro.srs.bean.CredentialsBean)}
	 * .
	 */
	@Test
	public void testLogin() {
		  CredentialsBean credentials = new CredentialsBean();
		// TestCase-1 with valid admin Credentials
		credentials.setUserID("KA1002");
		credentials.setPassword("abcd12");
		String actual = user.login(credentials);
		assertEquals("INVALID", actual);
		// TestCase-2 with valid customer Credentials
		credentials.setUserID("SM1043");
		credentials.setPassword("abcd12345");
		actual = user.login(credentials);
		assertEquals("INVALID", actual);
		// TestCase-3 with Invalid Credentials
		credentials.setUserID("ab");
		credentials.setPassword("abcdefg");
	     actual = user.login(credentials);
		assertEquals("INVALID", actual);
		// TestCase-4 with null
		actual = user.login(null);
		assertEquals("INVALID", actual);
	}
	/**
	 * Test method for
	 * {@link com.wipro.srs.util.UserImpl#logout(java.lang.String)}.
	 */
	@Test
	public void testLogout() {
		CredentialsBean credentials = new CredentialsBean();
		Boolean actual = user.logout("KA1002");
		assertEquals(false,actual);
		actual = user.logout(null);
		assertFalse(actual);
	}
	/**
	 * Test method for
	 * {@link com.wipro.srs.util.UserImpl#changePassword(com.wipro.srs.bean.CredentialsBean, java.lang.String)}
	 * .
	 */
	
	/**
	 * Test method for
	 * {@link com.wipro.srs.util.UserImpl#register(com.wipro.srs.bean.ProfileBean)}
	 * .
	 */
	@Test
	public void testRegister() {
		final ProfileBean profile = new ProfileBean();
		profile.setFirstName("anushka");
		profile.setLastName("SHARMA");
		profile.setCity("new Delhi");
		profile.setDateOfBirth(new Date());
		profile.setGender("female");
		profile.setLocation("hyderabad");
		profile.setMobileNo("98762345");
		profile.setPincode("251001");
		profile.setEmailID("anshka@gmail.com");
		profile.setState("u.p");
		profile.setStreet("ndscxjh");
		profile.setPassword("wipro");
		String actual = user.register(profile);
		assertEquals("SUCCESS", actual);
		// test-2 for null values
		actual = user.register(null);
		assertEquals("Faliure", actual);
	}
}
