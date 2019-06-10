package com.heliommsfilho.sistemafinanceiro.api.exception.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.heliommsfilho.sistemafinanceiro.api.Mensagens;
import com.heliommsfilho.sistemafinanceiro.api.exception.PessoaInexistenteOuInativaException;
import com.heliommsfilho.sistemafinanceiro.api.exception.handler.SistemaFinanceiroApiExceptionHandler.Erro;

@ControllerAdvice
public class PessoaExceptionHandler {

	@Autowired
	private MessageSource messages;
	
	@ExceptionHandler({PessoaInexistenteOuInativaException.class})
	public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex) {
		String msgUsuario = messages.getMessage(Mensagens.PESSOA_INEXISTENTE.toString(), null, LocaleContextHolder.getLocale());
		String msgDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(msgUsuario, msgDesenvolvedor));
		
		return ResponseEntity.badRequest().body(erros);
	}
}
