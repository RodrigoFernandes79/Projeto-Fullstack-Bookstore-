package com.rodrigo.bookstore.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.bookstore.Dtos.CategoriaDto;
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
	public ResponseEntity<Categoria> mostrarCategoriaPorId(@PathVariable	Long id){
		Categoria obj = catService.mostrarCategoriaPorId(id);
		return ResponseEntity.ok().body(obj);
		
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDto>> mostrarCategoria(){
		List<Categoria> list = catService.mostrarCategoria();
		List<CategoriaDto> listDto = list.stream().map(obj -> new CategoriaDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDto> atualizarCategoria(@RequestBody CategoriaDto catDto, @PathVariable Long id){
		Categoria obj = catService.atualizarCategoria(catDto,id);
		CategoriaDto objDto = new CategoriaDto(obj);
		
		
		return ResponseEntity.ok().body(objDto);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCategoriaPorId(@PathVariable Long id) {
		catService.deletarCategoriaPorId(id);
	}
	

}
