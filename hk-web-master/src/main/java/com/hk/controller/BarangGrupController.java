package com.hk.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.constant.BaseConstant;
import com.hk.controller.base.LocaleController;
import com.hk.security.AppPermission;
import com.hk.service.BarangGrupService;
import com.hk.util.rest.RestUtil;
import com.hk.vo.BarangGrupVO;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("/barangGrup")
public class BarangGrupController extends LocaleController {

	@Autowired
	private BarangGrupService barangGrupService;

	@SuppressWarnings("unchecked")
	@AppPermission(hakAkses = "IS_ADD")
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> Save(@Valid @RequestBody BarangGrupVO entity, HttpServletRequest request) {
		Map<String, Object> result = barangGrupService.saveBarangGrup(entity);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.CREATED.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.CREATED.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.CREATED, mapHeaderMessage);

	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT,
	 * consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.
	 * APPLICATION_JSON_VALUE) public ResponseEntity<Map<String,Object>>
	 * Save(@PathVariable("id") String id,@Valid @RequestBody BarangGrupVO
	 * entity,HttpServletRequest request) { Map<String, Object> result =
	 * barangGrupService.saveBarangGrup(entity);
	 * mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.CREATED.name());
	 * mapHeaderMessage.put(BaseConstant.STATUS_CODE,
	 * HttpStatus.CREATED.toString());
	 * mapHeaderMessage.put(BaseConstant.MESSAGE,
	 * BaseConstant.HttpHeaderInfo.LABEL_SUCCESS); return
	 * RestUtil.getJsonResponse(result, HttpStatus.CREATED, mapHeaderMessage);
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/del/{id}")
	public ResponseEntity<Map<String, Object>> DeleteById(@PathVariable("id") String id) {
		Map<String, Object> result = barangGrupService.deleteBarangGrup(id);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
	public ResponseEntity<Map<String, Object>> FindAll() {
		Map<String, Object> result = barangGrupService.findAllBarangGrup();
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> FindById(@PathVariable("id") String id) {
		Map<String, Object> result = barangGrupService.findById(id);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

}
