package com.phoneList.DAO;

import java.util.List;

import com.phoneList.entity.Telefone;

/**
 * 
 * @author edneyroldao
 *
 */
public interface TelefoneDAO extends DAO<Telefone, Integer> {
	
	List<Telefone> findAll();

}
