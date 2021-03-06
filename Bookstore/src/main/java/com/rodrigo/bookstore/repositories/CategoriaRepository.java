package com.rodrigo.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.bookstore.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
