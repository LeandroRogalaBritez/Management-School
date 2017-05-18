package com.oficial.domain.curso;

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

import com.oficial.domain.curso.Curso;
import com.oficial.domain.curso.Disciplina;
import com.oficial.domain.curso.Semestre;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="disciplina_sequence")
	@SequenceGenerator(name="disciplina_sequence", allocationSize=1, sequenceName="disciplina_sequence")
	private Long id;
	@NotNull
	private String nome;
	private String descricao;
	@Column(name="carge_horaria")
	@NotNull
	private int cargaHoraria;
	@ManyToOne
    @JoinColumn(name="curso_id")
	@NotNull
	private Curso curso;
	@ManyToOne
	@NotNull
	@JoinColumn(name="semestre_id")
	private Semestre semestre;
	@OneToMany
	private Collection<Disciplina> dependencias;
	
	Disciplina() { }

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
}