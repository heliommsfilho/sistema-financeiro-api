package com.heliommsfilho.sistemafinanceiro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heliommsfilho.sistemafinanceiro.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
