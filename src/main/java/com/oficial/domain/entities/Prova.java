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
public class Prova {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private String descricao;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date data;

	@NotNull
	private double nota;

	@NotNull
	@ManyToOne
	private Aluno aluno;

	@NotNull
	@ManyToOne
	private Disciplina disciplina;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
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

	public Prova(int id, String descricao, Date data, double nota, Aluno aluno, Disciplina disciplina) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.nota = nota;
		this.aluno = aluno;
		this.disciplina = disciplina;
	}

	public Prova() {
		super();
	}

}
