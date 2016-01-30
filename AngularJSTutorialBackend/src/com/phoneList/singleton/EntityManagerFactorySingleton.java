package com.phoneList.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 /**
  * 
  * @author edneyroldao
  * Essa classe vai returnar uma conexao com o Banco de Dados com o Pattern Singleton
  */
public class EntityManagerFactorySingleton {
	
	private static EntityManagerFactory factory;
	private static final String MY_SQL_DATABASE = "mySQLConfig";
	
	private EntityManagerFactorySingleton() {
		
	}
	
	public static EntityManagerFactory getInstance() {
		if(factory == null)
			factory = Persistence.createEntityManagerFactory(MY_SQL_DATABASE);
		
		return factory;
	}

}
