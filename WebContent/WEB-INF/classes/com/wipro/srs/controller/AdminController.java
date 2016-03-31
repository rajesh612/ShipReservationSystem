/* 
 * File Name: AdminController.java
 *
 * Short Description: This file is used as ShipController.java  details.
 * 
 * Version Number: 0.1 
 *
 * Created Date: April 25, 2015
 */

package com.wipro.srs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.poi.hssf.record.formula.functions.Today;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.dao.ShipDAO;
import com.wipro.srs.service.Administrator;
/**
 *
 * @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */

@Controller
public class AdminController {

	@Autowired
	private Administrator admin;
	@Autowired
	private ShipDAO shipDAO;

	/**
	 * This method is used to perform the addShip functionality.
	 * 
	 * @param model
	 *            represents the data that will be passed to and from an
	 *            operation and the view.
	 * 
	 * @return a view name ShipAdd.
	 */

	@RequestMapping(value = "addShip1.htm", method = RequestMethod.GET)
	public String viewShip(final Model model) {
		model.addAttribute("ship", new ShipBean());
		System.out.println("after creating ship bean");
		return "ShipAdd";
	}

	/**
	 * This method is used to perform the addShip functionality.
	 * 
	 * @param Ship
	 *            is used as the command object that would be bound with the
	 *            HTTP request data.
	 * @param res2
	 *            is used to bind with the bean variable.
	 * @param ship
	 *            object of class ShipBean.
	 * @return an object of type ModelAndView.
	 */
	@RequestMapping(value = "addShip.htm", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("Ship") final ShipBean ship,
			final BindingResult res2) {
		if (res2.hasErrors()) {
			return new ModelAndView("ShipAdd");
		} else {
			ModelAndView res = null;
			String res1 = admin.addShip(ship);
			if (!"INVALID".equals(res1) && !"Ship already exists".equals(res1)) {
				res = new ModelAndView("Success", "MSG",
						"Ship Registered successfully with Ship ID:"
								+ ship.getShipID() + "!!");
			} else {
				res = new ModelAndView("Failure", "MSG",
						"Ship Registration unsuccessful as Ship already exists");
			}
			return res;
		}
	}

	/**
	 * This method is used to perform the viewShip functionality.
	 * 
	 * @return an object of type ModelAndView.
	 */
	@RequestMapping(value = "ViewShips.htm", method = RequestMethod.GET)
	public ModelAndView viewAllShips() {
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("ViewShip", admin.viewByAllShips());
		return new ModelAndView("ViewShips", map);
	}

	/**
	 * This method is used to perform the DeleteShip functionality.
	 * 
	 * @param ship
	 *            is used as the command object that would be bound with the
	 *            HTTP request data.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @param ship
	 *            object of class ShipBean.
	 * @return an ModelAndView.
	 */
	@RequestMapping(value = "DeleteShip.htm")
	public ModelAndView deleteShip(@ModelAttribute("ship") final ShipBean ship,
			final HttpSession session) {
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("Shiplist", shipDAO.findByAllIds());
		map.put("Ship", admin.viewByShipId(ship.getShipID()));
		session.setAttribute("shipID", ship.getShipID());
		return new ModelAndView("DeleteShip", "map", map);
	}

	/**
	 * This method is used to perform the DeleteShip functionality.
	 * 
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "DeleteShip1.htm", method = RequestMethod.POST)
	public ModelAndView deleteShipById(
			@ModelAttribute("ship") final ShipBean ship,
			final HttpSession session) {
		final String s1 = (String) session.getAttribute("shipID");
		final List<String> sid = new ArrayList<String>();
		sid.add(s1);
		final int remove = admin.removeShip(sid);
		if (remove == 1) {
			return new ModelAndView("Success", "MSG",
					"Ship deleted successfully!!");
		} else {
			return new ModelAndView("Failure", "MSG",
					"Ship cannot be deleted!!");
		}
	}

	/**
	 * This method is used to perform the ModifyShip functionality.
	 * 
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @param ship
	 *            object of class ShipBean.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "ModifyShip.htm")
	public ModelAndView viewModifyShip(
			@ModelAttribute("ship") final ShipBean ship,
			final HttpSession session) {
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("Shiplist", shipDAO.findByAllIds());
		map.put("Ship", admin.viewByShipId(ship.getShipID()));
		session.setAttribute("shipID", ship.getShipID());
		return new ModelAndView("ModifyShip", "map", map);
	}

	/**
	 * This method is used to perform the ModifyShip functionality.
	 * 
	 * @param ship
	 *            used as a reference for ShipBean.
	 * @return an object of type ModelAndView.
	 * @param result2
	 *            used as a binding variable.
	 */

	@RequestMapping(value = "ModifyShip1.htm")
	public ModelAndView modifyDetails(
			@Valid @ModelAttribute("ship") final ShipBean ship,
			final BindingResult result2) {
		if (result2.hasErrors()) {
			return new ModelAndView("ModifyShip");
		} else {
			boolean value = true;
			if (ship instanceof ShipBean) {
				value = admin.modifyShip(ship);
				if (value) {
					return new ModelAndView("Success", "MSG",
							"Ship details are successfully modified");
				} else {
					return new ModelAndView("Failure", "MSG",
							"Ship details could not be modified as values already exist");
				}
			}
			return new ModelAndView("Failure", "MSG",
					"Ship details could not be modified");
		}
	}

	/**
	 * This method is used to perform add Route functionality.
	 * 
	 * @param model
	 *            represents the data that will be passed to and from an
	 *            operation and the view.
	 * @return ModelView.
	 */
	@RequestMapping(value = "AddRoute", method = RequestMethod.GET)
	public String viewroute(final Model model) {
		model.addAttribute("route", new RouteBean());
		return "RouteAdd";
	}

	/**
	 * This method is used to perform add Route functionality.
	 * 
	 * @param route
	 *            This parameter is used as a reference to RouteBean.
	 * @param result2
	 *            used as a binding variable.
	 * @return an object of type ModelView.
	 */
	@RequestMapping(value = "ARoute", method = RequestMethod.POST)
	public ModelAndView register(
			@Valid @ModelAttribute("route") final RouteBean route,
			final BindingResult result2) {
		if (result2.hasErrors()) {
			return new ModelAndView("RouteAdd");
		} else {
			ModelAndView result1 = null;
			String res = admin.addRoute(route);
			if (!"INVALID".equals(res) && !"Route already exists".equals(res)) {
				result1 = new ModelAndView("Success", "MSG",
						"Route Registered successfully with Route ID:"
								+ route.getRouteID() + "!!");
			}
			
			else {
				result1 = new ModelAndView("Failure", "MSG",
						"Route Registration unsuccessful as route already exists");
			}
			return result1;
		}
	}

	/**
	 * This method is used to perform ViewRoute functionality.
	 * 
	 * @return ModelView.
	 */
	@RequestMapping(value = "ViewRoute", method = RequestMethod.GET)
	public ModelAndView viewAllRoute() {
		final Map<String, Object> map = new HashMap<String, Object>();
		// map.put("flight", new FlightBean());
		map.put("ViewRoute", admin.viewByAllRoute());
		return new ModelAndView("ViewRoute", map);
	}

	/**
	 * This method is used to perform ModifyRoute functionality.
	 * 
	 * @param route
	 *            This parameter is used as a reference to RouteBean.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return ModelView.
	 */
	@RequestMapping(value = "ModifyRoute.htm")
	public ModelAndView viewModifyRoute(
			@ModelAttribute("route") final RouteBean route,
			final HttpSession session) {
		System.out.println("in modify route");
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("routelist", admin.findByAllRouteId());
		map.put("route", admin.viewByRouteId(route.getRouteID()));
		System.out.println("in Modify route" + route.getRouteID());
		session.setAttribute("routeID", route.getRouteID());
		return new ModelAndView("ModifyRoute", "map", map);
	}

	/**
	 * This method is used to perform ModifyRoute functionality.
	 * 
	 * @param route
	 *            This parameter is used as a reference to RouteBean.
	 * @param result2
	 *            This parameter is used as a binding variable.
	 * @return Returns ModelAndView.
	 */
	@RequestMapping(value = "ModifyRoute1.htm")
	public ModelAndView modifyRouteDetails(
			@Valid @ModelAttribute("route") final RouteBean route,
			final BindingResult result2) {
		if (result2.hasErrors()) {
			return new ModelAndView("ModifyRoute");
		} else {
			boolean value = true;
			if (route instanceof RouteBean) {
				value = admin.modifyRoute(route);
				if (value) {
					return new ModelAndView("Success", "MSG",
							"Route details are successfully modified");
				} else {
					return new ModelAndView("Failure", "MSG",
							"Route details could not be modified");
				}
			}
			return new ModelAndView("Failure", "MSG",
					"Route details could not be modified");
		}
	}

	/**
	 * This method is used to perform DeleteRoute functionality.
	 * 
	 * @param route
	 *            This parameter is used as a reference to RouteBean.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return Returns ModelAndView.
	 */
	@RequestMapping(value = "DeleteRoute.htm")
	public ModelAndView deleteRoute(
			@ModelAttribute("route") final RouteBean route,
			final HttpSession session) {
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("routelist", admin.findByAllRouteId());
		map.put("route", admin.viewByRouteId(route.getRouteID()));
		System.out.println("in deleteroute" + route.getRouteID());
		session.setAttribute("routeID", route.getRouteID());
		return new ModelAndView("DeleteRoute", "map", map);
	}

	/**
	 * This method is used to perform DeleteRoute functionality.
	 * 
	 * @param route
	 *            This parameter is used as a reference to RouteBean.
	 * @param session
	 *            is used as an object of Http Session to maintain the session..
	 * @return Returns ModelAndView.
	 */
	@RequestMapping(value = "DeleteRoute1.htm", method = RequestMethod.GET)
	public ModelAndView deleteRouteById(
			@ModelAttribute("route") final RouteBean route,
			final HttpSession session) {
		// ModelAndView result1 = null;
		final String val = (String) session.getAttribute("routeID");
		final List<String> rid = new ArrayList<String>();
		rid.add(val);
		final int remove = admin.removeRoute(rid);
		if (remove == 1) {
			return new ModelAndView("Success", "MSG",
					"Route deleted successfully!!");
		} else {
			return new ModelAndView("Failure", "MSG",
					"Route cannot be deleted!!");
		}
	}

	/**
	 * This method is used to perform AddSchedule functionality.
	 * 
	 * @param schedule
	 *            This parameter is used as a reference to ScheduleBean.
	 * @param result2
	 *            This parameter is used as a binding variable.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return Returns ModelAndView.
	 */
	@RequestMapping(value = "AddSchedule.htm", method = RequestMethod.GET)
	public ModelAndView view(
			@Valid @ModelAttribute("schedule") final ScheduleBean schedule) {
		final Map<String, Object> map = new HashMap<String, Object>();
		// map.put("ship", new ShipBean());
		map.put("viewShip", admin.findByAllShipId());
		map.put("viewRoute", admin.findByAllRouteId());
		map.put("schedule", new ScheduleBean());
		return new ModelAndView("ScheduleAdd", "map", map);
	}

	/**
	 * This method is used to perform AddSchedule functionality.
	 * 
	 * @param schedule
	 *            This parameter is used as a reference to ScheduleBean.
	 * @param result2
	 *            This parameter is used as a binding variable.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return Returns ModelAndView.
	 */
	@RequestMapping(value = "scheduleAdd.htm", method = RequestMethod.POST)
	public ModelAndView viewschedule(
			@Valid @ModelAttribute("schedule") final ScheduleBean schedule,
			final BindingResult result2) {
		if (result2.hasErrors()) {
			return new ModelAndView("ScheduleAdd");
		} else {
			ModelAndView result1 = null;
			String res = admin.addSchedule(schedule);
			if (!res.equals("INVALID")
					&& !res.equals("Schedule already exists")) {
				result1 = new ModelAndView("Success", "MSG",
						"Schedule Registered successfully with Schedule ID:"
								+ schedule.getScheduleID() + "!!");
			} else {
				result1 = new ModelAndView("Failure", "MSG",
						"Schedule Registration unsuccessful as schedule already exists");
			}
			return result1;
		}
	}

	/**
	 * This method is used to perform ViewSchedule functionality.
	 * 
	 * @return Returns ModelAndView.
	 */
	@RequestMapping(value = "ViewSchedule", method = RequestMethod.GET)
	public ModelAndView viewAllSchedule() {
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("ViewSchedule", admin.viewByAllSchedule());
		return new ModelAndView("ViewSchedule", map);
	}

	/**
	 * This method is used to perform ModifySchedule functionality.
	 * 
	 * @param schedule
	 *            This parameter is used as a reference to ScheduleBean.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return Returns ModelAndView.
	 */
	@RequestMapping(value = "ModifySchedule.htm")
	public ModelAndView viewModifySchedule(
			@ModelAttribute("schedule") final ScheduleBean schedule) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("schedulelist", admin.findByAllScheduleId());
		map.put("routelist", admin.findByAllRouteId());
		map.put("shiplist", admin.findByAllShipId());
		map.put("schedule", admin.viewByScheduleId(schedule.getScheduleID()));
		return new ModelAndView("ModifySchedule", "map", map);
	}

	/**
	 * This method is used to perform ModifySchedule functionality.
	 * 
	 * @param schedule
	 *            This parameter is used as a reference to ScheduleBean.
	 * @param result2
	 *            This parameter is used as a binding variable.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return Returns ModelAndView.
	 */
	
		
		
	@RequestMapping(value = "ModifySchedule1")
	public ModelAndView modifyScheduleDetails(
			@ModelAttribute("schedule") final ScheduleBean schedule,
			final BindingResult result2) {
		if (result2.hasErrors()) {
			return new ModelAndView("ModifySchedule");
		} else {
			boolean value = true;
			if (schedule instanceof ScheduleBean) {
				value = admin.modifySchedule(schedule);
				System.out.println(value);
				if (value) {
					return new ModelAndView("Success", "MSG",
							"Schedule details are successfully modified");
				} else {
					return new ModelAndView("Failure", "MSG",
							"Schedule details could not be modified");
				}
			}
			return new ModelAndView("Failure", "MSG",
					"Schedule details could not be modified");
		}
	}

	/**
	 * This method is used to perform DeleteSchedule functionality.
	 * 
	 * @param schedule
	 *            This parameter is used as a reference to ScheduleBean.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return Returns ModelAndView.
	 */
	@RequestMapping(value = "DeleteSchedule")
	public ModelAndView deleteSchedule(
			@ModelAttribute("schedule") final ScheduleBean schedule,
			final HttpSession session) {
		final Map<String, Object> map = new HashMap<String, Object>();
		// map.put("flight", new FlightBean());
		map.put("schedulelist", admin.findByAllScheduleId());
		map.put("schedule", admin.viewByScheduleId(schedule.getScheduleID()));
		session.setAttribute("scheduleID", schedule.getScheduleID());
		return new ModelAndView("DeleteSchedule", "map", map);
	}

	/**
	 * This method is used to perform DeleteSchedule functionality.
	 * 
	 * @param schedule
	 *            This parameter is used as a reference to ScheduleBean.
	 * @param session
	 *            is used as an object of Http Session to maintain the session.
	 * @return Returns ModelAndView.
	 */
	@RequestMapping(value = "DeleteSchedule1")
	public ModelAndView deleteScheduleById(
			@ModelAttribute("schedule") final ScheduleBean schedule,
			final HttpSession session) {
		ModelAndView result1 = null;
		final String val = (String) session.getAttribute("scheduleID");
		final List<String> fid = new ArrayList<String>();
		fid.add(val);
		final int remove = admin.removeSchedule(fid);
		if (remove == 1) {
			result1 = new ModelAndView("Success", "MSG",
					"Schedule deleted successfully!!");
		} else {
			result1 = new ModelAndView("Failure", "MSG",
					"Schedule cannot be deleted!!");
		}
		return result1;
	}

	@RequestMapping(value = "passenger.htm",method = RequestMethod.GET)
	public ModelAndView viewPassenger(
			@ModelAttribute("schedule") final ScheduleBean schedule,
			@ModelAttribute("ship") final ShipBean ship,
			@ModelAttribute("passenger") final PassengerBean pb,
			final HttpSession session) {
		String name = null;
		String age = null;
		String gender = null;
		String date=null;
		String shipName = null;
		Date d=null;
		
		List<Object[]> list=admin.viewPasengers();
		int i=0;
		for(Object[] obj : list){
			System.out.println(list.get(i));
			name = String.valueOf(obj[5]); 
			age = String.valueOf(obj[3]); 
			gender = String.valueOf(obj[4]);
			date = String.valueOf(obj[7]);
			shipName = String.valueOf(obj[10]);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				 d=sdf.parse(date);
			} catch (ParseException e) {
				System.out.print(e);
			}
			
			pb.setName(name);
			pb.setAge(Integer.parseInt(age));
			pb.setGender(gender);
			ship.setShipName(shipName);
			schedule.setStartDate(d);
			System.out.println(pb.getName());
			i++;
			
		}
			
		return new ModelAndView("ViewPassengers");
	}
	
	@RequestMapping(value = "p1.htm")
	public ModelAndView viewSchedulejsp(final Model model,
			final PassengerBean p, final HttpSession session,
			@RequestParam("scheduleID") final String scheduleID
) {
		
		List<PassengerBean> pb = admin.viewPasengersByShip(scheduleID);
		
		return new ModelAndView("ViewPassenger1", "list",
				pb);
	}
}
