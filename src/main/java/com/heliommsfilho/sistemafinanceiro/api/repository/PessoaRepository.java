package com.heliommsfilho.sistemafinanceiro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heliommsfilho.sistemafinanceiro.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
