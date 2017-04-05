package com.hk.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.constant.BaseConstant;
import com.hk.constant.HakAksesConstant;
import com.hk.controller.base.LocaleController;
import com.hk.enumeration.ActionEnum;
import com.hk.security.AppPermission;
import com.hk.service.GudangGrupService;
import com.hk.util.rest.RestUtil;
import com.hk.vo.GudangGrupVO;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("/gudangGrup")
public class GudangGrupController extends LocaleController {

	@Autowired
	private GudangGrupService gudangGrupService;
	
	@SuppressWarnings("unchecked")
	@AppPermission(hakAkses = HakAksesConstant.CREATE,hakMenu="/gudangGrup")
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> Save(@Valid @RequestBody GudangGrupVO entity, HttpServletRequest request) {
		Map<String, Object> result = gudangGrupService.saveGudangGrup(entity);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.CREATED.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.CREATED.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.CREATED, mapHeaderMessage);

	}

	@SuppressWarnings("unchecked")
	@AppPermission(hakAkses = HakAksesConstant.UPDATE,hakMenu="/gudangGrup")
	@RequestMapping(value = "/edit/{version}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> Edit(@PathVariable("version") Integer version, @Valid @RequestBody GudangGrupVO entity, HttpServletRequest request) {
		Map<String, Object> result = gudangGrupService.editGudangGrup(entity,version);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.CREATED.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.CREATED.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.CREATED, mapHeaderMessage);
	}
	
	@SuppressWarnings("unchecked")
	@AppPermission(hakAkses = HakAksesConstant.SUPERVISOR,hakMenu="/gudangGrup")
	@RequestMapping(value = "/active/{id}/version/{version}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> Activation(@PathVariable("id") String id, @PathVariable("version") Integer version,HttpServletRequest request) {
		Map<String, Object> result = gudangGrupService.isActiveGudangGrup(id,version);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.CREATED.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.CREATED.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.CREATED, mapHeaderMessage);
	}

	@SuppressWarnings("unchecked")
	@AppPermission(hakAkses = HakAksesConstant.DELETE,hakMenu="/gudangGrup")
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/del/{id}")
	public ResponseEntity<Map<String, Object>> DeleteById(@PathVariable("id") String id) {
		Map<String, Object> result = gudangGrupService.deleteGudangGrup(id);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

	@SuppressWarnings("unchecked")
	@AppPermission(hakMenu="/gudangGrup")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value={ "/active/{isActive}", "/all" })
	public ResponseEntity<Map<String, Object>> FindAll(@PathVariable Map<String, String> pathVariables) {
		Map<String, Object> result = gudangGrupService.findAllGudangGrup(pathVariables);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

	@SuppressWarnings("unchecked")
	@AppPermission(hakMenu="/gudangGrup")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> FindById(@PathVariable("id") String id) {
		Map<String, Object> result = gudangGrupService.findById(id);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

}
