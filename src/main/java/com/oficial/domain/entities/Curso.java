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
	
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Disciplina> disciplinas;
	
	@OneToMany(cascade = CascadeType.ALL)
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Curso(Long id, String nome, String descricao, List<Disciplina> disciplinas, List<Turma> turmas) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.disciplinas = disciplinas;
		this.turmas = turmas;
	}

	public Curso() {
		super();
	}

}
