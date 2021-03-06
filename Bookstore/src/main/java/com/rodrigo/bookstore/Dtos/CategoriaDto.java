package com.rodrigo.bookstore.Dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.rodrigo.bookstore.models.Categoria;

public class CategoriaDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	@NotEmpty(message= "Campo NOME não foi preenchido!")
	@Length(min= 3 , max=100 , message="Campo NOME deve ser Preenchido entre 3 e 100 Caracteres!" )
	private String nome;
	
	@NotEmpty(message= "Campo DESCRIÇÃO não foi preenchido!")
	@Length(min= 3 , max=200 , message="Campo DESCRIÇÃO deve ser Preenchido entre 3 e 200 Caracteres!" )
	private String descricao;

	public CategoriaDto() {
		
	}

	public CategoriaDto(Categoria cat) {
		
		this.id = cat.getId();
		this.nome = cat.getNome();
		this.descricao = cat.getDescricao();
		
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
	
	
	
	
	
	

}
