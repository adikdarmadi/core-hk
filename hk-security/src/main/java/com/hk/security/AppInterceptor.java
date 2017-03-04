package com.hk.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hk.constant.HakAksesConstant;
import com.hk.constant.SecurityConstant;
import com.hk.dao.UserDao;
import com.hk.entities.AccessUser;
import com.hk.entities.User;
import com.hk.util.CommonUtil;

/**
 * Interceptor class for All annotation method controller @AppPermission
 * 
 * @author Adik
 */
public class AppInterceptor implements HandlerInterceptor {

	private final Logger LOG = LoggerFactory.getLogger(AppInterceptor.class);

	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;

	@Autowired
	private UserDao userDao;
	
	public AppInterceptor() {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			HandlerMethod hm = (HandlerMethod) handler;
			Method method = hm.getMethod();

			Boolean isAuthHakAkses = false;
			Boolean isAuthHakMenu = false;
			
			User user = null;
	        try {
	            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	            String id = principal.toString();
	            user = userDao.findById(id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
            
			if (method.isAnnotationPresent(AppPermission.class)) {
				String hakAksesValue = method.getAnnotation(AppPermission.class).hakAkses();
				List<String> list = new ArrayList<String>();
				if (CommonUtil.isNotNullOrEmpty(hakAksesValue)) {
					String[] array = hakAksesValue.split("\\,", -1);
					list = Arrays.asList(array);
				}
				if (CommonUtil.isNotNullOrEmpty(list)) {
					Boolean isLogin = false;
					for (String hakAkses : list) {
						
						if (hakAkses.equalsIgnoreCase(HakAksesConstant.CREATE)) {
							if(user.getIsCreate()){
								isLogin = true;
							}
						}else if(hakAkses.equalsIgnoreCase(HakAksesConstant.UPDATE)) {
							if(user.getIsUpdate()){
								isLogin = true;
							}
						}else if(hakAkses.equalsIgnoreCase(HakAksesConstant.DELETE)) {
							if(user.getIsDelete()){
								isLogin = true;
							}
						}else if(hakAkses.equalsIgnoreCase(HakAksesConstant.PRINT)) {
							if(user.getIsPrint()){
								isLogin = true;
							}
						}else if(hakAkses.equalsIgnoreCase(HakAksesConstant.REPORT)) {
							if(user.getIsReport()){
								isLogin = true;
							}
						}else if(hakAkses.equalsIgnoreCase(HakAksesConstant.CANCEL)) {
							if(user.getIsCancel()){
								isLogin = true;
							}
						}else if(hakAkses.equalsIgnoreCase(HakAksesConstant.CONFIRM)) {
							if(user.getIsConfirm()){
								isLogin = true;
							}
						}else if(hakAkses.equalsIgnoreCase(HakAksesConstant.UNCONFIRM)) {
							if(user.getIsUnconfirm()){
								isLogin = true;
							}
						}else if(hakAkses.equalsIgnoreCase(HakAksesConstant.SUPERVISOR)) {
							if(user.getIsSupervisor()){
								isLogin = true;
							}
						}else if(hakAkses.equalsIgnoreCase(HakAksesConstant.SUPERUSER)) {
							if(user.getIsSuperuser()){
								isLogin = true;
							}
						}
					}
					isAuthHakAkses = isLogin;
				}
				
				
				String hakMenu = method.getAnnotation(AppPermission.class).hakMenu();
				if (CommonUtil.isNotNullOrEmpty(hakMenu)) {
					Boolean isLogin = false;
						
					if (hakMenu.equalsIgnoreCase("*")) {
						isLogin = true;
					}else{
						if(CommonUtil.isNotNullOrEmpty(userDao.findByUserIdPathMap(user.getId(), hakMenu))){
							isLogin = true;
						}
					}
					isAuthHakMenu = isLogin;
				}
				
				if (isAuthHakAkses && isAuthHakMenu) {
					return true;
				} else {
					setUnautorized(response);
					return false;
				}
			}
		} catch (Exception e) {
			setNotFound(response);
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {
	}
	
	public void setUnautorized(HttpServletResponse response) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SecurityConstant.STATUS, HttpStatus.UNAUTHORIZED.name());
		map.put(SecurityConstant.STATUS_CODE, HttpStatus.UNAUTHORIZED.toString());
		map.put(SecurityConstant.MESSAGE, HttpStatus.UNAUTHORIZED.toString());
		response.setHeader(SecurityConstant.STATUS_CODE, HttpStatus.UNAUTHORIZED.toString());
		response.setHeader(SecurityConstant.MESSAGE, HttpStatus.UNAUTHORIZED.toString());
		// convert map to JSON string
		try {
			json = mapper.writeValueAsString(map);
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType("application/json");
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();						

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setNotFound(HttpServletResponse response) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SecurityConstant.STATUS, HttpStatus.NOT_FOUND.name());
		map.put(SecurityConstant.STATUS_CODE, HttpStatus.NOT_FOUND.toString());
		map.put(SecurityConstant.MESSAGE, HttpStatus.NOT_FOUND.toString());
		response.setHeader(SecurityConstant.STATUS_CODE, HttpStatus.NOT_FOUND.toString());
		response.setHeader(SecurityConstant.MESSAGE, HttpStatus.NOT_FOUND.toString());
		// convert map to JSON string
		try {
			json = mapper.writeValueAsString(map);
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);

			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.setContentType("application/json");
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}