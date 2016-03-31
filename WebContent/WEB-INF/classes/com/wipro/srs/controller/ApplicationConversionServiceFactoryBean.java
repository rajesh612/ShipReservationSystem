
/* 
 * File Name: ShipController.java
 *
 * Short Description: This file is used to set/get Date.
 * 
 * Version Number: 0.1 
 *
 * Created Date: April 28, 2015
 */

package com.wipro.srs.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
/**
 * This class is a controller class.
 *
 * @author Rajesh Kumar
 * @version 1.0,May 5,2015
 * @since 1.0
 */
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters (final FormatterRegistry registry) {
		super.installFormatters(registry);
		registry.addConverter(getStringToDateConverter());
	}
	/**
	 * @return returns a null value
	 */
	public Converter<String, java.util.Date> getStringToDateConverter () {
		return new Converter<String, java.util.Date>() {

			@Override
			public java.util.Date convert (final String source) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				try {
					return sdf.parse(source);
				} catch (ParseException e) {
					System.out.print(e);
					System.out.print("Date Conversion error");
					return null;
				}
			}
		};
	}
}