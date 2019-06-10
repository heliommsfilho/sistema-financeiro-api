package com.heliommsfilho.sistemafinanceiro.api.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.heliommsfilho.sistemafinanceiro.api.model.Lancamento;
import com.heliommsfilho.sistemafinanceiro.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter filter, Pageable pageable);
}
