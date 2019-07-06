package com.heliommsfilho.sistemafinanceiro.api.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.heliommsfilho.sistemafinanceiro.api.model.enums.TipoLancamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ResumoLancamento {

	private Long codigo;
	private String descricao;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private BigDecimal valor;
	private TipoLancamento tipo;
	private String categoria;
	private String pessoa;
}
