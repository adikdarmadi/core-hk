package com.hk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.AccessUserDao;
import com.hk.dao.ModuleDao;
import com.hk.entities.Module;
import com.hk.service.MenuService;
import com.hk.util.CommonUtil;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("MenuService : ");

	@Autowired
	private AccessUserDao accessUserDao;
	
	@Autowired
	private ModuleDao moduleDao;
	
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAccessUserByUserId(String userId) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		
		List<Object> listModuleL1 = new ArrayList<>();
		Integer colIdL1 = 5;
		for(Module moduleL1 : moduleDao.parentNode()){
			Map<String, Object> mapL1 = new HashMap<String, Object>();
			
			mapL1.put("id", moduleL1.getId());
			mapL1.put("title", moduleL1.getNama());
			mapL1.put("state", moduleL1.getState());
			mapL1.put("icon", moduleL1.getIcon());
			mapL1.put("colId", colIdL1);
			
			List<Object> listModuleL2 = new ArrayList<>();
			String joinColId = colIdL1.toString()+"10";
			Integer colIdL2 = new Integer(joinColId);
			for(Module moduleL2 : moduleDao.childNode(moduleL1.getId())){
				Map<String, Object> mapL2 = new HashMap<String, Object>();
				
				mapL2.put("id", moduleL2.getId());
				mapL2.put("title", moduleL2.getNama());
				mapL2.put("state", moduleL2.getState());
				mapL2.put("icon", moduleL2.getIcon());
				mapL2.put("colId", colIdL2);

				List<Object> listModuleL3 = new ArrayList<>();
				for(Module moduleL3 : moduleDao.childNode(moduleL2.getId())){
					Map<String, Object> mapL3 = new HashMap<String, Object>();
					
					mapL3.put("id", moduleL3.getId());
					mapL3.put("title", moduleL3.getNama());
					mapL3.put("state", moduleL3.getState());
					mapL3.put("icon", moduleL3.getIcon());
					mapL3.put("colId", null);
					
					if(CommonUtil.isNotNullOrEmpty(accessUserDao.findByUserIdModuleId(userId, moduleL3.getId()))){
						listModuleL3.add(mapL3);
					}
				}
				
				mapL2.put("childs", listModuleL3);
				
				if(CommonUtil.isNotNullOrEmpty(accessUserDao.findByUserIdModuleId(userId, moduleL2.getId()))){
					listModuleL2.add(mapL2);
				}
				
				colIdL2++;
			}
			
			mapL1.put("childs", listModuleL2);
			
			if(CommonUtil.isNotNullOrEmpty(accessUserDao.findByUserIdModuleId(userId, moduleL1.getId()))){
				listModuleL1.add(mapL1);
			}
			
			colIdL1++;
		}
		
		result.put("listMenu", listModuleL1);
		
		return result;
	}
	
}
