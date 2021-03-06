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
import com.hk.vo.AccessUserChildVO;
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
			int unselected2 = 0;
			int indeterminate2 = 0;
			int selected2 = 0;
			for(Module moduleL2 : moduleDao.childNode(moduleL1.getId())){
				Map<String, Object> mapL2 = new HashMap<String, Object>();
				
				mapL2.put("id", moduleL2.getId());
				mapL2.put("label", moduleL2.getNama());
				

				List<Object> listModuleL3 = new ArrayList<>();
				int unselected3 = 0;
				int selected3 = 0;
				for(Module moduleL3 : moduleDao.childNode(moduleL2.getId())){
					Map<String, Object> mapL3 = new HashMap<String, Object>();
					
					mapL3.put("id", moduleL3.getId());
					mapL3.put("label", moduleL3.getNama());
					
					if(CommonUtil.isNotNullOrEmpty(accessUserDao.findByUserIdModuleId(userId, moduleL3.getId()))){
						mapL3.put("selected", true);
						selected3++;
					}else{
						mapL3.put("selected", false);
						unselected3++;
					}
					
					listModuleL3.add(mapL3);
				}
				
				
				if((unselected3 > 0) && (selected3 > 0)){
					mapL2.put("selected", false);
					mapL2.put("__ivhTreeviewIndeterminate", true);
					indeterminate2++;
				}else if((unselected3 == 0) && (selected3 > 0)){
					mapL2.put("selected", true);
					mapL2.put("__ivhTreeviewIndeterminate", false);
					selected2++;
				}else if((unselected3 > 0) && (selected3 == 0)){
					mapL2.put("selected", false);
					mapL2.put("__ivhTreeviewIndeterminate", false);
					unselected2++;
				}else{
					if(CommonUtil.isNotNullOrEmpty(accessUserDao.findByUserIdModuleId(userId, moduleL2.getId()))){
						mapL2.put("selected", true);
						selected2++;
					}else{
						mapL2.put("selected", false);
						unselected2++;
					}
				}
				
				mapL2.put("children", listModuleL3);
				
				listModuleL2.add(mapL2);
			}
			
			if((unselected2 > 0) && (selected2 > 0)){
				mapL1.put("selected", false);
				mapL1.put("__ivhTreeviewIndeterminate", true);
			}else if((unselected2 == 0) && (selected2 > 0)){
				if(indeterminate2 > 0){
					mapL1.put("selected", false);
					mapL1.put("__ivhTreeviewIndeterminate", true);
				}else{
					mapL1.put("selected", true);
					mapL1.put("__ivhTreeviewIndeterminate", false);
				}
			}else if((unselected2 > 0) && (selected2 == 0)){
				if(indeterminate2 > 0){
					mapL1.put("selected", false);
					mapL1.put("__ivhTreeviewIndeterminate", true);
				}else{
					mapL1.put("selected", false);
					mapL1.put("__ivhTreeviewIndeterminate", false);
				}
			}else{
				if(indeterminate2 > 0){
					mapL1.put("selected", false);
					mapL1.put("__ivhTreeviewIndeterminate", true);
				}else{
					if(CommonUtil.isNotNullOrEmpty(accessUserDao.findByUserIdModuleId(userId, moduleL1.getId()))){
						mapL1.put("selected", true);
					}else{
						mapL1.put("selected", false);
					}
				}
			}
			
			mapL1.put("children", listModuleL2);
			
			listModuleL1.add(mapL1);
		}
		
		result.put("listAccessUser", listModuleL1);
		result.put("userId", userId);
		return result;
	}

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveAccessUser(AccessUserVO p) {
		
		User model=userDao.findById(p.getUserId());
		
		/*if((p.getModules() != null) && CommonUtil.isNotNullOrEmpty(model)){
			List<AccessUser> listAccessUser = new ArrayList<AccessUser>();
			
			for(String module : p.getModules()){
				Module m = moduleDao.findById(module);
				AccessUser am = new AccessUser();
				am.setUser(model);
				am.setModule(m);
				listAccessUser.add(am);
			}
			
			accessUserDaoCustom.deleteByUserId(model.getId());
			model.getListAccessUser().clear();
			model.setListAccessUser(listAccessUser);
		}*/
		
		if((p.getListAccessUserChildVO() != null) && CommonUtil.isNotNullOrEmpty(model)){
			List<AccessUser> listAccessUser = new ArrayList<AccessUser>();
			
			for(AccessUserChildVO module : p.getListAccessUserChildVO()){
				
					Module m = moduleDao.findById(module.getId());
					AccessUser am = new AccessUser();
					am.setUser(model);
					am.setModule(m);
					
					if(CommonUtil.isNullOrEmpty(module.get__ivhTreeviewIndeterminate())){
						module.set__ivhTreeviewIndeterminate(false);
					}
					
					if(module.getSelected() || module.get__ivhTreeviewIndeterminate()){
						listAccessUser.add(am);
					}
					
					for(AccessUserChildVO module2 : module.getChildren()){
						
							Module m2 = moduleDao.findById(module2.getId());
							AccessUser am2 = new AccessUser();
							am2.setUser(model);
							am2.setModule(m2);

							if(CommonUtil.isNullOrEmpty(module2.get__ivhTreeviewIndeterminate())){
								module2.set__ivhTreeviewIndeterminate(false);
							}
							
							if(module2.getSelected() || module2.get__ivhTreeviewIndeterminate()){
								listAccessUser.add(am2);
							}
							
							for(AccessUserChildVO module3 : module2.getChildren()){
								
									Module m3 = moduleDao.findById(module3.getId());
									AccessUser am3 = new AccessUser();
									am3.setUser(model);
									am3.setModule(m3);
									
									if(CommonUtil.isNullOrEmpty(module3.get__ivhTreeviewIndeterminate())){
										module3.set__ivhTreeviewIndeterminate(false);
									}
									
									if(module3.getSelected() || module3.get__ivhTreeviewIndeterminate()){
										listAccessUser.add(am3);
									}
							}
					}
			}
			
			accessUserDaoCustom.deleteByUserId(model.getId());
			model.getListAccessUser().clear();
			model.setListAccessUser(listAccessUser);
		}
		
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
		
		if((sourceAccessUser != null) && CommonUtil.isNotNullOrEmpty(model.getId())){
			List<AccessUser> listAccessUser = new ArrayList<AccessUser>();

			for(AccessUser au : sourceAccessUser){
				AccessUser am = new AccessUser();
				am.setUser(model);
				am.setModule(au.getModule());
				listAccessUser.add(am);
			}
			
			accessUserDaoCustom.deleteByUserId(model.getId());
			model.getListAccessUser().clear();
			model.setListAccessUser(listAccessUser);
		}
		
		User user=userDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", user.getId());
		result.put("isActive", user.getIsActive());
		return result;
	}
}
