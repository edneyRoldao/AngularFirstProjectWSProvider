package com.phoneList.DAO;

import java.util.List;

import com.phoneList.entity.Operadora;

/**
 * 
 * @author edneyroldao
 */
public interface OperadoraDAO extends DAO<Operadora, Integer>{

	List<Operadora> findAll();
	
}
