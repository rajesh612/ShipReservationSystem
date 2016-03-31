package com.wipro.srs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.srs.service.PrintTicket;
/**
*
* @author Rajesh Kumar
 * @version 1.0,May 8,2015
 * @since 1.0
*/
@Controller
public class PdfController{
	
	@Autowired
	PrintTicket pt;
  
	@RequestMapping(value = "pdf.htm")
	public ModelAndView viewpdf(final HttpSession session,@RequestParam("reservationID") final String reservationID) {
		
		session.setAttribute("reservationID", reservationID);
		System.out.println(reservationID);
		pt.generatePDF(reservationID);
		System.out.println("pdf generated!!!");
		return new ModelAndView("ViewPdf");
	}
} 