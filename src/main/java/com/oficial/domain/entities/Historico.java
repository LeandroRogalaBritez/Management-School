package com.oficial.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Historico {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="historico_sequence")
	@SequenceGenerator(name="historico_sequence", sequenceName="historico_sequence")
	private Long id;
	@ManyToOne
	@NotNull
	private Disciplina disciplina;
	@ManyToOne
	@NotNull
	private Aluno aluno;
	@NotNull
	private Long nota;
	private boolean aprovado;
	
	Historico() {}

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

	public Long getNota() {
		return nota;
	}

	public void setNota(Long nota) {
		this.nota = nota;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}
}