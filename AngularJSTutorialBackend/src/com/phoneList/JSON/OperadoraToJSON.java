package com.phoneList.JSON;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.phoneList.entity.Operadora;

/**
 * 
 * @author edneyroldao
 *
 * Resolvi implementar na mao as conversoes de arquivos JSON sem o uso do mapeamente presente na API de Jackson e Jettison.
 * Acredito que apesar da verbosidade, ele se torna facil de entender e manter
 *
 */
public class OperadoraToJSON implements ToJSON<Operadora> {
	
	private static final String SIMPLE_ATTRIBUTE_ID = "id";
	private static final String SIMPLE_ATTRIBUTE_NAME = "nome";
	private static final String SIMPLE_ATTRIBUTE_PRECO = "preco";
	private static final String SIMPLE_ATTRIBUTE_CODIGO = "codigo";
	private static final String SIMPLE_ATTRIBUTE_CATEGORIA = "categoria";


	@Override
	public JSONObject convertJavaObjectToJSONObject(Operadora operadora) {
		try {
			
		JSONObject operadoraObj = new JSONObject();
		operadoraObj.put(SIMPLE_ATTRIBUTE_ID, operadora.getId());
		operadoraObj.put(SIMPLE_ATTRIBUTE_NAME, operadora.getNome());
		operadoraObj.put(SIMPLE_ATTRIBUTE_PRECO, operadora.getPreco());
		operadoraObj.put(SIMPLE_ATTRIBUTE_CODIGO, operadora.getCodigo());
		operadoraObj.put(SIMPLE_ATTRIBUTE_CATEGORIA, operadora.getCategoria());
		
		return operadoraObj;
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	@Override
	public Operadora convertJSONObjectToJavaObject(String jsonData) {
		try {
			
			Operadora operadora = new Operadora();
			JSONObject operadoraObj = new JSONObject(jsonData);
			
			String valor = operadoraObj.getString(SIMPLE_ATTRIBUTE_PRECO);

			operadora.setId(operadoraObj.getInt(SIMPLE_ATTRIBUTE_ID));
			operadora.setNome(operadoraObj.getString(SIMPLE_ATTRIBUTE_NAME));
			operadora.setPreco(Float.parseFloat(valor));
			operadora.setCodigo(operadoraObj.getInt(SIMPLE_ATTRIBUTE_CODIGO));
			operadora.setCategoria(operadoraObj.getString(SIMPLE_ATTRIBUTE_CATEGORIA));

			return operadora;
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
