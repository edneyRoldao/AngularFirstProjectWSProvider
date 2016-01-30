package com.phoneList.DAOImpl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import com.phoneList.DAO.DAO;

/**
 * 
 * @author edneyroldao
 *
 * Implementacao do CRUD da aplicacao com a utilizacao da API do hibernate para implementacao da JPA
 *
 */
public abstract class DAOImpl<T, K> implements DAO<T, K> {

	protected EntityManager em;
	private Class<T> classe;
	
	@SuppressWarnings("unchecked")
	public DAOImpl(EntityManager em) {
		this.em = em;
		this.classe = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
	}

	@Override
	public void insert(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	@Override
	public void remove(K id) {
		T entity = findOne(id);
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	@Override
	public T findOne(K id) {
		return em.find(classe, id);
	}
	
	
	
}
