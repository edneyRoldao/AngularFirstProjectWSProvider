package com.phoneList.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 
 * @author edney.souza
 * 	
 */
@Entity
public class Operadora implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	private Integer codigo;
	
	private String categoria;
	
	private Float preco;

	
	public Operadora() {
	}
	
	public Operadora(String nome, Integer codigo, String categoria, Float preco) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.categoria = categoria;
		this.preco = preco;
	}


	@Override
	public String toString() {
		return "Operadora [id=" + id + ", nome=" + nome + ", codigo=" + codigo
				+ ", categoria=" + categoria + ", preco=" + preco + "]";
	}
	
	
	//Getters and Setters
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
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
}
