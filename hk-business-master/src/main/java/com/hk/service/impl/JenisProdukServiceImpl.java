package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.ProdukDao;
import com.hk.service.JenisProdukService;
import com.hk.service.UserService;

@Service("jenisProdukService")
public class JenisProdukServiceImpl implements JenisProdukService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JenisProdukServiceImpl.class);

	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveJenisProduk() {
		LOGGER.info(userService.getLoginUser().getNamaUser() +"save Jenis Produk");

		/*
		 * Sample Excetion when save detail Jenis Produk
		 */
		Integer a=null;
		Integer b=a/0;
		
		Map<String,Object> result=new HashMap<String,Object>(); 
		return result;
	}
	
	
	
	


}
