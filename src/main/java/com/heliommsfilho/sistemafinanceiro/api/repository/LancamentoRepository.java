package com.heliommsfilho.sistemafinanceiro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heliommsfilho.sistemafinanceiro.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
