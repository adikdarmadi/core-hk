package com.hk.controller.base;

import java.util.HashMap;
import java.util.Map;


/**
 * Base Controller Class for handling messaga resource for internationalization
 * & locale
 * 
 * @author Adik
 */
public abstract class LocaleController<V> {

	protected Map<String, Object> mapHeaderMessage = new HashMap<String, Object>();
	

	protected void addHeaderMessage(String key, String message) {
		this.mapHeaderMessage.put(key, message);
	}



}
