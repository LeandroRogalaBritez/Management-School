package com.oficial.domain.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.oficial.domain.entities.Disciplina;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private int cargaHoraria;

	@NotNull
	private boolean aberta;

	@OneToMany
	private Collection<Disciplina> dependencias;

	@OneToOne
	private Professor professor;

	@ManyToOne
	private Curso curso;

	@ManyToOne
	private Semestre semestre;

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

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public boolean isAberta() {
		return aberta;
	}

	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}

	public Collection<Disciplina> getDependencias() {
		return dependencias;
	}

	public void setDependencias(Collection<Disciplina> dependencias) {
		this.dependencias = dependencias;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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

	public Disciplina(Long id, String nome, int cargaHoraria, boolean aberta, Collection<Disciplina> dependencias,
			Professor professor, Curso curso, Semestre semestre) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.aberta = aberta;
		this.dependencias = dependencias;
		this.professor = professor;
		this.curso = curso;
		this.semestre = semestre;
	}

	public Disciplina() {
		super();
	}

	public void adicionaDependencia(Disciplina dependencia) {
		dependencias.add(dependencia);
	}

	public void removeDependencia(Disciplina dependencia) {
		dependencias.remove(dependencia);
	}

}