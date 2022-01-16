package com.rodrigo.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.rodrigo.bookstore.models.Livro;
import com.rodrigo.bookstore.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livRepository;

	public Livro criarLivro(Livro livro) {
		Livro obj = livRepository.save(livro);
		return obj;
	}



	public Livro mostrarLivroPorId(Long id) {
		Optional<Livro> obj = livRepository.findById(id);
		obj.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"ID: "+id+ " não encontrado!" ));

		return obj.get();
		
	}

}
