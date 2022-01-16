package com.rodrigo.bookstore.Dtos;

import java.io.Serializable;



import com.rodrigo.bookstore.models.Categoria;

public class CategoriaDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	private String nome;
	
	private String descriçao;

	public CategoriaDto() {
		
	}

	public CategoriaDto(Categoria cat) {
		
		this.id = cat.getId();
		this.nome = cat.getNome();
		this.descriçao = cat.getDescriçao();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescriçao() {
		return descriçao;
	}

	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}

	
	
	
	
	
	
	

}
