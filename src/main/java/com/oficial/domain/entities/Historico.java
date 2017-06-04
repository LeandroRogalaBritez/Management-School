package com.oficial.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@NotNull
	private Disciplina disciplina;

	@ManyToOne
	@NotNull
	private Aluno aluno;

	@NotNull
	private boolean aprovado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Historico(Long id, Disciplina disciplina, Aluno aluno, boolean aprovado) {
		super();
		this.id = id;
		this.disciplina = disciplina;
		this.aluno = aluno;
		this.aprovado = aprovado;
	}

	public Historico() {
		super();
	}

}