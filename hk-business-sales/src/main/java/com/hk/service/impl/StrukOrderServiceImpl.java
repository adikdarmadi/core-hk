package com.hk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.StrukOrderDao;
import com.hk.entities.DetailKomponenHarga;
import com.hk.entities.StrukOrder;
import com.hk.entities.StrukOrderDetail;
import com.hk.service.StrukOrderService;
import com.hk.util.CommonUtil;
import com.hk.vo.DetailKomponenHargaVO;
import com.hk.vo.StrukOrderDetailVO;
import com.hk.vo.StrukOrderVO;

@Service("strukOrderService")
public class StrukOrderServiceImpl implements StrukOrderService {

	@Autowired
	private StrukOrderDao strukOrderDao;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Map<String, Object> saveStrukOrder(StrukOrderVO strukOrderVo) {
		StrukOrder strukOrder = new StrukOrder();
		List<StrukOrderDetail> tmpStrukOrderDetail = new ArrayList<StrukOrderDetail>();
		if (CommonUtil.isNotNullOrEmpty(strukOrderVo.getStrukOrders())) {
			for (StrukOrderDetailVO strukOrderDetailVO : strukOrderVo.getStrukOrders()) {
				StrukOrderDetail strukOrderDetail = modelMapper.map(strukOrderDetailVO, StrukOrderDetail.class);
				strukOrderDetail.setStrukOrder(strukOrder);
				Set<DetailKomponenHarga> detailKomponenHarga = new HashSet<DetailKomponenHarga>();
				if (CommonUtil.isNotNullOrEmpty(strukOrderDetailVO.getDetailKomponenHarga())) {
					for (DetailKomponenHargaVO detailKomponenHargaVO : strukOrderDetailVO.getDetailKomponenHarga()) {
						DetailKomponenHarga model = modelMapper.map(detailKomponenHargaVO, DetailKomponenHarga.class);
						model.setStrukOrderDetail(strukOrderDetail);
						detailKomponenHarga.add(model);
					}
				}
				strukOrderDetail.getDetailKomponenHarga().clear();
				strukOrderDetail.getDetailKomponenHarga().addAll(detailKomponenHarga);
				tmpStrukOrderDetail.add(strukOrderDetail);
			}
		}
		strukOrder.getStrukOrders().clear();
		strukOrder.getStrukOrders().addAll(tmpStrukOrderDetail);
		strukOrder = strukOrderDao.save(strukOrder);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", strukOrder.getId());
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> findAll() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", strukOrderDao.listStrukOrder());
		return result;
	}

}
