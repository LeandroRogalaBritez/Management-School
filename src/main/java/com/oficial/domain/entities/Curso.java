package com.oficial.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;

	@OneToOne
	private Cordenador cordenador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso(Long id, String nome, Cordenador cordenador) {
		super();
		this.id = id;
		this.nome = nome;
		this.cordenador = cordenador;
	}

	public void setCordenador(Cordenador cordenador) {
		this.cordenador = cordenador;
	}

	public Cordenador getCordenador() {
		return cordenador;
	}

	public Curso() {
		super();
	}

}
