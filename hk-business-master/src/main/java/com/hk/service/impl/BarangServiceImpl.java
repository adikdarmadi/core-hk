package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.AkunDao;
import com.hk.dao.BarangDao;
import com.hk.dao.BarangDivisiDao;
import com.hk.dao.BarangGrupDao;
import com.hk.dao.BarangMerkDao;
import com.hk.dao.GudangDao;
import com.hk.dao.SupplierDao;
import com.hk.dao.UnitDao;
import com.hk.entities.AkunGrup;
import com.hk.entities.Barang;
import com.hk.entities.Widget;
import com.hk.service.BarangService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.BarangVO;

@Service("barangService")
public class BarangServiceImpl implements BarangService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("BarangService : ");

	@Autowired
	private BarangDao barangDao;
	
	@Autowired
	private BarangDivisiDao barangDivisiDao;
	
	@Autowired
	private BarangMerkDao barangMerkDao;
	
	@Autowired
	private BarangGrupDao barangGrupDao;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private GudangDao gudangDao;
	
	@Autowired
	private AkunDao akunDao;
	
	@Autowired
	private UnitDao unitDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveBarang(BarangVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barang execute");
		Barang model=modelMapper.map(p, Barang.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getUnitBesarId())){
			model.setUnitBesar(unitDao.findById(model.getUnitBesarId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getUnitKecilId())){
			model.setUnitKecil(unitDao.findById(model.getUnitKecilId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getBarangDivisiId())){
			model.setBarangDivisi(barangDivisiDao.findById(model.getBarangDivisiId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getBarangMerkId())){
			model.setBarangMerk(barangMerkDao.findById(model.getBarangMerkId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getBarangGrupId())){
			model.setBarangGrup(barangGrupDao.findById(model.getBarangGrupId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getSupplierId())){
			model.setSupplier(supplierDao.findById(model.getSupplierId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getGudangId())){
			model.setGudang(gudangDao.findById(model.getGudangId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getAkunId())){
			model.setAkun(akunDao.findById(model.getAkunId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getUnitBeliId())){
			model.setUnitBeli(unitDao.findById(model.getUnitBeliId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getUnitJualId())){
			model.setUnitJual(unitDao.findById(model.getUnitJualId()));
		}
		
		Barang barang=barangDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barang.getId());
		result.put("isActive", barang.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editBarang(BarangVO p, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barang execute");
		Barang model=modelMapper.map(p, Barang.class);

		Barang obj = barangDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		if(CommonUtil.isNotNullOrEmpty(model.getUnitBesarId())){
			model.setUnitBesar(unitDao.findById(model.getUnitBesarId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getUnitKecilId())){
			model.setUnitKecil(unitDao.findById(model.getUnitKecilId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getBarangDivisiId())){
			model.setBarangDivisi(barangDivisiDao.findById(model.getBarangDivisiId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getBarangMerkId())){
			model.setBarangMerk(barangMerkDao.findById(model.getBarangMerkId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getBarangGrupId())){
			model.setBarangGrup(barangGrupDao.findById(model.getBarangGrupId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getSupplierId())){
			model.setSupplier(supplierDao.findById(model.getSupplierId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getGudangId())){
			model.setGudang(gudangDao.findById(model.getGudangId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getAkunId())){
			model.setAkun(akunDao.findById(model.getAkunId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getUnitBeliId())){
			model.setUnitBeli(unitDao.findById(model.getUnitBeliId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getUnitJualId())){
			model.setUnitJual(unitDao.findById(model.getUnitJualId()));
		}
		
		Barang barang=barangDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barang.getId());
		result.put("isActive", barang.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveBarang(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barang execute");
		
		Barang model = barangDao.findById(id);
		
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
		
		Barang barang=barangDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barang.getId());
		result.put("isActive", barang.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllBarang() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listBarang", barangDao.findAllBarang());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Barang barang=barangDao.findById(id);
		result.put("barang", barang);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteBarang(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		barangDao.delete(id);
		result.put("id", id);
		return result;
	}


}
