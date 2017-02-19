package com.hk.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hk.constant.SecurityConstant;

/**
 * RestAuthenticationEntryPoint class
 * set Unauthorized response from "Unauthorized client"
 * 
 * @author Adik
 */
@Component("RestAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse res, AuthenticationException ae)
			throws IOException, ServletException {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SecurityConstant.STATUS, HttpStatus.UNAUTHORIZED.name());
		map.put(SecurityConstant.STATUS_CODE, HttpStatus.UNAUTHORIZED.toString());
		map.put(SecurityConstant.MESSAGE, HttpStatus.UNAUTHORIZED.toString());

		// convert map to JSON string
		json = mapper.writeValueAsString(map);
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		res.setContentType("application/json");
		res.getWriter().write(json);
		res.getWriter().flush();
		res.getWriter().close();
	}

}