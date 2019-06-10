package com.heliommsfilho.sistemafinanceiro.api.repository.lancamento;

import java.util.List;

import com.heliommsfilho.sistemafinanceiro.api.model.Lancamento;
import com.heliommsfilho.sistemafinanceiro.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public List<Lancamento> filtrar(LancamentoFilter filter);
}
