package com.phoneList.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.phoneList.DAO.TelefoneDAO;
import com.phoneList.entity.Telefone;

/**
 * 
 * @author edneyroldao
 * 
 * estou usando a EntityManager do hibernate para obter conexao com o Banco de Dados e JPQL para mantar as queries
 * 
 */
public class TelefoneDAOImpl extends DAOImpl<Telefone, Integer> implements TelefoneDAO{

	public TelefoneDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Telefone> findAll() {
		TypedQuery<Telefone> query = em.createQuery("from Telefone", Telefone.class);
		return query.getResultList();
	}

}
