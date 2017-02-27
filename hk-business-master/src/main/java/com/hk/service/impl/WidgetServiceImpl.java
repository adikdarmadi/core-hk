package com.hk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.RoleDao;
import com.hk.dao.WidgetDao;
import com.hk.entities.RoleWidget;
import com.hk.entities.Widget;
import com.hk.service.WidgetService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.WidgetVO;

@Service("widgetService")
public class WidgetServiceImpl implements WidgetService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("WidgetService : ");

	@Autowired
	private WidgetDao widgetDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveWidget(WidgetVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save widget execute");
		Widget model=modelMapper.map(p, Widget.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		List<RoleWidget> listRoleWidget = new ArrayList<RoleWidget>();
		for(String role : p.getRoles()){
			RoleWidget roleWidget=new RoleWidget();
			if(CommonUtil.isNotNullOrEmpty(role)){
				roleWidget.setRole(roleDao.findById(role));
				roleWidget.setWidget(model);
				listRoleWidget.add(roleWidget);
			}
		}
		
		model.getListRoleWidget().clear();
		model.setListRoleWidget(listRoleWidget);
		
		Widget widget=widgetDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", widget.getId());
		result.put("isActive", widget.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllWidget() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listWidget", widgetDao.findAllWidget());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Widget widget=widgetDao.findById(id);
		result.put("widget", widget);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteWidget(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		widgetDao.delete(id);
		result.put("id", id);
		return result;
	}


}
