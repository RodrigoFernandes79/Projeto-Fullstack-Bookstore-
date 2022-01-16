package com.rodrigo.bookstore.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.rodrigo.bookstore.Dtos.CategoriaDto;
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



	public Categoria mostrarCategoriaPorId(Long id) {
		Optional<Categoria> obj = catRepository.findById(id);
		 obj.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"ID: "+id+ " não encontrado!" ));
		 return obj.get();	
		 }



	public List<Categoria> mostrarCategoria() {
		List<Categoria> obj = catRepository.findAll();
		
		return obj;
	}



	public Categoria atualizarCategoria(CategoriaDto catDto, Long id) {
		return catRepository.findById(id)
				.map(obj ->{
					obj.setNome(catDto.getNome());
					obj.setDescriçao(catDto.getDescriçao());
					Categoria dto = catRepository.save(obj);
					return dto;
				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID: "+id+ " não encontrado!"));
		
		
	}



	public void deletarCategoriaPorId(Long id) {
		
		catRepository.findById(id).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "ID: "+id+  " não encontrado!"));
		try {
		catRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Categoria nao pode ser Deletada! Possui Livros Associados.");
		}
		
	}

}
