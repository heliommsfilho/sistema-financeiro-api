package com.heliommsfilho.sistemafinanceiro.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heliommsfilho.sistemafinanceiro.api.event.RecursoCriadoEvent;
import com.heliommsfilho.sistemafinanceiro.api.model.Lancamento;
import com.heliommsfilho.sistemafinanceiro.api.repository.LancamentoRepository;
import com.heliommsfilho.sistemafinanceiro.api.repository.filter.LancamentoFilter;
import com.heliommsfilho.sistemafinanceiro.api.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Lancamento> salvar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
		Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarPorCodigo(@PathVariable Long codigo) {
		Optional<Lancamento> lancamentoSalvo = Optional.ofNullable(lancamentoRepository.findOne(codigo));
		
		return lancamentoSalvo.isPresent() ? ResponseEntity.ok(lancamentoSalvo.get()) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public List<Lancamento> pesquisar(LancamentoFilter filter) {
		return lancamentoRepository.filtrar(filter);
	}
	
	@DeleteMapping("/{codigo}")
	public void excluir(@PathVariable Long codigo) {
		lancamentoService.excluir(codigo);
	}
}
