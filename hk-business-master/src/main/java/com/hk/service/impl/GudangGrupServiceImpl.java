package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.GudangGrupDao;
import com.hk.entities.GudangGrup;
import com.hk.service.GudangGrupService;
import com.hk.service.UserService;
import com.hk.util.DateUtil;
import com.hk.vo.GudangGrupVO;

@Service("gudangGrupService")
public class GudangGrupServiceImpl implements GudangGrupService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("GudangGrupService : ");

	@Autowired
	private GudangGrupDao gudangGrupDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveGudangGrup(GudangGrupVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save gudangGrup execute");
		GudangGrup model=modelMapper.map(p, GudangGrup.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		GudangGrup gudangGrup=gudangGrupDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", gudangGrup.getId());
		result.put("isActive", gudangGrup.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllGudangGrup() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listGudangGrup", gudangGrupDao.findAllGudangGrup());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		GudangGrup gudangGrup=gudangGrupDao.findById(id);
		result.put("gudangGrup", gudangGrup);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteGudangGrup(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		gudangGrupDao.delete(id);
		result.put("id", id);
		return result;
	}


}
