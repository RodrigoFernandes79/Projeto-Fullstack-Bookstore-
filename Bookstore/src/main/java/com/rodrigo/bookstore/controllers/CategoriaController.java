package com.rodrigo.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.bookstore.models.Categoria;
import com.rodrigo.bookstore.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService catService;
	
	@PostMapping
	public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria cat){
		Categoria obj = catService.criarCategoria(cat);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> mostrarCategoria(@PathVariable	Long id){
		Categoria obj = catService.mostrarCategoria(id);
		return ResponseEntity.ok().body(obj);
		
	}


}
