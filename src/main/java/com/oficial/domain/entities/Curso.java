package com.oficial.domain.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
	private List<Disciplina> disciplinas;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
	private List<Turma> turmas;

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

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Curso(Long id, String nome, List<Disciplina> disciplinas, List<Turma> turmas) {
		super();
		this.id = id;
		this.nome = nome;
		this.disciplinas = disciplinas;
		this.turmas = turmas;
	}

	public Curso() {
		super();
	}

}
