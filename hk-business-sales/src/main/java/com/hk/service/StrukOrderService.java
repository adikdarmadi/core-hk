package com.hk.service;

import java.util.List;
import java.util.Map;

import com.hk.entities.StrukOrder;
import com.hk.vo.StrukOrderVO;

/**
 * Agama Service
 * 
 * @author Adik
 */
public interface StrukOrderService {


	Map<String, Object> saveStrukOrder(StrukOrderVO strukOrderVo);

	Map<String, Object> findAll();

}
