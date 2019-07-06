

package com.heliommsfilho.sistemafinanceiro.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("sistema-financeiro")
public class SistemaFinanceiroApiProperty {

	@Getter
	private final Seguranca seguranca = new Seguranca();
	
	@Getter @Setter
	public static class Seguranca {
		private boolean enableHttps;
		private String origemPermitida = "localhot:8000";
	}
}
