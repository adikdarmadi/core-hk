package com.hk.service;

import java.util.Map;

import com.hk.vo.WidgetVO;

/**
 * Widget Service
 * 
 * @author Adhityarismawan
 */
public interface WidgetService {

	Map<String, Object> findAllWidget();

	Map<String, Object> saveWidget(WidgetVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteWidget(String id);

	Map<String, Object> editWidget(WidgetVO p, Integer version);

}
