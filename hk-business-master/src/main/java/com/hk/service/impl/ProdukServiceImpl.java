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
import com.hk.entities.Produk;
import com.hk.service.ProdukService;
import com.hk.service.UserService;
import com.hk.util.HibernateInitialize;
import com.hk.vo.ProdukVO;

@Service("produkService")
public class ProdukServiceImpl implements ProdukService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("ProdukService : ");

	@Autowired
	private ProdukDao produkDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveProduk(ProdukVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save produk execute");
		Produk model=modelMapper.map(p, Produk.class);
		Produk produk=produkDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", produk.getId());
		result.put("namaProduk", produk.getNamaProduk());
		Integer a=null;
		Integer b=a/100;
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllProduk() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listProduk", produkDao.findAllProduk());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(Integer id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Produk produk=produkDao.findById(id);
		produk.setDetailJenisProduk(HibernateInitialize.initializeAndUnproxy(produk.getDetailJenisProduk()));
		result.put("produk", produk);
		
		return result;
	}
	
	


}
