package com.rodrigo.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rodrigo.bookstore.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	@Query(value="SELECT * FROM bookstore.livro WHERE categoria_id = :idCat ORDER BY titulo", nativeQuery=true)
	List<Livro> encontrarPorCategoria(@Param(value="idCat") Long idCat);

}
