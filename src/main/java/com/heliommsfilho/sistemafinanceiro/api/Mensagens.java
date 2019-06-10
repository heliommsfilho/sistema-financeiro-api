package com.heliommsfilho.sistemafinanceiro.api;

public enum Mensagens {

	MENSAGEM_INVALIDA("requisicao.mensagem-invalida"),
	NAO_ENCONTRADO("requisicao.recurso-nao-encontrado");
	
	private String mensagem;

	private Mensagens(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	@Override
	public String toString() {
		return mensagem;
	}
}
