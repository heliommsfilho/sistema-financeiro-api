package com.heliommsfilho.sistemafinanceiro.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heliommsfilho.sistemafinanceiro.api.exception.CategoriaNaoExistenteException;
import com.heliommsfilho.sistemafinanceiro.api.exception.PessoaInexistenteOuInativaException;
import com.heliommsfilho.sistemafinanceiro.api.model.Categoria;
import com.heliommsfilho.sistemafinanceiro.api.model.Lancamento;
import com.heliommsfilho.sistemafinanceiro.api.model.Pessoa;
import com.heliommsfilho.sistemafinanceiro.api.repository.CategoriaRepository;
import com.heliommsfilho.sistemafinanceiro.api.repository.LancamentoRepository;
import com.heliommsfilho.sistemafinanceiro.api.repository.PessoaRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		validarLancamento(lancamento);
		
		return lancamentoRepository.save(lancamento);
	}

	private void validarLancamento(Lancamento lancamento) {
		Optional<Pessoa> pessoa = Optional.ofNullable(pessoaRepository.findOne(lancamento.getPessoa().getCodigo()));
		
		if (!pessoa.isPresent() || pessoa.get().isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		
		Optional<Categoria> categoria = Optional.ofNullable(categoriaRepository.findOne(lancamento.getCategoria().getCodigo()));
		categoria.orElseThrow(CategoriaNaoExistenteException::new);
	}

	public void excluir(Long codigo) {
		lancamentoRepository.delete(codigo);
	}	
}
