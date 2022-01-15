package com.rodrigo.bookstore.models;

import java.util.Objects;




public class Livro {

	private Long id;
	
	private String titulo;
	
	private String nome_autor;
	
	private String descriçao;
	
	private String texto;
	
	private Categoria categoria;

	public Livro() {
		
	}

	public Livro(Long id, String titulo, String nome_autor, String descriçao, String texto, Categoria categoria) {
		
		this.id = id;
		this.titulo = titulo;
		this.nome_autor = nome_autor;
		this.descriçao = descriçao;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public String getDescriçao() {
		return descriçao;
	}

	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
