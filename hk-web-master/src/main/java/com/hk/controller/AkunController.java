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
import com.hk.constant.HakAksesConstant;
import com.hk.controller.base.LocaleController;
import com.hk.security.AppPermission;
import com.hk.service.AkunService;
import com.hk.util.rest.RestUtil;
import com.hk.vo.AkunGrupVO;
import com.hk.vo.AkunVO;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("/akun")
public class AkunController extends LocaleController {

	@Autowired
	private AkunService akunService;

	@SuppressWarnings("unchecked")
	@AppPermission(hakAkses = HakAksesConstant.CREATE,hakMenu="/akun")
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> Save(@Valid @RequestBody AkunVO entity, HttpServletRequest request) {
		Map<String, Object> result = akunService.saveAkun(entity);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.CREATED.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.CREATED.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.CREATED, mapHeaderMessage);

	}

	@SuppressWarnings("unchecked")
	@AppPermission(hakAkses = HakAksesConstant.UPDATE,hakMenu="/akun")
	@RequestMapping(value = "/edit/{version}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> Edit(@PathVariable("version") Integer version, @Valid @RequestBody AkunVO entity, HttpServletRequest request) {
		Map<String, Object> result = akunService.editAkun(entity,version);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.CREATED.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.CREATED.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.CREATED, mapHeaderMessage);
	}

	@SuppressWarnings("unchecked")
	@AppPermission(hakAkses = HakAksesConstant.SUPERVISOR,hakMenu="/akun")
	@RequestMapping(value = "/active/{id}/version/{version}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> Activation(@PathVariable("id") String id, @PathVariable("version") Integer version,HttpServletRequest request) {
		Map<String, Object> result = akunService.isActiveAkun(id,version);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.CREATED.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.CREATED.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.CREATED, mapHeaderMessage);
	}
	
	@SuppressWarnings("unchecked")
	@AppPermission(hakAkses = HakAksesConstant.DELETE,hakMenu="/akun")
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/del/{id}")
	public ResponseEntity<Map<String, Object>> DeleteById(@PathVariable("id") String id) {
		Map<String, Object> result = akunService.deleteAkun(id);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

	@SuppressWarnings("unchecked")
	@AppPermission(hakMenu="/akun")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value={ "/active/{isActive}", "/all" })
	public ResponseEntity<Map<String, Object>> FindAll(@PathVariable Map<String, String> pathVariables) {
		Map<String, Object> result = akunService.findAllAkun(pathVariables);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

	@SuppressWarnings("unchecked")
	@AppPermission(hakMenu="/akun")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> FindById(@PathVariable("id") String id) {
		Map<String, Object> result = akunService.findById(id);
		mapHeaderMessage.put(BaseConstant.STATUS, HttpStatus.OK.name());
		mapHeaderMessage.put(BaseConstant.STATUS_CODE, HttpStatus.OK.toString());
		mapHeaderMessage.put(BaseConstant.MESSAGE, BaseConstant.HttpHeaderInfo.LABEL_SUCCESS);
		return RestUtil.getJsonResponse(result, HttpStatus.OK, mapHeaderMessage);
	}

}
