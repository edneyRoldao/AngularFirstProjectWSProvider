package com.phoneList.test;

import javax.persistence.EntityManager;

import com.phoneList.DAO.OperadoraDAO;
import com.phoneList.DAOImpl.OperadoraDAOImpl;
import com.phoneList.entity.Operadora;
import com.phoneList.singleton.EntityManagerFactorySingleton;

/**
 * 
 * @author edneyroldao
 *
 *	Classe que realiza uma pequena carga no banco para os Testes.
 *
 * OBS: Este classe deve ser executada antes de subir o servico para popular o banco de Dados com as operadoras
 *
 */
public class StartDatabase {
	
	static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
	public static void main(String[] args) {
		
		OperadoraDAO operadoraDAO = new OperadoraDAOImpl(em);
		
		operadoraDAO.insert(new Operadora("Tim", 25, "celular", 22.00f));
		operadoraDAO.insert(new Operadora("Vivo", 15, "celular", 20.00f));
		operadoraDAO.insert(new Operadora("Claro", 30, "celular", 15.00f));
		operadoraDAO.insert(new Operadora("Oi", 35, "celular", 5.500f));
		operadoraDAO.insert(new Operadora("Embratel", 40, "fixo", 10.00f));
		operadoraDAO.insert(new Operadora("GVT", 45, "fixo", 5.00f));
	}

}
