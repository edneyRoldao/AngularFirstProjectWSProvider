package com.phoneList.webService.restful;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.json.JSONException;

import com.phoneList.DAO.OperadoraDAO;
import com.phoneList.DAOImpl.OperadoraDAOImpl;
import com.phoneList.JSON.OperadoraToJSON;
import com.phoneList.entity.Operadora;
import com.phoneList.singleton.EntityManagerFactorySingleton;
/**
 * 
 * @author edneyroldao
 * Esta classe e um webservice Restful com um metodo http do tipo GET que disponibiliza a lista de operadoras que
 * 	sao consumidas na view
 * 
 * OBS: metodos privados sao auxiliares dos metodos publico
 * 
 */
@Path("/lista/operadoras")
public class ListaOperadoraWSRest {
	
	private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private OperadoraDAO operadoraDAO = new OperadoraDAOImpl(em);
	private OperadoraToJSON converter = new OperadoraToJSON();

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnListaOperadoras() {
		
		List<Operadora> listaOperadora = operadoraDAO.findAll();
		JSONArray jsonArray = getJSONArray(listaOperadora);

		return Response.ok()
				.entity(jsonArray.toString())
				.build();
	}
	
	
	private JSONArray getJSONArray(List<Operadora> operadoras) {
		try {
			
			JSONArray jsonArray = new JSONArray();
			for(Operadora op : operadoras) {
				JSONObject json = converter.convertJavaObjectToJSONObject(op);
				jsonArray.put(json);
			}
			
			return jsonArray;
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
