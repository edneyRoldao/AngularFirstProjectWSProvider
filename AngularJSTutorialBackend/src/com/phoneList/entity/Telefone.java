package com.phoneList.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * 
 * @author edney.souza
 * 
 */
@Entity
public class Telefone implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	private String serial;
	
	private String telefone;
	
	private String data;
	
	@ManyToOne
	private Operadora operadora;
	
	
	public Telefone() {
	}

	
	public Telefone(String nome, String serial, String telefone, String data, Operadora operadora) {
		super();
		this.nome = nome;
		this.serial = serial;
		this.telefone = telefone;
		this.data = data;
		this.operadora = operadora;
	}

	
	@Override
	public String toString() {
		return "Telefone [id=" + id + ", nome=" + nome + ", serial=" + serial + ", telefone=" + telefone + ", data="
				+ data + ", operadora=" + operadora + "]";
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}
	
}
