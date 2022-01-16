package com.rodrigo.bookstore.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.rodrigo.bookstore.models.Categoria;
import com.rodrigo.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catRepository;

	
	
	public Categoria criarCategoria(Categoria cat) {
		Categoria obj = catRepository.save(cat);
		return obj;
	}



	public Categoria mostrarCategoria(Long id) {
		Optional<Categoria> obj = catRepository.findById(id);
		 obj.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"ID: "+id+ " não encontrado!" ));
		 return obj.get();	
		 }

}
