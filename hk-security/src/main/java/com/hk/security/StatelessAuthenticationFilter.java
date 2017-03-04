package com.hk.security;

import io.jsonwebtoken.MalformedJwtException;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.fasterxml.jackson.core.JsonParseException;
import com.hk.constant.SecurityConstant;

/**
 * StatelessAuthenticationFilter class
 * 
 * @author Roberto
 */
public class StatelessAuthenticationFilter extends GenericFilterBean {
	private final TokenAuthenticationService authenticationService;

	public StatelessAuthenticationFilter(
			TokenAuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		res.setHeader("Access-Control-Allow-Origin",
				req.getHeader("Origin"));
		res.setHeader("Access-Control-Allow-Credentials", "true");
		
		res.setHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS, DELETE");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Accept, X-Requested-With, remember-me,X-AUTH-TOKEN");

		Authentication authentication = null;
		try {
		
			authentication = authenticationService
					.getAuthentication(httpRequest);
		} catch (JsonParseException | MalformedJwtException e) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.addHeader(SecurityConstant.MessageInfo.ERROR_MESSAGE,
					"Error Token (Not Valid Token)");
			filterChain.doFilter(request, response);
		}
		try {
			SecurityContextHolder.getContext().setAuthentication(authentication);
			if(authentication==null){
				res.setHeader(SecurityConstant.STATUS_CODE, HttpStatus.UNAUTHORIZED.toString());
				res.setHeader(SecurityConstant.STATUS, HttpStatus.UNAUTHORIZED.name());
			}
			filterChain.doFilter(request, response);
			SecurityContextHolder.getContext().setAuthentication(null);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("not found for url : "+req.getRequestURI());
		}
	
	}
}
