package com.rodrigo.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.rodrigo.bookstore.models.Livro;
import com.rodrigo.bookstore.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livRepository;
	
	
	@Autowired
	private CategoriaService catService;


	

	public Livro criarLivro(Livro livro) {
		try {
		Livro obj = livRepository.save(livro);
		
		return obj;
	
	}catch(DataIntegrityViolationException e) {
		throw new DataIntegrityViolationException("Categoria: " + livro.getCategoria().getId()+ " não Existe!");
	}
	}



	public Livro mostrarLivroPorId(Long id) {
		Optional<Livro> obj = livRepository.findById(id);
		obj.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"ID: "+id+ " não encontrado!" ));

		return obj.get();
		
	}

	//Procurar livros por categoria:

	public List<Livro> mostrarLivroPorCategoriaId(Long idCat) {
		catService.mostrarCategoriaPorId(idCat);
		
		
		return livRepository.encontrarPorCategoria(idCat);
	}



	public Livro alterarLivroPorId(Long id, Livro livro) {
		return livRepository.findById(id)
				.map(object ->{
					object.setTitulo(livro.getTitulo());
					object.setNome_autor(livro.getNome_autor());
					object.setTexto(livro.getTexto());
					object.setDescriçao(livro.getDescriçao());
					object.setCategoria(livro.getCategoria());
					Livro obj = livRepository.save(object);
					return obj;
				})
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"ID: "+id+ " não encontrado!"));
		
		
	}



	public void deletarLivroPorId(Long id) {
		livRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "ID: "+id+ " não encontrado! Não foi possível deletar este livro!"));
		livRepository.deleteById(id);
	}



	
}
