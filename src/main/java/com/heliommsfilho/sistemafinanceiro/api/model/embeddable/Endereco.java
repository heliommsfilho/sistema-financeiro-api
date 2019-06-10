package com.heliommsfilho.sistemafinanceiro.api.model.embeddable;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Endereco {

	@Size(min = 1, max = 30)
	private String logradouro;
	
	@Size(min = 1, max = 30)
	private String numero;
	
	@Size(min = 1, max = 30)
	private String complemento;
	
	@Size(min = 1, max = 30)
	private String bairro;
	
	@Size(min = 1, max = 30)
	private String cep;
	
	@Size(min = 1, max = 30)
	private String cidade;
	
	@Size(min = 1, max = 30)
	private String estado;
}
