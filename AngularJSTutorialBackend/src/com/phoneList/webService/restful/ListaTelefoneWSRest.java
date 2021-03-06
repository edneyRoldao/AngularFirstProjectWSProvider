package com.phoneList.webService.restful;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.json.JSONException;

import com.phoneList.DAO.TelefoneDAO;
import com.phoneList.DAOImpl.TelefoneDAOImpl;
import com.phoneList.JSON.TelefoneToJSON;
import com.phoneList.entity.Telefone;
import com.phoneList.singleton.EntityManagerFactorySingleton;

/**
 * 
 * @author edneyroldao
 *
 *	Esta classe pode ser considerada o coracao do nosso backend que vai servir nossa lista de telefones do Angular.
 *
 */
@Path("/lista/telefones")
public class ListaTelefoneWSRest {
	
	private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private TelefoneDAO telefoneDAO = new TelefoneDAOImpl(em);
	private TelefoneToJSON converter = new TelefoneToJSON();
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTelefone(String incomingData) {
		
		Telefone fone = converter.convertJSONObjectToJavaObject(incomingData);
		telefoneDAO.insert(fone);
		
		List<Telefone> phoneList = telefoneDAO.findAll();
		JSONArray jsonArray = getJSONArray(phoneList);

		return Response.ok()
				.entity(jsonArray.toString())
				.build();
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA, MediaType.TEXT_PLAIN})
	public Response deleteTelefone(String incomingData) {

		deletePhone(incomingData);

		List<Telefone> phoneList = telefoneDAO.findAll();
		JSONArray jsonArray = getJSONArray(phoneList);

		return Response.ok()
				.entity(jsonArray.toString())
				.build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnListaTelefonica() {
		
		List<Telefone> phoneList = telefoneDAO.findAll();
		JSONArray jsonArray = getJSONArray(phoneList);

		return Response.ok()
				.entity(jsonArray.toString())
				.build();
	}
	
	
	private void deletePhone(String jsonData) {
		try {
			JSONArray array = new JSONArray(jsonData);
			List<Telefone> list = getObjects(array);
			for (Telefone t : list) {
				telefoneDAO.remove(t.getId());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private List<Telefone> getObjects(JSONArray jsonArray) throws Exception {
		List<Telefone> list = new ArrayList<>();
		for(int i = 0; i < jsonArray.length(); i++) {
			Telefone tel = converter.convertJSONObjectToJavaObject(jsonArray.get(i).toString());
			list.add(tel);
		}
		return list;
	}
	
	private JSONArray getJSONArray(List<Telefone> telefones) {
		try {
			
			JSONArray jsonArray = new JSONArray();
			for(Telefone fone : telefones) {
				JSONObject json = converter.convertJavaObjectToJSONObject(fone);
				jsonArray.put(json);
			}
			
			return jsonArray;
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
