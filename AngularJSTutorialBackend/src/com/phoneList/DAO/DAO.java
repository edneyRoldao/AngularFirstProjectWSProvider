package com.phoneList.DAO;
/**
 * 
 * @author edneyroldao
 *
 * @param <T> Utilizando Generics
 * @param <K>
 *	Esta interface contem as assinaturas dos metodos responsaveis pelo CRUD da aplicacao 
 * 
 */
public interface DAO<T, K> {

	void insert(T entity);
	
	void update(T entity);
	
	void remove(K id);
	
	T findOne(K id);
	
}
