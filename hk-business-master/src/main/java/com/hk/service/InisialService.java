package com.hk.service;

import java.util.Map;

import com.hk.vo.InisialVO;

/**
 * Inisial Service
 * 
 * @author Adhityarismawan
 */

public interface InisialService {

	Map<String, Object> findAllLimit();

	Map<String, Object> editInisial(InisialVO p);

}
