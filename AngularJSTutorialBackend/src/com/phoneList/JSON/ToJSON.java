package com.phoneList.JSON;

import org.codehaus.jettison.json.JSONObject;

/**
 * 
 * @author edneyroldao
 *
 *	Assinaturas dos metodos que tratam a conversao de POJO para JSON e vice-versa
 *
 */
public interface ToJSON<T> {

	JSONObject convertJavaObjectToJSONObject(T entity);
	
	T convertJSONObjectToJavaObject(String jsonData);
	
}
