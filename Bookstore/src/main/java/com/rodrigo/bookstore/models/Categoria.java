package com.rodrigo.bookstore.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message= "Campo NOME não foi preenchido!")
	@Length(min= 3 , max=100 , message="Campo NOME deve ser Preenchido entre 3 e 100 Caracteres!" )
	private String nome;
	
	@NotEmpty(message= "Campo DESCRIÇÃO não foi preenchido!")
	@Length(min= 3 , max=200 , message="Campo DESCRIÇÃO deve ser Preenchido entre 3 e 200 Caracteres!" )
	private String descricao;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="categoria")
	private List<Livro> livros = new ArrayList<>();


	public Categoria() {
		
	}


	public Categoria(Long id, String nome, String descricao, List<Livro> livros) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.livros = livros;
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


	public List<Livro> getLivros() {
		return livros;
	}


	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
