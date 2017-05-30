package com.oficial.domain.entities;

import java.util.Date;

public class Prova {

	private int id;
	private String descricao;
	private Date data;
	private Nota nota;
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

	public Prova(int id, String descricao, Date data, Nota nota, Disciplina disciplina) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.nota = nota;
		this.disciplina = disciplina;
	}

	public Prova() {
		super();
	}

}
