package com.oficial.domain.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private String nome;

	@OneToMany
	private List<Aluno> alunos;

	@NotNull
	private int limiteAluno;

	@ManyToOne
	private Semestre Semestre;

	@NotNull
	private boolean situacao;

	@ManyToOne
	private Curso curso;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public int getLimiteAluno() {
		return limiteAluno;
	}

	public void setLimiteAluno(int limiteAluno) {
		this.limiteAluno = limiteAluno;
	}

	public Semestre getSemestre() {
		return Semestre;
	}

	public void setSemestre(Semestre semestre) {
		Semestre = semestre;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Turma(int id, String nome, List<Aluno> alunos, int limiteAluno,
			com.oficial.domain.entities.Semestre semestre, boolean situacao, Curso curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.alunos = alunos;
		this.limiteAluno = limiteAluno;
		Semestre = semestre;
		this.situacao = situacao;
		this.curso = curso;
	}

	public Turma() {
		super();
	}

}
