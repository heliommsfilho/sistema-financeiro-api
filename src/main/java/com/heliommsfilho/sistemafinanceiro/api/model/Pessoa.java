package com.heliommsfilho.sistemafinanceiro.api.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heliommsfilho.sistemafinanceiro.api.model.embeddable.Endereco;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Getter @Setter
@EqualsAndHashCode(of = {"codigo"})
public class Pessoa implements Serializable {

	private static final long serialVersionUID = -6689464324624201555L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String nome;
	
	@Embedded
	private Endereco endereco;
	
	@NotNull
	private Boolean ativo;
	
	@Transient
	@JsonIgnore
	public boolean isInativo() {
		return !this.ativo;
	}
}
