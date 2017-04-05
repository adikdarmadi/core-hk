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

import com.hk.dao.AkunDao;
import com.hk.dao.DepartmentHdrDao;
import com.hk.dao.MataUangDao;
import com.hk.dao.PegawaiDao;
import com.hk.entities.AkunGrup;
import com.hk.entities.Pegawai;
import com.hk.entities.Widget;
import com.hk.service.PegawaiService;
import com.hk.service.UserMasterService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.PegawaiVO;

@Service("pegawaiService")
public class PegawaiServiceImpl implements PegawaiService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("PegawaiService : ");

	@Autowired
	private PegawaiDao pegawaiDao;
	
	@Autowired
	private DepartmentHdrDao departmentHdrDao;
	
	@Autowired
	private AkunDao akunDao;
	
	@Autowired
	private MataUangDao mataUangDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> savePegawai(PegawaiVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save pegawai execute");
		Pegawai model=modelMapper.map(p, Pegawai.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getDepartmentId())){
			model.setDepartment(departmentHdrDao.findById(model.getDepartmentId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getAkunId())){
			model.setAkun(akunDao.findById(model.getAkunId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getMataUangId())){
			model.setMataUang(mataUangDao.findById(model.getMataUangId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getTanggalLahir())){
			model.setTanggalLahir(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTanggalLahir())));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getMulaiBekerja())){
			model.setMulaiBekerja(DateUtil.toDate(DateUtil.defaultFormatDate(model.getMulaiBekerja())));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getAkhirKontrak())){
			model.setAkhirKontrak(DateUtil.toDate(DateUtil.defaultFormatDate(model.getAkhirKontrak())));
		}
		
		Pegawai pegawai=pegawaiDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", pegawai.getId());
		result.put("isActive", pegawai.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editPegawai(PegawaiVO p, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save pegawai execute");
		Pegawai model=modelMapper.map(p, Pegawai.class);

		Pegawai obj = pegawaiDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		if(CommonUtil.isNotNullOrEmpty(model.getDepartmentId())){
			model.setDepartment(departmentHdrDao.findById(model.getDepartmentId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getAkunId())){
			model.setAkun(akunDao.findById(model.getAkunId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getMataUangId())){
			model.setMataUang(mataUangDao.findById(model.getMataUangId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getTanggalLahir())){
			model.setTanggalLahir(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTanggalLahir())));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getMulaiBekerja())){
			model.setMulaiBekerja(DateUtil.toDate(DateUtil.defaultFormatDate(model.getMulaiBekerja())));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getAkhirKontrak())){
			model.setAkhirKontrak(DateUtil.toDate(DateUtil.defaultFormatDate(model.getAkhirKontrak())));
		}
		
		Pegawai pegawai=pegawaiDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", pegawai.getId());
		result.put("isActive", pegawai.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActivePegawai(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save pegawai execute");
		
		Pegawai model = pegawaiDao.findById(id);
		
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
		
		Pegawai pegawai=pegawaiDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", pegawai.getId());
		result.put("isActive", pegawai.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllPegawai(Map<String, String> pathVariables) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		
		List<Object> listMap = new ArrayList<Object>();
		for(Map<String, Object> map : pegawaiDao.findAllPegawai()){
			int notAdd = 0;
			
			for(Map.Entry<String, String> filter : pathVariables.entrySet()){
				if(!filter.getValue().equalsIgnoreCase("all")){
					if(!filter.getValue().equalsIgnoreCase(map.get(filter.getKey()).toString())){
						notAdd++;
					}
				}
			}
			
			if(notAdd == 0){
				listMap.add(map);
			}
			
		}
		
		result.put("listPegawai", listMap);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Pegawai pegawai=pegawaiDao.findById(id);
		result.put("pegawai", pegawai);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deletePegawai(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		pegawaiDao.delete(id);
		result.put("id", id);
		return result;
	}


}
