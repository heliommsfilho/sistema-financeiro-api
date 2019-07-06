package com.heliommsfilho.sistemafinanceiro.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "permissao")
@Getter @Setter
@EqualsAndHashCode(of = {"codigo"})
public class Permissao implements Serializable {

	private static final long serialVersionUID = -2413304395495793046L;

	@Id
	private Long codigo;
	private String descricao;
}
