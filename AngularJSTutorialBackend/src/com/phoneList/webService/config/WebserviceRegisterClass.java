package com.phoneList.webService.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.phoneList.webService.restful.ListaOperadoraWSRest;
import com.phoneList.webService.restful.ListaTelefoneWSRest;
import com.phoneList.webService.restful.TestService;

/**
 * @author edneyroldao
 *	Esta classe nao esta sendo utilizada, entao nao se preocupe com ela.
 *
 *	Esta classe e uma segunda e mais elegante forma de mapear as classes com os Servicos Restful.
 *	Aqui nos passamos uma lista cam esses classes, porém para ela funcionar precisamos modificar no nosso web.xml
 *
 */
public class WebserviceRegisterClass extends Application{
	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> register = new HashSet<Class<?>>();
		
		register.add(ListaTelefoneWSRest.class);
		register.add(ListaOperadoraWSRest.class);
		register.add(TestService.class);
		return register;
	}

}
