package com.hk.service;

import java.util.Map;

import com.hk.vo.WidgetVO;

/**
 * Widget Service
 * 
 * @author Adhityarismawan
 */
public interface WidgetService {

	Map<String, Object> findAllWidget(Map<String, String> pathVariables);

	Map<String, Object> saveWidget(WidgetVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteWidget(String id);

	Map<String, Object> editWidget(WidgetVO p, Integer version);

	Map<String, Object> isActiveWidget(String id, Integer version);

}
