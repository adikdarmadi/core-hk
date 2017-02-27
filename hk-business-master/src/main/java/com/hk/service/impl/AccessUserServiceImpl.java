package com.hk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.AccessUserDao;
import com.hk.dao.ModuleDao;
import com.hk.dao.UserDao;
import com.hk.dao.custom.AccessUserDaoCustom;
import com.hk.entities.AccessUser;
import com.hk.entities.Module;
import com.hk.entities.User;
import com.hk.service.AccessUserService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.vo.AccessUserVO;

@Service("accessUserService")
public class AccessUserServiceImpl implements AccessUserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("AccessUserService : ");

	@Autowired
	private AccessUserDao accessUserDao;
	
	@Autowired
	private AccessUserDaoCustom accessUserDaoCustom;
	
	@Autowired
	private ModuleDao moduleDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Map<String,Object> findByUserId(String userId) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		
		List<Object> listModuleL1 = new ArrayList<>();
		for(Module moduleL1 : moduleDao.parentNode()){
			Map<String, Object> mapL1 = new HashMap<String, Object>();
			
			mapL1.put("id", moduleL1.getId());
			mapL1.put("label", moduleL1.getNama());
			
			if(CommonUtil.isNotNullOrEmpty(accessUserDao.findByUserIdModuleId(userId, moduleL1.getId()))){
				mapL1.put("selected", true);
			}else{
				mapL1.put("selected", false);
			}
			
			List<Object> listModuleL2 = new ArrayList<>();
			for(Module moduleL2 : moduleDao.childNode(moduleL1.getId())){
				Map<String, Object> mapL2 = new HashMap<String, Object>();
				
				mapL2.put("id", moduleL2.getId());
				mapL2.put("label", moduleL2.getNama());
				
				if(CommonUtil.isNotNullOrEmpty(accessUserDao.findByUserIdModuleId(userId, moduleL2.getId()))){
					mapL2.put("selected", true);
				}else{
					mapL2.put("selected", false);
				}

				List<Object> listModuleL3 = new ArrayList<>();
				for(Module moduleL3 : moduleDao.childNode(moduleL2.getId())){
					Map<String, Object> mapL3 = new HashMap<String, Object>();
					
					mapL3.put("id", moduleL3.getId());
					mapL3.put("label", moduleL3.getNama());
					
					if(CommonUtil.isNotNullOrEmpty(accessUserDao.findByUserIdModuleId(userId, moduleL3.getId()))){
						mapL3.put("selected", true);
					}else{
						mapL3.put("selected", false);
					}
					
					listModuleL3.add(mapL3);
				}
				
				mapL2.put("children", listModuleL3);
				
				listModuleL2.add(mapL2);
			}
			
			mapL1.put("children", listModuleL2);
			
			listModuleL1.add(mapL1);
		}
		
		result.put("listAccessUser", listModuleL1);
		return result;
	}

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveAccessUser(AccessUserVO p) {
		List<AccessUser> listAccessUser = new ArrayList<AccessUser>();
		User model=userDao.findById(p.getUserId());
		accessUserDaoCustom.deleteByUserId(model.getId());
		
		if(CommonUtil.isNotNullOrEmpty(p.getModules()) && CommonUtil.isNotNullOrEmpty(p.getUserId())){
			for(String module : p.getModules()){
				Module m = moduleDao.findById(module);
				AccessUser am = new AccessUser();
				am.setUser(model);
				am.setModule(m);
				listAccessUser.add(am);
			}
		}
		
		model.getListAccessUser().clear();
		model.setListAccessUser(listAccessUser);
		
		User user=userDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", user.getId());
		result.put("isActive", user.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> copyAccessUser(String toUserId,String fromUserId) {
		
		List<AccessUser> sourceAccessUser = accessUserDao.findByUserId(fromUserId);
		
		User model=userDao.findById(toUserId);
		accessUserDaoCustom.deleteByUserId(model.getId());
		
		List<AccessUser> listAccessUser = new ArrayList<AccessUser>();
		if(CommonUtil.isNotNullOrEmpty(sourceAccessUser) && CommonUtil.isNotNullOrEmpty(model.getId())){
			for(AccessUser au : sourceAccessUser){
				AccessUser am = new AccessUser();
				am.setUser(model);
				am.setModule(au.getModule());
				listAccessUser.add(am);
			}
		}
		
		model.getListAccessUser().clear();
		model.setListAccessUser(listAccessUser);
		
		User user=userDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", user.getId());
		result.put("isActive", user.getIsActive());
		return result;
	}
}
