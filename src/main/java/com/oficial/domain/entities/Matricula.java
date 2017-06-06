package com.oficial.domain.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@NotNull
	private Aluno aluno;

	@ManyToOne
	@NotNull
	private Disciplina disciplina;

	@NotNull
	private boolean situacao;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public Matricula(Long id, Aluno aluno, Disciplina disciplina, Date data, boolean situacao) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.data = data;
		this.situacao = situacao;
	}

	public Matricula() {
		super();
	}

}