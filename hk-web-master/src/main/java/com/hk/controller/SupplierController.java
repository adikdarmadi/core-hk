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
import com.hk.service.SupplierService;
import com.hk.util.rest.RestUtil;
import com.hk.vo.SupplierContactVO;
import com.hk.vo.SupplierVO;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("/supplier")
public class SupplierController extends LocaleController {

	@Autowired
	private SupplierService supplierService;

	@SuppressWarnings("unchecked")
	@AppPermission(hakAkses = "IS_ADD")
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> Save(@Valid @RequestBody SupplierVO entity, HttpServletRequest request) {
		Map<String, Object> result = supplierService.saveSupplier(entity);
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
	 * Save(@PathVariable("id") String id,@Valid @RequestBody SupplierVO
	 * entity,HttpServletRequest request) { Map<String, Object> result =
	 * supplierService.saveSupplier(entity);
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
		Map<String, Object> result = supplierService.deleteSupplier(id);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
	public ResponseEntity<Map<String, Object>> FindAll(){
		Map<String, Object> result = supplierService.findAllSupplier();
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> FindById(@PathVariable("id") String id) {
		Map<String, Object> result = supplierService.findById(id);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

	@SuppressWarnings("unchecked")
	@AppPermission(hakAkses = "IS_ADD")
	@RequestMapping(value = "/detail/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> SaveDetail(@Valid @RequestBody SupplierContactVO entity, HttpServletRequest request) {
		Map<String, Object> result = supplierService.saveSupplierContact(entity);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.CREATED.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.CREATED.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.CREATED, mapHeaderMessage);

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}/detail")
	public ResponseEntity<Map<String, Object>> FindDetailByParent(@PathVariable("id") String id) {
		Map<String, Object> result = supplierService.findDetailByParent(id);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> FindDetailById(@PathVariable("id") String id) {
		Map<String, Object> result = supplierService.findDetailById(id);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/detail/del/{id}")
	public ResponseEntity<Map<String, Object>> DeleteDetailById(@PathVariable("id") String id) {
		Map<String, Object> result = supplierService.deleteSupplierContact(id);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}
}
