/*
 *
 * File Name         : Controller.java
 *
 * Short Description : This file is controller.
 *
 * Version Number    : 1.0
 *
 *
 */

package com.wipro.srs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.util.User;
/**
 * This class is a controller class.
 *
 * @author Rajesh Kumar
 * @version 1.0,May 7,2015
 * @since 1.0
 */
@Controller
public class controller {

	@Autowired
	private User user;

	/**
	 * This method is used to redirect to the index page.
	 * 
	 * @param model
	 *            is used as an object of Modal class.
	 * @return a view index.
	 */
	@RequestMapping(value = "index.htm", method = RequestMethod.GET)
	public String viewfront(final Model model) {
		model.addAttribute("credentials", new CredentialsBean());
		model.addAttribute("credentials1", new ProfileBean());

		return "index";
	}

	/**
	 * This method is used for login functionality.
	 * 
	 * @param credentials
	 *            is used as the command object that would be bound with the
	 *            HTTP request data.
	 * @param session
	 *            to maintain the session.
	 * @return the object of type ModelAndView.
	 */
	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public ModelAndView login(
			@ModelAttribute("credentials") final CredentialsBean credentials,
			final HttpSession session) {
		System.out.println("in login");
		ModelAndView result = new ModelAndView("InvalidUser", "MSG",
				"INVALID User Details");
		String status = user.login(credentials);
		if ("admin".equals(status)) {
			session.setAttribute("userID", credentials.getUserID());
			session.setAttribute("userType", status);
			System.out.println("status for admin "+status);
			result = new ModelAndView("AdminHome", "MSG", "Welcome Admin "
					+ credentials.getUserID());
		} else if ("customer".equals(status)) {
			session.setAttribute("userID", credentials.getUserID());
			session.setAttribute("userType", status);
			System.out.println("status for customer is"+status);
			result = new ModelAndView("CustomerHome", "MSG", "Logged In As "
					+ credentials.getUserID());
		}
		session.setAttribute("nameheader", credentials.getUserID());
		return result;
	}

	/**
	 * This method is used for logout functionality.
	 * 
	 * @param session
	 *            to maintain the session.
	 * @param credentials
	 *            is used as the command object that would be bound with the
	 *            HTTP request data.
	 * @param result
	 *            is used to bind with the bean variable.
	 * @return logout view name.
	 */
	@RequestMapping(value = "logout.htm", method = RequestMethod.GET)
	public String viewlogout(final HttpSession session,
			@ModelAttribute("credentials") final CredentialsBean credentials) {

		ModelAndView result1 = null;
		user.logout(session.getAttribute("userID").toString());

		session.invalidate();
		result1 = new ModelAndView("index", "MSG", "Logout successful!!");

		return "index";

	}

	/**
	 * This method is used for change password functionality.
	 * 
	 * @return password view.
	 */
	@RequestMapping(value = "password.htm")
	public String gotopassword() {
		return "password";
	}

	/**
	 * This method is used for change password functionality.
	 * 
	 * @param session
	 *            to maintain the session.
	 * @param credentials
	 *            is used as the command object that would be bound with the
	 *            HTTP request data.
	 * @return index view name.
	 */
	@RequestMapping(value = "Change.htm", method = RequestMethod.GET)
	public String changePassowrd(final HttpSession session,
			@ModelAttribute("credentials") final CredentialsBean credentials) {
		ModelAndView result = null;
		result = new ModelAndView("Change", "MSG", "FAILED");
		String newPassword = credentials.getNpassword();
		credentials.setUserID(session.getAttribute("userID").toString());
		user.changePassword(credentials, newPassword);
		return "index";
	}

	/**
	 * This method is used for registration functionality.
	 * 
	 * @param profile
	 *            variable used to bind with ProfileBean.
	 * @return res1 returns view of name RegSuccess.
	 * @param binding
	 *            returns the binding result
	 */
	@RequestMapping(value = "register.htm", method = RequestMethod.POST)
	System.out.println("register page");
	public ModelAndView register(
			@Valid @ModelAttribute("credentials1") final ProfileBean profile,
			final BindingResult binding) {
		ModelAndView res1 = null;
		if (binding.hasErrors()) {
			return new ModelAndView("index");
		}

		else {
			final String res = user.register(profile);
			if (!res.equalsIgnoreCase("INVALID")) {
				res1 = new ModelAndView("RegSuccess", "MSG",
						"Registered successfully with ID="
								+ profile.getUserID());
			}
		}
		return res1;
	}
	
}