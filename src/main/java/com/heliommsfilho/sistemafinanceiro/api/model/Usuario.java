package com.heliommsfilho.sistemafinanceiro.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter @Setter
@EqualsAndHashCode(of = {"codigo"})
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1621416508254466196L;
	
	@Id
	private Long codigo;
	
	private String nome;
	private String email;
	private String senha;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_permissao", 
			   joinColumns = @JoinColumn(name = "codigo_usuario"),
			   inverseJoinColumns = @JoinColumn(name = "codigo_permissao"))		
	private List<Permissao> permissoes;
}
