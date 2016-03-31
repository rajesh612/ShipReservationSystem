/**
 * 
 */
package com.wipro.srs.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.service.Administrator;

/**
*
* @author Rajesh Kumar
* @version 1.0,May 10,2015
* @since 1.0
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/dispatcher-servlet.xml" })
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class AdministratorTest {
	@Autowired
	private Administrator admin;
	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#addShip(com.wipro.srs.bean.ShipBean)}.
	 */
	@Test
	public void testAddShip() {
		final ShipBean ship = new ShipBean();
		// Test-1 for valid case
		ship.setShipName("MWR SHIP DETAILS");
		String actual = admin.addShip(ship);
		assertEquals("SUCCESS", actual);
		// Test-2 for null ship name
		ship.setShipName(null);
		actual = admin.addShip(null);
		assertEquals("INVALID", actual);
		// TEST-3 for null bean
				ship.setShipName("IN TRAVELS");
				actual = admin.addShip(null);
				assertEquals("INVALID", actual);
				// TEST-4 for empty bean
				ship.setShipName("IN TRAVELS");
				actual = admin.addShip(new ShipBean());
				assertEquals("INVALID", actual);
				// TEST-5 for both null
				ship.setShipName(null);
				actual = admin.addShip(null);
				assertEquals("INVALID", actual);
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#modifyShip(com.wipro.srs.bean.ShipBean)}.
	 */
	@Test
	public void testModifyShip() {
		final ShipBean ship = new ShipBean();
		// test-1 for valid case
		ship.setShipID("MW1020");
		ship.setShipName("MW SHIPS");
		boolean actual = admin.modifyShip(ship);
		assertEquals(true, actual);
		// test-2 for null bean
		actual = admin.modifyShip(null);
		assertEquals(false, actual);
		// test-3 for empty bean
		actual = admin.modifyShip(new ShipBean());
		assertEquals(false, actual);
		
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#removeShip(java.util.List)}.
	 */
	@Test
	public void testRemoveShip() {
		List<String> sid = new ArrayList<String>();
		sid.add("MY1126");
	// Test-1 for valid user
	int actual = admin.removeShip(sid);
	assertEquals(0, actual);
	 //Test-2 for null value
	//ship.setShipID(null);
	 List<String> sid2 = new ArrayList<String>();
		sid2.add("cfg");
	actual = admin.removeShip(sid2);
	assertEquals(0, actual);
		
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#addSchedule(com.wipro.srs.bean.ScheduleBean)}.
	 */
	@Test
	public void testAddSchedule() {
		final ScheduleBean schedule = new ScheduleBean();
		// Test-Case 1 for valid case
		schedule.setShipID("MW1020");
		schedule.setRouteID("SO1045");
		String actual = admin.addSchedule(schedule);
		assertEquals("SUCCESS", actual);
		// Test-case 2 for null source
		schedule.setShipID(null);
		schedule.setRouteID(null);
		actual = admin.addSchedule(schedule);
		assertEquals("INVALID", actual);

	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#modifySchedule(com.wipro.srs.bean.ScheduleBean)}.
	 */
	@Test
	public void testModifySchedule() {
		final ScheduleBean schedule = new ScheduleBean();
		// Test-1 for valid case
		schedule.setScheduleID("INGU1062");
		schedule.setShipID("IN1064");
		schedule.setRouteID("GU1040");
boolean actual = admin.modifySchedule(schedule);
		assertEquals(true, actual);
		// Test-2 for empty bean
				actual = admin.modifySchedule(null);
				assertEquals(false, actual);
				// Test-3 for null bean
				actual = admin.modifySchedule(new ScheduleBean());
				assertEquals(false, actual);
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#removeSchedule(java.util.List)}.
	 */
	@Test
	public void testRemoveSchedule() {
		List<String> sid = new ArrayList<String>();
		sid.add("MYAU1060");
		List<String> sid2 = new ArrayList<String>();
		sid2.add("fdh");
	
		// Test-1 for valid user
		int actual = admin.removeSchedule(sid);
		assertEquals(0, actual);
		// Test-2 for null value
		
		actual = admin.removeSchedule(sid2);
		assertEquals(0, actual);
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#addRoute(com.wipro.srs.bean.RouteBean)}.
	 */
	@Test
	public void testAddRoute() {
		final RouteBean route = new RouteBean();
		// Test-1 for valid case
		route.setSource("Australia");
		route.setDestination("USA");
		String actual = admin.addRoute(route);
		assertEquals("SUCCESS", actual);
		// Test-case 2 for null source
		route.setSource(null);
		route.setDestination(null);
		actual = admin.addRoute(route);
		assertEquals("INVALID", actual);
		// test-3 for empty bean
		actual = admin.addRoute(new RouteBean());
		assertEquals("INVALID", actual);
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#modifyRoute(com.wipro.srs.bean.RouteBean)}.
	 */
	@Test
	public void testModifyRoute() {
		final RouteBean route = new RouteBean();
		route.setRouteID("AU1127");
		route.setSource("Chennai");
		// test-1 for valid case
		boolean actual = admin.modifyRoute(route);
		assertEquals(true, actual);
		// test-2 for null bean
		actual = admin.modifyRoute(null);
		assertEquals(false, actual);
		// test-3 for empty bean
		actual = admin.modifyRoute(new RouteBean());
		assertEquals(false, actual);
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#removeRoute(java.util.List)}.
	 */
	@Test
	public void testRemoveRoute() {
		final RouteBean route = new RouteBean();
		List<String> rlist = new ArrayList<String>();
		rlist.add("AU1127");
		List<String> rlist1 = new ArrayList<String>();
		rlist1.add("fdh");
		// Test-1 for valid user
		int actual = admin.removeRoute(rlist);
		assertEquals(0, actual);
		// Test-2 for null value
		route.setRouteID(null);
		actual = admin.removeRoute(rlist1);
		assertEquals(0, actual);
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#viewByShipId(java.lang.String)}.
	 */
	@Test
	public void testViewByShipId() {
		final ShipBean ship = admin.viewByShipId(null);
		assertEquals(null, ship);
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#viewByRouteId(java.lang.String)}.
	 */
	@Test
	public void testViewByRouteId() {
		final RouteBean route = admin.viewByRouteId(null);
		assertEquals(null, route);
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#viewByAllShips()}.
	 */
	@Test
	public void testViewByAllShips() {
		List<ShipBean> view = new ArrayList<ShipBean>();
		view = admin.viewByAllShips();
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#viewByAllRoute()}.
	 */
	@Test
	public void testViewByAllRoute() {
		List<RouteBean> view = new ArrayList<RouteBean>();
		view = admin.viewByAllRoute();
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#viewByAllSchedule()}.
	 */
	@Test
	public void testViewByAllSchedule() {
		List<ScheduleBean> view = new ArrayList<ScheduleBean>();
		view = admin.viewByAllSchedule();
	}

	/**
	 * Test method for {@link com.wipro.srs.service.AdministratorImpl#viewByScheduleId(java.lang.String)}.
	 */
	@Test
	public void testViewByScheduleId() {
		final ScheduleBean schedulebean = admin.viewByScheduleId(null);
		assertEquals(null, schedulebean);
	}



}
