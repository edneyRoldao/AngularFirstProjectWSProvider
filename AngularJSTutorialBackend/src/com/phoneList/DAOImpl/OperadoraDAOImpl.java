package com.phoneList.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.phoneList.DAO.OperadoraDAO;
import com.phoneList.entity.Operadora;

public class OperadoraDAOImpl extends DAOImpl<Operadora, Integer> implements OperadoraDAO {

	public OperadoraDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Operadora> findAll() {
		TypedQuery<Operadora> query = em.createQuery("from Operadora", Operadora.class);
		return query.getResultList();
	}

}
