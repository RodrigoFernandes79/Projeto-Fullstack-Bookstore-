package com.rodrigo.bookstore.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.bookstore.Dtos.LivroDto;
import com.rodrigo.bookstore.models.Livro;
import com.rodrigo.bookstore.services.LivroService;

@RestController
@RequestMapping("/livros")
@CrossOrigin("http://localhost:4200")
public class LivroController {
	
	@Autowired
	private LivroService livService;
	
	@PostMapping
	ResponseEntity<Livro> criarLivro(@RequestParam(value="categoria",defaultValue="0") Long idCat, @Valid @RequestBody Livro livro){
		
	Livro obj = livService.criarLivro( idCat, livro);
	
	return ResponseEntity.status(HttpStatus.CREATED).body(obj);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> mostrarLivroPorId(@PathVariable	Long id){
		Livro obj = livService.mostrarLivroPorId(id);
		return ResponseEntity.ok().body(obj);

}
	//Procurar livros por categoria:
	
	@GetMapping  //localhost:8080/livros?categoria=?
	public ResponseEntity<List<LivroDto>> mostrarLivroPorCategoriaId(@RequestParam(value="categoria", defaultValue="0") Long idCat){
		List<Livro> list = livService.mostrarLivroPorCategoriaId(idCat);
		List<LivroDto> listDto = list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> alterarLivroPorId(@PathVariable Long id, @Valid @RequestBody Livro livro){
		
		Livro obj = livService.alterarLivroPorId(id,livro);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarLivroPorId(@PathVariable Long id) {
		livService.deletarLivroPorId(id);
		
	}
	
	}
