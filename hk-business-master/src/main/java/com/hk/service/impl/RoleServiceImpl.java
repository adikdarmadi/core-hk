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
import com.hk.dao.UserRoleDao;
import com.hk.dao.WidgetDao;
import com.hk.dao.custom.RoleWidgetDaoCustom;
import com.hk.entities.AkunGrup;
import com.hk.entities.Role;
import com.hk.entities.RoleWidget;
import com.hk.entities.Widget;
import com.hk.service.RoleService;
import com.hk.service.UserMasterService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.RoleVO;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("RoleService : ");

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private WidgetDao widgetDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private RoleWidgetDaoCustom roleWidgetDaoCustom;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveRole(RoleVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save role execute");
		Role model=modelMapper.map(p, Role.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(p.getWidgets() != null){
			List<RoleWidget> listRoleWidget = new ArrayList<RoleWidget>();
			for(String widgetId : p.getWidgets()){
				RoleWidget roleWidget = new RoleWidget();
				roleWidget.setWidget(widgetDao.findById(widgetId));
				roleWidget.setRole(model);
				listRoleWidget.add(roleWidget);
			}
			
			model.getListRoleWidget().clear();
			model.setListRoleWidget(listRoleWidget);
		}
		
		
		
		Role role=roleDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", role.getId());
		result.put("isActive", role.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editRole(RoleVO p, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save role execute");
		Role model=modelMapper.map(p, Role.class);

		Role obj = roleDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		if(p.getWidgets() != null){
			List<RoleWidget> listRoleWidget = new ArrayList<RoleWidget>();
			for(String widgetId : p.getWidgets()){
				RoleWidget roleWidget = new RoleWidget();
				roleWidget.setWidget(widgetDao.findById(widgetId));
				roleWidget.setRole(model);
				listRoleWidget.add(roleWidget);
			}
			
			roleWidgetDaoCustom.deleteByRoleId(model.getId());
			model.getListRoleWidget().clear();
			model.setListRoleWidget(listRoleWidget);
		}
		
		Role role=roleDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", role.getId());
		result.put("isActive", role.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveRole(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save role execute");
		
		Role model = roleDao.findById(id);
		
		if(model.getIsActive()){
			model.setIsActive(false);
			model.setDateNonActive(DateUtil.now());
		}else{
			model.setIsActive(true);
			model.setDateNonActive(null);
		}
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		Role role=roleDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", role.getId());
		result.put("isActive", role.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllRole() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listRole", roleDao.findAllRole());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Role role=roleDao.findById(id);
		result.put("role", role);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteRole(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		roleDao.delete(id);
		result.put("id", id);
		return result;
	}

	@Override
	public Map<String,Object> findByUserId(String userId){
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listRole", userRoleDao.findRoleByUserId(userId));
		return result;
	}
}
