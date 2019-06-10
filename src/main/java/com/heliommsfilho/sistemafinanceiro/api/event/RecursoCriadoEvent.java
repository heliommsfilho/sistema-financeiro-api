package com.heliommsfilho.sistemafinanceiro.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = -4307106364238576318L;

	private HttpServletResponse response;
	private Long codigo;
	
	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}
}
