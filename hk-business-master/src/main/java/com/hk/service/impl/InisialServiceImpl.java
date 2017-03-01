package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.InisialDao;
import com.hk.dao.MataUangDao;
import com.hk.dao.SupplierDao;
import com.hk.entities.Inisial;
import com.hk.service.InisialService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.InisialVO;

@Service("inisialService")
public class InisialServiceImpl implements InisialService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("InisialService : ");

	@Autowired
	private InisialDao inisialDao;
	
	@Autowired
	private MataUangDao mataUangDao;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editInisial(InisialVO p){
		Inisial model=modelMapper.map(p, Inisial.class);

		if(CommonUtil.isNotNullOrEmpty(model.getMataUangId())){
			model.setMataUang(mataUangDao.findById(model.getMataUangId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getSupplierId())){
			model.setSupplier(supplierDao.findById(model.getSupplierId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getBookStart())){
			model.setBookStart(DateUtil.toDate(DateUtil.defaultFormatDate(model.getBookStart())));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getTglSaldoAwal())){
			model.setTglSaldoAwal(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTglSaldoAwal())));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getTglStockOpname())){
			model.setTglStockOpname(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTglStockOpname())));
		}
		
		if(CommonUtil.isNotNullOrEmpty(p.getDefaultTglProteksi())){
			model.setTglProteksiRequestBeli(DateUtil.toDate(DateUtil.defaultFormatDate(p.getDefaultTglProteksi())));
		}else if(CommonUtil.isNotNullOrEmpty(model.getTglProteksiRequestBeli())){
			model.setTglProteksiRequestBeli(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTglProteksiRequestBeli())));
		}
		
		if(CommonUtil.isNotNullOrEmpty(p.getDefaultTglProteksi())){
			model.setTglProteksiOrderPembelian(DateUtil.toDate(DateUtil.defaultFormatDate(p.getDefaultTglProteksi())));
		}else if(CommonUtil.isNotNullOrEmpty(model.getTglProteksiOrderPembelian())){
			model.setTglProteksiOrderPembelian(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTglProteksiOrderPembelian())));
		}
		
		if(CommonUtil.isNotNullOrEmpty(p.getDefaultTglProteksi())){
			model.setTglProteksiFakturPembelian(DateUtil.toDate(DateUtil.defaultFormatDate(p.getDefaultTglProteksi())));
		}else if(CommonUtil.isNotNullOrEmpty(model.getTglProteksiFakturPembelian())){
			model.setTglProteksiFakturPembelian(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTglProteksiFakturPembelian())));
		}
		
		if(CommonUtil.isNotNullOrEmpty(p.getDefaultTglProteksi())){
			model.setTglProteksiBatalOrderBeli(DateUtil.toDate(DateUtil.defaultFormatDate(p.getDefaultTglProteksi())));
		}else if(CommonUtil.isNotNullOrEmpty(model.getTglProteksiFakturPembelian())){
			model.setTglProteksiBatalOrderBeli(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTglProteksiBatalOrderBeli())));
		}
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		
		Inisial inisial=inisialDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", inisial.getId());
		result.put("version", inisial.getVersion());
		return result;
	}
	
	@Override
	public Map<String,Object> findAllLimit() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("inisial", inisialDao.findAll().get(0));
		return result;
	}
	
}
