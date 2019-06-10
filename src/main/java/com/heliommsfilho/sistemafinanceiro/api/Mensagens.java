package com.heliommsfilho.sistemafinanceiro.api;

public enum Mensagens {

	MENSAGEM_INVALIDA("requisicao.mensagem-invalida"),
	NAO_ENCONTRADO("requisicao.recurso-nao-encontrado"),
	OPERACAO_NAO_PERMITIDA("requisicao.operacao-nao-permitida"),
	PESSOA_INEXISTENTE("pessoa.inexistente-ou-inativa"),
	CATEGORIA_NAO_EXISTENTE("categoria.nao-existente");
	
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
