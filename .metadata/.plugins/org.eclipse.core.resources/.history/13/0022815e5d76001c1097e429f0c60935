package com.rodrigo.bookstore.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;






public class Categoria {
	
	
	private Long id;
	
	private String nome;
	
	private String descriçao;
	
	
	private List<Livro> livros = new ArrayList<>();


	public Categoria() {
		
	}


	public Categoria(Long id, String nome, String descriçao, List<Livro> livros) {
		super();
		this.id = id;
		this.nome = nome;
		this.descriçao = descriçao;
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


	public String getDescriçao() {
		return descriçao;
	}


	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
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
