package com.heliommsfilho.sistemafinanceiro.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.heliommsfilho.sistemafinanceiro.api.model.Pessoa;
import com.heliommsfilho.sistemafinanceiro.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPorCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva.getCodigo(), "codigo");
		
		return pessoaRepository.save(pessoaSalva);
	}

	public void atualizarStatus(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = buscarPorCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}
	
	public Pessoa buscarPorCodigo(Long codigo) {
		Optional<Pessoa> pessoaSalva = Optional.ofNullable(pessoaRepository.findOne(codigo));
		
		return pessoaSalva.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
}
