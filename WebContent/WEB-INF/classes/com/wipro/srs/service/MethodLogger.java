/**
 * 
 */


package com.wipro.srs.service;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 *
 * @author Rajesh Kumar
 * @version 1.0,May 8,2015
 * @since 1.0
 */
@Component
@Aspect
public class MethodLogger {

	/**
	 * 
	 */
	public static final Logger log = Logger.getLogger(MethodLogger.class);
	@Around("execution(* com.wipro.srs..*.*(..))")
	public Object timeMethod (final ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		 * System.out.println("Method  '"+joinPoint.toShortString()+"' is executing");
		 * log.debug("Method-----"+joinPoint.toShortString()); StopWatch stopWatch = new StopWatch(); stopWatch.start();
		 * 
		 * Object retVal = joinPoint.proceed();
		 */
		log.fatal("Method  '" + joinPoint.toShortString() + "' is executing");
		Object result = joinPoint.proceed();
		log.fatal("Return val from  '" + joinPoint.getSignature().getName() + "'  method is::" + result);
		return result;
	}
}