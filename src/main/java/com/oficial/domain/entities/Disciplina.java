package com.oficial.domain.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.oficial.domain.entities.Disciplina;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_sequence")
	@SequenceGenerator(name = "disciplina_sequence", allocationSize = 1, sequenceName = "disciplina_sequence")
	private Long id;
	
	@NotNull
	private String nome;
	private String descricao;
	@Column(name = "carge_horaria")
	@NotNull
	private int cargaHoraria;
	@ManyToOne
	@JoinColumn(name = "curso_id")
	@NotNull
	private Curso curso;
	@ManyToOne
	@NotNull
	@JoinColumn(name = "semestre_id")
	private Semestre semestre;
	@OneToMany
	private Collection<Disciplina> dependencias;
	private boolean aberta;
	private Professor professor;

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

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Collection<Disciplina> getDependencias() {
		return dependencias;
	}

	public void setDependencias(Collection<Disciplina> dependencias) {
		this.dependencias = dependencias;
	}

	public boolean isAberta() {
		return aberta;
	}

	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina(Long id, String nome, String descricao, int cargaHoraria, Curso curso, Semestre semestre,
			Collection<Disciplina> dependencias, boolean aberta, Professor professor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
		this.curso = curso;
		this.semestre = semestre;
		this.dependencias = dependencias;
		this.aberta = aberta;
		this.professor = professor;
	}

	public Disciplina() {
		super();
	}

}