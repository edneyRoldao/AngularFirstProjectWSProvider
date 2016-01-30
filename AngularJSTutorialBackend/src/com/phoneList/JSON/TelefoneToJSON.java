package com.phoneList.JSON;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.phoneList.entity.Operadora;
import com.phoneList.entity.Telefone;

/**
 * 
 * @author edneyroldao
 *
 * Resolvi implementar na mao as conversoes de arquivos JSON sem o uso do mapeamente presente na API de Jackson e Jettison.
 * Acredito que apesar da verbosidade, ele se torna facil de entender e manter
 *
 */
public class TelefoneToJSON implements ToJSON<Telefone>{
	
	private static final String SIMPLE_ATTRIBUTE_ID = "id";
	private static final String SIMPLE_ATTRIBUTE_NAME = "nome";
	private static final String SIMPLE_ATTRIBUTE_SERIAL = "serial";
	private static final String SIMPLE_ATTRIBUTE_DATE = "data";
	private static final String SIMPLE_ATTRIBUTE_PHONE = "telefone";
	private static final String SIMPLE_ATTRIBUTE_CODIGO = "codigo";
	private static final String SIMPLE_ATTRIBUTE_CATEGORIA = "categoria";
	private static final String SIMPLE_ATTRIBUTE_PRECO = "preco";
	private static final String OBJECT_ATTRIBUTE_OPERADORA = "operadora";


	@Override
	public JSONObject convertJavaObjectToJSONObject(Telefone telefone) {
		try {
			JSONObject telefoneObj = new JSONObject();
			telefoneObj.put(SIMPLE_ATTRIBUTE_ID, telefone.getId());
			telefoneObj.put(SIMPLE_ATTRIBUTE_NAME, telefone.getNome());
			telefoneObj.put(SIMPLE_ATTRIBUTE_SERIAL, telefone.getSerial());
			telefoneObj.put(SIMPLE_ATTRIBUTE_PHONE, telefone.getTelefone());
			telefoneObj.put(SIMPLE_ATTRIBUTE_DATE, telefone.getData());
			
			JSONObject operadoraObj = new JSONObject();
			operadoraObj.put(SIMPLE_ATTRIBUTE_ID, telefone.getOperadora().getId());
			operadoraObj.put(SIMPLE_ATTRIBUTE_NAME, telefone.getOperadora().getNome());
			operadoraObj.put(SIMPLE_ATTRIBUTE_CODIGO, telefone.getOperadora().getCodigo());
			operadoraObj.put(SIMPLE_ATTRIBUTE_CATEGORIA, telefone.getOperadora().getCategoria());
			operadoraObj.put(SIMPLE_ATTRIBUTE_PRECO, telefone.getOperadora().getPreco());
			
			telefoneObj.put(OBJECT_ATTRIBUTE_OPERADORA, operadoraObj);
			
			return telefoneObj;
			
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

	
	@Override
	public Telefone convertJSONObjectToJavaObject(String jsonData) {
		try {
			Telefone telefone = new Telefone();
			Operadora operadora = new Operadora();
			JSONObject telefoneObj = new JSONObject(jsonData);
			JSONObject operadoraObj = telefoneObj.getJSONObject(OBJECT_ATTRIBUTE_OPERADORA);
			
			//Setting data inside Operadora object
			operadora.setId(operadoraObj.getInt(SIMPLE_ATTRIBUTE_ID));
			String valor = operadoraObj.getString(SIMPLE_ATTRIBUTE_PRECO);
			operadora.setNome(operadoraObj.getString(SIMPLE_ATTRIBUTE_NAME));
			operadora.setCodigo(operadoraObj.getInt(SIMPLE_ATTRIBUTE_CODIGO));
			operadora.setCategoria(operadoraObj.getString(SIMPLE_ATTRIBUTE_CATEGORIA));
			operadora.setPreco(Float.parseFloat(valor));

			//Setting data inside Telefone object
			boolean temId = telefoneObj.has(SIMPLE_ATTRIBUTE_ID);
			if(temId) telefone.setId(telefoneObj.getInt(SIMPLE_ATTRIBUTE_ID));
			telefone.setData(telefoneObj.getString(SIMPLE_ATTRIBUTE_DATE));
			telefone.setNome(telefoneObj.getString(SIMPLE_ATTRIBUTE_NAME));
			telefone.setSerial(telefoneObj.getString(SIMPLE_ATTRIBUTE_SERIAL));
			telefone.setTelefone(telefoneObj.getString(SIMPLE_ATTRIBUTE_PHONE));
			telefone.setOperadora(operadora);

			return telefone;
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}
	
}
