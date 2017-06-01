package com.oficial.domain.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Trabalho {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String descricao;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	private Nota nota;
	
	@ManyToOne
	private Aluno aluno;
	
	@NotNull
	@OneToOne
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

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Trabalho(int id, String descricao, Date data, Nota nota, Disciplina disciplina) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.nota = nota;
		this.disciplina = disciplina;
	}

	public Trabalho() {
		super();
	}

}
