package com.hk.logging;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Adik
 */
/*@Component*/
@Aspect
public class LoggingAdvise {
	
	private final Logger LOG = LoggerFactory.getLogger(LoggingAdvise.class);


	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controller() {
	}

	@Pointcut("execution(* *.*(..))")
	protected void allMethod() {
	}

	@Pointcut("execution(public * *(..))")
	protected void loggingPublicOperation() {
	}

	@Pointcut("execution(* *.*(..))")
	protected void loggingAllOperation() {
	}

	@Pointcut("within(org.learn.LOG..*)")
	private void logAnyFunctionWithinResource() {
	}

	//before -> Any resource annotated with @Controller annotation 
	//and all method and function taking HttpServletRequest as first parameter
	@Before("controller() && allMethod() && args(..,request)")
	public void logBefore(JoinPoint joinPoint, HttpServletRequest request) {

		LOG.info("Entering in Method :  " + joinPoint.getSignature().getName());
		LOG.info("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
		LOG.info("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
		LOG.info("Target class : " + joinPoint.getTarget().getClass().getName());

		if (null != request) {
			LOG.info("Start Header Section of request ");
			LOG.info("Method Type : " + request.getMethod());
			Enumeration headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String headerName = headerNames.nextElement().toString();
				String headerValue = request.getHeader(headerName);
				LOG.info("Header Name: " + headerName + " Header Value : " + headerValue);
			}
			LOG.info("Request Path info :" + request.getServletPath());
			LOG.info("End Header Section of request ");
		}
	}
	//After -> All method within resource annotated with @Controller annotation 
	// and return a  value
	@AfterReturning(pointcut = "controller() && allMethod()", returning = "result")
	public void logAfter(JoinPoint joinPoint, Object result) {
		String returnValue = this.getValue(result);
		LOG.info("Method Return value : " + returnValue);
	}
	//After -> Any method within resource annotated with @Controller annotation 
	// throws an exception ...Log it
	@AfterThrowing(pointcut = "controller() && allMethod()", throwing = "exception")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
		LOG.error("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
		LOG.error("Cause : " + exception.toString());
	}
	//Around -> Any method within resource annotated with @Controller annotation 
	@Around("controller() && allMethod()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		try {
			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			Object result = joinPoint.proceed();
			long elapsedTime = System.currentTimeMillis() - start;
			LOG.info("Method " + className + "." + methodName + " ()" + " execution time : "
					+ elapsedTime + " ms");
		
			return result;
		} catch (IllegalArgumentException e) {
			LOG.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}
	private String getValue(Object result) {
		String returnValue = null;
		if (null != result) {
			if (result.toString().endsWith("@" + Integer.toHexString(result.hashCode()))) {
				returnValue = ReflectionToStringBuilder.toString(result);
			} else {
				returnValue = result.toString();
			}
		}
		return returnValue;
	}
	
}
