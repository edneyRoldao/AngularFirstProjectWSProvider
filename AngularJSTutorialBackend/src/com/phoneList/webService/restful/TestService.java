package com.phoneList.webService.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author edneyroldao
 * Classe que serve como teste para verificar se o ambiente foi configurado corretamente (web.xml, servicos e mapeamentos).
 */
@Path("/welcome")
public class TestService {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String welcomeService() {
		return "<h4>if you can see this message, then the server of AngularJS webService Rest Provider is Working</h4>";
	}

}
