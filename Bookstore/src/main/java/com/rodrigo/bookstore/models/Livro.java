package com.rodrigo.bookstore.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;



@Entity
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@NotEmpty(message= "Campo TÍTULO não foi preenchido!")
	@Length(min= 3 , max=50 , message="Campo TÍTULO deve ser Preenchido entre 3 e 50 Caracteres!" )
	private String titulo;
	
	@NotEmpty(message= "Campo NOME DO AUTOR não foi preenchido!")
	@Length(min= 3 , max=50 , message="Campo NOME DO AUTOR deve ser Preenchido entre 3 e 50 Caracteres!" )
	private String nome_autor;
	
	@NotEmpty(message= "Campo DESCRIÇÃO não foi preenchido!")
	@Length(min= 3 , max=50 , message="Campo DESCRIÇÃO deve ser Preenchido entre 3 e 50 Caracteres!" )
	private String descricao;
	
	@NotEmpty(message= "Campo TEXTO não foi preenchido!")
	@Length(min= 100 , max=500000000 , message="Campo TEXTO deve ser Preenchido entre 100 e 5.000.000 de Caracteres!" )
	private String texto;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;

	public Livro() {
		
	}

	public Livro(Long id, String titulo, String nome_autor, String descricao, String texto, Categoria categoria) {
		
		this.id = id;
		this.titulo = titulo;
		this.nome_autor = nome_autor;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
