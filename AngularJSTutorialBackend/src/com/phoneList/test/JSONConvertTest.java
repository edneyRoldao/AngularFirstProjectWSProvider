package com.phoneList.test;

import org.codehaus.jettison.json.JSONObject;

import com.phoneList.JSON.TelefoneToJSON;
import com.phoneList.entity.Operadora;
import com.phoneList.entity.Telefone;

public class JSONConvertTest {
	
	public static void main(String[] args) {
		
		TelefoneToJSON converter = new TelefoneToJSON();
		Operadora p = new Operadora("Tim", 25, "celular", 22.00f);
		p.setId(1);
		Telefone tel1 = new Telefone("Edney", "99999-9999","dfsht", "segunda-feira 04-01-2016", p);
		System.out.println("Converting Java Object to JSON Object:");
		JSONObject json = converter.convertJavaObjectToJSONObject(tel1);
		System.out.println(json.toString());
		
		System.out.println("");
		System.out.println("---------------------------------------------------------------");
		
		System.out.println("Converting JSONObject to JavaObject:");
		Telefone tel2 = converter.convertJSONObjectToJavaObject(json.toString());
		System.out.println(tel2.toString());
		
	}

}
