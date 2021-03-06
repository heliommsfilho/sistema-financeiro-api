package com.heliommsfilho.sistemafinanceiro.api.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.heliommsfilho.sistemafinanceiro.api.event.RecursoCriadoEvent;

@Component
class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
		HttpServletResponse response = recursoCriadoEvent.getResponse();
		Long codigo = recursoCriadoEvent.getCodigo();
		
		adicionarHeaders(response, codigo);
	}

	private void adicionarHeaders(HttpServletResponse response, Long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
											 .buildAndExpand(codigo).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
	}

}
